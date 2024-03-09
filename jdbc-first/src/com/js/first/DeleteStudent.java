package com.js.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStudent {
	
	       //DELETE
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "delete from student where id = 3";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			Statement st = c.createStatement();
			st.execute(query);
			c.close();
			System.out.println("Student deleted Successfully!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
