package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Domain.BookDomain;
import Enumeration.BooKStatus;
import configDB.JDBC;

public class BookController {
	
   public void create(String bookCode, String title ,String language,String authors,String publicAt, String edition, int categoryId) {
	   BookDomain book = new BookDomain();
	   book.setStatus(BooKStatus.NEW); 
	   //book.setQty();
	   ArrayList<ArrayList<String>> importDeatil = new ArrayList<ArrayList<String>>();
	   try {
		importDeatil = JDBC.readBy("importDetail", "book_id", bookCode);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//	   book.setQty(importDeatil.get(0).get(7).toString());
	   
	   JDBC.setKey("title","language","status","authors","public_at","edition","book_code",
   			"qty","price_paid", "category_id"); 
   	   try {
			JDBC.insert("Book",title.toString(),language.toString(),book.getStatus().toString(),authors,publicAt,edition,
					bookCode,book.getQty().toString(),book.getPricePaid().toString(),categoryId+"");
//					bookCode,"1","12",categoryId+"");
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
//	   try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libraryproject","root","password");	   
//			Statement st = con.createStatement(); 	
//		    String sql = "insert into * book(title,language,status,authors,public_atm,edition,book_code,qty,price_paid,category_id)";
//		    ResultSet rs = st.executeQuery(sql);
//		   	        
//		   }
// 		 }catch (Exception e) {
//			System.out.println(e);
//		}
	   
   }

}
