package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import operate.Adpater;
import picture.GetIcon;
import picture.Icons;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
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
import javax.swing.JPasswordField;

public class AdminHome extends JFrame {

	static Login login = new Login();
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
	JPanel StaffUpdate = new JPanel();

	private JTextField txtEmailEdit;
	private JTextField txtHouseNumbeEdit;
	private JTextField txtCommuneEdit;
	private JTextField txtDistictEdit;

	private JTextField txtEmail;
	private JTextField txtStreet;
	private JTextField txtHouseNumber;
	private JTextField txtCommune;
	private JTextField txtDistict;
	private JTextField txtCity;
	StaffController obj = new StaffController();
	private JTextField txtSearch;

	private JTextField txtFirstN;
	private JTextField txtLastN;
	private JTextField textEmailP;
	private JTextField txtPhone;
	private JTextField txtDob;
	private JTextField txtAddress;
	private JPasswordField txtPass;
	JLabel label = new JLabel("");

	/**
	 * Launch the application.
	 */
	static AdminHome adminHome;
	private JTextField txtPSex;
	private JTextField txtStaffFirstNameEdit;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the frame.
	 * 
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

		// Main panel
		TotalBookView.setVisible(false);
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

				try {
					adminHome = new AdminHome();
					login.setVisible(true);
					adminHome.setVisible(false);
				} catch (SQLException e1) {
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
		Drawer.setLayout(null);
//====================================================

		/**
		 * enable JPanel ProfileView
		 */
//NameUserLogin
		JLabel txtProfileLoninName = new JLabel(Adpater.getInfo().get(2) + " " + Adpater.getInfo().get(3));
		txtProfileLoninName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		txtProfileLoninName.setHorizontalAlignment(SwingConstants.CENTER);
		txtProfileLoninName.setForeground(Color.WHITE);
		txtProfileLoninName.setBounds(0, 143, 185, 41);
		Drawer.add(txtProfileLoninName);
//ProfileIconlogin
		final JLabel ProfileIcon = new JLabel("");
		ProfileIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu.setVisible(false);
				StaffView.setVisible(false);
				ProfileView.setVisible(false);
				IssueBookView.setVisible(false);
				ProfileView.setVisible(true);
			}
		});
		ProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileIcon.setBounds(0, 0, 185, 146);
		if (Adpater.getInfo().get(4).toString().equals("Male")) {
			ProfileIcon.setIcon(GetIcon.setIcon(Icons.MaleUser));
		} else {
			ProfileIcon.setIcon(GetIcon.setIcon(Icons.FemaleUser));
		}
		Drawer.add(ProfileIcon);
		if (Adpater.getInfo().get(4).toString().equals("Male")) {
			label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		} else {
			label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		}

		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);

		separator.setForeground(Color.BLACK);
		separator.setBounds(220, 113, 254, 12);
//===============================================================

		Drawer.add(DrawerItem.drawerItem("Dashboard", 195, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Home");
				MainMenu.setVisible(true);
				HomeItem.setVisible(true);
				TotalBookView.setVisible(false);
				IssueBookView.setVisible(false);
				ReturnBookView.setVisible(false);
				StaffTables.setVisible(false);
				StaffItem.setVisible(false);
				ProfileIcon.setVisible(true);
			}
		}));
//==============================================================	

		HomeItem.setBackground(new Color(0, 0, 51));
		HomeItem.setBounds(0, 246, 185, 492);
		Drawer.add(HomeItem);
		HomeItem.setLayout(null);

		HomeItem.add(DrawerItem.drawerItem("Total book", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Total book");
				HomeItem.setVisible(false);
				ProfileView.setVisible(false);
				MainMenu.setVisible(false);
				TotalBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Issue book", 46, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issue book");
				ProfileView.setVisible(false);
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				IssueBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Book returned", 46 * 2, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Book returned");
				ProfileView.setVisible(false);
				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
				ReturnBookView.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Staff", 46 * 3, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Staff");
				ProfileView.setVisible(false);
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

		StaffItem.add(DrawerItem.drawerItem("Add staff", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Add staff");
				StaffView.setVisible(true);
			}
		}));
		StaffItem.add(DrawerItem.drawerItem("Edit staff", 46, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Edit staff");
				StaffView.setVisible(false);
				StaffTables.setVisible(false);
				StaffUpdate.setVisible(true);
			}
		}));
