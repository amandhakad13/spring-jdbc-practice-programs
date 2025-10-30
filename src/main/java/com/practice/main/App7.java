package com.practice.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.model.Item;
import com.practice.resources.SpringConfigFile;

public class App7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "select * from items";
		
		List<Item> items = jdbcTemplate.query(query, (rs, rowNum) -> {
			Item i = new Item();
			i.setId(rs.getInt("Id"));
			i.setName(rs.getString("name"));
			i.setPrice(rs.getInt("price"));
			
            return i;
        });
		
		for(Item i : items) {
				System.out.println(i.getId()+" "+i.getName()+" "+i.getPrice());
		}
	}

}
