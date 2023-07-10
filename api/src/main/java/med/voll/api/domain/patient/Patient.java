package med.voll.api.domain.patient;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.voll.api.domain.adress.Adress;
import med.voll.api.domain.patient.dto.PatientRequestDTO;
import med.voll.api.domain.patient.dto.PatientUpdateDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "tb_patient")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_patient")
    private String name; 

    @Column(name = "em_patient")
    private String email;

    @Column(name = "phone_patient")
    private String phone;

    @Column(name = "cpf_patient")
    private String cpf;

    @Embedded
    private Adress adress;

    private Boolean active;

    public Patient(PatientRequestDTO data){
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.cpf = data.cpf();
        this.adress = new Adress(data.adress());
    }

    public void updateInfo(PatientUpdateDTO data){
        if(data.name() != null)
            this.name = data.name();
        if(data.phone() != null)
            this.phone = data.phone();
        if(data.adress() != null)
            this.adress.updateInfo(data.adress());
    }

    public void delete(){
        this.active = false;
    }

}
