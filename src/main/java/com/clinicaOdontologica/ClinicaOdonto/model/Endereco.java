package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
    private int id;
    private String estado;
    private String cidade;
    private String cep;
    private String rua;
    private String numero;

    public Endereco(int id, String cidade, String rua, String numero) {
        this.id = id;
        this.cidade = cidade;
        this.rua = rua;
        this.numero = numero;
    }
}
