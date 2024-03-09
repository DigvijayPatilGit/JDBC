package com.js.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetStudents {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "select * from student";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, user, password);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);//ResultSet = ctr+space select first interface enter
			while(rs.next()) {
				System.out.println("Id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
				System.out.println("Age = "+rs.getInt(3));
				System.out.println("====================================");
			}
			c.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
