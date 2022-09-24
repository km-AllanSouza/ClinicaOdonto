package com.clinicaOdontologica.ClinicaOdonto;

import com.clinicaOdontologica.ClinicaOdonto.model.Role;
import com.clinicaOdontologica.ClinicaOdonto.model.Usuario;
import com.clinicaOdontologica.ClinicaOdonto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CreateUserRun implements ApplicationRunner {
    @Autowired
    UsuarioRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //
        Role admin = new Role();
        admin.setDescricao("ADMIN");
        Role user = new Role();
        user.setDescricao("USER");

        //
        List<Role> usuario1Roles = new ArrayList<>();
        usuario1Roles.add(user);

        //
        Usuario usuario1 = new Usuario();
        usuario1.setUsername("mainuser");
        usuario1.setPassword(encoder.encode("123456"));
        usuario1.setRoleList(usuario1Roles);

        repository.save(usuario1);
    }
}
