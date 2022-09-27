package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import com.clinicaOdontologica.ClinicaOdonto.model.Horario;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.ConsultaService;
import com.clinicaOdontologica.ClinicaOdonto.service.EnderecoService;
import com.clinicaOdontologica.ClinicaOdonto.service.HorarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    @Autowired
    ConsultaService service;
    private static final Logger logger = LogManager.getLogger(EnderecoController.class);

    @PostMapping
    public ResponseEntity salvar(@RequestBody Consulta consulta) throws SQLException {
        logger.info("o metodo salvar foi acionado");
        return service.salvar(consulta);
    }

    @GetMapping
    public ResponseEntity buscarTodos() throws SQLException {
        logger.info("o metodo buscarTodos foi acionado");
        return new ResponseEntity(service.buscarTodos(),HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterar(@RequestBody Consulta consulta) throws SQLException {
        logger.info("o metodo alterar foi acionado");
        service.alterar(consulta);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity excluir(@RequestParam Long id) throws SQLException {
        logger.info("o metodo excluir foi acionado");
        service.excluir(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/buscarid", method = RequestMethod.GET)
    public ResponseEntity buscarPorId(@RequestParam("id") Long id) throws SQLException {
        logger.info("o metodo buscarId foi acionado");
        ObjectMapper mapper = new ObjectMapper();

        Optional<Consulta> consultaOptional = service.buscarPorId(id);
        if(consultaOptional.isEmpty()){
            return new ResponseEntity("Paciente não foi encontrado", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(consultaOptional, HttpStatus.OK);
    }

}
