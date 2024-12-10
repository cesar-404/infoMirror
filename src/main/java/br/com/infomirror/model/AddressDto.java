package br.com.infomirror.model;

public record AddressDto(String cep,
                         String logradouro,
                         String numero,
                         String complemento,
                         String bairro,
                         String localidade,
                         String uf,
                         String estado) {
}
