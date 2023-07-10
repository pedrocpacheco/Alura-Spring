package med.voll.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
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
import med.voll.api.dto.doctor.DoctorRequestDTO;
import med.voll.api.dto.doctor.DoctorUpdateDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "tb_doctor")
public class Doctor {
    
    public Doctor(DoctorRequestDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.adress =  new Adress(data.adress());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_doctor")
    private String name;

    @Column(name = "em_doctor")
    private String email;

    @Column(name = "phone_doctor")
    private String phone;
    // Adicionado depois -> precisa criar outra migration

    @Column(name = "crm_doctor")
    private String crm;

    @Enumerated
    @Column(name = "spe_doctor")
    private Specialty specialty;

    @Embedded
    private Adress adress;

    /*
     * Estamos querendo atualizar os dados de um Doctor,para isso, criamos um novo DTO 
     * e passamos ele como Parametro para este metodo. O que vamos fazer, é modificar
     * os dados do objeto Doctor pelos dados que o objeto data possui.
     * 
     * Mas, precisamos fazer uma validação antes, pois pode ser que o usuario não deseje
     * mudar todos os atributos de uma vez, por isso utilizamos esses ifs
     *
     * Como o Adress é uma Classe por si so, criamos um metodo igual a este nela, e passamos
     * o data.adress() que devolve um AdressData como parametro do metodo
     */
    public void updateInfo(DoctorUpdateDTO data){
        if(data.name() != null)
            this.name = data.name();
        if(data.phone() != null)
            this.phone = data.phone();
        if(data.adress() != null)
            this.adress.updateInfo(data.adress());
    }

}
