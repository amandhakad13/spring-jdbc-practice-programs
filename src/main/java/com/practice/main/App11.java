package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.mapper.EmployeeRowMapper;
import com.practice.model.Employee;
import com.practice.resources.SpringConfigFile;

public class App11 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "select * from employees where id = ?";
		
		Employee emp = jdbcTemplate.queryForObject(query, new EmployeeRowMapper(), 101);
		
		System.out.println("Id : "+emp.getId());
		System.out.println("Name : "+emp.getName());
		System.out.println("Salary : "+emp.getSalary());
		System.out.println("Post : "+emp.getPost());
		
	}

}
