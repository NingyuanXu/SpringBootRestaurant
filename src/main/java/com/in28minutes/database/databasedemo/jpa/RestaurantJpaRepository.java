package com.in28minutes.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Restaurant;

@Repository
@Transactional
public class RestaurantJpaRepository {

	// connect to the database
	@PersistenceContext
	EntityManager entityManager;

	public List<Restaurant> findAll() {
		TypedQuery<Restaurant> namedQuery = entityManager.createNamedQuery("find_all_restaurants", Restaurant.class);
		return namedQuery.getResultList();
	}

	public Restaurant findById(int id) {
		return entityManager.find(Restaurant.class, id);// JPA
	}

	public Restaurant update(Restaurant restaurant) {
		return entityManager.merge(restaurant);
	}

	public Restaurant insert(Restaurant restaurant) {
		return entityManager.merge(restaurant);
	}

	public void deleteById(int id) {
		Restaurant restaurant = findById(id);
		entityManager.remove(restaurant);
	}
}
