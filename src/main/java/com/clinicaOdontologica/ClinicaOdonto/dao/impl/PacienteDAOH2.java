package com.clinicaOdontologica.ClinicaOdonto.dao.impl;

import com.clinicaOdontologica.ClinicaOdonto.dao.ConfigurationJDBC;
import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Configuration
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

            stmt.execute(SQLINSERT, stmt.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            logger.info("dados inseridos com sucesso");

            if(rs.next()){
                paciente.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
            logger.info("fechando conexao");

        }
        return paciente;
    }

    @Override
    public List<Paciente> buscarTodos() throws SQLException {
        String SQLQUERY = "SELECT * FROM PACIENTES";
        List<Paciente> paciente = new ArrayList<>();

        try {
            connection = configurationJDBC.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQUERY);

            while (rs.next()){
                paciente.add(criarObjetoProduto(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }

        return paciente;
    }

    @Override
    public void alterar(Paciente paciente) throws SQLException {

    }

    @Override
    public void excluir(int id) throws SQLException {

    }

    private Paciente criarObjetoProduto(ResultSet rs) throws SQLException {

        Integer id = rs.getInt("idPaciente");
        String nome = rs.getString("nome");
        String sobrenome = rs.getString("sobrenome");
        return new Paciente(id, nome, sobrenome);

    }
}
