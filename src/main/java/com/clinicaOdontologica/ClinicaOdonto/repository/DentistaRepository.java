package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
}
