package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    List<Consulta> findByHorarioAndDataAndIdDentistaId(Time hora, Date data, Long idD);
}
