package com.HotelUniandes.HotelUniandes.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document("TipoHabitacion")
@Data
public class TipoHabitacion {

    @Id
    @Getter @Setter
    private int id;

    @Setter @Getter
    private String tipo;
    @Setter @Getter
    private String descripcion;
    @Setter @Getter
    private int precio;
    @Setter @Getter
    private int capacidad;


    public TipoHabitacion(int id, String tipo, String descripcion, int precio, int capacidad){
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.capacidad = capacidad;
    }


    
}
