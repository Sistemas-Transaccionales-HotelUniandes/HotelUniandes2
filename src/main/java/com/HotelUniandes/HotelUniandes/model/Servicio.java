package com.HotelUniandes.HotelUniandes.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
@Data
public class Servicio {

    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int precio;
    @Getter @Setter
    private Date fecha;
    @Getter @Setter
    private String descripcion;

    public Servicio(int id, int precio, Date fecha, String descripcion){
        this.id = id;
        this.precio = precio;
        this.fecha = fecha;
        this.descripcion = descripcion; 
    }
}
