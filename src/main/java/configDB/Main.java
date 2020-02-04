package configDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws SQLException {

		ArrayList<ArrayList<String>> result = JDBC.readData("book_detail", "code", "dueDate");

		
		result = JDBC.readBy("book_detail", "dueDate","");
		System.out.println(result.size());
		
		result = JDBC.readBys("book_detail", "status", "2", "dueDate", "2020-02-02");
		System.out.println(result);

		int c = JDBC.getCountBy("book_detail","status","2","dueDate","2020-02-02");
		System.out.println(c);
		
		//need to call this two method to insert date to DB and follow the format
		JDBC.setKey("code", "borrowed", "dueDate", "status");
		JDBC.insert("book_detail","005","2020-02-06","2020-02-06","3");
	
		
	}
	
	
	

}
