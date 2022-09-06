package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    private int id;
    private int idDentista;
    private int idPaciente;
    private String dataHorario;

    public Consulta(int idDentista, int idPaciente, String dataHorario) {
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
        this.dataHorario = dataHorario;
    }
}
