package admin.table;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StaffTable {
	public static DefaultTableModel model = new DefaultTableModel();
	
	public static JScrollPane staffTables() throws SQLException {
		JTable TotalBookTable = new JTable(model);
		model.addColumn("No");
		model.addColumn("Name");
		model.addColumn("Sex");;
		model.addColumn("Email");
		model.addColumn("Phone number");
		model.addColumn("Role");
		
//		ArrayList<ArrayList<String>> res = JDBC.readData("Book");
//		
//		for(int i = 0; i < res.size();i++) {
//			model.addRow(new Object[] {res.get(i).get(0),res.get(i).get(1),res.get(i).get(2),res.get(i).get(3),res.get(i).get(4),res.get(i).get(5),res.get(i).get(6)});
//		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);
		
		scrollPane.setViewportView(TotalBookTable);
		
		return scrollPane;
	}
}
