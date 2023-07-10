package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.dto.doctor.DoctorData;
import med.voll.api.entity.Doctor;
import med.voll.api.repository.DoctorRepository;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorRepository repository;

    @GetMapping
    public List<Doctor> findAll(){
        return repository.findAll();
    }

    @PostMapping        // 1- Requisições Post precisam do @RequestBody
    @Transactional
    public void register(@RequestBody DoctorData data){
        repository.save(new Doctor(data));
    }

}
