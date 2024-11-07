package com.prueba.mifel.modelo;

import lombok.Data;

import javax.persistence.*;

/*Autor: ING. Elson Castillo. Clase Entidad*/

@Entity
@Data
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    //Gettes y Setters automaticos con lombok

}
