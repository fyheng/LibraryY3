package admin.table;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import configDB.JDBC;

public class MemberTable2 {

	public static DefaultTableModel MemberTableModel = new DefaultTableModel();
	public static JScrollPane issuetable(){
		JTable MemberTable = new JTable(MemberTableModel);
		MemberTableModel.addColumn("No");
		MemberTableModel.addColumn("Member name");
		MemberTableModel.addColumn("National ID");
		MemberTableModel.addColumn("Phone Number");
		MemberTableModel.addColumn("Address");
		MemberTableModel.addColumn("Email");
		
		
		ArrayList<ArrayList<String>> res;
		try {
			res = JDBC.readData("member");
			for(int i = 0; i < res.size();i++) {
				MemberTableModel.addRow(new Object[] {res.get(i).get(0),res.get(i).get(5),res.get(i).get(3),res.get(i).get(8),res.get(i).get(9),res.get(i).get(7)});
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);
		
		scrollPane.setViewportView(MemberTable);
		
		return scrollPane;
	}
	public static void setTable()  {
		ArrayList<ArrayList<String>> res;
		try {
			res = JDBC.readData("member");
			for(int i = 0; i < res.size();i++) {
				MemberTableModel.addRow(new Object[] {res.get(i).get(0),res.get(i).get(5),res.get(i).get(3),res.get(i).get(8),res.get(i).get(9),res.get(i).get(7)});
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
