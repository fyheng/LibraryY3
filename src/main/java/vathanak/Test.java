package vathanak;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import Controller.BookController;
import Controller.CategoryController;
import Controller.ImportDetailController;
import Controller.MemberController;
import Controller.StaffController;
import Controller.SupplierController;
import Domain.BookDomain;
import Domain.StaffDomain;
import Domain.SupplierDomain; 
import configDB.JDBC;
public class Test {

	public static void main(String[] args) throws ParseException {

	 //add staff
//	StaffController staff = new StaffController();
//	staff.create("kok2", "jm", "m", "09876", "kok@gmail.com", "345679", "20202", "pp", 2, "1999");
	
		
		//add supplier
//		SupplierController supplier = new SupplierController();
//		supplier.create("kok", "jm", "m", "kok", "098765", "pp", 1);
		
		//create category
//		CategoryController category = new CategoryController();
//		category.create("math", "test math category"); 
		
		//create book
//		BookController book = new BookController();
//		book.create("111222", "java", "engish", "vathanak", "20202", "1", 4);
//		

//		 LocalDate date = LocalDate.now();
//		 System.out.println(date);
		
//		Calendar calendar = Calendar.getInstance();
//        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
//        System.out.println(ourJavaDateObject);
//		String importDate= "2020-02-10";
//    	String[] splitDate = importDate.split("-", 5); 
//  	  
//        for (String split : splitDate) 
//            System.out.println(split);
//		 String importDate="2020-02-10";
//		 SimpleDateFormat importDatecv = new SimpleDateFormat("yyy-MMM-dd");  
//    	 Date date= (Date) importDatecv.parse(importDate); 
		
		
//		ImportDetailController importDetail = new ImportDetailController();
//		importDetail.create(10, 100,"111223", "2020-02-23", "test", 1, 1);

//		importDetail.create(10, 100, , importDate, description, StaffId, SupplierId);
//		importDetail.create(10,100,"2020-02-23", "test", 1, 1);
		
		MemberController member = new MemberController();
		member.create("23456", "aaa", "bbb", "m", "aaa@gmail.com", "0987654", "pp", 3);
	}
	

}
