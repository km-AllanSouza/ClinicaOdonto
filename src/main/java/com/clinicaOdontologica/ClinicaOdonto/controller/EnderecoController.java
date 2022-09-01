package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.EnderecoDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.EnderecoService;
import com.clinicaOdontologica.ClinicaOdonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    EnderecoService service;
    @PostMapping
    public Endereco salvarEndereco(@RequestBody Endereco endereco) throws SQLException {
        return service.salvar(endereco);
    }
    @GetMapping
    public List<EnderecoDTO> buscarEnderecos() throws SQLException {
        return service.buscarTodos();
    }
}
