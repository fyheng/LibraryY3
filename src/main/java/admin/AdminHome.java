package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.StaffController;
import admin.function.ButtonClick;
import admin.uiTool.DrawerItem;
import admin.uiTool.MenuItem;
import configDB.JDBC;
import login.Login;
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

public class AdminHome extends JFrame {

	
	static Login login = new Login();
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
	private JTextField txtEmail;
	private JTextField txtStreet;
	private JTextField txtHouseNumber;
	private JTextField txtCommune;
	private JTextField txtDistict;
	private JTextField txtCity;
	StaffController obj = new StaffController();
	static AdminHome frame = new AdminHome();
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public AdminHome() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Main panel
		TotalBookView.setVisible(false);
		BookReturniew.setVisible(false);
		StaffView.setVisible(false);
		IssueBookView.setVisible(false);
		StaffItem.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1240, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(1169, 10, 50, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminHome frame;
				try {
					frame = new AdminHome();
					System.exit(0);
					login.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
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
				TotalBookView.setVisible(false);
				StaffView.setVisible(false);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(false);
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
				MainMenu.setVisible(true);
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
				lblNewLabel.setText("Total book");
				MainMenu.setVisible(false);
				TotalBookView.setVisible(true);
				StaffView.setVisible(false);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(false);
			}
		}));
		MainMenu.add(MenuItem.menu("Issue book",JDBC.getCount("category"),Icons.Book,new Color(75, 163, 97),new Color(85, 173, 107),267, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issue book");
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(false);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(true);
			}
		}));
		MainMenu.add(MenuItem.menu("Book returned",JDBC.getCount("category"),Icons.Book,new Color(231, 159, 62),new Color(241, 169, 72),503, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Book returned");
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(false);
				BookReturniew.setVisible(true);
				IssueBookView.setVisible(false);
			}
		}));
		MainMenu.add(MenuItem.menu("Staff",JDBC.getCount("category"),Icons.User,new Color(230, 113, 93),new Color(240, 123, 103),739, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Staff");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(false);
				StaffView.setVisible(true);
				BookReturniew.setVisible(false);
				IssueBookView.setVisible(false);
				StaffItem.setVisible(true);;
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
		
<<<<<<< refs/remotes/origin/master:src/main/java/admin/Home.java
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
=======
		BookReturniew.setBackground(Color.WHITE);
		BookReturniew.setBounds(220, 133, 989, 645);
		contentPane.add(BookReturniew);
		BookReturniew.setLayout(null);
		StaffView.setVisible(false);
>>>>>>> Auto stash before rebase of "origin/master":src/main/java/admin/AdminHome.java
		
		StaffView.setBackground(Color.WHITE);
		StaffView.setBounds(220, 133, 989, 645);
		contentPane.add(StaffView);
		StaffView.setLayout(null);
		final JTextField txtFristname = new JTextField();
		txtFristname.setBounds(43, 62, 288, 34);
		StaffView.add(txtFristname);
		txtFristname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(438, 34, 97, 16);
		StaffView.add(lblLastName);
		
		final JTextField txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(436, 62, 288, 34);
		StaffView.add(txtLastname);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(43, 108, 97, 16);
		StaffView.add(lblSex);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(43, 136, 120, 34);
		StaffView.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Month");
		lblNewLabel_3.setBounds(201, 108, 61, 16);
		StaffView.add(lblNewLabel_3);
		
		final JComboBox txtMonth = new JComboBox();
		txtMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		txtMonth.setBounds(201, 136, 120, 34);
		StaffView.add(txtMonth);
		
		JLabel lblNewLabel_4 = new JLabel("Day");
		lblNewLabel_4.setBounds(343, 108, 61, 16);
		StaffView.add(lblNewLabel_4);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(549, 108, 61, 16);
		StaffView.add(lblYear);
		
		
		final JTextField txtDay = new JTextField();
		txtDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String day = txtDay.getText();
				int lenght = day.length();
				char event = evt.getKeyChar();
				if(event>='0'&&event<='9') {
					if(lenght<2) {
						txtDay.setEditable(true);
					}else {
						txtDay.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtDay.setEditable(true);
					}else {
						txtDay.setEditable(false);
					}
				}
			}
		});
		txtDay.setBounds(343, 135, 175, 34);
		StaffView.add(txtDay);
		txtDay.setColumns(10);
		
		
		final JTextField txtYear = new JTextField();
		txtYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String year = txtYear.getText();
				int lenght = year.length();
				char event = evt.getKeyChar();
				if(event>='0'&&event<='9') {
					if(lenght<4) {
						txtYear.setEditable(true);
					}else {
						txtYear.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtYear.setEditable(true);
					}else {
						txtYear.setEditable(false);
					}
				}
			}
		});
		txtYear.setBounds(549, 135, 175, 34);
		StaffView.add(txtYear);
		txtYear.setColumns(10);
		
		final JTextField txtPhoneNumber = new JTextField();
		txtPhoneNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String year = txtPhoneNumber.getText();
				int lenght = year.length();
				char event = evt.getKeyChar();
				if(event>='0'&&event<='9') {
					if(lenght<10) {
						txtPhoneNumber.setEditable(true);
					}else {
						txtPhoneNumber.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtPhoneNumber.setEditable(true);
					}else {
						txtPhoneNumber.setEditable(false);
					}
				}
			}
		});
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(331, 210, 260, 34);
		StaffView.add(txtPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(331, 181, 109, 16);
		StaffView.add(lblPhoneNumber);
		
		JLabel lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setBounds(603, 181, 61, 16);
		StaffView.add(lblNewLabel_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(603, 211, 120, 34);
		StaffView.add(comboBox_2);
		
		JLabel lblAddress = new JLabel("Your birthday");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setBounds(736, 144, 102, 16);
		StaffView.add(lblAddress);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(43, 34, 97, 16);
		StaffView.add(lblFirstName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(43, 182, 97, 16);
		StaffView.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(43, 210, 260, 34);
		StaffView.add(txtEmail);
		
		JLabel lblAddress_1 = new JLabel("Street");
		lblAddress_1.setBounds(43, 255, 97, 16);
		StaffView.add(lblAddress_1);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(43, 283, 91, 34);
		StaffView.add(txtStreet);
		
		JLabel lblCity = new JLabel("House number");
		lblCity.setBounds(146, 256, 97, 16);
		StaffView.add(lblCity);
		
		txtHouseNumber = new JTextField();
		txtHouseNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String year = txtHouseNumber.getText();
				int lenght = year.length();
				char event = evt.getKeyChar();
				if(event>='0'&&event<='9') {
					if(lenght<10) {
						txtHouseNumber.setEditable(true);
					}else {
						txtHouseNumber.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtHouseNumber.setEditable(true);
					}else {
						txtHouseNumber.setEditable(false);
					}
				}
			}
		});
		txtHouseNumber.setColumns(10);
		txtHouseNumber.setBounds(146, 283, 120, 34);
		StaffView.add(txtHouseNumber);
		
		JLabel lblSongkat = new JLabel("Commune");
		lblSongkat.setBounds(278, 256, 97, 16);
		StaffView.add(lblSongkat);
		
		txtCommune = new JTextField();
		txtCommune.setColumns(10);
		txtCommune.setBounds(278, 283, 144, 34);
		StaffView.add(txtCommune);
		
		JLabel lblKhan = new JLabel("District");
		lblKhan.setBounds(438, 255, 97, 16);
		StaffView.add(lblKhan);
		
		txtDistict = new JTextField();
		txtDistict.setColumns(10);
		txtDistict.setBounds(434, 283, 144, 34);
		StaffView.add(txtDistict);
		
		JLabel lblCity_1 = new JLabel("City");
		lblCity_1.setBounds(594, 256, 97, 16);
		StaffView.add(lblCity_1);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(590, 283, 134, 34);
		StaffView.add(txtCity);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(193, 380, 130, 39);
		StaffView.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Create");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String address = txtStreet.getText()+','+txtHouseNumber.getText()+','+txtCommune.getText()+','+txtDistict.getText()+','+txtCity.getText();
				String dob = txtMonth.getSelectedItem().toString() +','+txtDay.getText()+','+txtYear.getText();
				/*
				 
				*/
				obj.create(txtFristname.getText(), txtLastname.getText(), txtFristname.getText()+' '+txtLastname.getText(), (String) comboBox.getSelectedItem(), address, dob, txtPhoneNumber.getText(), txtPhoneNumber.getText(), txtPhoneNumber.getText());
				System.out.println(address+dob);
			}
		});
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 130, 39);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblAddress_2 = new JLabel("Address");
		lblAddress_2.setForeground(Color.LIGHT_GRAY);
		lblAddress_2.setBounds(736, 292, 102, 16);
		StaffView.add(lblAddress_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(393, 380, 130, 39);
		StaffView.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setBounds(0, 0, 130, 39);
		panel_3.add(lblCancel);
		
	}
}
