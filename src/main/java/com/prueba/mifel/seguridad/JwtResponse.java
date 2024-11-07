package com.prueba.mifel.seguridad;

import lombok.Getter;
import lombok.Setter;

/*Autor: ING. Elson Castillo. Clase DTO de la respuesta del token*/

@Setter
@Getter
public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
//Getters y Setters automaticos con lombok
}