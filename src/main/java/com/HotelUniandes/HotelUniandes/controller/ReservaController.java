package com.HotelUniandes.HotelUniandes.controller;

import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/Reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/save")
    public ResponseEntity<Reserva> saveReserva(@RequestBody Reserva reserva){
        return new ResponseEntity<Reserva>(reservaService.saveReserva(reserva), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReserva(){
        return new ResponseEntity<>(reservaService.getAllReserva(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id){
        return new ResponseEntity<Reserva>(reservaService.getReservaById(id), HttpStatus.OK);
    }
    @GetMapping("/get/{id}/tipohabitacion")
    public ResponseEntity<Pair<Reserva, TipoHabitacion>> getReservaByIdHab(@PathVariable int id){
        return new ResponseEntity<>(reservaService.getReservaByIdHab(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reserva> updateReservaById(@RequestBody Reserva reserva, @PathVariable int id){
        Reserva updatedReserva = reservaService.updateReservaById(reserva, id);
        if(updatedReserva != null){
            return new ResponseEntity<>(updatedReserva, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReserva(@PathVariable int id){
        String mensaje = reservaService.deleteReserva(id);
        return new ResponseEntity<>(mensaje, HttpStatus.NO_CONTENT);
    }
}

