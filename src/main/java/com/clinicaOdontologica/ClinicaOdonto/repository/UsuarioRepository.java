package com.clinicaOdontologica.ClinicaOdonto.repository;

import com.clinicaOdontologica.ClinicaOdonto.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
