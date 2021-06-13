package com.in28minutes.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Restaurant;
import com.in28minutes.database.databasedemo.springdata.RestaurantSpringDataRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestaurantSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		logger.info("Inserting -> {}", 
				repository.save(new Restaurant("Black and Blue", 5, "1032 Alberni St, Vancouver")));
		
		logger.info("Update 10003 -> {}", 
				repository.save(new Restaurant("Fishy's shrimp", 5, "2388 Western Parkaway" )));
		
		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());
	}
}
