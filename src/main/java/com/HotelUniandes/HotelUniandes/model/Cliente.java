package com.HotelUniandes.HotelUniandes.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document(value = "Cliente")
@Data
public class Cliente {

    @Id
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String tipodocumento;
    @Getter @Setter
    private String documento;
    @Getter @Setter
    private int reservaId;
    @Getter @Setter
    private String estado;

    public Cliente(String nombre, String email, String tipoDocumento, String documento, int reservaId, String estado) {
        this.nombre = nombre;
        this.email = email;
        this.tipodocumento = tipoDocumento;
        this.documento = documento;
        this.reservaId = reservaId;
        this.estado = estado;
    }
    
}
