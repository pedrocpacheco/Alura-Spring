package med.voll.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import med.voll.api.dto.doctor.DoctorData;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "tb_doctor")
public class Doctor {
    
    public Doctor(DoctorData data) {
        this.name = data.name();
        this.email = data.email();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.adress =  new Adress(data.adress());
    }

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

    @Enumerated
    @Column(name = "spe_doctor")
    private Specialty specialty;

    @Embedded
    private Adress adress;

}
