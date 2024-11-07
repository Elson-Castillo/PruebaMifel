package com.prueba.mifel.seguridad;

import lombok.Getter;
import lombok.Setter;

/*Autor: ING. Elson Castillo. Clase DTO para la autentoficación del token*/

@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
    // Getters y setters automaticos con lombok
}
