package com.practice.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.resources.SpringConfigFile;

public class App8 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query1 = "insert into items values (105, 'Sockes', 20)";
		String query2 = "insert into items values (106, 'Jacket', 200)";
		String query3 = "insert into items values (107, 'Hoddy', 350)";
		
		int[] counts = jdbcTemplate.batchUpdate(query1, query2, query3);
		
		for(int count : counts) {
			System.out.println(count+" : Success");
		}
	}

}
