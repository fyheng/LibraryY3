package configDB;

import java.sql.SQLException;

public class Main {
	
	public static void main(String args[]) throws SQLException {
		
		Object reauft = JDBC.readData("book_detail","code","dueDate");
		System.out.println(reauft);
		
		
		int c = JDBC.getCount("book_detail","dueDate","");
		System.out.println(c);
	}


}
