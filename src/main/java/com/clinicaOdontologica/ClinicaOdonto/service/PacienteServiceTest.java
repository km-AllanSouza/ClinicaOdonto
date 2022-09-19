package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional

class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    static Paciente pacienteTeste;

    @BeforeEach
    void doBefore(){

        pacienteTeste = new Paciente("Filho","doBill","5487982314","518.432.145-54");

    }

    @Test
    void testeSalvar(){
        pacienteTeste = pacienteService.salvar(pacienteTeste);
        assertTrue(pacienteTeste.getId() >0);
    }

    @Test
    void testeBuscaId()  {
        pacienteTeste = pacienteService.salvar(pacienteTeste);

        Optional<Paciente> result = pacienteService.buscarPorId(pacienteTeste.getId());
        assertEquals(pacienteTeste, result.orElse(null));
    }

    @Test
    void testeBuscarTodos(){
        Paciente paciente2 = new Paciente("Mulher","doBill","547182314","547.144.145-54");
        pacienteService.salvar(paciente2);
        pacienteTeste = pacienteService.salvar(pacienteTeste);

        List<PacienteDTO> result = pacienteService.buscarTodos();
        assertTrue(result.size() > 1);
    }
    @Test
    void testeExcluir()  {
        pacienteTeste = pacienteService.salvar(pacienteTeste);
        pacienteService.excluir(pacienteTeste.getId());

        assertFalse(pacienteService.buscarPorId(pacienteTeste.getId()).isPresent());
    }

    @Test
    void testeAlterar() {

        pacienteTeste = pacienteService.salvar(pacienteTeste);

        String novoNome = "carlos";
        String novoSobrenome = "doBill";

        pacienteTeste.setNome(novoNome);
        pacienteTeste.setSobrenome(novoSobrenome);
        pacienteService.alterar(pacienteTeste);

        Optional<Paciente> result = pacienteService.buscarPorId(pacienteTeste.getId());
        Paciente pacienteAlterado = result.get();
        assertSame(pacienteAlterado.getNome(), novoNome);
        assertSame(pacienteAlterado.getSobrenome(), novoSobrenome);

    }

}