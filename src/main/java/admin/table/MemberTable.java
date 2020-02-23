package admin.table;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MemberTable {

	public static DefaultTableModel MemberTableModel = new DefaultTableModel();
	public static JScrollPane issuetable(){
		JTable MemberTable = new JTable(MemberTableModel);
		MemberTableModel.addColumn("No");
		MemberTableModel.addColumn("Member name");
		MemberTableModel.addColumn("Menber ID");
		MemberTableModel.addColumn("Date of brith");
		MemberTableModel.addColumn("Phone Number");
		MemberTableModel.addColumn("Address");
		MemberTableModel.addColumn("Email");
		
		
//		ArrayList<ArrayList<String>> res = JDBC.readData("Book");
//		
//		for(int i = 0; i < res.size();i++) {
//			model.addRow(new Object[] {res.get(i).get(0),res.get(i).get(1),res.get(i).get(2),res.get(i).get(3),res.get(i).get(4),res.get(i).get(5),res.get(i).get(6)});
//			System.out.println();
//		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);
		
		scrollPane.setViewportView(MemberTable);
		
		return scrollPane;
	}

}
