package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/buscarId", method = RequestMethod.GET)
    public ResponseEntity buscarPorId(@RequestParam("id") int id) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Paciente> pacienteOptional = service.buscarPorId(id);
        if(pacienteOptional.isEmpty()){
            return new ResponseEntity("Paciente não foi encontrado", HttpStatus.NOT_FOUND);
        }

        Paciente paciente =  pacienteOptional.get();
        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);

        return new ResponseEntity(pacienteDTO, HttpStatus.OK);
    }

}
