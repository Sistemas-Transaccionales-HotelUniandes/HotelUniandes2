package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.Servicio;

@Repository
public interface ServicioRepository extends MongoRepository<Servicio, Integer> {
    
}
