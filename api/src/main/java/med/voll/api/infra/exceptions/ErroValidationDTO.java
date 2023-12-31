package med.voll.api.infra.exceptions;

import org.springframework.validation.FieldError;

public record ErroValidationDTO(String field, String message) {
    
    public ErroValidationDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }

}
