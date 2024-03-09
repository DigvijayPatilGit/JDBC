package com.js.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class GetStudentByColumnName {
	
	//ANOTHER WAY TO LOAD THE
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "select * from student";
		Connection c=null;
		try {
			Driver d=new Driver();       //Another way to Load the driver
			DriverManager.registerDriver(d);
			c=DriverManager.getConnection(url, user, password);
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				System.out.println("Id = "+rs.getInt("id"));
				System.out.println("Name = "+rs.getString("name"));
				System.out.println("Age = "+rs.getInt("age"));
				System.out.println("====================================");
			}
		//Using this way of loading the driver we remove one catch block of classnotfound
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
