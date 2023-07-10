package med.voll.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import med.voll.api.entity.Doctor;
                                                        // Obj | Id
public interface DoctorRepository extends JpaRepository<Doctor, Long>{    

}
