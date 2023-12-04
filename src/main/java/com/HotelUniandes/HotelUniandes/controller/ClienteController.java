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

import com.HotelUniandes.HotelUniandes.model.Cliente;
import com.HotelUniandes.HotelUniandes.model.Reserva;
import com.HotelUniandes.HotelUniandes.service.ClienteService;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    ClienteService sr;

    @PostMapping("/save")
    public ResponseEntity<Cliente> createCliente( @RequestBody Cliente c){
        sr.saveCliente(c);
        return new ResponseEntity<Cliente>(sr.saveCliente(c),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllCliente(){
        return new ResponseEntity<List<Cliente>>(sr.getAllCliente(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pair<Cliente, Reserva>> getClienteById(@PathVariable int id){
        return new ResponseEntity<Pair<Cliente, Reserva>>(sr.getClienteById(id), HttpStatus.OK);
    }

    @GetMapping("/get/{id}/estado")
    public ResponseEntity<String>getEstadoById(@PathVariable int id){
        return new ResponseEntity<String>(sr.getEstadoClienteReserva(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable int id, @RequestBody Cliente c){
        return new ResponseEntity<Cliente>(sr.updateClienteById(c, id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}/estado")
    public ResponseEntity<String> updateEstadoById(@PathVariable int id, @RequestBody String estado){
        return new ResponseEntity<String>(sr.updateEstadoCliente(id, estado), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClienteById(@PathVariable int id){
        return new ResponseEntity<String>(sr.deleteCliente(id), HttpStatus.NO_CONTENT);
    }
    
}
