package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.ConsultaRepository;
import com.clinicaOdontologica.ClinicaOdonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository repository;

    public Consulta salvar(Consulta consulta){
        return repository.save(consulta);
    }

    public List<Consulta> buscarTodos(){
        List<Consulta> consultaList = repository.findAll();

        return consultaList;
    }

    public void alterar(Consulta consulta){
        repository.save(consulta);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Optional<Consulta> buscarPorId(Long id){
        return repository.findById(id);
    }
}
