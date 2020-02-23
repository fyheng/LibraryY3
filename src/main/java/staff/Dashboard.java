package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controller.BookController;
import Controller.CategoryController;
import admin.function.ButtonClick;
import admin.table.AddIssueTable;
import admin.table.IssueBook;
import admin.table.ReturnBook;
import admin.table.ReuseTable;
import admin.uiTool.DrawerItem;
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
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	GetIcon icon;
	JLabel lblNewLabel = new JLabel("Home");
	final JPanel HomeItem = new JPanel();
	final JPanel MemberItem = new JPanel();
	final JPanel BookItem = new JPanel();
	final JPanel IssuebookItem = new JPanel();
	final JPanel ReturnedbookItem = new JPanel();
	JPanel MainMenu = new JPanel();
	JPanel BookInput = new JPanel();
	JPanel BookTable = new JPanel();
	JPanel MemberInput = new JPanel();
	JPanel MemberTable = new JPanel();
	JPanel IssuesedBook = new JPanel();
	JPanel AddIssuesedBook = new JPanel();

	JPanel ReturnedBook = new JPanel();
	JPanel AddReturnBook = new JPanel();
	JPanel ReturnBook2 = new JPanel();
	JPanel AboutUs = new JPanel();
	JPanel ProfileView = new JPanel();
	JPanel AddBookCategory = new JPanel();
	JPanel ImportBook = new JPanel();

	final JLabel setMemberName = new JLabel("");
	final JLabel setBookTitle = new JLabel("");
	final JLabel setIssueDate = new JLabel("");
	final JLabel setReturnDate = new JLabel("");
	final JLabel setReturnDate_1 = new JLabel("");
	final JLabel lblNewLabel_9 = new JLabel("Member name");
	final JComboBox<String> txtCategoryBook = new JComboBox<String>();

	private JTextField txtFristname;
	private JTextField txtBookTitleBook;
	private JTextField txtLastname;
	private JTextField txtDay;
	private JTextField txtYear;
	private JTextField txtPhoneNumber;
	private JTextField txtLanguageBook;
	private JTextField txtAuthorBook;
	private JTextField txtYearBook;
	private JTextField txtMonthBook;
	private JTextField txtDayBook;
	private JTextField txtMember;
	private JTextField txtBookTitle;
	private JTextField txtIssueDay;
	private JTextField txtIssueMonth;
	private JTextField txtIssueYear;
	private JTextField txtQty;
	private JTextField txtDueDay;
	private JTextField txtDueMonth;
	private JTextField txtDueYear;
	private JTextField txtPrice;
	private JTextField txtFirstN;
	private JTextField txtLastN;
	private JTextField textEmailP;
	private JTextField txtPhone;
	private JTextField txtDob;
	private JTextField txtPAddress;
	private JPasswordField txtPass;
	int on = 1;
	private JTextField getMemberName;
	private JTextField txtCategoryTitle;
	private JTextField txtEditionBook;
	private JTextField txtBookCodeBook;
	JLabel label = new JLabel("");
	private JTextField txtNationalID;
	private JTextField txtEmailMember;
	private JTextField txtBookCodeImport;
	private JTextField txtBookTitleImport;
	private JTextField txtBookPriceImport;
	private JTextField txtBookQtyImport;
	private JTextField txtYearImport;
	private JTextField txtMonthImport;
	private JTextField txtDayImport;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 850);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1240, 72);
		contentPane.add(panel);

		JPanel Drawer = new JPanel();
		Drawer.setBackground(new Color(0, 0, 51));
		Drawer.setBounds(0, 72, 185, 738);
		contentPane.add(Drawer);
		Drawer.setLayout(null);

		JLabel ProfileIcon = new JLabel("");
		ProfileIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setText("Profile");
				MainMenu.setVisible(false);
				ProfileView.setVisible(true);
			}
		});

		if (Adpater.getInfo().get(4).toString().equals("Male")) {
			ProfileIcon.setIcon(GetIcon.setIcon(Icons.MaleUser));
		} else {
			ProfileIcon.setIcon(GetIcon.setIcon(Icons.FemaleUser));
		}

		ProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileIcon.setBounds(0, 0, 185, 146);
		Drawer.add(ProfileIcon);

		ProfileView.setBackground(Color.WHITE);

		// popUp ProfileInfo Login for User
		// =============================================================
		ProfileView.setVisible(false);
		ProfileView.setBounds(220, 133, 989, 645);
		ProfileView.setLayout(null);
		ProfileView.setBackground(Color.WHITE);

		if (Adpater.getInfo().get(4).toString().equals("Male")) {
			label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		} else {
			label.setIcon(GetIcon.setIcon(Icons.FemaleUser));
		}

		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(179, 51, 183, 145);
		ProfileView.add(label);

		JLabel lblPFirstName = new JLabel("First Name");
		lblPFirstName.setBounds(27, 209, 99, 16);
		ProfileView.add(lblPFirstName);

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

		txtPAddress = new JTextField();
		txtPAddress.setColumns(10);
		txtPAddress.setBounds(27, 461, 521, 64);
		ProfileView.add(txtPAddress);
		final String cAddress = Adpater.getInfo().get(13);
		txtPAddress.setText(cAddress);

		JLabel lblPSex = new JLabel("Gender");
		lblPSex.setBounds(330, 358, 99, 16);
		ProfileView.add(lblPSex);
		final String cSex = Adpater.getInfo().get(4);

		final JComboBox<String> CbmSex = new JComboBox<String>();
		CbmSex.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		CbmSex.setBounds(330, 386, 217, 34);

		if (cSex.equals("Male")) {
			CbmSex.setSelectedIndex(0);
		} else {
			CbmSex.setSelectedIndex(1);
		}
		ProfileView.add(CbmSex);

		// ===========

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
		// --------------------------------------------------END

		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		MainMenu.setVisible(true);

		// ---------------------------------------------------------------------------
		MainMenu.setLayout(null);
		MainMenu.add(MenuItem.menu("Total Book", JDBC.getCount("category"), Icons.Book, new Color(57, 124, 188),
				new Color(77, 134, 198), 31, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Total Book");
						BookTable.setVisible(true);
						MainMenu.setVisible(false);
						HomeItem.setVisible(false);
						BookItem.setVisible(true);
					}
				}));
		MainMenu.add(MenuItem.menu("Issuesed Book", JDBC.getCount("category"), Icons.Book, new Color(75, 163, 97),
				new Color(85, 173, 107), 267, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Issuesed Book");
						MainMenu.setVisible(false);
						MemberInput.setVisible(false);
						MemberTable.setVisible(false);
						BookTable.setVisible(false);
						BookInput.setVisible(false);
						AboutUs.setVisible(false);
						IssuesedBook.setVisible(true);
						IssuebookItem.setVisible(true);
						HomeItem.setVisible(false);
					}
				}));
		MainMenu.add(MenuItem.menu("Book Returned", JDBC.getCount("category"), Icons.Book, new Color(231, 159, 62),
				new Color(241, 169, 72), 503, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Returned Book");
						MainMenu.setVisible(false);
						MemberInput.setVisible(false);
						MemberTable.setVisible(false);
						BookTable.setVisible(false);
						BookInput.setVisible(false);
						AboutUs.setVisible(false);
						HomeItem.setVisible(false);
						ReturnedBook.setVisible(true);
						ReturnedbookItem.setVisible(true);
					}
				}));
		MainMenu.add(MenuItem.menu("Total Member", JDBC.getCount("category"), Icons.User, new Color(230, 113, 93),
				new Color(240, 123, 103), 739, 21, new ButtonClick() {
					public void action() {
						lblNewLabel.setText("Member");
						HomeItem.setVisible(false);
						MemberItem.setVisible(true);
						MainMenu.setVisible(false);
						MemberTable.setVisible(true);
					}
				}));
		MainMenu.setVisible(true);
		Border border = BorderFactory.createLineBorder(Color.black, 1);

		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		contentPane.add(MainMenu);
		MainMenu.setLayout(null);
		// setVisible
		MainMenu.setVisible(true);
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
			txtPAddress.disable();
			txtDob.disable();
			CbmSex.disable();
		}
		btnEnable.addActionListener(new ActionListener() {
			// Test kok fuck U
			private boolean check = false;
			private boolean change = false;

			public void actionPerformed(ActionEvent e) {
				txtFirstN.enable();
				txtLastN.enable();
				textEmailP.enable();
				txtPass.enable();
				txtPass.show();
				txtPhone.enable();
				txtPAddress.enable();
				txtDob.enable();
				CbmSex.enable();

				txtFirstN.setFont(txtFirstN.getFont().deriveFont(Font.BOLD, 14f));
				txtLastN.setFont(txtLastN.getFont().deriveFont(Font.BOLD, 14f));
				textEmailP.setFont(textEmailP.getFont().deriveFont(Font.BOLD, 14f));
				txtPass.setFont(txtPass.getFont().deriveFont(Font.BOLD, 14f));
				txtPhone.setFont(txtPhone.getFont().deriveFont(Font.BOLD, 14f));
				txtPAddress.setFont(txtPAddress.getFont().deriveFont(Font.BOLD, 14f));
				txtDob.setFont(txtDob.getFont().deriveFont(Font.BOLD, 14f));
				CbmSex.setFont(txtDob.getFont().deriveFont(Font.BOLD, 14f));

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

					if (CbmSex.isEditable() == false) {
						change = true;
						JDBC.updateBy("staff", "sex", cSex, CbmSex.getSelectedItem().toString());
					}

					if (!textEmailP.getText().equals(cEmail)) {
						change = true;
						JDBC.updateBy("staff", "email", cEmail, textEmailP.getText());
					}

					if (!txtDob.getText().equals(cDob)) {
						change = true;
						JDBC.updateBy("staff", "dob", cDob, txtDob.getText());
					}

					if (!txtPAddress.getText().equals(cAddress)) {
						change = true;
						JDBC.updateBy("staff", "address", cAddress, txtPAddress.getText());
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
					txtPAddress.disable();
					txtDob.disable();
					CbmSex.disable();
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
		JLabel lbleFirstName = new JLabel("First Name");
		lbleFirstName.setBounds(27, 209, 73, 16);
		ProfileView.add(lbleFirstName);

		ArrayList<ArrayList<String>> bookcategory = JDBC.readData("category");
		for (int i = 0; i < bookcategory.size(); i++) {
			txtCategoryBook.addItem(bookcategory.get(i).get(2));
//			theModel.addAll(new List<String>[] bookcategory.length.get(2));
		}
		// BookTable=====================================================
		BookTable.add(ReuseTable.TotalBook());
		BookTable.setVisible(false);
		BookTable.setToolTipText("");

		BookTable.setBackground(Color.WHITE);
		BookTable.setBounds(220, 133, 989, 645);
		contentPane.add(BookTable);
		BookTable.setLayout(null);
		ProfileView.setBackground(Color.WHITE);
//Profile view==========================================================
		ProfileView.setBounds(220, 133, 989, 645);
		contentPane.add(ProfileView);
		ProfileView.setVisible(false);
		ProfileView.setLayout(null);
//======================================================================

		JLabel lblUserName = new JLabel(Adpater.getInfo().get(2) + " " + Adpater.getInfo().get(3));
		lblUserName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(0, 159, 185, 41);
		Drawer.add(lblUserName);

		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);
		contentPane.add(lblNewLabel);

		HomeItem.setBackground(new Color(0, 0, 51));
		HomeItem.setBounds(0, 263, 185, 475);
		Drawer.add(HomeItem);
		HomeItem.setLayout(null);

		HomeItem.add(DrawerItem.drawerItem("Total book", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Total book");

				MainMenu.setVisible(false);
				HomeItem.setVisible(false);
				BookTable.setVisible(true);
				BookItem.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Member", 46, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Member");
				HomeItem.setVisible(false);
				MemberItem.setVisible(true);
				MainMenu.setVisible(false);
				MemberTable.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Issuesed Book", 46 * 2, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Issuesed Book");
				IssuesedBook.setVisible(true);
				IssuebookItem.setVisible(true);

				HomeItem.setVisible(false);
				MainMenu.setVisible(false);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("Returned Book", 46 * 3, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Returned Book");
				MainMenu.setVisible(false);
				MemberInput.setVisible(false);
				HomeItem.setVisible(false);
				ReturnBook2.setVisible(true);
				ReturnedBook.setVisible(true);
				ReturnedbookItem.setVisible(true);
			}
		}));
		HomeItem.add(DrawerItem.drawerItem("About Us", 46 * 4, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("About Us");
				MainMenu.setVisible(false);
				MemberInput.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				ReturnedBook.setVisible(false);
				AboutUs.setVisible(true);
			}
		}));

