package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.DentistaDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
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
    public ResponseEntity salvarDentista(@RequestBody Dentista dentista) {
        return new ResponseEntity("Operação concluida"+service.salvar(dentista), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity buscarDentistas() throws SQLException{
        return new ResponseEntity("Resultado da busca: "+service.listarDentistas(), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity alterarDentista(@RequestBody Dentista dentista){
        service.alterar(dentista);
        return new ResponseEntity(dentista.getId()+" Alterado",HttpStatus.OK );
    }

    @DeleteMapping
    public ResponseEntity deleteDentista(@RequestParam Long id)  {
        service.excluir(id);
        return new ResponseEntity(id +" Excluido.",HttpStatus.OK);
    }
    @RequestMapping( value ="/buscaid", method = RequestMethod.GET)
    public ResponseEntity buscarDentistaId(@RequestParam("id") Long id) throws SQLException {
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
