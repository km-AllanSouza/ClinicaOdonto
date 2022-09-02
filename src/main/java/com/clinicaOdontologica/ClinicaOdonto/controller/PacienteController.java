package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
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
    public List<PacienteDTO> buscarPacientes() throws SQLException {
        return service.buscarTodos();
    }

    @PatchMapping
    public void alterarPaciente(@RequestBody Paciente paciente) throws SQLException {
        service.alterar(paciente);
    }

    @DeleteMapping
    public void delete(@RequestParam int id) throws SQLException {
        service.excluir(id);
    }



}
