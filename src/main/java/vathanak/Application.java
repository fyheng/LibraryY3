package vathanak;

import java.sql.Connection;
import java.sql.DriverManager;

public class Application {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryproject","root","mengsieng");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage()); 
		}
		return con;
	}
	
	
}
