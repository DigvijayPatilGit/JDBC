package com.js.first;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

public class Student {
	          //INSERT

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "insert into student values (5,'Priya',12)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//1.Load and register the driver
			
			Connection c = DriverManager.getConnection(url, user, password);//2.Establish the connection
			//Connection=ctr+space=connection java connection.sql
			Statement st = c.createStatement();//Statement=ctr+space=click statement java.sql=enter//3.Create Statement
			
			st.execute(query);//4.Executing the statement
			
			c.close();//5.Close connection

			System.out.println("Student Data Saved");
			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
