package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    List<Consulta> findByHorarioAndDataAndIdDentistaId(Time hora, Date data, Long idD);
}
