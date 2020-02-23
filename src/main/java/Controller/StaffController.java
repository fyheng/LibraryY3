package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import Domain.RoleDomain;
import Domain.StaffDomain;
import configDB.JDBC;

public class StaffController {
      public void create(String firstName,String lastName,String sex , String phone,String email,String nationalId,String startAt,String address,int roleId,
    		             String dob) {
    	  StaffDomain staff = new StaffDomain();
    	  staff.setFullName(firstName+lastName); 
//    	  //find phone staff
//    	  ArrayList<ArrayList<String>> staffList = new ArrayList<ArrayList<String>>();
//    	  try {
//    		  staffList = JDBC.readBy("staff", "phone", phone);
//    	  } catch (SQLException e1) {
//    		  // TODO Auto-generated catch block
//    		  e1.printStackTrace();
//    	  }
//    	
//    	  System.out.println(staffList);
//    	  String staffPhone = staffList.get(1).get(6);
//    	  System.out.println(staffPhone);
//    	  if(staffList==null) {
    		  //create secuser
        	  JDBC.setKey("password","username","role_id");
        	  try {
      			JDBC.insert("secuser",phone,phone,roleId+"");
      		 } catch (SQLException e) {
      			e.printStackTrace();
      		 }
        	  
        	  //find secuser id
        	  ArrayList<ArrayList<String>> secuser = new ArrayList<ArrayList<String>>();
        	  try {
        		  secuser = JDBC.readBy("secuser", "username", phone);
        	  } catch (SQLException e1) {
        		  // TODO Auto-generated catch block
        		  e1.printStackTrace();
        	  }
        	  	 String secuserId = secuser.get(0).get(0); 

        	  JDBC.setKey("first_name","last_name","sex","full_name","phone","email","national_id",
        			"start_at","dob","address","SecUser_id","SecUser_role_id"); 
        	 try {
    			JDBC.insert("staff",firstName,lastName,sex,staff.getFullName(),phone,email,nationalId,
    					startAt,dob,address,secuserId,roleId+"");
    		 } catch (SQLException e) {
    			e.printStackTrace();
    		 }
    		  
//    	  }
//    	  else {
//    		  Logger logger = Logger.getGlobal();
//  			logger.info("phone number already exit");
//    	  }
    	  
    	 
      }
    	  
}
