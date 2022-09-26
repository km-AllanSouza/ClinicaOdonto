package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Horario;
import com.clinicaOdontologica.ClinicaOdonto.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/horario")
public class HorarioController {
    @Autowired
    HorarioService service;
    @PostMapping
    public ResponseEntity salvarHorario(@RequestBody Horario horario) throws SQLException {
        return new  ResponseEntity(service.salvar(horario), HttpStatus.OK) ;
    }
    @GetMapping
    public  ResponseEntity buscarHorario() throws  SQLException{
        return new ResponseEntity(service.buscarTodos(),HttpStatus.OK);
    }
    @PatchMapping
    public  ResponseEntity alterar(@RequestBody Horario horario){
        if (!service.alterar(horario)){
            return new ResponseEntity<>("Horario não encontrado", HttpStatus.NOT_FOUND);
        }

        return new  ResponseEntity("Alterado horario de Id: "+horario.getId(), HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity excluir(@RequestParam("id") Long id){
        if (!service.excluir(id)){
            return new ResponseEntity("Horario não encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Excluido Horario de ID: "+id,HttpStatus.OK);
    }
}
