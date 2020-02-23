package Controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Logger;

import Domain.SupplierDomain;
import configDB.JDBC;
import vathanak.Application;

public class ImportDetailController {
	
	   public void create(int importQty,double unitPrice,String bookCode, String importDate,String description,int StaffId,int SupplierId) {
   	    
		ImportDetailController importDetail = new ImportDetailController();
    	Connection con = Application.getConnection();
 //# step 1 add to table import   	
    	//convert staring to date
    	LocalDate date = LocalDate.parse(importDate);
    	
    	//convert date java to sql date
    	java.sql.Date dateimportSql = java.sql.Date.valueOf(date);
    	
    	//get current date 
   	    Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
        
   	    try {
		    String sql = "insert into import(create_date,import_date,Staff_id,Supplier_id) "
		    			+ "values (?,?,?,?)";
		    PreparedStatement  ps = con.prepareStatement(sql);
		    ps.setDate(1,ourJavaDateObject);
		    ps.setDate(2, dateimportSql);
		    ps.setInt(3, StaffId);
		    ps.setInt(4, SupplierId);
		    ps.execute();
			con.close();
			System.out.println("inert to table import sucess");
   	    }catch (Exception e) {
   	    	System.out.println(e.getMessage());
		}
// # step 2 find find import last record 
   	    ArrayList<ArrayList<String>> importList = new ArrayList<ArrayList<String>>();	    
   	    try {
   	    	importList=JDBC.readData("import","id");
		} catch (SQLException e) {
			e.printStackTrace();
		}
   	    ArrayList<String> importId = importList.get(importList.size()-1);
   	    System.out.println(importId);
// # step 3 find book_id by bookCode 	    
   	    ArrayList<ArrayList<String>> bookList = new ArrayList<ArrayList<String>>();
   	    try {
   	    	bookList=JDBC.readBy("book", "book_code", bookCode);
   	    }catch (SQLException e) {
			e.printStackTrace();
		}
	   	String bookId = bookList.get(0).get(0);
	   	String categoryId = bookList.get(0).get(9);
	   	String qty = bookList.get(0).get(10) ;
	   	String pricePaid = bookList.get(0).get(11);
	   	
// # step 4 add to table import detail	  
      	Connection con2 = Application.getConnection();   
   	    try {   	
		    String sql = "insert into import_detail(import_qty, unit_price, description, import_id, Book_id, Book_category_id)"
		    		   + "values (?,?,?,?,?,?)";
		   PreparedStatement  ps = con2.prepareStatement(sql);
		   ps.setInt   (1, importQty);
		   ps.setDouble(2, unitPrice);
		   ps.setString(3, description);
		   ps.setString(4, importId.get(0));
		   ps.setInt(5, Integer.parseInt(bookId));
		   ps.setInt(6, Integer.parseInt(categoryId));
		   System.out.println("inert to table import_detail sucess");
		   ps.execute();
		   con2.close();
  		 }catch (Exception e) {
			System.out.println(e.getMessage());  
  		 } 	    
// # step 5 update qty book or update price 
   	    int newQty = Integer.parseInt(qty)+importQty; // old qty + new qty;
   	    JDBC.updateBy("book", "qty",newQty+"", "book_code", bookCode);
   	    JDBC.updateBy("book", "price_paid",unitPrice+"", "book_code", bookCode);
   	    
// # step 6 update qty book or update price   
    }
}
