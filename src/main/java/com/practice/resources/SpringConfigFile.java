package com.practice.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.practice.model.Item;

@Configuration
public class SpringConfigFile {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_db");
		ds.setUsername("root");
		ds.setPassword("Admin");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		
		JdbcTemplate jdbc = new JdbcTemplate();
		jdbc.setDataSource(dataSource());
		
		return jdbc;
	}
	
	@Bean
	public Item itemObj() {
		
		Item it = new Item();
		it.setId(104);
		it.setName("Shirt");
		it.setPrice(350);
		
		return it;
	}
}
