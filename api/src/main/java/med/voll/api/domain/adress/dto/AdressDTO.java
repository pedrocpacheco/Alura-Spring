package med.voll.api.domain.adress.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AdressDTO(
    
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
