package med.voll.api.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.adress.AdressData;

/*
 * Estamos criando um novo DTO que contem apenas as informações que desejamos
 * modificar com uma atualização da entidade
 * 
 * Criamos isso pois, podem ter informações que o usuario pode mudar, e outras que não 
 * serão permitidas (como um salario, por exemplo), por isso precisamos desse novo DTO
 * 
 * No nosso caso, o usuario poderá modificar apenas o 
 */
public record DoctorUpdateDTO(

    @NotNull 
    Long id,
    String name, 
    String phone, 
    AdressData adress
    
    ) {
    
}
/* Como nos precisamos saber qual é o Doctor
 * Que desejamos modificar, deixamos o id obrigatorio
 * Isso não quer dizer que o usuario vai mudar de ID
 * E sim que ele precisa informa-lo
 */