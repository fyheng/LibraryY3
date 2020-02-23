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
// # step 1 create secuser
        	  JDBC.setKey("password","username","email","role_id");
        	  try {
      			JDBC.insert("secuser",phone,phone,email,roleId+"");
      		 } catch (SQLException e) {
      			e.printStackTrace();
      		 }
        	  
//# step 2 find secuser id
        	  ArrayList<ArrayList<String>> secuser = new ArrayList<ArrayList<String>>();
        	  try {
        		  secuser = JDBC.readBy("secuser", "username", phone);
        	  } catch (SQLException e1) {
        		  e1.printStackTrace();
        	  }
        	  	 String secuserId = secuser.get(0).get(0); 
//# step 3  insert to staff table
		try {
			JDBC.setKey("first_name", "last_name", "sex", "full_name", "phone", "email", "national_id", "start_at",
					"dob", "address", "SecUser_id", "SecUser_role_id");
			JDBC.insert("staff", firstName, lastName, sex, staff.getFullName(), phone, email, nationalId, startAt, dob,
					address, secuserId, roleId + "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
