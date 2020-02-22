package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.StaffController;
import admin.function.ButtonClick;
import admin.table.IssueBook;
import admin.table.ReturnBook;
import admin.table.ReuseTable;
import admin.table.StaffTable;
import admin.uiTool.DrawerItem;
import admin.uiTool.Header;
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
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminHome extends JFrame {

	private JPanel contentPane;
	GetIcon icon;
	JLabel lblNewLabel = new JLabel("Home");
	JSeparator separator = new JSeparator();

	final JPanel HomeItem = new JPanel();
	final JPanel StaffItem = new JPanel();
	
	JPanel Drawer = new JPanel();
	JPanel MainMenu = new JPanel();
	JPanel TotalBookView = new JPanel();
	JPanel StaffView = new JPanel();
	JPanel ProfileView = new JPanel();
	JPanel IssueBookView = new JPanel();
	JPanel ReturnBookView = new JPanel();
	JPanel StaffTables = new JPanel();
	
	private JTextField txtEmail;
	private JTextField txtStreet;
	private JTextField txtHouseNumber;
	private JTextField txtCommune;
	private JTextField txtDistict;
	private JTextField txtCity;
	StaffController obj = new StaffController();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField txtSearch;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
//Drawer==============================================
		Drawer.setBackground(new Color(0, 0, 51));
		Drawer.setBounds(0, 72, 185, 738);
		Drawer.setLayout(null);
//====================================================
		JLabel ProfileIcon = new JLabel("");
		ProfileIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu.setVisible(false);
				StaffView.setVisible(false);
				ProfileView.setVisible(false);
				ProfileView.setVisible(true);
			}
		});
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
				HomeItem.setVisible(true);
				TotalBookView.setVisible(false);
				IssueBookView.setVisible(false);
				ReturnBookView.setVisible(false);
				StaffTables.setVisible(false);
				StaffItem.setVisible(false);
			}
		}));
