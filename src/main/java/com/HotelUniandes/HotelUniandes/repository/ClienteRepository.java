package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Integer> {
    
}
