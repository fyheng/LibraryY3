package admin.table;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookTable {

	public static DefaultTableModel BookTablemodel = new DefaultTableModel();
	public static JScrollPane issuetable(){
		JTable BookTable = new JTable(BookTablemodel);
		BookTablemodel.addColumn("No");
		BookTablemodel.addColumn("Book ID");
		BookTablemodel.addColumn("Book title");
		BookTablemodel.addColumn("Author");
		BookTablemodel.addColumn("Pubilsher");
		BookTablemodel.addColumn("Language");
		BookTablemodel.addColumn("Price");
		
		
//		ArrayList<ArrayList<String>> res = JDBC.readData("Book");
//		
//		for(int i = 0; i < res.size();i++) {
//			model.addRow(new Object[] {res.get(i).get(0),res.get(i).get(1),res.get(i).get(2),res.get(i).get(3),res.get(i).get(4),res.get(i).get(5),res.get(i).get(6)});
//			System.out.println();
//		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 109, 965, 523);
		
		scrollPane.setViewportView(BookTable);
		
		return scrollPane;
	}

}
