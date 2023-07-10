package med.voll.api.domain.patient.dto;

import med.voll.api.domain.patient.Patient;

public record PatientResponseDTO(Long id, String name, String email, String cpf) {

    public PatientResponseDTO(Patient patient){
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }

}
