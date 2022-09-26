package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
    List<Horario> findByHorarioInicio(Time hora);
}
