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
		return JDBC.readBy("staff", "secuserId", Login.data.get(0)).get(0); 
	}
	
	
	
	public static void componen(JTextField jtextField,JPanel panel,int w,int x,int y,int z) {
		jtextField = new JTextField();
		jtextField.setColumns(10);
		jtextField.setBounds(w, x, y, z);
		panel.add(jtextField);

	}

}
