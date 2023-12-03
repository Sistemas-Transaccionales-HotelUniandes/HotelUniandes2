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

import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.service.TipoHabitacionService;


@RestController
@RequestMapping("/TipoHabitacion")
public class TipoHabitacionController {

    @Autowired
    TipoHabitacionService sr;

    @PostMapping("/save")
    public ResponseEntity<TipoHabitacion> createTipoHabitacion( @RequestBody TipoHabitacion tp){
        return new ResponseEntity<TipoHabitacion>(sr.saveTipoHabitacion(tp), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacion>> getAllTipoHabitacion(){
        return new ResponseEntity<List<TipoHabitacion>>(sr.getAllTipoHabitacion(), HttpStatus.OK);
    }

    @GetMapping("/get/{tipo}")
    public ResponseEntity<TipoHabitacion> getTipoHabitacionByTipo(@PathVariable String tipo){
        return new ResponseEntity<TipoHabitacion>(sr.getTipoHabitacionByTipo(tipo), HttpStatus.OK);
    }

    @PutMapping("/update/{tipo}")
    public ResponseEntity<TipoHabitacion> updateTipoHabitacionByTipo(@PathVariable String tipo, @RequestBody TipoHabitacion tph){
        return new ResponseEntity<TipoHabitacion>(sr.updateTipoHabitacionByTipo(tipo, tph), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{tipo}")
    public ResponseEntity<String> deleteTipoHabitacionByTipo(@PathVariable String tipo){
        return new ResponseEntity<String>(sr.deleteTipoHabitacion(tipo), HttpStatus.NO_CONTENT);
    }
    
}
