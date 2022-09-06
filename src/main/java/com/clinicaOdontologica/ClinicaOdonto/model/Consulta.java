package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idDentista;
    private int idPaciente;
    private String dataHorario;

    public Consulta(int idDentista, int idPaciente, String dataHorario) {
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
        this.dataHorario = dataHorario;
    }
}