//IssuesedBook==================================================

		IssuesedBook.setBackground(Color.WHITE);
		IssuesedBook.setBounds(220, 133, 989, 645);
		IssuesedBook.setVisible(false);
		IssuesedBook.add(IssueBook.issuetable());
		MemberTable.setVisible(false);
//		IssuesedBook.setToolTipText("");
//Return book===================================================
		ReturnBook2.setBackground(Color.WHITE);
		ReturnBook2.setBounds(220, 133, 989, 645);
		ReturnBook2.setVisible(false);

		// AddIssuesedBook==============================================

		AddIssuesedBook.setBackground(Color.WHITE);
		AddIssuesedBook.setBounds(220, 133, 989, 645);
		AddIssuesedBook.setVisible(false);
		contentPane.add(AddIssuesedBook);
		AddIssuesedBook.add(AddIssueTable.issuetable());

		AddIssuesedBook.setLayout(null);

		JLabel lblMenberName = new JLabel("Member Name");
		lblMenberName.setBounds(50, 67, 97, 16);
		AddIssuesedBook.add(lblMenberName);

		txtMember = new JTextField();
		txtMember.setColumns(10);
		txtMember.setBounds(50, 95, 679, 34);
		AddIssuesedBook.add(txtMember);

		JLabel lblBookId = new JLabel("Book Title ");
		lblBookId.setBounds(50, 141, 97, 16);
		AddIssuesedBook.add(lblBookId);

		txtBookTitle = new JTextField();
		txtBookTitle.setColumns(10);
		txtBookTitle.setBounds(50, 169, 319, 34);
		AddIssuesedBook.add(txtBookTitle);

		JLabel lblIssuesDate = new JLabel("Issues Date ( day / month / year )");
		lblIssuesDate.setBounds(445, 141, 277, 16);
		AddIssuesedBook.add(lblIssuesDate);

		txtIssueDay = new JTextField();
		txtIssueDay.setColumns(10);
		txtIssueDay.setBounds(445, 169, 82, 34);
		AddIssuesedBook.add(txtIssueDay);

		txtIssueMonth = new JTextField();
		txtIssueMonth.setColumns(10);
		txtIssueMonth.setBounds(539, 169, 82, 34);
		AddIssuesedBook.add(txtIssueMonth);

		txtIssueYear = new JTextField();
		txtIssueYear.setColumns(10);
		txtIssueYear.setBounds(633, 169, 96, 34);
		AddIssuesedBook.add(txtIssueYear);

		JButton lblIssuesedBook = new JButton("Add");

		lblIssuesedBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMember.getText().length() == 0 || txtBookTitle.getText().length() == 0
						|| txtQty.getText().length() == 0 || txtIssueYear.getText().length() == 0
						|| txtIssueMonth.getText().length() == 0 || txtIssueDay.getText().length() == 0
						|| txtDueYear.getText().length() == 0 || txtDueMonth.getText().length() == 0
						|| txtDueDay.getText().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "Please insert all field", "Fail",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						ArrayList<ArrayList<String>> book = JDBC.readBy("Book", "title", txtBookTitle.getText());
						ArrayList<ArrayList<String>> member = JDBC.readBy("member", "first_name", txtMember.getText());
						if (member.size() == 0) {
							JOptionPane.showMessageDialog(contentPane, "Member not found", "Fail",
									JOptionPane.WARNING_MESSAGE);
						} else if (book.size() == 0) {
							JOptionPane.showMessageDialog(contentPane, "Book not found", "Fail",
									JOptionPane.WARNING_MESSAGE);
						} else {
							txtPrice.setText(book.get(0).get(10) + " Riel");
							AddIssueTable.Issuemodel.addRow(new Object[] { (on++), txtMember.getText(),
									txtBookTitle.getText(), txtQty.getText(),
									txtIssueYear.getText() + '-' + txtIssueMonth.getText() + '-'
											+ txtIssueDay.getText(),
									txtDueYear.getText() + '-' + txtDueMonth.getText() + '-' + txtDueDay.getText(),
									txtPrice.getText() });

							txtBookTitle.setText("");
							txtQty.setText("");
							txtIssueYear.setText("");
							txtIssueMonth.setText("");
							txtIssueDay.setText("");
							txtDueYear.setText("");
							txtDueMonth.setText("");
							txtDueDay.setText("");
							txtPrice.setText("");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		lblIssuesedBook.setBackground(Color.GREEN);
		lblIssuesedBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssuesedBook.setBounds(738, 277, 219, 76);
		AddIssuesedBook.add(lblIssuesedBook);

		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(50, 216, 97, 16);
		AddIssuesedBook.add(lblQty);

		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(50, 244, 319, 34);
		AddIssuesedBook.add(txtQty);

		JLabel lblDueDate = new JLabel("Due Date ( day / month / year )");
		lblDueDate.setBounds(445, 216, 277, 16);
		AddIssuesedBook.add(lblDueDate);

		txtDueDay = new JTextField();
		txtDueDay.setColumns(10);
		txtDueDay.setBounds(445, 244, 82, 34);
		AddIssuesedBook.add(txtDueDay);

		txtDueMonth = new JTextField();
		txtDueMonth.setColumns(10);
		txtDueMonth.setBounds(539, 244, 82, 34);
		AddIssuesedBook.add(txtDueMonth);

		txtDueYear = new JTextField();
		txtDueYear.setColumns(10);
		txtDueYear.setBounds(633, 244, 96, 34);
		AddIssuesedBook.add(txtDueYear);

		JLabel lblBookPrices = new JLabel("Book Prices ");
		lblBookPrices.setBounds(50, 291, 97, 16);
		AddIssuesedBook.add(lblBookPrices);

		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(50, 319, 319, 34);
		txtPrice.setEditable(false);
		AddIssuesedBook.add(txtPrice);

		JButton button = new JButton("Issuesed Book");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setBackground(Color.GREEN);
		button.setBounds(741, 95, 219, 76);
		AddIssuesedBook.add(button);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AddIssueTable.Issuemodel.removeRow(AddIssueTable.IssueBook.getSelectedRow());
			}
		});
		btnRemove.setHorizontalAlignment(SwingConstants.CENTER);
		btnRemove.setBackground(Color.GREEN);
		btnRemove.setBounds(741, 189, 219, 76);
		AddIssuesedBook.add(btnRemove);
		ReturnBook2.add(ReturnBook.TotalBook());
		contentPane.add(ReturnBook2);
		ReturnBook2.setLayout(null);
		MemberInput.setVisible(false);
		MemberInput.setVisible(false);
		//

		// Member Input

		MemberInput.setToolTipText("");

		MemberInput.setBackground(Color.WHITE);
		MemberInput.setBounds(220, 133, 989, 645);
		contentPane.add(MemberInput);
		MemberInput.setLayout(null);

		txtFristname = new JTextField();
		txtFristname.setBounds(43, 62, 288, 34);
		MemberInput.add(txtFristname);
		txtFristname.setColumns(10);

		JLabel lblFristname = new JLabel("Frist name");
		lblFristname.setBounds(43, 34, 97, 16);
		MemberInput.add(lblFristname);

		JLabel lblLastname = new JLabel("Last name");
		lblLastname.setBounds(438, 34, 97, 16);
		MemberInput.add(lblLastname);

		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(436, 62, 288, 34);
		MemberInput.add(txtLastname);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(43, 108, 97, 16);
		MemberInput.add(lblSex);

		final JComboBox<String> sexCombo = new JComboBox<String>();
		sexCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		sexCombo.setBounds(43, 136, 120, 34);
		MemberInput.add(sexCombo);

		JLabel lblNewLabel_3 = new JLabel("Month");
		lblNewLabel_3.setBounds(43, 182, 61, 16);
		MemberInput.add(lblNewLabel_3);

		final JComboBox<String> txtMonth = new JComboBox<String>();
		txtMonth.setModel(new DefaultComboBoxModel<String>(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		txtMonth.setBounds(43, 210, 204, 34);
		MemberInput.add(txtMonth);

		JLabel lblNewLabel_4 = new JLabel("Day");
		lblNewLabel_4.setBounds(307, 182, 61, 16);
		MemberInput.add(lblNewLabel_4);

		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(549, 182, 61, 16);
		MemberInput.add(lblYear);

		txtDay = new JTextField();
		txtDay.setBounds(307, 209, 175, 34);
		MemberInput.add(txtDay);
		txtDay.setColumns(10);

		txtYear = new JTextField();
		txtYear.setBounds(549, 209, 175, 34);
		MemberInput.add(txtYear);
		txtYear.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(436, 135, 288, 34);
		MemberInput.add(txtPhoneNumber);

		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(438, 108, 109, 16);
		MemberInput.add(lblPhoneNumber);

		JLabel lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setBounds(211, 108, 61, 16);
		MemberInput.add(lblNewLabel_5);

		JComboBox<String> roleCombo = new JComboBox<String>();
		roleCombo.setBounds(211, 136, 120, 34);
		MemberInput.add(roleCombo);

		JLabel lblAddress = new JLabel("Your birthday");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setBounds(736, 218, 102, 16);
		MemberInput.add(lblAddress);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(446, 259, 97, 16);
		MemberInput.add(lblAddress_1);

		final JTextArea txtAddress = new JTextArea();
		txtAddress.setBackground(Color.WHITE);
		txtAddress.setBounds(446, 287, 278, 147);
		txtAddress.setBorder(border);
		MemberInput.add(txtAddress);

		JLabel panel_2 = new JLabel();
		panel_2.setBounds(498, 525, 117, 34);
		MemberInput.add(panel_2);

		MemberInput.setBackground(Color.WHITE);
		MemberInput.setBounds(220, 133, 989, 645);
		contentPane.add(MemberInput);
		MemberInput.setLayout(null);

		txtFristname = new JTextField();
		txtFristname.setBounds(43, 62, 288, 34);
		MemberInput.add(txtFristname);
		txtFristname.setColumns(10);

		JLabel lblFristName = new JLabel("Frist name");
		lblFristName.setBounds(43, 34, 97, 16);
		MemberInput.add(lblFristName);

		JLabel lblLastNames = new JLabel("Last name");
		lblLastNames.setBounds(438, 34, 97, 16);
		MemberInput.add(lblLastNames);

		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(436, 62, 288, 34);
		MemberInput.add(txtLastname);

		JLabel lblsex = new JLabel("Sex");
		lblsex.setBounds(43, 108, 97, 16);
		MemberInput.add(lblsex);

		final JComboBox<String> comboBoxSex = new JComboBox<String>();
		comboBoxSex.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		comboBoxSex.setBounds(43, 136, 120, 34);
		MemberInput.add(comboBoxSex);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(43, 182, 61, 16);
		MemberInput.add(lblMonth);

		final JComboBox<String> txtMonths = new JComboBox<String>();
		txtMonths.setModel(new DefaultComboBoxModel<String>(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		txtMonths.setBounds(43, 210, 204, 34);
		MemberInput.add(txtMonths);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(307, 182, 61, 16);
		MemberInput.add(lblDay);

		JLabel lblYears = new JLabel("Year");
		lblYears.setBounds(549, 182, 61, 16);
		MemberInput.add(lblYears);

		txtDay = new JTextField();
		txtDay.setBounds(307, 209, 175, 34);
		MemberInput.add(txtDay);
		txtDay.setColumns(10);

		txtYear = new JTextField();
		txtYear.setBounds(549, 209, 175, 34);
		MemberInput.add(txtYear);
		txtYear.setColumns(10);

		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(436, 135, 288, 34);
		MemberInput.add(txtPhoneNumber);

		txtNationalID = new JTextField();
		txtNationalID.setColumns(10);
		txtNationalID.setBounds(43, 287, 288, 34);
		MemberInput.add(txtNationalID);

		JLabel lblNotionalId = new JLabel("Notional ID");
		lblNotionalId.setBounds(43, 259, 97, 16);
		MemberInput.add(lblNotionalId);

		JButton btnMemberCreate = new JButton("Create");
		btnMemberCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtFristname.getText().length() == 0 || txtYear.getText().length() == 0
						|| txtDay.getText().length() == 0 || txtAddress.getText().length() == 0
						|| txtLastname.getText().length() == 0 || txtPhoneNumber.getText().length() == 0
						|| txtNationalID.getText().length() == 0) {

				} else {
//					JDBC.insert("member", 0, txtNationalID.getText(), txtFristname.getText(), txtLastname.getText(),
//							txtFristname.getText() + txtLastname.getText(), comboBoxSex.getSelectedItem(),
//							txtEmailMember.getText(), txtAddress.getText(),);
				}
				String dob = txtYear.getText() + "-" + txtMonths.getSelectedIndex() + 1 + "-" + txtDay.getText();
				txtPhoneNumber.getText();
				;
				/*
				 
				 */
			}
		});
		btnMemberCreate.setBounds(211, 494, 117, 29);
		MemberInput.add(btnMemberCreate);

		JButton btnCancelMember = new JButton("Cancel");
		btnCancelMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelMember.setBounds(438, 494, 117, 29);
		MemberInput.add(btnCancelMember);

		txtEmailMember = new JTextField();
		txtEmailMember.setColumns(10);
		txtEmailMember.setBounds(43, 400, 288, 34);
		MemberInput.add(txtEmailMember);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(43, 372, 97, 16);
		MemberInput.add(lblEmail);
		MemberInput.setVisible(false);
		// Add book
		// category======================================================================================
		AddBookCategory.setBackground(Color.WHITE);
		AddBookCategory.setBounds(220, 133, 989, 645);
		contentPane.add(AddBookCategory);
		AddBookCategory.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Title");
		lblNewLabel_11.setBounds(49, 61, 61, 16);
		AddBookCategory.add(lblNewLabel_11);

		txtCategoryTitle = new JTextField();
		txtCategoryTitle.setColumns(10);
		txtCategoryTitle.setBounds(49, 89, 260, 36);
		AddBookCategory.add(txtCategoryTitle);

		JLabel lblDecrip = new JLabel("Description");
		lblDecrip.setBounds(49, 137, 127, 16);
		AddBookCategory.add(lblDecrip);
		final JTextArea txtCategoryDescription = new JTextArea();
		txtCategoryDescription.setBorder(border);
		txtCategoryDescription.setBounds(49, 165, 260, 114);
		AddBookCategory.add(txtCategoryDescription);

		JButton btnCreateCategory = new JButton("Create");
		btnCreateCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCategoryTitle.getText().length() == 0 || txtCategoryDescription.getText().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "Please insert all field", "Fail",
							JOptionPane.WARNING_MESSAGE);
				} else {
					CategoryController categoryController = new CategoryController();
					categoryController.create(txtCategoryTitle.getText(), txtCategoryDescription.getText());
					txtCategoryBook.removeAllItems();
					ArrayList<ArrayList<String>> bookcategory;
					try {
						bookcategory = JDBC.readData("category");

						for (int i = 0; i < bookcategory.size(); i++) {
							txtCategoryBook.addItem(bookcategory.get(i).get(2));
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(contentPane, "Insert Suceesful", "Success",
							JOptionPane.INFORMATION_MESSAGE);
					txtCategoryTitle.setText("");
					txtCategoryDescription.setText("");
				}

			}
		});
		btnCreateCategory.setBounds(294, 361, 117, 29);
		AddBookCategory.add(btnCreateCategory);

		JButton btnCancelCategory = new JButton("Cancel");
		btnCancelCategory.setBounds(500, 361, 117, 29);
		btnCancelCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddBookCategory.setVisible(false);
				BookTable.setVisible(true);
			}
		});
		AddBookCategory.add(btnCancelCategory);
		BookInput.setVisible(false);

		// Input Book

		BookInput.setBackground(Color.WHITE);
		BookInput.setBounds(220, 133, 989, 645);
		contentPane.add(BookInput);
		BookInput.setLayout(null);

		txtBookTitleBook = new JTextField();
		txtBookTitleBook.setBounds(43, 62, 288, 34);
		BookInput.add(txtBookTitleBook);
		txtBookTitleBook.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Book title");
		lblNewLabel_1.setBounds(43, 34, 97, 16);
		BookInput.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Language");
		lblLastName.setBounds(438, 34, 97, 16);
		BookInput.add(lblLastName);

		txtLanguageBook = new JTextField();
		txtLanguageBook.setColumns(10);
		txtLanguageBook.setBounds(438, 62, 288, 34);
		BookInput.add(txtLanguageBook);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(43, 108, 97, 16);
		BookInput.add(lblAuthor);

		txtAuthorBook = new JTextField();
		txtAuthorBook.setColumns(10);
		txtAuthorBook.setBounds(43, 136, 288, 34);
		BookInput.add(txtAuthorBook);

		JLabel lblPublish = new JLabel("Publish at   ( Year / month / day )");
		lblPublish.setBounds(438, 108, 277, 16);
		BookInput.add(lblPublish);

		txtYearBook = new JTextField();
		txtYearBook.setColumns(10);
		txtYearBook.setBounds(438, 136, 82, 34);
		BookInput.add(txtYearBook);

		txtMonthBook = new JTextField();
		txtMonthBook.setColumns(10);
		txtMonthBook.setBounds(532, 136, 82, 34);
		BookInput.add(txtMonthBook);

		txtDayBook = new JTextField();
		txtDayBook.setColumns(10);
		txtDayBook.setBounds(626, 136, 96, 34);
		BookInput.add(txtDayBook);

		JLabel lblStatus = new JLabel("Category");
		lblStatus.setBounds(438, 182, 97, 16);
		BookInput.add(lblStatus);

		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setBounds(43, 182, 97, 16);
		BookInput.add(lblEdition);

		txtEditionBook = new JTextField();
		txtEditionBook.setColumns(10);
		txtEditionBook.setBounds(43, 213, 288, 34);
		BookInput.add(txtEditionBook);

		txtBookCodeBook = new JTextField();
		txtBookCodeBook.setColumns(10);
		txtBookCodeBook.setBounds(43, 287, 288, 34);
		BookInput.add(txtBookCodeBook);

		txtCategoryBook.setBounds(438, 210, 288, 34);
		BookInput.add(txtCategoryBook);

		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtBookTitleBook.getText().length() == 0 || txtLanguageBook.getText().length() == 0
						|| txtAuthorBook.getText().length() == 0 || txtYearBook.getText().length() == 0
						|| txtMonthBook.getText().length() == 0 || txtDayBook.getText().length() == 0
						|| txtEditionBook.getText().length() == 0 || txtBookCodeBook.getText().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "Please insert all file", "Fail",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						ArrayList<ArrayList<String>> secuser = JDBC.readBy("book", "book_code", txtBookCodeBook.getText());
						if(secuser.size()!=0) {
							JOptionPane.showMessageDialog(contentPane, "This book already has", "Fail",
									JOptionPane.WARNING_MESSAGE);
						}else {
							BookController bookcontroller = new BookController();
							String date = txtYearBook.getText() + "-" + txtMonthBook.getText() + "-" + txtDayBook.getText();
							bookcontroller.create(txtBookCodeBook.getText(), txtBookTitleBook.getText(),
									txtLanguageBook.getText(), txtAuthorBook.getText(), date, txtEditionBook.getText(),
									txtCategoryBook.getSelectedIndex() + 4);
							JOptionPane.showMessageDialog(contentPane, "Insert Suceesful", "Success",
									JOptionPane.INFORMATION_MESSAGE);
							txtBookCodeBook.setText("");
							txtMonthBook.setText("");
							txtDayBook.setText("");
							txtBookCodeBook.setText("");
							txtBookTitleBook.setText("");
							txtLanguageBook.setText("");
							txtAuthorBook.setText("");
							txtEditionBook.setText("");
							txtYearBook.setText("");
							ReuseTable.model.setRowCount(0);
							ReuseTable.setTable();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					///
				}
			}
		});
		btnCreate.setBounds(215, 346, 117, 29);
		BookInput.add(btnCreate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookInput.setVisible(false);
				BookTable.setVisible(true);
			}
		});
		btnCancel.setBounds(438, 346, 117, 29);
		BookInput.add(btnCancel);

		JLabel lblBookCode = new JLabel("Book Code");
		lblBookCode.setBounds(43, 259, 97, 16);
		BookInput.add(lblBookCode);
		//Import book============================================================================================
				ImportBook.setBackground(Color.WHITE);
				ImportBook.setBounds(220, 133, 989, 645);
				contentPane.add(ImportBook);
				ImportBook.setLayout(null);
				
				JLabel lblNewLabel_2 = new JLabel("Book code");
				lblNewLabel_2.setBounds(47, 26, 114, 16);
				ImportBook.add(lblNewLabel_2);
				
				txtBookCodeImport = new JTextField();
				txtBookCodeImport.setBounds(47, 54, 197, 26);
				ImportBook.add(txtBookCodeImport);
				txtBookCodeImport.setColumns(10);
				
				JButton btnSearchImport = new JButton("search");
				btnSearchImport.setBounds(283, 54, 117, 29);
				ImportBook.add(btnSearchImport);
				
				JLabel lblBookTitle_1 = new JLabel("Book title");
				lblBookTitle_1.setBounds(47, 119, 114, 16);
				ImportBook.add(lblBookTitle_1);
				
				txtBookTitleImport = new JTextField();
				txtBookTitleImport.setColumns(10);
				txtBookTitleImport.setBounds(47, 147, 216, 26);
				ImportBook.add(txtBookTitleImport);
				
				JLabel lblBookPrice = new JLabel("Book Price");
				lblBookPrice.setBounds(47, 185, 114, 16);
				ImportBook.add(lblBookPrice);
				
				txtBookPriceImport = new JTextField();
				txtBookPriceImport.setColumns(10);
				txtBookPriceImport.setBounds(47, 213, 216, 26);
				ImportBook.add(txtBookPriceImport);
				
				JLabel lblBookQty = new JLabel("Book qty");
				lblBookQty.setBounds(47, 251, 114, 16);
				ImportBook.add(lblBookQty);
				
				txtBookQtyImport = new JTextField();
				txtBookQtyImport.setColumns(10);
				txtBookQtyImport.setBounds(47, 279, 216, 26);
				ImportBook.add(txtBookQtyImport);
				
				JLabel lblYear_1 = new JLabel("Year");
				lblYear_1.setBounds(47, 317, 56, 16);
				ImportBook.add(lblYear_1);
				
				txtYearImport = new JTextField();
				txtYearImport.setColumns(10);
				txtYearImport.setBounds(47, 345, 64, 26);
				ImportBook.add(txtYearImport);
				
				JLabel lblMonth_2 = new JLabel("Month");
				lblMonth_2.setBounds(123, 317, 56, 16);
				ImportBook.add(lblMonth_2);
				
				JLabel lblMonth_1 = new JLabel("Day");
				lblMonth_1.setBounds(199, 317, 56, 16);
				ImportBook.add(lblMonth_1);
				
				txtMonthImport = new JTextField();
				txtMonthImport.setColumns(10);
				txtMonthImport.setBounds(123, 345, 64, 26);
				ImportBook.add(txtMonthImport);
				
				txtDayImport = new JTextField();
				txtDayImport.setColumns(10);
				txtDayImport.setBounds(199, 345, 64, 26);
				ImportBook.add(txtDayImport);
				
				JLabel lblDescription = new JLabel("Description");
				lblDescription.setBounds(47, 383, 114, 16);
				ImportBook.add(lblDescription);
				
				JTextArea txtDescriptionImport = new JTextArea();
				txtDescriptionImport.setBounds(47, 411, 216, 74);
				txtDescriptionImport.setBorder(border);
				ImportBook.add(txtDescriptionImport);
				
				JButton btnImport = new JButton("Import");
				btnImport.setBounds(283, 538, 117, 29);
				ImportBook.add(btnImport);
				
				JButton btnCancelImport = new JButton("Cancel");
				btnCancelImport.setBounds(490, 538, 117, 29);
				ImportBook.add(btnCancelImport);
				ImportBook.setVisible(false);
		// ========================================================================================
		// AddReturnedBook
		AddReturnBook.setBackground(Color.WHITE);
		AddReturnBook.setBounds(220, 133, 989, 645);
		contentPane.add(AddReturnBook);
		AddReturnBook.setLayout(null);

		getMemberName = new JTextField();
		getMemberName.setBounds(72, 43, 300, 32);
		AddReturnBook.add(getMemberName);
		getMemberName.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<ArrayList<String>> member = JDBC.readBy("member", "first_name", getMemberName.getText());
					if (member.size() == 0) {

					} else {
						setMemberName.setText(member.get(0).get(3) + " " + member.get(0).get(4));
						ArrayList<ArrayList<String>> booking = JDBC.readBy("booking", "member_ship_id",
								member.get(0).get(0));
						ArrayList<ArrayList<String>> bookDetail = JDBC.readBy("Book", "id", booking.get(0).get(9));
						setIssueDate.setText(booking.get(0).get(3));
						setReturnDate.setText(booking.get(0).get(4));
						setBookTitle.setText(bookDetail.get(0).get(2));
						System.out.print(bookDetail);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(412, 46, 117, 29);
		AddReturnBook.add(btnNewButton);

		JLabel lblNewLabel_8 = new JLabel("Member name :");
		lblNewLabel_8.setBounds(72, 143, 132, 29);
		AddReturnBook.add(lblNewLabel_8);

		JLabel lblBookTitle = new JLabel("Book title :");
		lblBookTitle.setBounds(72, 184, 132, 29);
		AddReturnBook.add(lblBookTitle);

		JLabel lblIssueDate = new JLabel("Issue date :");
		lblIssueDate.setBounds(72, 225, 132, 29);
		AddReturnBook.add(lblIssueDate);

		JLabel lblReturnMoney = new JLabel("Return money :");
		lblReturnMoney.setBounds(72, 307, 132, 29);
		AddReturnBook.add(lblReturnMoney);

		JLabel lblReturnDate = new JLabel("Return date :");
		lblReturnDate.setBounds(72, 266, 132, 29);
		AddReturnBook.add(lblReturnDate);

		setMemberName.setBounds(216, 143, 313, 29);
		AddReturnBook.add(setMemberName);

		setBookTitle.setBounds(216, 184, 313, 29);
		AddReturnBook.add(setBookTitle);

		setIssueDate.setBounds(216, 225, 313, 29);
		AddReturnBook.add(setIssueDate);

		setReturnDate.setBounds(216, 266, 313, 29);
		AddReturnBook.add(setReturnDate);

		setReturnDate_1.setBounds(216, 307, 313, 29);
		AddReturnBook.add(setReturnDate_1);

		lblNewLabel_9.setBounds(72, 15, 102, 16);
		AddReturnBook.add(lblNewLabel_9);

		IssuesedBook.setBackground(Color.WHITE);
		IssuesedBook.setBounds(220, 133, 989, 645);
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);
//=======================================================================================
		// BOOK
		BookItem.setBackground(new Color(0, 0, 51));
		BookItem.setBounds(0, 263, 185, 475);
		BookItem.setLayout(null);
		BookItem.setVisible(false);
		Drawer.add(BookItem);

		BookItem.add(DrawerItem.drawerItem("Create category", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Create category");
				MainMenu.setVisible(false);
				MemberInput.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				ImportBook.setVisible(false);
				AddBookCategory.setVisible(true);
				BookInput.setVisible(false);
			}
		}));
		BookItem.add(DrawerItem.drawerItem("Create book", 46, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Create Book");
				MainMenu.setVisible(false);
				MemberInput.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				BookInput.setVisible(true);
				ImportBook.setVisible(false);
				AddBookCategory.setVisible(false);
			}
		}));
		BookItem.add(DrawerItem.drawerItem("Import Book", 46 * 2, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Import Book");
				MainMenu.setVisible(false);
				MemberInput.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				ImportBook.setVisible(true);
				AddBookCategory.setVisible(false);
				BookInput.setVisible(false);
			}
		}));
