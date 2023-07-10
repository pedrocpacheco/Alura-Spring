package med.voll.api.dto.doctor;

import med.voll.api.entity.Doctor;
import med.voll.api.entity.Specialty;

/*
 * Este é o DTO de Resposta da API, ou seja, quando alguem fazer uma requisição
 * GET para doctors, ele tera um retorno desta classe
 * 
 * Nest record então, colocamos apenas as informações que desejamos que sejam mostradas
 * ao usuario que fazer a requisição
 * 
 * 1- Precisamos lidar com o problema de que o repository no controller apenas devolve
 * entidades completas, e não um dto que desejamos.
 *    - Para lidar com isso, criamos aqui um construtor que receba a nossa entidade
 */
public record DoctorResponseDTO(String name, String email, String crm, Specialty specialty) {
    
    public DoctorResponseDTO(Doctor doctor){
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }


}
