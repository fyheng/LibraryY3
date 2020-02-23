package admin.table;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddIssueTable {
	public static DefaultTableModel Issuemodel = new DefaultTableModel();
	public static JScrollPane issuetable(){
		JTable IssueBook = new JTable(Issuemodel);
		Issuemodel.addColumn("No");
		Issuemodel.addColumn("Member name");
		Issuemodel.addColumn("Book title");
		Issuemodel.addColumn("Quantity");
		Issuemodel.addColumn("Issue Date");
		Issuemodel.addColumn("Due Date");
		Issuemodel.addColumn("Book price");
		
		
//		ArrayList<ArrayList<String>> res = JDBC.readData("Book");
//		
//		for(int i = 0; i < res.size();i++) {
//			model.addRow(new Object[] {res.get(i).get(0),res.get(i).get(1),res.get(i).get(2),res.get(i).get(3),res.get(i).get(4),res.get(i).get(5),res.get(i).get(6)});
//			System.out.println();
//		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 370, 965, 250);
		
		scrollPane.setViewportView(IssueBook);
		
		return scrollPane;
	}
}
