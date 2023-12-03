package com.HotelUniandes.HotelUniandes.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
public class Spa extends Servicio {

    @Setter @Getter
    private int capacidad;
    @Setter @Getter
    private String tipo;
    @Setter @Getter
    private String horaInicio;
    @Setter @Getter
    private String horaFinal;


    public Spa(int id, int precio, Date fecha, String descripcion,  int capacidad, String tipo, String horaInicio, String horaFinal) {
        super(id, precio, fecha, descripcion);
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
    
}
