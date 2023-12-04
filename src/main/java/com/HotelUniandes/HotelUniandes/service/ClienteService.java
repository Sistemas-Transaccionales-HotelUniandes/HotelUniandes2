package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Cliente;
import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.repository.ReservaRepository;
import com.HotelUniandes.HotelUniandes.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository rp;
    @Autowired
    ReservaRepository rp2;

    public Cliente saveCliente(Cliente c){
        if(!rp2.findById(c.getReservaId()).isEmpty()){
            rp.save(c);
            return c;
        }
        return null;
    }

    public List<Cliente> getAllCliente(){
        return rp.findAll();
    }

    public Pair<Cliente, Reserva> getClienteById(int id){
        return new Pair<Cliente, Reserva>(rp.findById(id).get(), rp2.findById(rp.findById(id).get().getReservaId()).get());
    }

    public String getEstadoClienteReserva(int id){
        return "El estado del cliente es " + rp.findById(id).get().getEstado() + " y El estado de la reserva es " + rp2.findById(rp.findById(id).get().getReservaId()).get().getEstado();
    }

    public String updateEstadoCliente(int id, String estado){
        Cliente c = rp.findById(id).get();
        Reserva r = rp2.findById(c.getReservaId()).get();
        if(c != null){
            if(rp2.findById(c.getReservaId()).isPresent()){
                c.setEstado(estado);
                r.setEstado(estado);
                rp.save(c);
                rp2.save(r);
                return "El estado del cliente es " + rp.findById(id).get().getEstado() + " y El estado de la reserva es " + rp2.findById(c.getReservaId()).get().getEstado();
            }
        }
        return "Error al actualizar";
    }

    public Cliente updateClienteById(Cliente c, int id){
        Cliente c2 = rp.findById(id).get();
        Reserva r = rp2.findById(c.getReservaId()).get();
        if(c2 != null){
            if(rp2.findById(c.getReservaId()).isPresent()){
                r.setEstado(c.getEstado());
                c2.setId(c.getId());
                c2.setDocumento(c.getDocumento());
                c2.setEmail(c.getEmail());
                c2.setEstado(c.getEstado());
                c2.setNombre(c.getNombre());
                c2.setReservaId(c.getReservaId());
                c2.setTipodocumento(c.getTipodocumento());
                rp.save(c2);
                rp2.save(r);
                return c2;
            }
        }
        return null;
    }


    public String deleteCliente(int id){
        if(!rp.findById(id).isEmpty()){
            rp.deleteById(id);
            return "El Cliente " + id + " ha sido eliminado";
        }
        return "Error al eliminar";
    }

    
}
