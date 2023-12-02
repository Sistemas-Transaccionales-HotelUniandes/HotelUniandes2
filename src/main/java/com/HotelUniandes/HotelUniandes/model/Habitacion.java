package com.HotelUniandes.HotelUniandes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(value = "Habitaciones")
@Data
public class Habitacion {
    
    @Id
    private int id;

    private int tipoHabitacionId;

}
