package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private Endereco endereco;
    private String cpf;
    private LocalDateTime dataCadastro;

    public Paciente(String nome, String sobrenome, Endereco endereco, String cpf, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }
}
