package configDB;

import java.sql.SQLException;

public class Main {
	
	public static void main(String args[]) throws SQLException {
		
		Object reauft = JDBC.readData("subject","code");
		System.out.println(reauft);
		
		
		int c = JDBC.getCount("subject","code","003");
		System.out.println(c);
		System.out.print("hhhhhh");
	}


}
