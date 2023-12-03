package com.HotelUniandes.HotelUniandes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HotelUniandesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelUniandesApplication.class, args);
	}

}
