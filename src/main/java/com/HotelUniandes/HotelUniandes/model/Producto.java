package com.HotelUniandes.HotelUniandes.model;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
public class Producto extends Servicio {

    @Getter @Setter
    private String nombre;

    public Producto(int id, int precio,Date fecha, String descripcion,  String nombre){
        super(id, precio, fecha, descripcion);
        this.nombre = nombre;
    }

    
}
