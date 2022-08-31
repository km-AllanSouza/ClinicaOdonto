package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    public Paciente salvarPaciente(@RequestBody Paciente paciente) throws SQLException {
        return service.salvar(paciente);
    }

    @GetMapping
    public List<Paciente> buscarPacientes() throws SQLException {
        return service.buscarTodos();
    }



}
