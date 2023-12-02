package com.HotelUniandes.HotelUniandes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Habitaciones")
@Data
public class Habitacion {
    
    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int tipoHabitacionId;

    public Habitacion(int id, int tipoHabitacionId){
        this.tipoHabitacionId = tipoHabitacionId;
        this.id = id;
    }

}
