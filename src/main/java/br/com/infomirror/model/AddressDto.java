package br.com.infomirror.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AddressDto(String cep,
                         String logradouro,
                         String bairro,
                         String localidade,
                         String uf,
                         String estado) {
}
