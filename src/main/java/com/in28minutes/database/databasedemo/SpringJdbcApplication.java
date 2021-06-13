package com.in28minutes.database.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Restaurant;
import com.in28minutes.database.databasedemo.jdbc.RestaurantJdbcDao;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RestaurantJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("All restaurants -> {}", dao.findAll());
		
		logger.info("Restaurant id 10001 -> {}", dao.findById(10001));
		
		logger.info("Deleting 10002 -> No of Rows Deleted - {}", 
				dao.deleteById(10002));
		
		logger.info("Inserting 10004 -> {}", 
				dao.insert(new Restaurant(10006, "Zabu Chicken", 3, "1635 Robson St, Vancouver")));
		
		logger.info("Update 10003 -> {}", 
				dao.update(new Restaurant(10003, "Hy Steak House", 2, "637 Hornby St, Vancouver")));
		
	}
}
