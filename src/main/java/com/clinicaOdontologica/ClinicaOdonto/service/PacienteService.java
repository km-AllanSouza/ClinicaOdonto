package com.clinicaOdontologica.ClinicaOdonto.service;


import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public Paciente salvar(Paciente paciente){
        return repository.save(paciente);
    }

    public List<PacienteDTO> buscarTodos(){
        List<Paciente> pacienteList = repository.findAll();
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();

        for(Paciente e : pacienteList){
            pacienteDTOList.add(new PacienteDTO(e));
        }

        return pacienteDTOList;
    }

    public void alterar(Paciente paciente){
        repository.save(paciente);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Optional<Paciente> buscarPorId(Long id){
        return repository.findById(id);
    }


}
