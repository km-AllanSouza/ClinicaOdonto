package com.clinicaOdontologica.ClinicaOdonto.dao.impl;

import com.clinicaOdontologica.ClinicaOdonto.dao.ConfigurationJDBC;
import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PacienteDAOH2 implements IDao <Paciente> {

    private static final Logger logger = LogManager.getLogger(PacienteDAOH2.class);

    ConfigurationJDBC configurationJDBC = new ConfigurationJDBC("org.h2.Driver", "jdbc:h2:~/ClinicaOdonto;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
    Connection connection = null;

    @Override
    public Paciente salvar(Paciente paciente) throws SQLException {
        String SQLINSERT = String.format("INSERT INTO PACIENTES (nome, sobrenome, endereco, cpf, dataCadastro) VALUES('%s','%s','%s','%s','%s')",
                paciente.getNome(), paciente.getSobrenome(), paciente.getEndereco(), paciente.getCpf(), paciente.getDataCadastro());

        try {
            connection = configurationJDBC.getConnection();
            logger.info("conexao aberta");
            Statement stmt = connection.createStatement();

            stmt.execute(SQLINSERT);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Paciente> buscar() throws SQLException {
        return null;
    }

    @Override
    public void alterar(Paciente paciente) throws SQLException {

    }

    @Override
    public void excluir(int id) throws SQLException {

    }
}
