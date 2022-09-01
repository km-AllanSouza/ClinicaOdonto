package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.DentistaDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/dentista")
public class DentistaController {

    @Autowired
    DentistaService service;

    @PostMapping
    public Dentista salvarDentista(@RequestBody Dentista dentista) throws SQLException {
        return service.salvar(dentista);
    }

    @GetMapping
    public List<DentistaDTO> buscarDentistas() throws SQLException{
        return service.listarDentistas();
    }

}
