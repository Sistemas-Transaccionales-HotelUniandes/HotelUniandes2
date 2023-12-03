package com.HotelUniandes.HotelUniandes.service;

import java.util.List;

import org.javatuples.Quartet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Cliente;
import com.HotelUniandes.HotelUniandes.model.Cuenta;
import com.HotelUniandes.HotelUniandes.model.Habitacion;
import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.model.Servicio;
import com.HotelUniandes.HotelUniandes.repository.ClienteRepository;
import com.HotelUniandes.HotelUniandes.repository.CuentaRepository;
import com.HotelUniandes.HotelUniandes.repository.HabitacionRepository;
import com.HotelUniandes.HotelUniandes.repository.ReservaRepository;
import com.HotelUniandes.HotelUniandes.repository.ServicioRepository;

@Service
public class CuentaService {

    @Autowired
    CuentaRepository rp;
    @Autowired
    ServicioRepository rp2;
    @Autowired
    ClienteRepository rp3;
    @Autowired
    ReservaRepository rp4;
    @Autowired
    HabitacionRepository rp5;

    public Cuenta saveCuenta(Cuenta c){
        int count = 0;
        for(int i = 0; i < c.getServiciosConsumidos().size(); i++){
            if(rp2.findById(c.getServiciosConsumidos().get(i)).isPresent()){
                count += 1;
            }
        }
        if(count != 0){
            int total = c.getTotal() + calcularTotal(c.getServiciosConsumidos());
            c.setTotal(total);
            rp.save(c);
            return c;
        }
        return null;
    }
        

    public List<Cuenta> getAllCuenta(){
        return rp.findAll();
    }

    public Quartet<Cuenta, Cliente, Reserva, Habitacion> getCuentaClienteId(int id){
        return new Quartet<Cuenta,Cliente,Reserva,Habitacion>(rp.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getCuentaReserva()).get(), rp3.findById(id).get(), rp4.findById(rp3.findById(id).get().getReservaId()).get(), rp5.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getHabitacionesReserva()).get());
    }

    public Cuenta updateCuentaByClienteId(int id, Cuenta c){
        Cuenta c2 = rp.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getCuentaReserva()).get(); 
        int count = 0;
        for(int i = 0; i < c.getServiciosConsumidos().size(); i++){
            if(rp2.findById(c.getServiciosConsumidos().get(i)).isPresent()){
                count += 1;
            }
        }
        if(count != 0){
            int total = c.getTotal() + calcularTotal(c.getServiciosConsumidos());
            c2.setId(c.getId());
            c2.setTotal(total);
            c2.setServiciosConsumidos(c.getServiciosConsumidos());
            rp.save(c2);
            return c2;
        }
        return null;
    }

    public Cuenta updateAgregarServicioByClienteId(int idServicio, int id){
        Cuenta c2 = rp.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getCuentaReserva()).get(); 
        c2.getServiciosConsumidos().add(idServicio);
        rp.save(c2);
        return c2;
    }

    public String deleteCuentaByClienteId(int id){
        if(!rp.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getCuentaReserva()).isEmpty()){
            rp.deleteById(rp.findById(rp4.findById(rp3.findById(id).get().getReservaId()).get().getCuentaReserva()).get().getId());
            return "La cuenta " + id + " ha sido eliminada";
        }
        return "Error al eliminar";
    }

    public int calcularTotal(List<Integer> serviciosConsumidos ){
        int total = 0;
        for(int i = 0; i < serviciosConsumidos.size(); i++){
            Servicio s = rp2.findById(serviciosConsumidos.get(i)).get();
            total += s.getPrecio();
        }

        return total/2;

    }
    
}
