package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
