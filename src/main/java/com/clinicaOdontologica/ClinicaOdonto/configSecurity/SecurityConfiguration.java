package com.clinicaOdontologica.ClinicaOdonto.configSecurity;

import com.clinicaOdontologica.ClinicaOdonto.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    AuthenticationToken authenticationToken;
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
                .and().formLogin()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(authenticationToken, UsernamePasswordAuthenticationFilter.class);
    }

    //responsavel por autenticar o usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManager();
    }
}
