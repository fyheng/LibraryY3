package configDB;

import java.sql.SQLException;

public class Main {
	
	public static void main(String args[]) throws SQLException {
		
		Object reauft = JDBC.readData("subject","code","id","name");
		System.out.println(reauft);
		
	}


}
