package admin.table;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import configDB.JDBC;
import operate.Adpater;

public class StaffTable {
	public static DefaultTableModel model = new DefaultTableModel();
	public static JScrollPane staffTables() throws SQLException {
		JTable TotalBookTable = new JTable(model);
		model.addColumn("No");
		model.addColumn("Name");
		model.addColumn("Sex");
		model.addColumn("Email");
		model.addColumn("Phone number");
		model.addColumn("Role");
		
		ArrayList<ArrayList<String>> res = JDBC.readData("staff");
		String role;
		int no;
		for(int i = 0; i < res.size();i++) {
			no=i+1;
			if(res.get(i).get(13).equals("1")) {
				role="admin";
			}else {
				role="staff";
			}
			model.addRow(new Object[] {no,res.get(i).get(5),res.get(i).get(4),res.get(i).get(7),res.get(i).get(6),role});
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);
		
		scrollPane.setViewportView(TotalBookTable);
		
		return scrollPane;
	}
}
