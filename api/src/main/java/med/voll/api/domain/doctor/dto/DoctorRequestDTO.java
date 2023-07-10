package med.voll.api.domain.doctor.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.adress.dto.AdressDTO;
import med.voll.api.domain.doctor.Specialty;

public record DoctorRequestDTO(

    //@NotNull
    @NotBlank // -> @NotBlank ja usa o @NotNull
    String name, 

    @NotBlank
    @Email
    String email, 

    @NotBlank
    String phone,

    @NotBlank
    @Pattern(regexp = "\\d{4,6}") // numero de 4 à 6 digitos
    String crm, 
    
    @NotNull // Not blanck é só para String
    Specialty specialty, 
    
    @NotNull
    @Valid  // Como é outro DTO, precisa validar la tambem
    AdressDTO adress

    ) {

}

// 1- Classes record são classes imutaveis que ja fazem coisas automaticamente
// 2- Como os dados nunca vão mudar (não os seus valores, sua estrutura) podemos usar o record

// Bean Validation:
