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
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "idDentista")
    private Dentista idDentista;
    @OneToOne
    @JoinColumn(name = "idPaciente")
    private Paciente idPaciente;
    private String dataHorario;

    public Consulta(Dentista idDentista, Paciente idPaciente, String dataHorario) {
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
        this.dataHorario = dataHorario;
    }
}
