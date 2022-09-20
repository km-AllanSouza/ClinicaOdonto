package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.exception.ResourceNotFoundException;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    //public List<Paciente> buscarTodos(){
//        return repository.findAll();
//    }
    public List<PacienteDTO> buscarTodos(){
        List<Paciente> pacienteList = repository.findAll();
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();

        for (Paciente e: pacienteList) {
            pacienteDTOList.add(new PacienteDTO(e));
        }

        return pacienteDTOList;
    }

    public void alterar(Paciente paciente){
        repository.save(paciente);
    }

    public void excluir(Long id) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao excluir produto, id informado não existe"));
        repository.deleteById(id);
    }

//    public Paciente buscarPorId(Long id) throws ResourceNotFoundException {
//        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Erro ao excluir produto, id informado não existe"));
//    }

    public PacienteDTO buscarPorId(Long id) throws ResourceNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        Paciente paciente = null;

        try {
            Optional<Paciente> pacienteOptional = repository.findById(id);
            paciente = pacienteOptional.get();
        } catch (Exception e) {
            throw new ResourceNotFoundException("ID invalido, este paciente não existe");
        }

        PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);

        return pacienteDTO;
    }


}
