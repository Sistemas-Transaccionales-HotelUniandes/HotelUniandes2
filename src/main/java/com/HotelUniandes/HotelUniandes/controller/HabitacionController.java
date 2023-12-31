package com.HotelUniandes.HotelUniandes.controller;

import java.util.List;

import org.javatuples.Pair;
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

import com.HotelUniandes.HotelUniandes.model.Habitacion;
import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.service.HabitacionService;

@RestController
@RequestMapping("/Habitacion")
public class HabitacionController {
    @Autowired
    HabitacionService sr;

    @PostMapping("/save")
    public ResponseEntity<Habitacion> createHabitacion( @RequestBody Habitacion habitacion){
        sr.saveHabitacion(habitacion);
        return new ResponseEntity<Habitacion>(sr.saveHabitacion(habitacion),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Habitacion>> getAllHabitacion(){
        return new ResponseEntity<List<Habitacion>>(sr.getAllHabitacion(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Habitacion> getReservaById(@PathVariable int id){
        return new ResponseEntity<Habitacion>(sr.getHabitacionById(id), HttpStatus.OK);
    }
    @GetMapping("/get/{id}/tipohabitacion")
    public ResponseEntity<Pair<TipoHabitacion, Habitacion>> getHabitacionByIdHab(@PathVariable int id){
        return new ResponseEntity<Pair<TipoHabitacion, Habitacion>>(sr.getHabitacionByIdHab(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Habitacion> updateHabitacionById(@PathVariable int id, @RequestBody Habitacion h){
        return new ResponseEntity<Habitacion>(sr.updateoHabitacionById(h, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHabitacionById(@PathVariable int id){
        return new ResponseEntity<String>(sr.deleteHabitacion(id), HttpStatus.NO_CONTENT);
    }
}
