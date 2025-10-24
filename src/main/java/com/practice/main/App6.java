package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.model.Item;
import com.practice.resources.SpringConfigFile;

public class App6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		Item itemObj = (Item) context.getBean("itemObj");
		
		String query = "insert into items values (?, ?, ?)";
		
		int count = jdbcTemplate.update(query, itemObj.getId(), itemObj.getName(), itemObj.getPrice());
		
		if(count>0) {
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Something Went Wrong");
		}
	}

}
