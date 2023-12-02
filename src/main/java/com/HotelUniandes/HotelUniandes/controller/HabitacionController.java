package com.HotelUniandes.HotelUniandes.controller;

import java.util.List;

import org.javatuples.Pair;
import org.modelmapper.ModelMapper;
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
import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.service.HabitacionService;

@RestController
@RequestMapping("/Habitacion")
public class HabitacionController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    HabitacionService sr;

    @PostMapping("/save")
    public ResponseEntity<String> createHabitacion( @RequestBody Habitacion habitacion){
        sr.saveHabitacion(habitacion);
        return new ResponseEntity<String>(sr.saveHabitacion(habitacion),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Habitacion>> getAllHabitacion(){
        return new ResponseEntity<List<Habitacion>>(sr.getAllHabitacion(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pair<TipoHabitacion, Habitacion>> getHabitacionByTipo(@PathVariable int id){
        return new ResponseEntity<Pair<TipoHabitacion, Habitacion>>(sr.getHabitacionById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Habitacion> updateHabitacionById(@PathVariable int id, @RequestBody Habitacion h){
        return new ResponseEntity<Habitacion>(sr.updateoHabitacionById(h, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteHabitacionByTipo(@PathVariable int id){
        return new ResponseEntity<String>(sr.deleteHabitacion(id), HttpStatus.OK);
    }
}
