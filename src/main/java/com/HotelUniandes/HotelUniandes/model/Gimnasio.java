package com.HotelUniandes.HotelUniandes.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Servicio")
public class Gimnasio extends Servicio {

    @Setter @Getter
    private int capacidad;
    @Setter @Getter
    private int numMaquinas;
    @Setter @Getter
    private String horaInicio;
    @Setter @Getter
    private String horaFinal;

    public Gimnasio(int id, int precio, Date fecha, String descripcion, int capacidad, int numMaquinas, String horaInicio, String horaFinal){
        super(id, precio, fecha, descripcion);
        this.capacidad = capacidad;
        this.numMaquinas = numMaquinas;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }
    
}
