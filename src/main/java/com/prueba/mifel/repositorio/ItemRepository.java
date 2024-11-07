package com.prueba.mifel.repositorio;

import com.prueba.mifel.modelo.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*Autor: ING. Elson Castillo. Interfaz del repositorio*/

public interface ItemRepository extends JpaRepository <Item, Long>{
   public List<Item> findByNombreContaining(String nombre);
}
