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

    public String saveCliente(Cliente c){
        if(!rp2.findById(c.getReservaId()).isEmpty()){
            rp.save(c);
            return "El cliente " + c.getId() + " fue guardado correctamente";
        }
        return "Error al guardar";
    }

    public List<Cliente> getAllCliente(){
        return rp.findAll();
    }

    public Pair<Cliente, Reserva> getClienteById(int id){
        return new Pair<Cliente, Reserva>(rp.findById(id).get(), rp2.findById(rp.findById(id).get().getReservaId()).get());
    }

    public String getEstadoCliente(int id){
        return rp.findById(id).get().getEstado();
    }

    public String updateEstadoCliente(int id, String estado){
        Cliente c = rp.findById(id).get();
        if(c != null){
            c.setEstado(estado);
            rp.save(c);
            return rp.findById(id).get().getEstado();
        }
        return "Error al actualizar";
    }

    public Cliente updateClienteById(Cliente c, int id){
        Cliente c2 = rp.findById(id).get();
        if(c2 != null){
            if(rp2.findById(c.getReservaId()).isPresent()){
                c2.setId(c.getId());
                c2.setDocumento(c.getDocumento());
                c2.setEmail(c.getEmail());
                c2.setEstado(c.getEstado());
                c2.setNombre(c.getNombre());
                c2.setReservaId(c.getReservaId());
                c2.setTipodocumento(c.getTipodocumento());
                rp.save(c2);
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
