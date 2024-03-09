package com.js.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
                     //STANDARD PROCEDURE
public class GetStudentById {
	
	static Connection c;     //making connection global variable
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc_first";
		String user = "root";
		String password = "Digvijay@123";
		
		String query = "select * from student where age=12";
		
		//Connection c=null  //using this we no need to close the connectiion
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    c = DriverManager.getConnection(url, user, password);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(query);//ResultSet = ctr+space select first interface enter
			while(rs.next()) {
				System.out.println("Id = "+rs.getInt(1));
				System.out.println("Name = "+rs.getString(2));
				System.out.println("Age = "+rs.getInt(3));
				System.out.println("====================================");
			}
			//System.out.println("Values not Found");//when values are out of table
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {              //No need to write this finally block but if we get any sql exception
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
