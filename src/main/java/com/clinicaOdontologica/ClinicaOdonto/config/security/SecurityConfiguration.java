package com.clinicaOdontologica.ClinicaOdonto.config.security;

import com.clinicaOdontologica.ClinicaOdonto.service.AutenticacaoService;
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
    AutenticacaoService autenticacaoService;
    @Autowired
    AutenticacaoViaTokenFilter autenticacaoViaTokenFilter;
    //responsavel por dizer quem acessa o que

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.POST,"/auth").permitAll()

                .antMatchers(HttpMethod.GET,"/paciente").hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/paciente").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/paciente/buscarid").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/paciente").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/paciente").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/paciente").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET,"/dentista").hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/dentista").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/dentista/buscarid").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/dentista").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/dentista").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/dentista").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET,"/consulta").hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/consulta").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/consulta/buscarid").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/consulta").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/consulta").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/consulta").hasAuthority("ADMIN")

                .antMatchers(HttpMethod.GET,"/endereco").hasAuthority("USER")
                .antMatchers(HttpMethod.GET,"/endereco").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/endereco/buscarid").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/endereco").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PATCH,"/endereco").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/endereco").hasAuthority("ADMIN")

                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(autenticacaoViaTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }

    //responsavel por autenticar o usuario
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
