package com.HotelUniandes.HotelUniandes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TipoHabitacion")
public class TipoHabitacion {

    @Id
    private Integer id;
    
}
