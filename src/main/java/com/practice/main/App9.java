package com.practice.main;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.practice.model.Employee;
import com.practice.resources.SpringConfigFile;

public class App9 {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
		
		Employee emp1 = (Employee) context.getBean("emp1");
		Employee emp2 = (Employee) context.getBean("emp2");
		Employee emp3 = (Employee) context.getBean("emp3");
		
		List<Employee> lists = new ArrayList<Employee>();
		lists.add(emp1);
		lists.add(emp2);
		lists.add(emp3);
		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
		
		String query = "insert into employees values (?, ?, ?, ?)";
		
		int[] counts = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				 
				Employee emp = lists.get(i);
				ps.setInt(1, emp.getId());
				ps.setString(2, emp.getName());
				ps.setInt(3, emp.getSalary());
				ps.setString(4, emp.getPost());
			}
			
			@Override
			public int getBatchSize() {
				
				return lists.size();
			}
		});
		
		for(int count : counts) {
			System.out.println(count+" : Success");
		}
	}

}
