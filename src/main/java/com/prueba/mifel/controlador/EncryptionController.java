package com.prueba.mifel.controlador;

import com.prueba.mifel.servicio.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*Autor: ING. Elson Castillo. Clase RestController para cifrar una cadena de texto*/

@RestController
@RequestMapping("/api/encryption")
public class EncryptionController {

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping("/encrypt")
    public Map<String, String> encryptText(@RequestBody String data) {
        try {
            String encryptedText = encryptionService.encrypt(data);

            // Crea un Map para estructurar la respuesta en JSON
            Map<String, String> response = new HashMap<>();
            response.put("cipherText", encryptedText);
            return response;
        } catch (Exception e) {
            throw new RuntimeException("Error al cifrar la información", e);
        }
    }
}

