package med.voll.api.domain.adress;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.domain.adress.dto.AdressDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adress {

    public Adress(AdressDTO data){
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.cep = data.cep();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.number = data.number(); 
    }
    
    @Column(name = "street_doctor")
    private String street;

    @Column(name = "neigh_doctor")
    private String neighborhood;
    
    @Column(name = "cep_doctor")
    private String cep; 

    @Column(name = "city_doctor")
    private String city; 
    
    @Column(name = "uf_doctor")
    private String uf; 
    
    @Column(name = "comp_doctor")
    private String complement;

    @Column(name = "num_doctor")
    private String number;

    /*
     * Aqui, fazemos a mesma coisa que realizamos na classe Doctor. Estamos modificando os dados
     * do objeto Adress com as informações passadas pelo objeto data. Mas, precisamos realizar
     * as validações com os blocos ifs, pois o usuario pode não querer atualizar seu endereço todo
     * 
     * Detalhe que, nesse caso, o usuario tem acesso de modificar o seu endereço por completo, então
     * não precisamos criar outro DTO exclusivo para update, como fizemos com o Doctor.
     */
    public void updateInfo(AdressDTO data){
        if(data.street() != null)
            this.street = data.street();
        if(data.neighborhood() != null)
            this.neighborhood = data.neighborhood();
        if(data.cep() != null)
            this.cep = data.cep();
        if(data.city() != null)
            this.city = data.city();
        if(data.uf() != null)
            this.uf = data.uf();
        if(data.complement() != null)
            this.complement = data.complement();
        if(data.number() != null)
            this.number = data.number();
    }

}
