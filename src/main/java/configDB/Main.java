package configDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws SQLException {

		ArrayList<ArrayList<String>> result = JDBC.readData("book_detail", "code", "dueDate");

		String value = JDBC.getDate();
		System.out.println(value);
		result = JDBC.readBy("book_detail", "dueDate","2012-01-01");

		result = JDBC.readBys("book_detail", "status", "2", "dueDate", "2020-02-02");

		System.out.println(result);

		int c = JDBC.getCountBy("book_detail","status","2","dueDate","2020-02-02");
		System.out.println(c);
	}

}
