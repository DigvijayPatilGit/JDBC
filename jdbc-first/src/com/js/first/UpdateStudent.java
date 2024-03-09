package com.js.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent {
	
	     //UPDATE
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "update student set name='Shivam', age = 12 where id = 4 ";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			Statement st = c.createStatement();
			st.execute(query);
			System.out.println("Student Updated Successfully");
			c.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