//=======================================================================================================
		// About Us

		AboutUs.setToolTipText("");

		AboutUs.setBackground(Color.WHITE);
		AboutUs.setBounds(220, 133, 989, 645);
		contentPane.add(AboutUs);
		AboutUs.setLayout(null);

		// Book Table
		MemberTable.setVisible(false);
		IssuesedBook.setVisible(false);

		// MEMBER

		MemberItem.setBackground(new Color(0, 0, 51));
		MemberItem.setBounds(0, 263, 185, 475);
		MemberItem.setLayout(null);
		MemberItem.setVisible(false);
		Drawer.add(MemberItem);

		MemberItem.add(DrawerItem.drawerItem("Add Member", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Add Member");
				MainMenu.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				MemberInput.setVisible(true);
			}
		}));

		final JPanel dashBoard = new JPanel();
		dashBoard.setBackground(new Color(0, 0, 51));
		dashBoard.setBounds(0, 218, 185, 46);
		Drawer.add(dashBoard);
		dashBoard.setLayout(null);
		dashBoard.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				dashBoard.setBackground(new Color(0, 51, 102));
			}
		});
		dashBoard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				dashBoard.setBackground(new Color(0, 0, 51));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel.setText("Home");
				MemberInput.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				AboutUs.setVisible(false);
				IssuesedBook.setVisible(false);
				HomeItem.setVisible(true);
				MainMenu.setVisible(true);
				BookItem.setVisible(false);
				AddReturnBook.setVisible(false);
				AddIssuesedBook.setVisible(false);
				ReturnBook2.setVisible(false);
				ProfileView.setVisible(false);
				IssuebookItem.setVisible(false);
				ReturnedbookItem.setVisible(false);
				MemberItem.setVisible(false);
			}
		});

		JLabel lblNewLabel_7 = new JLabel("Dashboard");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setBounds(20, 0, 160, 46);
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		dashBoard.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.WHITE);

		//
		IssuebookItem.setBackground(new Color(0, 0, 51));
		IssuebookItem.setBounds(0, 263, 185, 475);
		IssuebookItem.setLayout(null);
		IssuebookItem.setVisible(false);
		Drawer.add(IssuebookItem);

		IssuebookItem.add(DrawerItem.drawerItem("Add Issue book", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Add Issue book");
				MainMenu.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				AddIssuesedBook.setVisible(true);

			}
		}));

		ReturnedbookItem.setBackground(new Color(0, 0, 51));
		ReturnedbookItem.setBounds(0, 263, 185, 475);
		ReturnedbookItem.setLayout(null);
		ReturnedbookItem.setVisible(false);
		Drawer.add(ReturnedbookItem);

		ReturnedbookItem.add(DrawerItem.drawerItem("Add returned book", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Add returned book");
				MainMenu.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				ReturnBook2.setVisible(false);
				AddReturnBook.setVisible(true);
			}
		}));

		// Member Table

		MemberTable.setBackground(Color.WHITE);
		MemberTable.setBounds(220, 133, 989, 645);
		contentPane.add(MemberTable);
		MemberTable.setToolTipText("");

		MemberTable.setBackground(Color.WHITE);
		MemberTable.setBounds(220, 133, 989, 645);
		contentPane.add(MemberTable);
		MemberTable.setLayout(null);
		MemberTable.setLayout(null);

		BookInput.setVisible(false);
		BookTable.setVisible(false);
		MemberTable.setVisible(false);
		IssuesedBook.setVisible(false);
		AddIssuesedBook.setVisible(false);
		MemberItem.setVisible(false);
		ProfileView.setVisible(false);
		ReturnedBook.setVisible(false);
		AddReturnBook.setVisible(false);
		ReturnBook2.setVisible(false);
		AboutUs.setVisible(false);
		ProfileView.setVisible(false);
		AddBookCategory.setVisible(false);

	}
}
