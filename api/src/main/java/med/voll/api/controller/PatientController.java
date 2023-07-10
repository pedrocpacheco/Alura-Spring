package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.patient.PatientRequestDTO;
import med.voll.api.dto.patient.PatientResponseDTO;
import med.voll.api.dto.patient.PatientUpdateDTO;
import med.voll.api.entity.Patient;
import med.voll.api.repository.PatientRepository;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PatientRequestDTO data){
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientResponseDTO> findAllByActiveTrue(@PageableDefault(size= 10, sort = "name") Pageable pagination){
        return repository.findAllByActiveTrue(pagination).map(PatientResponseDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateDTO data){
        Patient patient = repository.getReferenceById(data.id());
        patient.updateInfo(data);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);
        patient.delete();
    }

}
