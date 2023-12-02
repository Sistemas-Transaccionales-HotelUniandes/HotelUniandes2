package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.repository.TipoHabitacionRepository;

@Service
public class TipoHabitacionService {

    @Autowired
    TipoHabitacionRepository rp;


    public String saveTipoHabitacion(TipoHabitacion tp){
        rp.save(tp);
        return "El tipo de Habitacion " + tp.getTipo() + " fue guardado con exito";
    }

    public List<TipoHabitacion> getAllTipoHabitacion(){
        return rp.findAll();
    }

    public TipoHabitacion getTipoHabitacionByTipo(String tipo){
        return rp.findTipoHabitacionByTipo(tipo);
    }

    public TipoHabitacion updateTipoHabitacionByTipo(String tipo, TipoHabitacion tph){
        TipoHabitacion tp = rp.findTipoHabitacionByTipo(tipo);
        TipoHabitacion n = null;
        if(tp != null){
            tp.setTipo(tph.getTipo());
            tp.setCapacidad(tph.getCapacidad());
            tp.setDescripcion(tph.getDescripcion());
            tp.setPrecio(tph.getPrecio());
            tp.setId(tph.getId());
            rp.save(tp);
            return tp;
        }
        return n;
    }

    public String deleteTipoHabitacion(String tipo){
        if (rp.findTipoHabitacionByTipo(tipo) != null){
            rp.deleteByTipo(tipo);
            return "El tipo de Habitacion " + tipo + " fue eliminado con exito";
        }
        return "Error al eliminar";
    }

    
    
}
