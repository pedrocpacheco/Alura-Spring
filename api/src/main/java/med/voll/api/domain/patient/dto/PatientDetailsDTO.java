package med.voll.api.domain.patient.dto;

import med.voll.api.domain.adress.Adress;
import med.voll.api.domain.patient.Patient;

public record PatientDetailsDTO(Long id, String name, String email, String phone, String cpf, Adress adress) {
    
    public PatientDetailsDTO(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAdress());
    }

}
