package configDB;

import java.sql.SQLException;
import java.util.ArrayList;

import login.Validate;

public class Main {

	public static void main(String args[]) throws SQLException {
		//JDBC jdbc = new JDBC("localhost","3306","libaryDB","root","12345678");

//		ArrayList<ArrayList<String>> result = JDBC.readData("Book", "code", "dueDate");
//
//		
//		result = JDBC.readBy("Book", "dueDate","");
//		System.out.println(result.size());
//		
//		result = JDBC.readBys("Book", "status", "2", "dueDate", "2020-02-02");
//		System.out.println(result);
//
//		int c = JDBC.getCountBy("Book","status","2","dueDate","2020-02-02");
//		System.out.println(c);
		
		//need to call this two method to insert date to DB and follow the format
		//JDBC.setKey("name");
		//JDBC.insert("role","ROLE_MEMBER");
//		jdbc.delete("book_detail", "code", "004");
		System.out.println("Hello");
		Validate.sendMail("hengta56@gmail.com");
	
		
	}
	
	
	

}
