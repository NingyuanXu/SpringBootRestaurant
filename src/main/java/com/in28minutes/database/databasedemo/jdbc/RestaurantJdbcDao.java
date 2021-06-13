package com.in28minutes.database.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Restaurant;

@Repository
public class RestaurantJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class RestaurantRowMapper implements RowMapper<Restaurant>{
		@Override
		public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(rs.getInt("id"));
			restaurant.setName(rs.getString("name"));
			restaurant.setStar_level(rs.getInt("star_level"));
			restaurant.setAddress(rs.getString("address"));
			return restaurant;
		}
		
	}
	
	public List<Restaurant> findAll() {
		return jdbcTemplate.query("select * from restaurant", new RestaurantRowMapper());
	}

	public Restaurant findById(int id) {
		return jdbcTemplate.queryForObject("select * from restaurant where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Restaurant>(Restaurant.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from restaurant where id=?", new Object[] { id });
	}

	public int insert(Restaurant restaurant) {
		return jdbcTemplate.update("insert into restaurant (id, name, star_level, address) " + "values(?,  ?, ?, ?)",
				new Object[] { restaurant.getId(), restaurant.getName(), restaurant.getStar_level(),
						restaurant.getAddress() });
	}

	public int update(Restaurant restaurant) {
		return jdbcTemplate.update("update restaurant " + " set name = ?, star_level = ?, address = ? " + " where id = ?",
				new Object[] { restaurant.getId(), restaurant.getName(), restaurant.getStar_level(),
						restaurant.getAddress() });
	}

}