package com.HotelUniandes.HotelUniandes.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelUniandes.HotelUniandes.model.Gimnasio;
import com.HotelUniandes.HotelUniandes.model.Internet;
import com.HotelUniandes.HotelUniandes.model.Piscina;
import com.HotelUniandes.HotelUniandes.model.Producto;
import com.HotelUniandes.HotelUniandes.model.Salon;
import com.HotelUniandes.HotelUniandes.model.Servicio;
import com.HotelUniandes.HotelUniandes.model.Spa;
import com.HotelUniandes.HotelUniandes.repository.ServicioRepository;

@Service
public class ServicioService {

    @Autowired
    ServicioRepository rp;

    public String savePiscina(Piscina psc){
        rp.save(psc);
        return "El serivicio de Piscina " + psc.getId() + " fue guardado correctamente";
    }

    public Gimnasio saveGimnasio(Gimnasio gim){
        return rp.save(gim);
    }

    public String saveInternet(Internet inter){
        rp.save(inter);
        return "El servicio de Internet " + inter.getId() + " fue guardado correctamente";
    } 

    public String saveSpa(Spa spa){
        rp.save(spa);
        return "El servicio de Spa " + spa.getId() + " fue guardado correctamente";
    }  

    public String saveSalon(Salon sl){
        rp.save(sl);
        return "El servicio de Salon " + sl.getId() + " fue guardado correctamente";
    }  

    public String saveProducto(Producto p){
        rp.save(p);
        return "El servicio de Producto " + p.getId() + " fue guardado correctamente";
    }

    public List<Servicio> getAllService(){
        return rp.findAll();
    }

    public Servicio getServicioByClassAndId(String type, int id){
        Servicio s = rp.findById(id).get();
        type = Character.toUpperCase(type.charAt(0)) + type.substring(1);
        if(s.getClass().getSimpleName().equals(type)){
            return s;
        }
        return null;
    }

    public Piscina updatePiscina(int id, Piscina ps){
        Servicio s = rp.findById(id).get();
        if(s instanceof Piscina){
            Piscina ps2 = ((Piscina)s);
            ps2.setId(ps.getId());
            ps2.setCapacidad(ps.getCapacidad());
            ps2.setDescripcion(ps.getDescripcion());
            ps2.setFecha(ps.getFecha());
            ps2.setHoraInicio(ps.getHoraInicio());
            ps2.setHoraFinal(ps.getHoraFinal());
            ps2.setPrecio(ps.getPrecio());
            ps2.setProfundidad(ps.getProfundidad());
            rp.save(ps2);
            return ps2;
        }
        return null;
    }

    public Gimnasio updateGimnasio(int id, Gimnasio gim){
        Servicio s = rp.findById(id).get();
        if(s instanceof Gimnasio){
            Gimnasio gim2 = ((Gimnasio)s);
            gim2.setCapacidad(gim.getCapacidad());
            gim2.setDescripcion(gim.getDescripcion());
            gim2.setFecha(gim.getFecha());
            gim2.setHoraFinal(gim.getHoraFinal());
            gim2.setHoraInicio(gim.getHoraInicio());
            gim2.setId(gim.getId());
            gim2.setNumMaquinas(gim.getNumMaquinas());
            gim2.setPrecio(gim.getPrecio());
            rp.save(gim2);
            return gim2;
        }
        return null;
    }

    public Internet updateInternet(int id, Internet i){
        Servicio s = rp.findById(id).get();
        if(s instanceof Internet){
            Internet i2 = ((Internet)s);
            i2.setCapacidad(i.getCapacidad());
            i2.setDescripcion(i.getDescripcion());
            i2.setFecha(i.getFecha());
            i2.setId(i.getId());
            i2.setPrecio(i.getPrecio());
            rp.save(i2);
            return i2;
        } 
        return null;

    }
    public Salon updateSalon(int id, Salon salon){
        Servicio s = rp.findById(id).get();
        if(s instanceof Salon){
            Salon salonToUpdate = (Salon) s;
            salonToUpdate.setCapacidad(salon.getCapacidad());
            salonToUpdate.setDescripcion(salon.getDescripcion());
            salonToUpdate.setFecha(salon.getFecha());
            salonToUpdate.setId(salon.getId());
            salonToUpdate.setPrecio(salon.getPrecio());
            salonToUpdate.setTipo(salon.getTipo());
            salonToUpdate.setHoraInicio(salon.getHoraInicio());
            salonToUpdate.setHoraFinal(salon.getHoraFinal());
            rp.save(salonToUpdate);
            return salonToUpdate;
        } 
        return null;
    }

    public Spa updateSpa(int id, Spa spa){
        Servicio s = rp.findById(id).get();
        if(s instanceof Spa){
            Spa spaToUpdate = (Spa) s;
            spaToUpdate.setCapacidad(spa.getCapacidad());
            spaToUpdate.setDescripcion(spa.getDescripcion());
            spaToUpdate.setFecha(spa.getFecha());
            spaToUpdate.setId(spa.getId());
            spaToUpdate.setPrecio(spa.getPrecio());
            spaToUpdate.setTipo(spa.getTipo());
            spaToUpdate.setHoraInicio(spa.getHoraInicio());
            spaToUpdate.setHoraFinal(spa.getHoraFinal());
            rp.save(spaToUpdate);
            return spaToUpdate;
        } 
        return null;
    }

    public Producto updateProducto(int id, Producto producto){
        Servicio s = rp.findById(id).get();
        if(s instanceof Producto){
            Producto productoToUpdate = (Producto) s;
            productoToUpdate.setDescripcion(producto.getDescripcion());
            productoToUpdate.setFecha(producto.getFecha());
            productoToUpdate.setId(producto.getId());
            productoToUpdate.setPrecio(producto.getPrecio());
            productoToUpdate.setNombre(producto.getNombre());
            rp.save(productoToUpdate);
            return productoToUpdate;
        } 
        return null;
    }
    

    public String deleteServicioById(int id){
        rp.deleteById(id);
        return "El servicio con id " + id + " fue eliminado correctamente";
    }


    
}
