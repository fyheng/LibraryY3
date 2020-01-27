package configDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static void main(String args[]) throws SQLException {
		Statement statement;
		ResultSet resultSet;
		JDBC jdbc = new JDBC();
		jdbc.connection();
		System.out.println(jdbc.connection().getClass());
		statement = jdbc.connection().createStatement();
		resultSet = statement.executeQuery("select * from subject");
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("code"));
		}
	}


}
