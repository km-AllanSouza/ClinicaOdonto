package com.clinicaOdontologica.ClinicaOdonto.dao.impl;

import com.clinicaOdontologica.ClinicaOdonto.dao.ConfigurationJDBC;
import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class DentistaDAOH2 implements IDao<Dentista> {
    private static final Logger logger = LogManager.getLogger(PacienteDAOH2.class);

    ConfigurationJDBC configurationJDBC = new ConfigurationJDBC("org.h2.Driver", "jdbc:h2:~/ClinicaOdonto;INIT=RUNSCRIPT FROM 'src/main/resources/create.sql'", "sa", "");
    Connection connection = null;


    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        String SQLINSERT = String.format("INSERT INTO DENTISTAS (nome, sobrenome, matricula) VALUES('%s','%s','%s')",
                dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula());

        try {
            connection = configurationJDBC.getConnection();
            logger.info("conexao aberta");
            Statement stmt = connection.createStatement();

            stmt.execute(SQLINSERT, stmt.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            logger.info("dados inseridos com sucesso");

            if(rs.next()){
                dentista.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
            logger.info("fechando conexao");

        }
        return dentista;
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException {
        String SQLQUERY = "SELECT * FROM DENTISTAS";
        List<Dentista> dentistaList = new ArrayList<>();
        try {
            connection = configurationJDBC.getConnection();
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(SQLQUERY);

            while (rs.next()){
                dentistaList.add(criarObjetoDentista(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
        return dentistaList;
    }

    @Override
    public void alterar(Dentista dentista) throws SQLException {

    }

    @Override
    public void excluir(int id) throws SQLException {

    }

    @Override
    public Optional<Dentista> buscarPorId(int id) throws SQLException {
        return Optional.empty();
    }

    public Dentista criarObjetoDentista(ResultSet rs) throws SQLException {
        Integer id = rs.getInt(1);
        String nome = rs.getString(2);
        String sobrenome = rs.getString(3);

        return new Dentista(id, nome, sobrenome);
    }


}
