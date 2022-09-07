package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDentistas")
    private Long id;
    private String nome;
    private String sobrenome;
    private String matricula;

    public Dentista(String nome, String sobrenome, String matricula) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
    }
}
