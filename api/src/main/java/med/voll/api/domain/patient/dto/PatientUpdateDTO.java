package med.voll.api.domain.patient.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.adress.dto.AdressDTO;

public record PatientUpdateDTO(
    
    @NotNull
    Long id, 
    
    String name, 
    
    String phone, 
    
    AdressDTO adress) {
    
}
