package med.voll.api.domain.patient.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.adress.dto.AdressDTO;

public record PatientRequestDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String phone,
        
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotNull @Valid AdressDTO adress) {
}
