package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Role;
import Domain.Staff;
import configDB.JDBC;

public class StaffController {
      public void create(String firstName,String lastName,String fullName,String sex , String address,String dob,String phoneNumber,String nationalId,String startAt,int roleId,String email) {
    	  Staff staff = new Staff(firstName,lastName,fullName,sex,address,dob,phoneNumber,nationalId,startAt,roleId,email);
    	  JDBC.setKey("first_name","last_name","full_name","sex","address","dob","phone_number",
    			"national_id","start_at","role_id","email"); 
    	 try {
			JDBC.insert("staff",staff.getFistName(),staff.getLastName(),staff.getFullName(),staff.getSex(),staff.getAddress(),staff.getDob(),staff.getPhoneNumber(),
					    staff.getNationalId(),staff.getStartAt(),staff.getRoleId().toString(),staff.getEmail().toString());
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
      }
    	  
}
