package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.resources.SpringConfigFile;

public class App3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int item_id = 101;
		String item_name = "jeans";
		int item_price = 700;
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "insert into items values ('"+item_id+"','"+item_name+"','"+item_price+"')";
		
		int insert = jdbcTemplate.update(query);
		
		if(insert>0) {
			System.out.println("Record Inserted Successfully");
		}
		else {
			System.out.println("Something Went Wrong");
		}
	}

}
