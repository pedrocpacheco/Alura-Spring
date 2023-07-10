package med.voll.api.domain.doctor.dto;

import med.voll.api.domain.adress.Adress;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.Specialty;

public record DoctorDetailsDTO(Long id, String name, String email, String phone, String crm, Specialty specialty, Adress adress) {

    public DoctorDetailsDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(),doctor.getCrm(), doctor.getSpecialty(), doctor.getAdress());
    }
    
}
