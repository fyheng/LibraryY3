package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Role;
import Domain.Staff;
import configDB.JDBC;

public class StaffController {
      public void create(String firstName,String lastName,String fullName,String sex , String address,String dob,String phoneNumber,String passport,String startAt) {
    	  Staff staff = new Staff(firstName,lastName,fullName,sex,address,dob,phoneNumber,passport,startAt);
    	  JDBC.setKey("firstName","lastName","fullName","sex","address","dob","phoneNumber"); 
    	 try {
			JDBC.insert("Person",staff.getFistName(),staff.getLastName(),staff.getFullName(),staff.getSex(),staff.getAddress(),staff.getDob(),staff.getPhoneNumber());
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
    	 
    	 JDBC.setKey("firstName","lastName","fullName","sex","address","dob","phoneNumber"); 
    	 try {
			JDBC.insert("Person",staff.getFistName(),staff.getLastName(),staff.getFullName(),staff.getSex(),staff.getAddress(),staff.getDob(),staff.getPhoneNumber());
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
    	  
      }
    	  
}
