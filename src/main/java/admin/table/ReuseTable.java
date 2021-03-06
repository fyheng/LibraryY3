package admin.table;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import configDB.JDBC;

public class ReuseTable {

	public static DefaultTableModel model = new DefaultTableModel();

	public static JScrollPane TotalBook() throws SQLException {
		JTable TotalBookTable = new JTable(model);
		model.addColumn("ID");
		model.addColumn("Book code");
		model.addColumn("Title");
		model.addColumn("Language");
		model.addColumn("Status");
		model.addColumn("Author");
		model.addColumn("publish");
		model.addColumn("Quantity");

		ArrayList<ArrayList<String>> res = JDBC.readData("Book");

		for (int i = 0; i < res.size(); i++) {
			model.addRow(new Object[] { res.get(i).get(0), res.get(i).get(2), res.get(i).get(3), res.get(i).get(4),
					res.get(i).get(5), res.get(i).get(6), res.get(i).get(7), res.get(i).get(9) });
		}

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);

		scrollPane.setViewportView(TotalBookTable);

		return scrollPane;
	}

	public static void setTable()  {
		ArrayList<ArrayList<String>> res;
		try {
			res = JDBC.readData("Book");
			for (int i = 0; i < res.size(); i++) {
				model.addRow(new Object[] { res.get(i).get(0), res.get(i).get(2), res.get(i).get(3), res.get(i).get(4),
						res.get(i).get(5), res.get(i).get(6), res.get(i).get(7), res.get(i).get(9) });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
