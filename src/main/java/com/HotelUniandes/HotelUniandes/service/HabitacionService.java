package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.javatuples.*;

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

    public String saveHabitacion(Habitacion habitacionEntity){
        rp.save(habitacionEntity);
        return "La habitacion " + habitacionEntity.getId() + " fue guardada correctamente";
    }

    public List<Habitacion> getAllHabitacion(){
        return rp.findAll();
    }

    public Pair<TipoHabitacion, Habitacion> getHabitacionById(int id){
        return new Pair<TipoHabitacion, Habitacion>(rp2.findById(rp.findById(id).get().getTipoHabitacionId()).get(), rp.findById(id).get());
    }

    public Habitacion updateoHabitacionById(Habitacion h, int id){
        Habitacion h2 = rp.findById(id).get();
        Habitacion n = null;
        if(h2 != null){
            h2.setId(h.getId());
            h2.setTipoHabitacionId(h.getTipoHabitacionId());
            rp.save(h2);
            return h2;
        }
        return n;
    }


    public String deleteHabitacion(int id){
        if(!rp.findById(id).isEmpty()){
            rp.deleteById(id);
            return "La Habitacion " + id + " ha sido eliminada";
        }
        return "Error al eliminar";
    }


}
