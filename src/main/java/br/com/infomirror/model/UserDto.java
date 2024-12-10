package br.com.infomirror.model;

import java.time.LocalDate;

public record UserDto(String username,
                      LocalDate birthDate,
                      String cpf,
                      String cep) {
}
