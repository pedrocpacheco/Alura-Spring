package med.voll.api.dto.doctor;

import med.voll.api.dto.adress.AdressData;

public record DoctorData(String name, String email, String crm, Specialty specialty, AdressData adress) {

}

// 1- Classes record são classes imutaveis que ja fazem coisas automaticamente
// 2- Como os dados nunca vão mudar (não os seus valores, sua estrutura) podemos usar o record
