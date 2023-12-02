package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Habitacion;
import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.repository.HabitacionRepository;
import com.HotelUniandes.HotelUniandes.repository.TipoHabitacionRepository;

@Service
public class HabitacionService {
    
    @Autowired
    HabitacionRepository rp;
    @Autowired
    TipoHabitacionRepository rp2;

    public String saveHabitacion(Habitacion h, int tp){
        h.setIdTipoHabitacion(tp);
        rp.save(h);
        return "La habitacion " + h.getId() + " fue guardada correctamente";
    }

    public List<Habitacion> getAllHabitacion(){
        return rp.findAll();
    }

    public Habitacion getHabitacionById(int id){
        return rp.findById(id).get();
    }

    public Habitacion updateHabitacion(int id, Habitacion h, int idTipo){
        TipoHabitacion tp = rp2.findById(idTipo).get();
        Habitacion hr = rp.findById(id).get();
        Habitacion n = null;
        if(hr != null){
            hr.setId(h.getId());
            hr.setIdTipoHabitacion(tp);
            return hr;
        }
        return n;
    }

    public String deleteHabitacion(int id){
        if(rp.findById(id).isPresent()){
            rp.deleteById(id);
            return "La Habitacion " + rp.findById(id).get().getId() + " ha sido eliminada";
        }
        return "Error al eliminar";
    }

}
