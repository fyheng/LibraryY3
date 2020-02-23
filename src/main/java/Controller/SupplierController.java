package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;
import Domain.SupplierDomain;
import vathanak.Application;

public class SupplierController {
	public void create(String firstName, String lastName, String sex, String email,String phone,String address,int roleId) {
	    	 Connection con = Application.getConnection();
	    	 SupplierDomain supplier = new SupplierDomain();
	    	 supplier.setFull_name(firstName+lastName);
	    	 try {   	
	 		    String sql = "insert into supplier(first_name,last_name,full_name,sex,email,phone,address,role_id) "
	 		    		   + "values (?,?,?,?,?,?,?,?)";
	 		   PreparedStatement  ps = con.prepareStatement(sql);
	 		   ps.setString(1, firstName);
	 		   ps.setString(2, lastName);
	 		   ps.setString(3, supplier.getFull_name());
	 		   ps.setString(4, sex);
	 		   ps.setString(5, email);
	 		   ps.setString(6, phone);
	 		   ps.setString(7, address);
	 		   ps.setInt(8, roleId);
	 		   ps.execute();
	 		   con.close();
	 		  Logger logger = Logger.getGlobal();
		 	  logger.info("Insert Data Success");
	   		 }catch (Exception e) {
	 			System.out.println(e.getMessage());  
	 		}    
     }

    }
