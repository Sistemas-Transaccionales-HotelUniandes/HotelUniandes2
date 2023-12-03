package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.repository.HabitacionRepository;
import com.HotelUniandes.HotelUniandes.repository.ReservaRepository;
import com.HotelUniandes.HotelUniandes.repository.TipoHabitacionRepository;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository rp;
    @Autowired
    HabitacionRepository rp2;
    @Autowired
    TipoHabitacionRepository rp3;

    public String saveReserva(Reserva r){
        if(rp2.findById(r.getHabitacionesReserva()).isPresent()){
            rp.save(r);
            return "La reserva " + r.getId() + " fue guardada correctamente";
        }
        return "Error al guardar";
    }
        

    public List<Reserva> getAllReserva(){
        return rp.findAll();
    }

    public Pair<Reserva, TipoHabitacion> getReservaById(int id){
        return new Pair<Reserva, TipoHabitacion>(rp.findById(id).get(), rp3.findById(rp2.findById(rp.findById(id).get().getHabitacionesReserva()).get().getTipoHabitacionId()).get());
    }

    public Reserva updateReservaById(Reserva r, int id){
        Reserva r2 = rp.findById(id).get();
        if(r2 != null){
            if(rp2.findById(r.getHabitacionesReserva()).isPresent()){
                r2.setAcompañantes(r.getAcompañantes());
                r2.setEstado(r.getEstado());
                r2.setFechaInicio(r.getFechaInicio());
                r2.setId(r.getId());
                r2.setNumNoches(r.getNumNoches());
                r2.setHabitacionesReserva(r.getHabitacionesReserva());
                rp.save(r2);
                return r2;
            }
        }
        return null;
    }


    public String deleteReserva(int id){
        if(!rp.findById(id).isEmpty()){
            rp.deleteById(id);
            return "La reserva " + id + " ha sido eliminada";
        }
        return "Error al eliminar";
    }
    
}
