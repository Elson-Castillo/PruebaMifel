package com.prueba.mifel.controlador;

import com.prueba.mifel.servicio.PokeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Autor: ING. Elson Castillo. Clase RestController para consumir la API Pokemon*/

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokeApiService pokeApiService;

    @GetMapping
    public ResponseEntity<String> obtenerPokemon() {
        String response = pokeApiService.obtenerPokemon();
        return ResponseEntity.ok(response);
    }
}
