package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
