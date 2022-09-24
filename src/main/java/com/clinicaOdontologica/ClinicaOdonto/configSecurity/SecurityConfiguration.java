package com.clinicaOdontologica.ClinicaOdonto.configSecurity;

import com.clinicaOdontologica.ClinicaOdonto.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationService authenticationService;
    //responsavel por dizer quem acessa o que
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/paciente").hasAuthority("USER")

                .antMatchers(HttpMethod.GET, "/dentista").denyAll()

                .antMatchers(HttpMethod.GET, "/usuario").permitAll()

                .antMatchers(HttpMethod.GET, "/endereco").permitAll()

                .antMatchers(HttpMethod.GET, "/consulta").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and().formLogin();
    }

    //responsavel por autenticar o usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
