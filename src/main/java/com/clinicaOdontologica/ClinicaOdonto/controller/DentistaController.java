package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.DentistaDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

    @PatchMapping
    public void alterarDentista(@RequestBody Dentista dentista) throws SQLException {
        service.alterar(dentista);
    }

    @DeleteMapping
    public void deleteDentista(@RequestParam int id) throws SQLException {
        service.excluir(id);
    }
    @RequestMapping( value ="/buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarDentistaId(@RequestParam("id") int id) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Dentista> dentistaOptional = service.buscarDentistaId(id);
        if(dentistaOptional.isEmpty()){
            return new ResponseEntity("Dentista nao cadastrado", HttpStatus.NOT_FOUND);
        }
        Dentista dentista = dentistaOptional.get();
        DentistaDTO dentistaDTO = mapper.convertValue(dentista,DentistaDTO.class);

        return new ResponseEntity(dentistaDTO,HttpStatus.OK);
    }

}