//		StaffItem.add(DrawerItem.drawerItem("Back", 46 * 3, new ButtonClick() {
//			public void action() {
//				lblNewLabel.setText("Home");
//				HomeItem.setVisible(true);
//				StaffItem.setVisible(false);
//				MainMenu.setVisible(true);
//			}
//		}));

		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);
		contentPane.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(220, 113, 254, 12);
		contentPane.add(separator);

		// popUp ProfileInfo Login
		// =============================================================
		ProfileView.setVisible(false);
		ProfileView.setBounds(220, 133, 989, 645);
		ProfileView.setLayout(null);
		ProfileView.setBackground(Color.WHITE);

		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(179, 51, 183, 145);
		ProfileView.add(label);

		JLabel lblNewLabel_8 = new JLabel("First Name");
		lblNewLabel_8.setBounds(27, 209, 99, 16);
		ProfileView.add(lblNewLabel_8);

		txtFirstN = new JTextField();
		txtFirstN.setBounds(27, 237, 218, 34);
		ProfileView.add(txtFirstN);
		txtFirstN.setColumns(10);
		final String cFirstName = Adpater.getInfo().get(2);
		txtFirstN.setText(cFirstName);

		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(330, 209, 99, 16);
		ProfileView.add(lblLastName_1);

		txtLastN = new JTextField();
		txtLastN.setColumns(10);
		txtLastN.setBounds(330, 237, 218, 34);
		ProfileView.add(txtLastN);
		final String cLastName = Adpater.getInfo().get(3);
		txtLastN.setText(cLastName);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(27, 283, 99, 16);
		ProfileView.add(lblEmail_1);

		textEmailP = new JTextField();
		textEmailP.setColumns(10);
		textEmailP.setBounds(27, 311, 218, 34);
		ProfileView.add(textEmailP);
		final String cEmail = Adpater.getInfo().get(7);
		textEmailP.setText(cEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(630, 463, 99, 16);
		ProfileView.add(lblPassword);

		txtPass = new JPasswordField();
		txtPass.setBounds(630, 491, 218, 34);
		ProfileView.add(txtPass);
		final String cPassword = Login.data.get(3);
		txtPass.setText(cPassword);

		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(330, 283, 99, 16);
		ProfileView.add(lblPhoneNumber_1);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(330, 311, 218, 34);
		ProfileView.add(txtPhone);
		final String cPhone = Adpater.getInfo().get(6);
		txtPhone.setText(cPhone);

		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBounds(27, 386, 218, 34);
		ProfileView.add(txtDob);
		final String cDob = Adpater.getInfo().get(12);
		txtDob.setText(cDob);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(27, 358, 99, 16);
		ProfileView.add(lblDateOfBirth);

		JLabel lblAddress_3 = new JLabel("Address");
		lblAddress_3.setBounds(27, 433, 99, 16);
		ProfileView.add(lblAddress_3);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(27, 461, 521, 64);
		ProfileView.add(txtAddress);
		final String cAddress = Adpater.getInfo().get(13);
		txtAddress.setText(cAddress);

		JLabel lblPSex = new JLabel("Gender");
		lblPSex.setBounds(330, 358, 99, 16);
		ProfileView.add(lblPSex);

		txtPSex = new JTextField();
		txtPSex.setColumns(10);
		txtPSex.setBounds(330, 386, 218, 34);
		final String cSex = Adpater.getInfo().get(4);
		txtPSex.setText(cSex);
		ProfileView.add(txtPSex);

		// ------==---===--

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(630, 236, 99, 34);
		ProfileView.add(lblUsername);

		JLabel lblSetName = new JLabel(Login.data.get(3));
		lblSetName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetName.setBounds(772, 233, 144, 40);
		ProfileView.add(lblSetName);

		JLabel lblSetRole = new JLabel(Adpater.getRole().get(1));
		lblSetRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetRole.setBounds(772, 315, 99, 30);
		ProfileView.add(lblSetRole);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(630, 311, 99, 34);
		ProfileView.add(lblRole);

		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStartDate.setBounds(630, 386, 99, 34);
		ProfileView.add(lblStartDate);

		final String cStartDate = Adpater.getInfo().get(9);
		JLabel lblSetStart = new JLabel(cStartDate);
		lblSetStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetStart.setBounds(772, 386, 99, 34);
		ProfileView.add(lblSetStart);

		final JButton btnEnable = new JButton("Enable");
		contentPane.add(ProfileView);
		// DisableJTextBox
		if (btnEnable.getText().equals("Enable")) {
			txtFirstN.disable();
			txtLastN.disable();
			textEmailP.disable();
			txtPass.disable();
			txtPhone.disable();
			txtAddress.disable();
			txtDob.disable();
			txtPSex.disable();
		}
		btnEnable.addActionListener(new ActionListener() {
			private boolean check = false;
			private boolean change = false;

			public void actionPerformed(ActionEvent e) {
				txtFirstN.enable();
				txtLastN.enable();
				textEmailP.enable();
				txtPass.enable();
				txtPass.show();
				txtPhone.enable();
				txtAddress.enable();
				txtDob.enable();
				txtPSex.enable();

				txtFirstN.setFont(txtFirstN.getFont().deriveFont(Font.BOLD, 14f));
				txtLastN.setFont(txtLastN.getFont().deriveFont(Font.BOLD, 14f));
				textEmailP.setFont(textEmailP.getFont().deriveFont(Font.BOLD, 14f));
				txtPass.setFont(txtPass.getFont().deriveFont(Font.BOLD, 14f));
				txtPhone.setFont(txtPhone.getFont().deriveFont(Font.BOLD, 14f));
				txtAddress.setFont(txtAddress.getFont().deriveFont(Font.BOLD, 14f));
				txtDob.setFont(txtDob.getFont().deriveFont(Font.BOLD, 14f));
				txtPSex.setFont(txtPSex.getFont().deriveFont(Font.BOLD, 14f));

				if (btnEnable.getText().equals("Save")) {
					btnEnable.setText("Enable");

					if (!txtFirstN.getText().equals(cFirstName)) {
						change = true;
						JDBC.updateBy("staff", "first_name", cFirstName, txtFirstN.getText());
					}

					if (!txtLastN.getText().equals(cLastName)) {
						change = true;
						JDBC.updateBy("staff", "last_name", cLastName, txtLastN.getText());
					}

					if (!txtPSex.getText().equals(cSex)) {
						change = true;
						JDBC.updateBy("staff", "sex", cSex, txtPSex.getText());
					}

					if (!textEmailP.getText().equals(cEmail)) {
						change = true;
						JDBC.updateBy("staff", "email", cEmail, textEmailP.getText());
					}

					if (!txtDob.getText().equals(cDob)) {
						change = true;
						JDBC.updateBy("staff", "dob", cDob, txtDob.getText());
					}

					if (!txtAddress.getText().equals(cAddress)) {
						change = true;
						JDBC.updateBy("staff", "address", cAddress, txtAddress.getText());
					}

					if (!txtPass.getText().equals(cPassword)) {
						change = true;
						JDBC.updateBy("secuser", "password", cPassword, txtPass.getText());
					}

					if (change == true) {
						JOptionPane.showMessageDialog(contentPane, "Update Your Profile Success", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}
					check = true;
				} else {
					check = false;
				}

				if (check == true) {
					txtFirstN.disable();
					txtLastN.disable();
					textEmailP.disable();
					txtPass.disable();
					txtPhone.disable();
					txtAddress.disable();
					txtDob.disable();
					txtPSex.disable();
					btnEnable.setText("Enable");
				} else {
					btnEnable.setText("Save");
				}
			}
		});

		btnEnable.setText("Enable");
		btnEnable.setBounds(451, 561, 97, 34);
		ProfileView.add(btnEnable);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBack.setBounds(330, 561, 97, 34);
		ProfileView.add(btnBack);

		ProfileView.setVisible(false);
//--------------------------------------------------END
		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		contentPane.add(MainMenu);

		MainMenu.setLayout(null);
		MainMenu.add(MenuItem.menu("Total book", JDBC.getCount("category"), Icons.Book, new Color(57, 124, 188),
				new Color(77, 134, 198), 31, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Total book");
						MainMenu.setVisible(false);
						TotalBookView.setVisible(true);
						StaffView.setVisible(false);
						IssueBookView.setVisible(false);
					}
				}));
		MainMenu.add(MenuItem.menu("Issue book", JDBC.getCount("category"), Icons.Book, new Color(75, 163, 97),
				new Color(85, 173, 107), 267, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Issue book");
						MainMenu.setVisible(false);
						TotalBookView.setVisible(false);
						StaffView.setVisible(false);
						IssueBookView.setVisible(true);
					}
				}));
		MainMenu.add(MenuItem.menu("Book returned", JDBC.getCount("category"), Icons.Book, new Color(231, 159, 62),
				new Color(241, 169, 72), 503, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Book returned");
						MainMenu.setVisible(false);
						TotalBookView.setVisible(false);
						StaffView.setVisible(false);
						IssueBookView.setVisible(false);
					}
				}));
		MainMenu.add(MenuItem.menu("Staff", JDBC.getCount("category"), Icons.User, new Color(230, 113, 93),
				new Color(240, 123, 103), 739, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Staff");
						HomeItem.setVisible(false);
						MainMenu.setVisible(false);
						TotalBookView.setVisible(false);
						StaffView.setVisible(true);
						IssueBookView.setVisible(false);
						StaffItem.setVisible(true);
						;
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

//Edit Staff===================================================

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
					ArrayList<ArrayList<String>> res = JDBC.readBy("Book", "title", txtSearch.getText());
					for (int i = 0; i < res.size(); i++) {
						ReuseTable.model.setRowCount(0);
						ReuseTable.model.addRow(new Object[] { res.get(i).get(0), res.get(i).get(1), res.get(i).get(2),
								res.get(i).get(3), res.get(i).get(4), res.get(i).get(5), res.get(i).get(6) });
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
		MainMenu.add(MenuItem.menu("Total book", JDBC.getCount("category"), Icons.Book, new Color(57, 124, 188),
				new Color(77, 134, 198), 31, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Total book");
						MainMenu.setVisible(false);
					}
				}));
		MainMenu.add(MenuItem.menu("Issue book", JDBC.getCount("category"), Icons.Book, new Color(75, 163, 97),
				new Color(85, 173, 107), 267, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Issue book");
					}
				}));
		MainMenu.add(MenuItem.menu("Book returned", JDBC.getCount("category"), Icons.Book, new Color(231, 159, 62),
				new Color(241, 169, 72), 503, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Book returned");
					}
				}));
		MainMenu.add(MenuItem.menu("Staff", JDBC.getCount("category"), Icons.User, new Color(230, 113, 93),
				new Color(240, 123, 103), 739, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Staff");
					}
				}));
		// ====================================================
		contentPane.add(MainMenu);
		contentPane.add(lblNewLabel);
		contentPane.add(separator);
		contentPane.add(Header.header());
		contentPane.add(Drawer);
		contentPane.add(IssueBookView);
		contentPane.add(ReturnBookView);
		contentPane.add(IssueBookView);
		StaffView.setVisible(false);

		// ==========================================================
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

		final JComboBox cmbSex = new JComboBox();
		cmbSex.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		cmbSex.setBounds(43, 136, 120, 34);
		StaffView.add(cmbSex);

		JLabel lblNewLabel_3 = new JLabel("Month");
		lblNewLabel_3.setBounds(201, 108, 61, 16);
		StaffView.add(lblNewLabel_3);

		final JComboBox txtMonth = new JComboBox();
		txtMonth.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December" }));
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
				if (event >= '0' && event <= '9') {
					if (lenght < 2) {
						txtDay.setEditable(true);
					} else {
						txtDay.setEditable(false);
					}
				} else {
					if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						txtDay.setEditable(true);
					} else {
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
				if (event >= '0' && event <= '9') {
					if (lenght < 4) {
						txtYear.setEditable(true);
					} else {
						txtYear.setEditable(false);
					}
				} else {
					if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						txtYear.setEditable(true);
					} else {
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
				if (event >= '0' && event <= '9') {
					if (lenght < 10) {
						txtPhoneNumber.setEditable(true);
					} else {
						txtPhoneNumber.setEditable(false);
					}
				} else {
					if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						txtPhoneNumber.setEditable(true);
					} else {
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

		final JComboBox cmbRole = new JComboBox();
		cmbRole.setBounds(603, 211, 120, 34);
		cmbRole.setModel(new DefaultComboBoxModel(new String[] { "admin", "staff" }));
		StaffView.add(cmbRole);

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
				if (event >= '0' && event <= '9') {
					if (lenght < 10) {
						txtHouseNumber.setEditable(true);
					} else {
						txtHouseNumber.setEditable(false);
					}
				} else {
					if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE
							|| evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
						txtHouseNumber.setEditable(true);
					} else {
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
				String address = txtStreet.getText() + ',' + txtHouseNumber.getText() + ',' + txtCommune.getText() + ','
						+ txtDistict.getText() + ',' + txtCity.getText();
				String dob = txtMonth.getSelectedItem().toString() + ',' + txtDay.getText() + ',' + txtYear.getText();
				String sex = cmbSex.getSelectedItem().toString();
				String startAt = JDBC.getDate();
				int roleId = cmbRole.getSelectedIndex();

				StaffController staff = new StaffController();
				staff.create(txtFristname.getText(), txtLastname.getText(), sex, txtPhoneNumber.getText(),
						txtEmail.getText(), "Na01", startAt, address, roleId, dob);
				JOptionPane.showMessageDialog(contentPane, "Create Profile Success", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				txtFristname.setText("");
				txtLastname.setText("");
				txtDay.setText("");
				cmbRole.setSelectedIndex(1);
				txtMonth.setSelectedIndex(0);
				txtYear.setText("");
				txtPhoneNumber.setText("");
				txtDob.setText("");
				txtEmail.setText("");
				txtHouseNumber.setText("");
				txtStreet.setText("");
				txtCity.setText("");
				txtCommune.setText("");
				txtDistict.setText("");
				txtCity.setText("");

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
		lblCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtFristname.setText("");
				txtLastname.setText("");
				txtDay.setText("");
				cmbRole.setSelectedIndex(1);
				txtMonth.setSelectedIndex(0);
				txtYear.setText("");
				txtPhoneNumber.setText("");
				txtDob.setText("");
				txtEmail.setText("");
				txtHouseNumber.setText("");
				txtStreet.setText("");
				txtCity.setText("");
				txtCommune.setText("");
				txtDistict.setText("");
				txtCity.setText("");
			}
		});
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setBounds(0, 0, 130, 39);
		panel_3.add(lblCancel);
		contentPane.add(StaffView);
		StaffView.setVisible(false);

		StaffUpdate.setBackground(Color.WHITE);
		StaffUpdate.setBounds(220, 133, 989, 645);
		contentPane.add(StaffUpdate);
		StaffUpdate.setLayout(null);

		txtStaffFirstNameEdit = new JTextField();
		txtStaffFirstNameEdit.setBounds(43, 62, 288, 34);
		StaffUpdate.add(txtStaffFirstNameEdit);
		txtStaffFirstNameEdit.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(353, 131, 168, 34);
		StaffUpdate.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(423, 62, 288, 34);
		StaffUpdate.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(543, 131, 168, 34);
		StaffUpdate.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(43, 203, 247, 34);
		StaffUpdate.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(333, 203, 229, 34);
		StaffUpdate.add(textField_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(43, 136, 129, 27);
		StaffUpdate.add(comboBox);

		JLabel lblFirstName_1 = new JLabel("First name");
		lblFirstName_1.setBounds(43, 34, 108, 16);
		StaffUpdate.add(lblFirstName_1);

		JLabel lblLastName_2 = new JLabel("Last name");
		lblLastName_2.setBounds(423, 34, 108, 16);
		StaffUpdate.add(lblLastName_2);

		JLabel lblSex_1 = new JLabel("Sex");
		lblSex_1.setBounds(43, 108, 108, 16);
		StaffUpdate.add(lblSex_1);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(202, 136, 129, 27);
		StaffUpdate.add(comboBox_1);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(202, 108, 108, 16);
		StaffUpdate.add(lblMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(353, 108, 108, 16);
		StaffUpdate.add(lblDay);

		JLabel lblYear_1 = new JLabel("Year");
		lblYear_1.setBounds(543, 108, 108, 16);
		StaffUpdate.add(lblYear_1);

		JLabel lblEmail_2 = new JLabel("Email");
		lblEmail_2.setBounds(43, 175, 108, 16);
		StaffUpdate.add(lblEmail_2);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(582, 208, 129, 27);
		StaffUpdate.add(comboBox_2);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(43, 253, 101, 16);
		StaffUpdate.add(lblStreet);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(43, 281, 108, 34);
		StaffUpdate.add(textField);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(163, 281, 101, 34);
		StaffUpdate.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(276, 281, 129, 34);
		StaffUpdate.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(433, 281, 129, 34);
		StaffUpdate.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(582, 281, 129, 34);
		StaffUpdate.add(textField_9);

		JLabel lblHouseNumber = new JLabel("House number");
		lblHouseNumber.setBounds(163, 253, 101, 16);
		StaffUpdate.add(lblHouseNumber);

		JLabel lblCommune = new JLabel("Commune");
		lblCommune.setBounds(276, 253, 101, 16);
		StaffUpdate.add(lblCommune);

		JLabel lblDistrict = new JLabel("District");
		lblDistrict.setBounds(433, 253, 101, 16);
		StaffUpdate.add(lblDistrict);

		JLabel lblCity_2 = new JLabel("City");
		lblCity_2.setBounds(582, 253, 101, 16);
		StaffUpdate.add(lblCity_2);

		JLabel lblPhoneNumber_2 = new JLabel("Phone number");
		lblPhoneNumber_2.setBounds(333, 175, 101, 16);
		StaffUpdate.add(lblPhoneNumber_2);

		JLabel lblRole_1 = new JLabel("Role");
		lblRole_1.setBounds(582, 177, 101, 16);
		StaffUpdate.add(lblRole_1);

		JLabel lblNewLabel_2 = new JLabel("Your birthday");
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setBounds(723, 140, 134, 16);
		StaffUpdate.add(lblNewLabel_2);

		JLabel lblYourAddress = new JLabel("Your Address");
		lblYourAddress.setBackground(Color.LIGHT_GRAY);
		lblYourAddress.setBounds(723, 290, 134, 16);
		StaffUpdate.add(lblYourAddress);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(193, 378, 129, 41);
		StaffUpdate.add(btnUpdate);

		JButton btnCreate = new JButton("Cancel");
		btnCreate.setBounds(392, 378, 129, 41);
		StaffUpdate.add(btnCreate);
		StaffUpdate.setVisible(false);
		contentPane.add(StaffTables);

//		StaffUpdate.setBackground(Color.WHITE);
//		StaffUpdate.setBounds(220, 133, 989, 645);
//		contentPane.add(StaffUpdate);
//		StaffUpdate.setLayout(null);

		// ====================================================
		MainMenu.setVisible(true);
		IssueBookView.setVisible(false);

	}
}
