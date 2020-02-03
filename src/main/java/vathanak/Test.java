package vathanak;
import java.sql.*;
public class Test {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/libraryproject","libraryproject","vathanak.com$$");
			   
			Statement st = con.createStatement(); 	
		    String sql = "Select * from role";
		    ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   System.out.println("name : "+rs.getString("name"));
		   }
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
