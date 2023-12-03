package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.repository.HabitacionRepository;
import com.HotelUniandes.HotelUniandes.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository rp;
    @Autowired
    HabitacionRepository rp2;

    public String saveReserva(Reserva r){
        rp.save(r);
        return "La reserva " + r.getId() + " fue guardada correctamente";
    }

    public List<Reserva> getAllReserva(){
        return rp.findAll();
    }

    public Reserva getReservaById(int id){
        return rp.findById(id).get();
    }

    public Reserva updateReservaById(Reserva r, int id){
        Reserva r2 = rp.findById(id).get();
        if(r2 != null){
            r2.setAcompañantes(r.getAcompañantes());
            r2.setEstado(r.getEstado());
            r2.setFechaInicio(r.getFechaInicio());
            r2.setId(r.getId());
            r2.setNumNoches(r.getNumNoches());
            r2.setHabitacionesReserva(r.getHabitacionesReserva());
            rp.save(r2);
            return r2;
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
