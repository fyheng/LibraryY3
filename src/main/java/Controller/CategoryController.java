package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import Domain.CategoryDomain;
import Domain.SupplierDomain;
import vathanak.Application;

public class CategoryController {
	public void create(String name,String description) {
	    	 Connection con = Application.getConnection();
	    	 CategoryDomain category = new CategoryDomain();
	    	 try {   	
	 		    String sql = "insert into category(name,description) "
	 		    		   + "values (?,?)";
	 		   PreparedStatement  ps = con.prepareStatement(sql);
	 		   ps.setString(1, name);
	 		   ps.setString(2, description);
	 		   ps.execute();
	 		   con.close();
	 		  Logger logger = Logger.getGlobal();
		 	  logger.info("Insert Data Success");
	   		 }catch (Exception e) {
	 			System.out.println(e.getMessage());  
	 		}    
	}

}
