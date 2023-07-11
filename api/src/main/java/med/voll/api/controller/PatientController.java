package med.voll.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.patient.Patient;
import med.voll.api.domain.patient.PatientRepository;
import med.voll.api.domain.patient.dto.PatientDetailsDTO;
import med.voll.api.domain.patient.dto.PatientRequestDTO;
import med.voll.api.domain.patient.dto.PatientResponseDTO;
import med.voll.api.domain.patient.dto.PatientUpdateDTO;

@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    private PatientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PatientDetailsDTO> register(@RequestBody @Valid PatientRequestDTO data, UriComponentsBuilder uriBuilder){
        Patient patient = new Patient(data);
        repository.save(patient);

        URI uri = uriBuilder.path("/doctors/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new PatientDetailsDTO(patient));
    }

    @GetMapping
    public ResponseEntity<Page<PatientResponseDTO>> findAllByActiveTrue(@PageableDefault(size= 10, sort = "name") Pageable pagination){
        var page = repository.findAllByActiveTrue(pagination).map(PatientResponseDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PatientDetailsDTO> update(@RequestBody @Valid PatientUpdateDTO data){
        Patient patient = repository.getReferenceById(data.id());
        patient.updateInfo(data);

        return ResponseEntity.ok(new PatientDetailsDTO(patient));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Patient patient = repository.getReferenceById(id);
        patient.delete();

        return ResponseEntity.noContent().build();
    }

}
