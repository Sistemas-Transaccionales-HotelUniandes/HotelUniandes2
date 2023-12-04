package com.HotelUniandes.HotelUniandes.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.Cuenta;

@Repository
public interface CuentaRepository extends MongoRepository<Cuenta, Integer>{

    
}
