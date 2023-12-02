package com.HotelUniandes.HotelUniandes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.HotelUniandes.HotelUniandes.model.TipoHabitacion;
import com.HotelUniandes.HotelUniandes.repository.TipoHabitacionRepository;

@SpringBootApplication
@EnableMongoRepositories
public class HotelUniandesApplication {

	@Autowired
	TipoHabitacionRepository tp;

	public static void main(String[] args) {
		SpringApplication.run(HotelUniandesApplication.class, args);
	}

}
