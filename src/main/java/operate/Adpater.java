package operate;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import configDB.JDBC;
import login.Login;
import login.Validate;

public class Adpater {
	
	static void getProperties(String...strings) {

	}
	
	public static ArrayList<String> getInfo() throws SQLException {
		return JDBC.readBy("staff", "SecUser_id", Login.data.get(0)).get(0);
	}
	
	public static ArrayList<String> getRole() throws SQLException {
		
		System.out.println("test"+JDBC.readBy("role", "id", Login.data.get(5)));
		
		return JDBC.readBy("role", "id", Login.data.get(5)).get(0);
	}
	
	
//	public static boolean updateBy(String tbName ,String column , String Oldvalue , String newValue) {
//		try {
//			JDBC.updateBy(tbName, column, Oldvalue, newValue);
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		return true;
//	}
		
		
	
	public static void componen(JTextField jtextField,JPanel panel,int w,int x,int y,int z) {
		jtextField = new JTextField();
		jtextField.setColumns(10);
		jtextField.setBounds(w, x, y, z);
		panel.add(jtextField);

	}

}
