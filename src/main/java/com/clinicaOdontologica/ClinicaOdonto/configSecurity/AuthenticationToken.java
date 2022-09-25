package com.clinicaOdontologica.ClinicaOdonto.configSecurity;

import com.clinicaOdontologica.ClinicaOdonto.model.Usuario;
import com.clinicaOdontologica.ClinicaOdonto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationToken extends OncePerRequestFilter {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);

        boolean valido = tokenService.verificaToken(token);

        if(valido == true){
            autenticarUsuario(token);
        }
    }

    private void autenticarUsuario(String token){
        String username = tokenService.getUsername(token);
        Usuario usuario = usuarioRepository.findByUsername(username);
    }

    private String recuperarToken(HttpServletRequest request) {
        String getToken = request.getHeader("Authorization");
        if(getToken == null || getToken.isEmpty() || !getToken.startsWith("Bearer")){
            return null;
        }
        return getToken.substring(7,getToken.length());
    }
}