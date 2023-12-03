package com.HotelUniandes.HotelUniandes.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
public class Internet extends Servicio {

    @Setter @Getter
    private int capacidad;

    public Internet(int id, int precio,Date fecha, String descripcion, int capacidad){
        super(id, precio, fecha, descripcion);
        this.capacidad = capacidad;
    }
    
}
