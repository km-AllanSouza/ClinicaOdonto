package com.clinicaOdontologica.ClinicaOdonto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String telefone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;
    private String cpf;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dataCadastro;

    public Paciente(Long id, String nome, String sobrenome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
}
