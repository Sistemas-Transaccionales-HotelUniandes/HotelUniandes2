package com.HotelUniandes.HotelUniandes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HotelUniandes.HotelUniandes.model.Gimnasio;
import com.HotelUniandes.HotelUniandes.model.Internet;
import com.HotelUniandes.HotelUniandes.model.Piscina;
import com.HotelUniandes.HotelUniandes.model.Producto;
import com.HotelUniandes.HotelUniandes.model.Salon;
import com.HotelUniandes.HotelUniandes.model.Servicio;
import com.HotelUniandes.HotelUniandes.model.Spa;
import com.HotelUniandes.HotelUniandes.service.ServicioService;

@RestController
@RequestMapping("/Servicio")
public class ServicioController {

    @Autowired
    ServicioService sr;


    @PostMapping("/piscina/save")
    public ResponseEntity<String> createPiscina( @RequestBody Piscina ps){
        sr.savePiscina(ps);
        return new ResponseEntity<String>(sr.savePiscina(ps),HttpStatus.OK);
    }

    @PostMapping("/gimnasio/save")
    public ResponseEntity<String> createGimnasio( @RequestBody Gimnasio gim){
        sr.saveGimnasio(gim);
        return new ResponseEntity<String>(sr.saveGimnasio(gim),HttpStatus.OK);
    }

    @PostMapping("/internet/save")
    public ResponseEntity<String> createInternet( @RequestBody Internet i){
        sr.saveInternet(i);
        return new ResponseEntity<String>(sr.saveInternet(i),HttpStatus.OK);
    }

    @PostMapping("/salon/save")
    public ResponseEntity<String> createSalon( @RequestBody Salon sl){
        sr.saveSalon(sl);
        return new ResponseEntity<String>(sr.saveSalon(sl),HttpStatus.OK);
    }

    @PostMapping("/spa/save")
    public ResponseEntity<String> createSap( @RequestBody Spa spa){
        sr.saveSpa(spa);
        return new ResponseEntity<String>(sr.saveSpa(spa),HttpStatus.OK);
    }

    @PostMapping("/producto/save")
    public ResponseEntity<String> createProducto( @RequestBody Producto p){
        sr.saveProducto(p);
        return new ResponseEntity<String>(sr.saveProducto(p),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicio(){
        return new ResponseEntity<List<Servicio>>(sr.getAllService(), HttpStatus.OK);
    }

    @GetMapping("/get/{type}/{id}")
    public ResponseEntity<Servicio> getServicioByTypeAndId(@PathVariable int id, @PathVariable String type){
        return new ResponseEntity<Servicio>(sr.getServicioByClassAndId(type, id), HttpStatus.OK);
    }
    @PutMapping("/update/piscina/{id}")
    public ResponseEntity<Piscina> updatePiscinaById(@PathVariable int id, @RequestBody Piscina ps) {
        return new ResponseEntity<>(sr.updatePiscina(id, ps), HttpStatus.OK);
    }

    @PutMapping("/update/gimnasio/{id}")
    public ResponseEntity<Gimnasio> updateGimnasioById(@PathVariable int id, @RequestBody Gimnasio gim) {
        return new ResponseEntity<>(sr.updateGimnasio(id, gim), HttpStatus.OK);
    }

    @PutMapping("/update/internet/{id}")
    public ResponseEntity<Internet> updateInternetById(@PathVariable int id, @RequestBody Internet i) {
        return new ResponseEntity<>(sr.updateInternet(id, i), HttpStatus.OK);
    }

    @PutMapping("/update/salon/{id}")
    public ResponseEntity<Salon> updateSalonById(@PathVariable int id, @RequestBody Salon salon) {
        return new ResponseEntity<>(sr.updateSalon(id, salon), HttpStatus.OK);
    }

    @PutMapping("/update/spa/{id}")
    public ResponseEntity<Spa> updateSpaById(@PathVariable int id, @RequestBody Spa spa) {
        return new ResponseEntity<>(sr.updateSpa(id, spa), HttpStatus.OK);
    }

    @PutMapping("/update/producto/{id}")
    public ResponseEntity<Producto> updateProductoById(@PathVariable int id, @RequestBody Producto producto) {
        return new ResponseEntity<>(sr.updateProducto(id, producto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteServicioById(@PathVariable int id){
        return new ResponseEntity<String>(sr.deleteServicioById(id), HttpStatus.OK);
    }
    
}
