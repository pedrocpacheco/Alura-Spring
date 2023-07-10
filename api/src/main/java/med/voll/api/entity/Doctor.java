package med.voll.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.dto.doctor.Specialty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_doctor")
public class Doctor {
    
    @Id
    @SequenceGenerator(name = "doctor", sequenceName = "sq_tb_doctor", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "doctor")
    @Column(name = "id_doctor")
    private Long id;

    @Column(name = "nm_doctor")
    private String name;

    @Column(name = "em_doctor")
    private String email;

    @Column(name = "crm_doctor")
    private String crm;

    @Column(name = "spe_doctor")
    private Specialty specialty;

    @Column(name = "adr_doctor")
    private Adress adress;

}
