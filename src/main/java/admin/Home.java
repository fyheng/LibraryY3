package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.function.ButtonClick;
import admin.uiTool.DrawerItem;
import admin.uiTool.MenuItem;
import Domain.RoleDomain;
import configDB.JDBC;
import picture.GetIcon;
import picture.Icons;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
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
		BookReturniew.setVisible(false);
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
		
		
//		StaffInput.setBackground(Color.WHITE);
//		StaffInput.setBounds(220, 133, 989, 645);
//		contentPane.add(StaffInput);
//		StaffInput.setLayout(null);
//		
//		txtFristname = new JTextField();
//		txtFristname.setBounds(43, 62, 288, 34);
//		StaffInput.add(txtFristname);
//		txtFristname.setColumns(10);
//		
//		JLabel lblNewLabel_1 = new JLabel("Frist name");
//		lblNewLabel_1.setBounds(43, 34, 97, 16);
//		StaffInput.add(lblNewLabel_1);
//		
//		JLabel lblLastName = new JLabel("Last name");
//		lblLastName.setBounds(438, 34, 97, 16);
//		StaffInput.add(lblLastName);
//		
//		txtLastname = new JTextField();
//		txtLastname.setColumns(10);
//		txtLastname.setBounds(436, 62, 288, 34);
//		StaffInput.add(txtLastname);
//		
//		JLabel lblSex = new JLabel("Sex");
//		lblSex.setBounds(43, 108, 97, 16);
//		StaffInput.add(lblSex);
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
//		comboBox.setBounds(43, 136, 120, 34);
//		StaffInput.add(comboBox);
//		
//		JLabel lblNewLabel_3 = new JLabel("Month");
//		lblNewLabel_3.setBounds(43, 182, 61, 16);
//		StaffInput.add(lblNewLabel_3);
//		
//		final JComboBox txtMonth = new JComboBox();
//		txtMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
//		txtMonth.setBounds(43, 210, 204, 34);
//		StaffInput.add(txtMonth);
//		
//		JLabel lblNewLabel_4 = new JLabel("Day");
//		lblNewLabel_4.setBounds(307, 182, 61, 16);
//		StaffInput.add(lblNewLabel_4);
//		
//		JLabel lblYear = new JLabel("Year");
//		lblYear.setBounds(549, 182, 61, 16);
//		StaffInput.add(lblYear);
//		
//		txtDay = new JTextField();
//		txtDay.setBounds(307, 209, 175, 34);
//		StaffInput.add(txtDay);
//		txtDay.setColumns(10);
//		
//		txtYear = new JTextField();
//		txtYear.setBounds(549, 209, 175, 34);
//		StaffInput.add(txtYear);
//		txtYear.setColumns(10);
//		
//		txtPhoneNumber = new JTextField();
//		txtPhoneNumber.setColumns(10);
//		txtPhoneNumber.setBounds(436, 135, 288, 34);
//		StaffInput.add(txtPhoneNumber);
//		
//		JLabel lblPhoneNumber = new JLabel("Phone number");
//		lblPhoneNumber.setBounds(438, 108, 109, 16);
//		StaffInput.add(lblPhoneNumber);
//		
//		JLabel lblNewLabel_5 = new JLabel("Role");
//		lblNewLabel_5.setBounds(211, 108, 61, 16);
//		StaffInput.add(lblNewLabel_5);
//		
//		//=====================get data role ============================
//		ArrayList<String> obj = new ArrayList<String>();
//		Role role = new Role();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/libraryproject","root","password");	   
//			Statement st = con.createStatement(); 	
//		    String sql = "Select * from role";
//		    ResultSet rs = st.executeQuery(sql);
//		   while(rs.next()) {
//			   role.setName(rs.getString("name"));
//			   String data = role.getName();
//			   obj.add(data);	        
//		   }
//  		 }catch (Exception e) {
//			System.out.println(e);
//		}
//		//==============================================================
//		 JComboBox comboBox_2 = new JComboBox(obj.toArray());
//		   StaffInput.add(comboBox_2);
//		   comboBox_2.setBounds(211, 136, 120, 34);
//		
//		JLabel lblAddress = new JLabel("Your birthday");
//		lblAddress.setForeground(Color.LIGHT_GRAY);
//		lblAddress.setBounds(736, 218, 102, 16);
//		StaffInput.add(lblAddress);
//		
//		JLabel lblAddress_1 = new JLabel("Address");
//		lblAddress_1.setBounds(43, 259, 97, 16);
//		StaffInput.add(lblAddress_1);
//		
//		final JTextArea txtAddress = new JTextArea();
//		txtAddress.setBackground(new Color(204, 204, 204));
//		txtAddress.setBounds(43, 287, 432, 147);
//		StaffInput.add(txtAddress);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(211, 525, 117, 34);
//		StaffInput.add(panel_1);
//		panel_1.setLayout(null);
//		
//		JLabel lblNewLabel_6 = new JLabel("Create");
//		lblNewLabel_6.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.out.print(txtMonth.getSelectedItem().toString());
//				
//			}
//		});
//		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_6.setBounds(0, 0, 117, 34);
//		panel_1.add(lblNewLabel_6);
//		
//		JPanel panel_2 = new JPanel();
//		panel_2.setBounds(498, 525, 117, 34);
//		StaffInput.add(panel_2);
		
		
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
		
		IssueBookView.setBackground(Color.WHITE);
		IssueBookView.setBounds(220, 133, 989, 645);
		contentPane.add(IssueBookView);
		IssueBookView.setLayout(null);
		
		BookReturniew.setBackground(Color.WHITE);
		BookReturniew.setBounds(220, 133, 989, 645);
		contentPane.add(BookReturniew);
		BookReturniew.setLayout(null);
		
		
		StaffView.setBackground(Color.WHITE);
		StaffView.setBounds(220, 133, 989, 645);
		contentPane.add(StaffView);
		StaffView.setLayout(null);
		
	}
}
