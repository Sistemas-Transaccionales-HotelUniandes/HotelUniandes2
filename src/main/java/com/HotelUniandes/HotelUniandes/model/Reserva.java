package com.HotelUniandes.HotelUniandes.model;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document("Reserva")
@Data
public class Reserva {

    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int numNoches;
    @Getter @Setter
    private Date fechaInicio;
    @Getter @Setter
    private String estado;
    @Getter @Setter
    private int acompañantes;
    @Getter @Setter
    private int habitacionesReserva;
    
    public Reserva(int id, int numNoches, Date fechaInicio, String estado, int acompañantes, int habitacionesReserva) {
        this.id = id;
        this.numNoches = numNoches;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.acompañantes = acompañantes;
        this.habitacionesReserva = habitacionesReserva;
    }
    
}