//==============================================================	
		HomeItem.setBackground(new Color(0, 0, 51));
		HomeItem.setBounds(0, 246, 185, 492);
		Drawer.add(HomeItem);
		HomeItem.setLayout(null);
		
		HomeItem.add(DrawerItem.drawerItem("Total book",0,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Total book");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Issue book",46,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issue book");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				IssueBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Book returned",46*2,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Book returned");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				ReturnBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Staff",46*3,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Staff");
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				StaffTables.setVisible(true);
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
				lblNewLabel.setText("Add staff");
				StaffView.setVisible(true);
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
		ProfileView.setVisible(false);
		
		ProfileView.setBounds(220, 133, 989, 645);
		ProfileView.setLayout(null);
		ProfileView.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(214, 22, 185, 146);
		label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		ProfileView.add(label);
		
		JLabel lblNewLabel_8 = new JLabel("First Name");
		lblNewLabel_8.setBounds(55, 206, 99, 16);
		ProfileView.add(lblNewLabel_8);
		
		textField_2 = new JTextField();
		textField_2.setBounds(55, 234, 218, 34);
		ProfileView.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(358, 206, 99, 16);
		ProfileView.add(lblLastName_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(358, 234, 218, 34);
		ProfileView.add(textField_3);
		
		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(55, 280, 99, 16);
		ProfileView.add(lblEmail_1);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(358, 280, 99, 16);
		ProfileView.add(lblPhoneNumber_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(55, 308, 218, 34);
		ProfileView.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(358, 308, 218, 34);
		ProfileView.add(textField_5);
		
		JLabel lblOldPassword = new JLabel("Old password");
		lblOldPassword.setBounds(55, 354, 99, 16);
		ProfileView.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(358, 354, 99, 16);
		ProfileView.add(lblNewPassword);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(55, 382, 218, 34);
		ProfileView.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(358, 382, 218, 34);
		ProfileView.add(textField_7);
		
		
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);
		
		
		separator.setForeground(Color.BLACK);
		separator.setBounds(220, 113, 254, 12);
		
			
		StaffView.setVisible(false);
		
		StaffView.setBackground(Color.WHITE);
		StaffView.setBounds(220, 133, 989, 645);
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
				//obj.create(txtFristname.getText(), txtLastname.getText(), txtFristname.getText()+' '+txtLastname.getText(), (String) comboBox.getSelectedItem(), address, dob, txtPhoneNumber.getText(), txtPhoneNumber.getText(), txtPhoneNumber.getText());
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
				
				
				
//TotalBookView================================================
				TotalBookView.setBackground(Color.WHITE);
				TotalBookView.setBounds(220, 133, 989, 645);
				TotalBookView.setLayout(null);
				TotalBookView.add(ReuseTable.TotalBook());
				contentPane.add(TotalBookView);
				
				txtSearch = new JTextField();
				txtSearch.setBounds(625, 55, 208, 36);
				TotalBookView.add(txtSearch);
				txtSearch.setColumns(10);
				
				JButton search = new JButton("search");
				search.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ArrayList<ArrayList<String>> res = JDBC.readBy("Book","title",txtSearch.getText());
							for(int i=0;i<res.size();i++) {
								ReuseTable.model.setRowCount(0);
								ReuseTable.model.addRow(new Object[] {res.get(i).get(0),res.get(i).get(1),res.get(i).get(2),res.get(i).get(3),res.get(i).get(4),res.get(i).get(5),res.get(i).get(6)});
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				});
				search.setBounds(846, 60, 117, 29);
				TotalBookView.add(search);
				TotalBookView.setVisible(false);
//IssueBookview=========================================================
				IssueBookView.setBackground(Color.WHITE);
				IssueBookView.setBounds(220, 133, 989, 645);
				IssueBookView.setLayout(null);
				IssueBookView.add(IssueBook.issuetable());
				IssueBookView.setVisible(false);
//IssueBookview=========================================================			
				ReturnBookView.setBackground(Color.WHITE);
				ReturnBookView.setBounds(220, 133, 989, 645);
				ReturnBookView.setLayout(null);
				ReturnBookView.add(ReturnBook.TotalBook());
				ReturnBookView.setVisible(false);
//IssueBookview=========================================================			
				StaffTables.setBackground(Color.WHITE);
				StaffTables.setBounds(220, 133, 989, 645);
				StaffTables.setLayout(null);
				StaffTables.add(StaffTable.staffTables());
				StaffTables.setVisible(false);
//MainMenul=============================================================
				
		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		MainMenu.setLayout(null);
		MainMenu.add(MenuItem.menu("Total book",JDBC.getCount("category"),Icons.Book,new Color(57, 124, 188),new Color(77, 134, 198),31, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Total book");
				MainMenu.setVisible(false);
			}
		}));
		MainMenu.add(MenuItem.menu("Issue book",JDBC.getCount("category"),Icons.Book,new Color(75, 163, 97),new Color(85, 173, 107),267, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issue book");
			}
		}));
		MainMenu.add(MenuItem.menu("Book returned",JDBC.getCount("category"),Icons.Book,new Color(231, 159, 62),new Color(241, 169, 72),503, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Book returned");
			}
		}));
		MainMenu.add(MenuItem.menu("Staff",JDBC.getCount("category"),Icons.User,new Color(230, 113, 93),new Color(240, 123, 103),739, 21,new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Staff");
			}
		}));
		//====================================================
				contentPane.add(MainMenu);
				contentPane.add(ProfileView);
				contentPane.add(lblNewLabel);
				contentPane.add(separator);
				contentPane.add(StaffView);
				contentPane.add(Header.header());
				contentPane.add(Drawer);
				contentPane.add(IssueBookView);
				contentPane.add(ReturnBookView);
				contentPane.add(IssueBookView);
				contentPane.add(StaffTables);
		//====================================================
				MainMenu.setVisible(true);
				StaffView.setVisible(false);
				ProfileView.setVisible(false);
				IssueBookView.setVisible(false);
	}
}
