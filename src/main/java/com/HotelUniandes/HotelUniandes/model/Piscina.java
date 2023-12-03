package com.HotelUniandes.HotelUniandes.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
public class Piscina extends Servicio {


    @Setter @Getter
    private int capacidad;
    @Setter @Getter
    private int profundidad;
    @Setter @Getter
    private String horaInicio;
    @Setter @Getter
    private String horaFinal;

    public Piscina(int id, int precio,Date fecha, String descripcion, int capacidad, int profundidad, String horaInicio, String horaFinal) {
        super(id, precio, fecha, descripcion);
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
    
}
