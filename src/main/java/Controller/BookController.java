package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import Domain.BookDomain;
import Domain.SupplierDomain;
import Enumeration.BooKStatus;
import configDB.JDBC;
import vathanak.Application;

public class BookController {
	
//   public void create(String bookCode, String title ,String language,String authors,String publicAt, String edition, int categoryId) {
//# old process and connection not use 
	   
	   //	   BookDomain book = new BookDomain(); 
//	   book.setStatus(BooKStatus.NEW); 
//	   //book.setQty();
//	   ArrayList<ArrayList<String>> importDeatil = new ArrayList<ArrayList<String>>();
//	   try {
//		importDeatil = JDBC.readBy("importDetail", "book_id", bookCode);
//	} catch (SQLException e1) {
//		// TODO Auto-generated catch block 
//		e1.printStackTrace();
//	}
////	   book.setQty(importDeatil.get(0).get(7).toString());
//	   
//	   JDBC.setKey("title","language","status","authors","public_at","edition","book_code",
//   			"qty","price_paid", "category_id"); 
//   	   try {
//			JDBC.insert("Book",title.toString(),language.toString(),book.getStatus().toString(),authors,publicAt,edition,
//					bookCode,book.getQty().toString(),book.getPricePaid().toString(),categoryId+"");
////					bookCode,"1","12",categoryId+"");
//		 } catch (SQLException e) {
//			e.printStackTrace();
//		 }
////	   try {
////			Class.forName("com.mysql.jdbc.Driver");
////			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libraryproject","root","password");	   
////			Statement st = con.createStatement(); 	
////		    String sql = "insert into * book(title,language,status,authors,public_atm,edition,book_code,qty,price_paid,category_id)";
////		    ResultSet rs = st.executeQuery(sql);
////		   	        
////		   }
//// 		 }catch (Exception e) {
////			System.out.println(e);
////		}  
//   }
	
	 public void create(String bookCode, String title ,String language,String authors,String publicAt, String edition, int categoryId) {
		 Connection con = Application.getConnection();
    	 BookDomain book = new BookDomain();
//    	 BooKStatus[] status = BooKStatus.values();
    	 book.setStatus(BooKStatus.NEW); 
    	 try {   	
 		    String sql = "insert into book(book_code,title,language,status,authors,public_at,edition,category_id) "
 		    		   + "values (?,?,?,?,?,?,?,?)";
 		   PreparedStatement  ps = con.prepareStatement(sql);
 		   ps.setString(1, bookCode);
 		   ps.setString(2, title);
 		   ps.setString(3, language);
 		   ps.setString(4, book.getStatus().toString());
 		   ps.setString(5, authors);
 		   ps.setString(6, publicAt);
 		   ps.setString(7, edition); 
 		   ps.setInt(8, categoryId); 
 		   ps.execute();
 		   con.close();
 		  Logger logger = Logger.getGlobal();
	 	  logger.info("Insert Data Success");
   		 }catch (Exception e) {
 			System.out.println(e.getMessage());  
 		}    
	 }

}
