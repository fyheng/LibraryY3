package Controller;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain.MemberDomain;
import Domain.StaffDomain;
import configDB.JDBC;

public class MemberController {
	public void create(String nationalId, String firstName, String lastName, String sex, String email, String phone,
			String address, int roleId) {
		String fullName = firstName+lastName;
//# step 1 create secuser
		JDBC.setKey("password", "username", "email", "role_id");
		try {
			JDBC.insert("secuser", phone, phone, email, roleId + "");
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
//# step 3  insert to member table
		try {
			JDBC.setKey("national_id", "first_name", "last_name", "full_name", "sex", "email", "phone", "address",
					"SecUser_id", "SecUser_role_id");
			String insert = JDBC.insert("member",nationalId, firstName, lastName,fullName,sex,email, phone, address,
					secuserId,roleId+"");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
