package configDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]) throws SQLException {
		
		ArrayList<ArrayList<String>> reauft = JDBC.readData("book_detail","code","dueDate");
		System.out.println(reauft.size());
		
		
		int c = JDBC.getCount("book_detail","dueDate","2020-2-01");
		System.out.println(c);
	}


}
