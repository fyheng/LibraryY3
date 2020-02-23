package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

import Domain.SupplierDomain;
import vathanak.Application;

public class ImportDetailController {
    public void create(int BookId,int importQty,Double unit_price,String description,int StaffId,int SupplierId) {
   	    ImportDetailController importDetail = new ImportDetailController();
   	    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
   	    Date dateobj = new Date(0);
   	    System.out.println(df.format(dateobj));
   	    
//   	    try {
//   	    	
//   	    }catch (Exception e) {
//   	    	System.out.println(e.getMessage());
//		}
   	    
//   	    try {   	
//		    String sql = "insert into import_detail(import_qty,unit_price,full_name,sex,email,phone,address,role_id) "
//		    		   + "values (?,?,?,?,?,?,?,?)";
//		   PreparedStatement  ps = con.prepareStatement(sql);
//		   ps.setString(1, firstName);
//		   ps.setString(2, lastName);
//		   ps.setString(3, supplier.getFull_name());
//		   ps.setString(4, sex);
//		   ps.setString(5, email);
//		   ps.setString(6, phone);
//		   ps.setString(7, address); 
//		   ps.setInt(8, roleId); 
//		   ps.execute();
//		   con.close();
//		  Logger logger = Logger.getGlobal();
//	 	  logger.info("Insert Data Success");
//  		 }catch (Exception e) {
//			System.out.println(e.getMessage());  
//		}    
    }
}
