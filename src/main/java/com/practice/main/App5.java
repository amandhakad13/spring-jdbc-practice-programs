package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.resources.SpringConfigFile;

public class App5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int id = 103;
		String name = "T-Shirt";
		int price = 200;
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "insert into items values(?, ? ,?)";
		
		int count = jdbcTemplate.update(query, new Object[] {id, name, price});
		
		if(count>0) {
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Something Went Wrong");
		}
	}

}
