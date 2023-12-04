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

    public Habitacion saveHabitacion(Habitacion habitacionEntity){
        if(!rp2.findById(habitacionEntity.getTipoHabitacionId()).isEmpty()){
            rp.save(habitacionEntity);
            return habitacionEntity;
        }
        return null;
    }

    public List<Habitacion> getAllHabitacion(){
        return rp.findAll();
    }

    public Habitacion getHabitacionById(int id){
        return rp.findById(id).get();
    }

    public Pair<TipoHabitacion, Habitacion> getHabitacionByIdHab(int id){
        return new Pair<TipoHabitacion, Habitacion>(rp2.findById(rp.findById(id).get().getTipoHabitacionId()).get(), rp.findById(id).get());
    }

    public Habitacion updateoHabitacionById(Habitacion h, int id){
        Habitacion h2 = rp.findById(id).get();
        if(h2 != null){
            if(rp2.findById(h.getTipoHabitacionId()).isPresent()){
                h2.setId(h.getId());
                h2.setTipoHabitacionId(h.getTipoHabitacionId());
                rp.save(h2);
                return h2;
            }
        }
        return null;
    }


    public String deleteHabitacion(int id){
        if(!rp.findById(id).isEmpty()){
            rp.deleteById(id);
            return "La Habitacion " + id + " ha sido eliminada";
        }
        return "Error al eliminar";
    }


}
