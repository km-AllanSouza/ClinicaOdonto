package com.clinicaOdontologica.ClinicaOdonto;

import com.clinicaOdontologica.ClinicaOdonto.dao.ConfigurationJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;


//private static final Logger logger = LogManager.getLogger(Main.class);

//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ClinicaOdontoApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(ClinicaOdontoApplication.class, args);



//				ConfigurationJDBC configurationJDBC = new ConfigurationJDBC("org.h2.Driver", "jdbc:h2:~/ClinicaOdonto;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");
//				Connection connection = null;
//				try {
//					connection = configurationJDBC.getConnection();
//				} catch (Exception e) {
//					throw new RuntimeException(e);
//				}  finally {
//					connection.close();
//				}
			}
	}


