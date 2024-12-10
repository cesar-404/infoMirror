package br.com.infomirror.model.controller;

import br.com.infomirror.model.Address;

import java.time.LocalDate;

public record FinalUserDto(String username,
                           LocalDate birthdate,
                           String cpf,
                           String cep,
                           Address address) {
}