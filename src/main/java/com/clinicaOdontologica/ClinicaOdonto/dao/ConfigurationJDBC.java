package com.clinicaOdontologica.ClinicaOdonto.dao;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationJDBC {
    private static final Logger logger = LogManager.getLogger(ConfigurationJDBC.class);
    private String jdbcDriver;
    private String dbUrl;
    private String user;
    private String password;

    public ConfigurationJDBC(String jdbcDriver, String dbUrl, String user, String password) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(this.jdbcDriver);
            logger.info("conexao estabelecida com sucesso");
            return DriverManager.getConnection(this.dbUrl, this.user, this.password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }

}
