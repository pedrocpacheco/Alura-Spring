package med.voll.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.adress.AdressData;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Adress {

    public Adress(AdressData data){
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

}
