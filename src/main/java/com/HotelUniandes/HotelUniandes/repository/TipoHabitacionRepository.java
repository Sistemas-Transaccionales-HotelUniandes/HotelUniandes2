package com.HotelUniandes.HotelUniandes.repository;


import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
@Repository
public interface TipoHabitacionRepository extends MongoRepository<TipoHabitacion, Integer>{

    // Query para hallar por tipo
    @Query("{tipo:'?0'}")
    TipoHabitacion findTipoHabitacionByTipo(String tipo);

    @DeleteQuery
    String deleteByTipo(String tipo);

    
}
