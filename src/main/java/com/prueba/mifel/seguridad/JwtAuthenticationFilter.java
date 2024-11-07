package com.prueba.mifel.seguridad;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

/*Autor: ING. Elson Castillo. Clase que filtra la autentoficación del token*/

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter() {
        jwtTokenProvider = new JwtTokenProvider();
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            // Obtén el token de la solicitud
            String token = jwtTokenProvider.getTokenFromRequest(request);

            // Verifica si el token es válido y si no hay una autenticación actual en el contexto
            if (token != null && jwtTokenProvider.validateToken(token) &&
                    SecurityContextHolder.getContext().getAuthentication() == null) {

                // Extrae el nombre de usuario y las autoridades
                String username = jwtTokenProvider.getUsernameFromToken(token);
                var authorities = jwtTokenProvider.getAuthoritiesFromToken(token);

                // Crea un objeto de autenticación
                var authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                // Configura la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            // Maneja cualquier excepción que ocurra durante el procesamiento del token
            logger.error("No se pudo establecer la autenticación de usuario en el contexto de seguridad", ex);
        }

        // Continúa con el siguiente filtro
        filterChain.doFilter(request, response);
    }
}

