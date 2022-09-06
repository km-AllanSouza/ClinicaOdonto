package com.clinicaOdontologica.ClinicaOdonto.service;


import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    IDao<Paciente> pacienteDAOH2;

    public Paciente salvar(Paciente paciente) throws SQLException {
        return pacienteDAOH2.salvar(paciente);
    }

//    public List<Paciente> buscarTodos() throws SQLException {
//        return pacienteDAOH2.buscarTodos();
//    }

    public List<PacienteDTO> buscarTodos() throws SQLException {
        List<Paciente> pacienteList = pacienteDAOH2.buscarTodos();
        List<PacienteDTO> pacienteDTOList = new ArrayList<>();

        for(Paciente e : pacienteList){
            pacienteDTOList.add(new PacienteDTO(e));
        }

        return pacienteDTOList;
    }

    public void alterar(Paciente paciente) throws SQLException {
        pacienteDAOH2.alterar(paciente);
    }

    public void excluir(int id) throws SQLException {
        pacienteDAOH2.excluir(id);
    }

    public Optional<Paciente> buscarPorId(int id) throws SQLException {
        return pacienteDAOH2.buscarPorId(id);
    }


}
