package com.clinicaOdontologica.ClinicaOdonto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "idUsuario")
    private Long id;

    @Email
    @NotEmpty(message = "Campo email não pode ser vazio")
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDentista")
    private Dentista dentista;

}
