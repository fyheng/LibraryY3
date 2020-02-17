package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.function.ButtonClick;
import admin.uiTool.DrawerItem;
import admin.uiTool.MenuItem;
import configDB.JDBC;
import picture.GetIcon;
import picture.Icons;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Home extends JFrame {

	private JPanel contentPane;
	GetIcon icon;
	JLabel lblNewLabel = new JLabel("Home");
	final JPanel HomeItem = new JPanel();
	final JPanel StaffItem = new JPanel();
	JPanel MainMenu = new JPanel();
	JPanel TotalBookView = new JPanel();
	JPanel StaffView = new JPanel();
	JPanel BookReturniew = new JPanel();
	JPanel IssueBookView = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Home() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Main panel
		TotalBookView.setVisible(false);
		StaffView.setVisible(false);
		IssueBookView.setVisible(false);
		StaffItem.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1240, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1169, 10, 50, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 50, 50);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(GetIcon.setIcon(Icons.Close));
		
		JPanel Drawer = new JPanel();
		Drawer.setBackground(new Color(0, 0, 51));
		Drawer.setBounds(0, 72, 185, 738);
		contentPane.add(Drawer);
		Drawer.setLayout(null);
		
		JLabel ProfileIcon = new JLabel("");
		ProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileIcon.setBounds(0, 0, 185, 146);
		Drawer.add(ProfileIcon);
		ProfileIcon.setIcon(GetIcon.setIcon(Icons.MaleUser));
		
		JLabel lblNewLabel_2 = new JLabel("Him meng sieng");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 143, 185, 41);
		Drawer.add(lblNewLabel_2);
		Drawer.add(DrawerItem.drawerItem("Dashboard",195,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Home");
				MainMenu.setVisible(true);
			}
		}));
		
		
		HomeItem.setBackground(new Color(0, 0, 51));
		HomeItem.setBounds(0, 246, 185, 492);
		Drawer.add(HomeItem);
		HomeItem.setLayout(null);
		
		HomeItem.add(DrawerItem.drawerItem("Total book",0,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Total book");
//				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(true);
				StaffView.setVisible(false);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(false);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Issue book",46,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issue book");
//				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(false);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Book returned",46*2,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Book returned");
//				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(false);
				BookReturniew.setVisible(true);
				IssueBookView.setVisible(false);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Staff",46*3,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Staff");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(true);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(false);
				StaffItem.setVisible(true);
			}
		}));
		
		StaffItem.setBackground(new Color(0, 0, 51));
		StaffItem.setBounds(0, 246, 185, 492);
		StaffItem.setLayout(null);
		StaffItem.setVisible(false);
		Drawer.add(StaffItem);
		
		StaffItem.add(DrawerItem.drawerItem("Add staff",0,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Drawer 1");
				MainMenu.setVisible(false);
//				StaffInput.setVisible(true);
			}
		}));
		StaffItem.add(DrawerItem.drawerItem("Delete staff",46,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Drawer 2");
			}
		}));
		StaffItem.add(DrawerItem.drawerItem("Edit staff",46*2,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Drawer 3");
			}
		}));
		StaffItem.add(DrawerItem.drawerItem("Back",46*3,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Home");
				HomeItem.setVisible(true);
				StaffItem.setVisible(false);
			}
		}));
		
		
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(220, 113, 254, 12);
		contentPane.add(separator);
		BookReturniew.setVisible(false);
		
		BookReturniew.setBackground(Color.WHITE);
		BookReturniew.setBounds(220, 133, 989, 645);
		contentPane.add(BookReturniew);
		BookReturniew.setLayout(null);
		
		String[] head = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] date = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		JLabel lblBookID = new JLabel("Book ID");
		lblBookID.setBounds(12, 13, 158, 35);
		BookReturniew.add(lblBookID);

		JTextField textField = new JTextField();
		textField.setBounds(22, 61, 280, 35);
		BookReturniew.add(textField);
		textField.setColumns(10);

		JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 61, 280, 35);
		BookReturniew.add(textField_1);

		JButton btnFilterResults = new JButton("Filter Results ");
		btnFilterResults.setBounds(728, 58, 200, 40);
		BookReturniew.add(btnFilterResults);
		JTable table = new JTable(date, head);
		table.setBounds(12, 109, 965, 523);
		BookReturniew.add(table);
		
		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		contentPane.add(MainMenu);
		
		MainMenu.setLayout(null);
		MainMenu.add(MenuItem.menu("Total book",JDBC.getCount("category"),Icons.Book,new Color(57, 124, 188),new Color(77, 134, 198),31, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Button 1");
			}
		}));
		MainMenu.add(MenuItem.menu("Issue book",JDBC.getCount("category"),Icons.Book,new Color(75, 163, 97),new Color(85, 173, 107),267, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Button 2");
			}
		}));
		MainMenu.add(MenuItem.menu("Book returned",JDBC.getCount("category"),Icons.Book,new Color(231, 159, 62),new Color(241, 169, 72),503, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Button 3");
			}
		}));
		MainMenu.add(MenuItem.menu("Staff",JDBC.getCount("category"),Icons.User,new Color(230, 113, 93),new Color(240, 123, 103),739, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Button 4");
			}
		}));
		
		TotalBookView.setBackground(Color.WHITE);
		TotalBookView.setBounds(220, 133, 989, 645);
		contentPane.add(TotalBookView);
		TotalBookView.setLayout(null);
		
		String[] col = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] row = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		JLabel lblBookid = new JLabel("Book ID");
		lblBookid.setBounds(12, 13, 158, 35);
		TotalBookView.add(lblBookid);

		JLabel lblMemberId = new JLabel("Member ID");
		lblMemberId.setBounds(382, 13, 158, 35);
		TotalBookView.add(lblMemberId);

		textField = new JTextField();
		textField.setBounds(22, 61, 280, 35);
		TotalBookView.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 61, 280, 35);
		TotalBookView.add(textField_1);

		JButton btnFilterResult = new JButton("Filter Results ");
		btnFilterResult.setBounds(728, 58, 200, 40);
		TotalBookView.add(btnFilterResult);
		table = new JTable(row, col);
		table.setBounds(12, 109, 965, 523);
		TotalBookView.add(table);
		
		IssueBookView.setBackground(Color.WHITE);
		IssueBookView.setBounds(220, 133, 989, 645);
		contentPane.add(IssueBookView);
		IssueBookView.setLayout(null);
		
		String[] header = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] data = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		JLabel lblbookID = new JLabel("Book ID");
		lblbookID.setBounds(12, 13, 158, 35);
		IssueBookView.add(lblbookID);

		JLabel lblmemberId = new JLabel("Member ID");
		lblmemberId.setBounds(382, 13, 158, 35);
		IssueBookView.add(lblmemberId);

		textField = new JTextField();
		textField.setBounds(22, 61, 280, 35);
		IssueBookView.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(392, 61, 280, 35);
		IssueBookView.add(textField_1);

		JButton btnFilterresult = new JButton("Filter Results ");
		btnFilterresult.setBounds(728, 58, 200, 40);
		IssueBookView.add(btnFilterresult);
		table = new JTable(data, header);
		table.setBounds(12, 109, 965, 523);
		IssueBookView.add(table);
		
		StaffView.setBackground(Color.WHITE);
		StaffView.setBounds(220, 133, 989, 645);
		contentPane.add(StaffView);
		StaffView.setLayout(null);
		
	}
}
