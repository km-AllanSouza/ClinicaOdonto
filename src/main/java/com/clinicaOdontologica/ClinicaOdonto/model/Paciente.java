package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Paciente {
    private int id;
    private String nome;
    private String sobrenome;
    private String telefone;
    private int endereco;
    private String cpf;
    private String dataCadastro;

    public Paciente(String nome, String sobrenome, String telefone, int endereco, String cpf, String dataCadastro) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.dataCadastro = dataCadastro;
    }

    public Paciente(Integer id, String nome, String sobrenome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }


}
