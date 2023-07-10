package med.voll.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DoctorRequestDTO;
import med.voll.api.dto.doctor.DoctorResponseDTO;
import med.voll.api.dto.doctor.DoctorUpdateDTO;
import med.voll.api.dto.doctor.DoctorDetailsDTO;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorRepository repository;

    @PostMapping        // 1- Requisições Post precisam do @RequestBody
    @Transactional                    // Pede pro Spring conversar com o BeanValidation
    public ResponseEntity register(@RequestBody @Valid DoctorRequestDTO data, UriComponentsBuilder uriBuilder){
        Doctor doctor = new Doctor(data);
        repository.save(doctor);

        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DoctorDetailsDTO(doctor));
    }

    /*
     * Exemplo de metodo que retorna uma entidade completa da JPA. Isso é 
     * uma ma pratica, pois pode ter campos que não queremos que sejam vistos
     * como a senha do usuario por exemplo. Os metodos seguinte vao corrigir isso 
     */
    @GetMapping(value =  "/full") // /doctors/full -> o @RequestMapping tem o padrao
    public List<Doctor> findAllFullEntities(){
        return repository.findAll();
    }

    /*
     * Criar metodo que devolva:
     * - Name | - Email | - Crm | - Specialty
     * Então, não podemos utilizar um metodo como o anterior, 
     * pois ele esta  devolvendo a entidade inteira, e não queremos isso
     * 
     * 1- Depois de criar o DoctorResponseDTO, precisamos lidar com o problema
     * de que o repository so devolve a entidade completa, e não o dto, então
     * precisamos fazer uma conversão.
     *  Então: 
     *      - Pegamos a lista de Doctor devolvida do repository.findAll()
     *      - Realizamos um stram para separar todos os Doctors.
     *      - Realizamos um map para fazer uma ação em cada um deles
     *      - E então, usamos o Doctor para construtir o nosso DTO
     *
     * 2- Com isso concluido, começamos a fazer a paginação da resposta
     *     - Primeiramente então passamos um objeto Pageable como parametro do metodo findAll
     *     (no nosso, e depois do no proprio repositorio)
     *     - Então, mudamos o tipo do retorno de List para Page
     *     - Por ultimo, removemos o .stream() e o .toList(), pois o Page ja tem um 
     *     metodo map, que devolve um Page também.
     *  
     * 2.5- A Paginação não acaba por aqui, tem alguns conceitos que precisam ser entendidos 
     * mas são sobre o funcionamento do endpoint da api,
     * 
     *      - Size: Determina o tamanho da pagina que você deseja 
     *      - Page: Determina a pagina que você quer
     * 
     *      Então, se eu tenho 3 cadastros e determino o size=1, para pegar o 3 cadastro, 
     *      eu preciso adicionar tbm o page=3
     * 
     * 3- Podemos fazer a ordenação e configuração da paginação default utilizando o @PageableDefault
     *      - Podemos colocar o size que queremos
     *      - A page que desejamos utilizar (o padrão é a 0)
     *      - E podemos colocar o sort, que recebe um array, dentro dele o nome 
     *      do atributo que desejamos que a paginação seja feita
     *    Esse padrão é mudado como alteremos a URL
     */
    @GetMapping // Não precisa de @Transactional
    public ResponseEntity<Page<DoctorResponseDTO>> findAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pagination){
        var page = repository.findAllByActiveTrue(pagination).map(DoctorResponseDTO::new);
        return ResponseEntity.ok(page); 
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid DoctorUpdateDTO data){
        Doctor doctor = repository.getReferenceById(data.id());
        doctor.updateInfo(data);

        return ResponseEntity.ok(new DoctorDetailsDTO(doctor));
    }

    /*
     * Aqui estamos fazendo uma exclusão completa de um Doctor ou seja, ele sera excluido 
     * completamente do banco de dados, também veremos como realizar uma exclusão logica
     * que não deleta o Doctor do banco de dados, e so o deixa inatvio
     * 
     * 1- Precisamos colocar no DeleteMapping o caminho que usaremos para deletar determinado
     * Doctor, para isso, colocamos o /{id} para indicar que a exclusão sera feita com este
     * 
     * 2- Então, precisamos colocar dentro do delete() o Long ID junto da @PathVariable
     * indicando que aquele parametro tem ligação com o caminho da url
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        Doctor doctor = repository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }
}