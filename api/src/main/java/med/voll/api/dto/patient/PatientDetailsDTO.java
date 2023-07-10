package med.voll.api.dto.patient;

import med.voll.api.entity.Adress;
import med.voll.api.entity.Patient;

public record PatientDetailsDTO(Long id, String name, String email, String phone, String cpf, Adress adress) {
    
    public PatientDetailsDTO(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), patient.getAdress());
    }

}
