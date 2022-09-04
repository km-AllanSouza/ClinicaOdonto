package com.clinicaOdontologica.ClinicaOdonto.controller;

import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.EnderecoDTO;
import com.clinicaOdontologica.ClinicaOdonto.service.EnderecoService;
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
    @PatchMapping
    public  void alterar(@RequestBody Endereco endereco)throws SQLException{
        service.alterar(endereco);
    }
    @DeleteMapping
    public void excluir(@RequestParam("id") int id)throws SQLException{

        service.excluir(id);
    }
    @RequestMapping(value = "/buscaId", method = RequestMethod.GET)
    public ResponseEntity buscarPorId(@RequestParam("id")int id)throws SQLException{
        ObjectMapper mapper = new ObjectMapper();
        Optional<Endereco> enderecoOptional = service.buscaPorId(id);
        if (enderecoOptional.isEmpty()){
            return new ResponseEntity("Endereco não encontrado", HttpStatus.NOT_FOUND);
        }
        Endereco endereco = enderecoOptional.get();
        EnderecoDTO enderecoDTO = mapper.convertValue(endereco, EnderecoDTO.class);
        return new ResponseEntity(enderecoDTO, HttpStatus.OK);
    }
}
