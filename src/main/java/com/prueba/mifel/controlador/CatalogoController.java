package com.prueba.mifel.controlador;

import com.prueba.mifel.modelo.Item;
import com.prueba.mifel.repositorio.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*Autor: ING. Elson Castillo. Clase RestController para devolver la respuesta del catalogo de ITEMS*/

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> obtenerCatalogo(@RequestParam(required = false) String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            //Si el filtro es nulo o vacio devuelve todos los datos de la base
            return itemRepository.findAll();
        } else {
            //De lo contrario, devuelve toda la información con el filtro del nombre seleccionado
            return itemRepository.findByNombreContaining(nombre);
        }
    }

}
