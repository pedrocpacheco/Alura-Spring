package med.voll.api.dto.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.adress.AdressData;

public record PatientUpdateDTO(
    
    @NotNull
    Long id, 
    
    String name, 
    
    String phone, 
    
    AdressData adress) {
    
}
