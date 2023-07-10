package med.voll.api.dto.adress;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdressData(
    
    @NotBlank
    String street, 

    @NotBlank
    String neighborhood, 

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    String cep,
    
    @NotBlank
    String city, 

    @NotBlank
    String uf, 

    String complement, 
    
    String number) {
    
}
