package com.practice.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.mapper.EmployeeRowMapper;
import com.practice.model.Employee;
import com.practice.resources.SpringConfigFile;

public class App10 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "select * from employees";
		
		List<Employee> lists = jdbcTemplate.query(query, new EmployeeRowMapper());
		
		for(Employee list : lists) {
			System.out.println("Id : "+list.getId());
			System.out.println("Name : "+list.getName());
			System.out.println("Salary : "+list.getSalary());
			System.out.println("Post : "+list.getPost());
			System.out.println("-------------------------------");
		}
	}

}
