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
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnderecos")
    private Long id;
    private String estado;
    private String cidade;
    private String cep;
    private String rua;
    private String numero;

    public Endereco(String estado, String cidade, String cep, String rua, String numero) {
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco(Long id, String cidade, String rua, String numero) {
        this.id = id;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }
}
