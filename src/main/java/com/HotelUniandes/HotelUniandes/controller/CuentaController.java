package com.HotelUniandes.HotelUniandes.controller;
import java.util.List;
import org.javatuples.Quartet;
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

import com.HotelUniandes.HotelUniandes.model.Cliente;
import com.HotelUniandes.HotelUniandes.model.Cuenta;
import com.HotelUniandes.HotelUniandes.model.Habitacion;
import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.service.CuentaService;

@RestController
@RequestMapping("/Cuenta")
public class CuentaController {

    @Autowired
    CuentaService sr;

    @PostMapping("/save")
    public ResponseEntity<Cuenta> createCuenta( @RequestBody Cuenta c){
        sr.saveCuenta(c);
        return new ResponseEntity<Cuenta>(sr.saveCuenta(c),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuenta(){
        return new ResponseEntity<List<Cuenta>>(sr.getAllCuenta(), HttpStatus.OK);
    }
    
    @GetMapping("/get/{id}")
    public ResponseEntity< Quartet<Cuenta, Cliente, Reserva, Habitacion>> getCuentaById(@PathVariable int id){
        return new ResponseEntity< Quartet<Cuenta, Cliente, Reserva, Habitacion>>(sr.getCuentaClienteId(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cuenta> updateCuentaByClienteId(@PathVariable int id, @RequestBody Cuenta c){
        return new ResponseEntity<Cuenta>(sr.updateCuentaByClienteId(id, c), HttpStatus.OK);
    }

    @PutMapping("/update/{id}/agregarServicio/{servicioId}")
    public ResponseEntity<Cuenta> updateHabitacionById(@PathVariable int id, @PathVariable int serivicioId){
        return new ResponseEntity<Cuenta>(sr.updateAgregarServicioByClienteId(serivicioId, id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCuentaById(@PathVariable int id){
        return new ResponseEntity<String>(sr.deleteCuentaByClienteId(id), HttpStatus.NO_CONTENT);
    }
}
