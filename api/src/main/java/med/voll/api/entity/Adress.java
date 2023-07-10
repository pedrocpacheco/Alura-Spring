package med.voll.api.entity;

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
    
    private String street;

    private String neighborhood;
    
    private String cep; 

    private String city; 
    
    private String uf; 
    
    private String complement;

    private String number;

}
