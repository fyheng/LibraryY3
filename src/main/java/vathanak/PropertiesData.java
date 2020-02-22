package vathanak;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import Domain.RoleDomain;
 
public class PropertiesData {
	
	public ArrayList<String> comboboItem() {
		ArrayList<String> obj = new ArrayList<String>();
		RoleDomain role = new RoleDomain();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libraryproject","root","password");	   
			Statement st = con.createStatement(); 	
		    String sql = "Select * from role";
		    ResultSet rs = st.executeQuery(sql);
		   while(rs.next()) {
			   role.setName(rs.getString("name"));
			   String data = role.getName();
			   obj.add(data);	        
		   }
  		 }catch (Exception e) {
			System.out.println(e);
		}
        return obj;
	}
	
}
