package com.HotelUniandes.HotelUniandes.model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document("Cuenta")
@Data
public class Cuenta {
    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int total;

    @Getter @Setter
    private List<Integer> serviciosConsumidos;

    public Cuenta(int id, List<Integer> serviciosConsumidos, int total){
        this.id = id;
        this.total = total;
        this.serviciosConsumidos = serviciosConsumidos;

    }


    
}
