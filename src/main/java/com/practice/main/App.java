package com.practice.main;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App 
{
    public static void main( String[] args )
    {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("/com/practice/resources/applicationContext.xml");
        
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    	
        try {
			Connection con = jdbcTemplate.getDataSource().getConnection();
			
			if(con!=null) {
				System.out.println("Connection Established Successfully");
			}
			else {
				System.out.println("Connection Failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        ((ClassPathXmlApplicationContext) context).close();
    }
}
