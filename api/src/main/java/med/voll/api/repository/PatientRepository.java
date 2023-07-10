package med.voll.api.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    Page<Patient> findAllByActiveTrue(Pageable pagination);
    
}