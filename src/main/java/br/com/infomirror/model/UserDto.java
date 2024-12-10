package br.com.infomirror.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserDto(@NotBlank String username,
                      @Past
                      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                      @NotNull
                      LocalDate birthDate,
                      @Size(min = 11, max = 11)
                      @NotBlank
                      String cpf,
                      @NotBlank
                      String cep) {
}