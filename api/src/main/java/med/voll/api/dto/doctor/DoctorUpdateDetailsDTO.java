package med.voll.api.dto.doctor;

import med.voll.api.entity.Adress;
import med.voll.api.entity.Doctor;
import med.voll.api.entity.Specialty;

public record DoctorUpdateDetailsDTO(Long id, String name, String email, String phone, String crm, Specialty specialty, Adress adress) {

    public DoctorUpdateDetailsDTO(Doctor doctor){
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(),doctor.getCrm(), doctor.getSpecialty(), doctor.getAdress());
    }
    
}
