package br.com.infomirror.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private LocalDate birthDate;

    private String cpf;

    private String cep;

    @Embedded
    private Address address;

    public User() {
    }
}
