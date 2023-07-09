package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.doctor.DoctorData;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    
    @PostMapping        // 1- Requisições Post precisam do @RequestBody
    public void register(@RequestBody DoctorData data){



    }

}
