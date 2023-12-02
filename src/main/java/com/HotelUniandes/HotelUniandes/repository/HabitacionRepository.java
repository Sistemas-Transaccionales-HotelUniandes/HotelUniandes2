package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.Habitacion;

@Repository
public interface HabitacionRepository extends MongoRepository<Habitacion, Integer> {
    
}
