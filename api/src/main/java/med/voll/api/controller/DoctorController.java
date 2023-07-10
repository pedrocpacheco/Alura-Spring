package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DoctorRequestDTO;
import med.voll.api.dto.doctor.DoctorResponseDTO;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorRepository repository;

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
     */
    @GetMapping // Não precisa de @Transactional
    public List<DoctorResponseDTO> list(){
        return repository.findAll().stream().map(DoctorResponseDTO::new).toList();
    }
    

    @PostMapping        // 1- Requisições Post precisam do @RequestBody
    @Transactional                    // Pede pro Spring conversar com o BeanValidation
    public void register(@RequestBody @Valid DoctorRequestDTO data){
        repository.save(new Doctor(data));
    }

}
