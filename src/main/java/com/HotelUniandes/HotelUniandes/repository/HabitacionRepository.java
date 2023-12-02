package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.HotelUniandes.HotelUniandes.model.Habitacion;


public interface HabitacionRepository extends MongoRepository<Habitacion, Integer> {
    
}
