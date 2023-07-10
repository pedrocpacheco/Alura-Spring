package med.voll.api.dto.patient;

import med.voll.api.entity.Patient;

public record PatientResponseDTO(Long id, String name, String email, String cpf) {

    public PatientResponseDTO(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }

}
