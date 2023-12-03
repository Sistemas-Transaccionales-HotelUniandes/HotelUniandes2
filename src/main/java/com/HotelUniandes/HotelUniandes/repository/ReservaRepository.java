package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.Reserva;

@Repository
public interface ReservaRepository  extends MongoRepository<Reserva, Integer> {
}
