package com.clinicaOdontologica.ClinicaOdonto.model.dto;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DentistaDTO {
    private int id;
    private String nome;
    private String sobrenome;

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
    }
}
