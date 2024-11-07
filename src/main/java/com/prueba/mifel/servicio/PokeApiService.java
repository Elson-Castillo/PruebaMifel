package com.prueba.mifel.servicio;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*Autor: ING. Elson Castillo. Clase service que obtiene toda la información de la url PokeAPI*/

@Service
public class PokeApiService {
    private final RestTemplate restTemplate = new RestTemplate();

    public String obtenerPokemon() {
        String url = "https://pokeapi.co/api/v2/pokemon/ditto";
        return restTemplate.getForObject(url, String.class);
    }
}
