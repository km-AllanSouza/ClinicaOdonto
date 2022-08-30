package com.clinicaOdontologica.ClinicaOdonto.service;


import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PacienteService {

    @Autowired
    IDao<Paciente> pacienteDAOH2;

    public Paciente salvar(Paciente paciente) throws SQLException {
        return pacienteDAOH2.salvar(paciente);
    }
}
