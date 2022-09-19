package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.exception.ResourceNotFoundException;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping
    public ResponseEntity salvarPaciente(@RequestBody Paciente paciente) {
        return new ResponseEntity(service.salvar(paciente),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity buscarPacientes() throws SQLException {

        return new ResponseEntity(service.buscarTodos(),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterarPaciente(@RequestBody Paciente paciente) {
        service.alterar(paciente);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id) throws ResourceNotFoundException {
        service.excluir(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarid", method = RequestMethod.GET)
    public ResponseEntity buscarPorId(@RequestParam("id") Long id) throws ResourceNotFoundException {

        return new ResponseEntity(service.buscarPorId(id), HttpStatus.OK);
    }

}
