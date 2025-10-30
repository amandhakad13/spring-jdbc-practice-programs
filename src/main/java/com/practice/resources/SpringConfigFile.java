package com.practice.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.practice.model.Employee;
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
	
	@Bean
	public Employee emp1() {
		
		Employee e1 = new Employee();
		e1.setId(101);
		e1.setName("Ravi Kumar");
		e1.setSalary(25555);
		e1.setPost("Python Developer");
		
		return e1;
	}
	
	@Bean
	public Employee emp2() {
		
		Employee e2 = new Employee();
		e2.setId(102);
		e2.setName("Tara Singh");
		e2.setSalary(35555);
		e2.setPost("Java Developer");
		
		return e2;
	}
	
	@Bean
	public Employee emp3() {
		
		Employee e3 = new Employee();
		e3.setId(103);
		e3.setName("Rohit Sinha");
		e3.setSalary(30000);
		e3.setPost("Mern Stack Developer");
		
		return e3;
	}
}
