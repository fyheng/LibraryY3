package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

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

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
	JPanel AddReturnedBook = new JPanel();
	JPanel ReturnBook2 = new JPanel();
	JPanel AboutUs = new JPanel();
	JPanel ProfileView = new JPanel();
	private JTextField txtFristname;
	private JTextField txtLastname;
	private JTextField txtDay;
	private JTextField txtYear;
	private JTextField txtPhoneNumber;
	private JTextField txtBookID;
	private JTextField txtMemberID;
	private JTable table;
	private JTextField txtLanguage;
	private JTextField txtAuthor;
	private JTextField txtPublishDay;
	private JTextField txtPublishMonth;
	private JTextField txtPublishYear;
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
	private JTextField txtDOB;
	private JPasswordField txtPass;
	private JTextField txtSetQuote;
	int on = 1;
	private JTable AddIssuesBook;

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
		ProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileIcon.setBounds(0, 0, 185, 146);
		Drawer.add(ProfileIcon);
		ProfileIcon.setIcon(GetIcon.setIcon(Icons.MaleUser));
		ProfileView.setBackground(Color.WHITE);
//Profile view==========================================================
		ProfileView.setBounds(220, 133, 989, 645);
		contentPane.add(ProfileView);
		ProfileView.setVisible(false);
		ProfileView.setLayout(null);
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(179, 18, 183, 145);
		if (Adpater.getInfo().get(4).toString().equals("Male")) {
			label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		} else {
			label.setIcon(GetIcon.setIcon(Icons.MaleUser));
		}
		ProfileView.setLayout(null);
		ProfileView.add(label);

		JLabel lbleFirstName = new JLabel("First Name");
		lbleFirstName.setBounds(27, 209, 73, 16);
		lbleFirstName.setText(Login.data.get(3));
		ProfileView.add(lbleFirstName);

		txtFirstN = new JTextField();
		txtFirstN.setBounds(27, 237, 218, 34);
		ProfileView.add(txtFirstN);
		txtFirstN.setColumns(10);

		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setBounds(330, 200, 218, 34);
		ProfileView.add(lblLastName_1);

		txtLastN = new JTextField();
		txtLastN.setBounds(330, 237, 218, 34);
		txtLastN.setColumns(10);
		ProfileView.add(txtLastN);
		txtLastN.setText(Login.data.get(3).toString());

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setBounds(27, 283, 34, 16);
		ProfileView.add(lblEmail_1);

		JLabel lblPhoneNumber_1 = new JLabel("Phone number");
		lblPhoneNumber_1.setBounds(330, 283, 90, 16);
		ProfileView.add(lblPhoneNumber_1);

		textEmailP = new JTextField();
		textEmailP.setColumns(10);
		textEmailP.setBounds(27, 311, 218, 34);
		ProfileView.add(textEmailP);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(330, 358, 59, 16);
		ProfileView.add(lblPassword);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(330, 311, 218, 34);
		ProfileView.add(txtPhone);

		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBounds(27, 386, 218, 34);
		ProfileView.add(txtDob);

		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setBounds(27, 358, 80, 16);
		ProfileView.add(lblDateOfBirth);

		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(27, 461, 521, 64);
		ProfileView.add(txtDOB);

		JLabel lblAddress_3 = new JLabel("Address");
		lblAddress_3.setBounds(27, 432, 51, 16);
		ProfileView.add(lblAddress_3);

		JButton btnEnable = new JButton("Enable");
		btnEnable.setBounds(451, 561, 97, 34);
		ProfileView.add(btnEnable);

		txtPass = new JPasswordField();
		txtPass.setBounds(330, 386, 218, 34);
		ProfileView.add(txtPass);

		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 268, 38);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(630, 244, 77, 19);
		ProfileView.add(lblUsername);

		JLabel lblSetName = new JLabel("liza(098914678)");
		lblSetName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetName.setBounds(772, 244, 131, 19);
		ProfileView.add(lblSetName);

		JLabel lblSetRole = new JLabel("admin");
		lblSetRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetRole.setBounds(772, 318, 47, 19);
		ProfileView.add(lblSetRole);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRole.setBounds(630, 318, 34, 19);
		ProfileView.add(lblRole);

		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStartDate.setBounds(630, 393, 74, 19);
		ProfileView.add(lblStartDate);

		JLabel lblSetStart = new JLabel("12-12-2020");
		lblSetStart.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSetStart.setBounds(772, 393, 92, 19);
		ProfileView.add(lblSetStart);

		JLabel lblMo = new JLabel("Motivational quotes");
		lblMo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMo.setBounds(630, 461, 150, 19);
		ProfileView.add(lblMo);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(330, 561, 97, 34);
		ProfileView.add(btnBack);

		txtSetQuote = new JTextField();
		txtSetQuote.setColumns(10);
		txtSetQuote.setBounds(630, 492, 273, 26);
		ProfileView.add(txtSetQuote);
		contentPane.add(ProfileView);
		ProfileView.setLayout(null);
//======================================================================

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(0, 143, 185, 41);
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
		IssuesedBook.setVisible(true);
		IssuesedBook.add(IssueBook.issuetable());
		MemberTable.setVisible(false);
		MemberInput.setVisible(false);
//BookTable=====================================================
		BookTable.add(ReuseTable.TotalBook());
//		IssuesedBook.setToolTipText("");
//Return book===================================================
		ReturnBook2.setBackground(Color.WHITE);
		ReturnBook2.setBounds(220, 133, 989, 645);
		ReturnBook2.setVisible(false);
		MemberTable.setVisible(false);
		MemberInput.setVisible(false);
		BookTable.setVisible(false);
		BookInput.setVisible(false);

		// AddIssuesedBook==============================================

		AddIssuesedBook.setBackground(Color.WHITE);
		AddIssuesedBook.setBounds(220, 133, 989, 645);
		AddIssuesedBook.setVisible(false);

		// IssuesedBook

		IssuesedBook.setBackground(Color.WHITE);
		IssuesedBook.setBounds(220, 133, 989, 645);
		IssuesedBook.setVisible(true);

		// AddReturnedBook

		AddReturnedBook.setBackground(Color.WHITE);
		AddReturnedBook.setBounds(220, 133, 989, 645);
		AddReturnedBook.setVisible(false);

		// MainMenu

		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		MainMenu.setVisible(true);
		contentPane.add(MainMenu);

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
		contentPane.add(AddReturnedBook);
		AddReturnedBook.setLayout(null);

		JLabel lblbookid = new JLabel("Book ID");
		lblbookid.setBounds(50, 67, 97, 16);
		AddReturnedBook.add(lblbookid);

		txtBookID = new JTextField();
		txtBookID.setColumns(10);
		txtBookID.setBounds(50, 95, 319, 34);
		AddReturnedBook.add(txtBookID);

		JButton btnSearch = new JButton("Search");
		btnSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setBounds(712, 67, 241, 62);
		AddReturnedBook.add(btnSearch);

		String[] AddReturnedHeadder = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] AddReturnedData = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		JTable TableAddReturnedBook = new JTable(AddReturnedData, AddReturnedHeadder);
		JScrollPane ScrollAddReturnedBook = new JScrollPane(TableAddReturnedBook);
		ScrollAddReturnedBook.setBounds(50, 142, 903, 490);
		AddReturnedBook.add(ScrollAddReturnedBook);

		txtMemberID = new JTextField();
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(381, 95, 319, 34);
		AddReturnedBook.add(txtMemberID);

		JLabel lblMenberId = new JLabel("Menber ID");
		lblMenberId.setBounds(381, 67, 97, 16);
		AddReturnedBook.add(lblMenberId);
		IssuesedBook.setToolTipText("");

		IssuesedBook.setBackground(Color.WHITE);
		IssuesedBook.setBounds(220, 133, 989, 645);
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);

		JLabel labelbookid = new JLabel("Book ID :");
		labelbookid.setBounds(12, 13, 100, 35);
		IssuesedBook.add(labelbookid);

		txtBookID = new JTextField();
		txtBookID.setColumns(10);
		txtBookID.setBounds(124, 15, 300, 35);
		IssuesedBook.add(txtBookID);

		JLabel lblMemberID = new JLabel("Menber ID :");
		lblMemberID.setBounds(436, 13, 100, 35);
		IssuesedBook.add(lblMemberID);

		txtMemberID = new JTextField();
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(548, 13, 300, 35);
		IssuesedBook.add(txtMemberID);

		JButton btnOK = new JButton("OK");
		btnOK.setBackground(new Color(0, 0, 102));
		btnOK.setForeground(Color.WHITE);
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnOK.setBounds(860, 13, 115, 35);
		IssuesedBook.add(btnOK);

		IssuesedBook.setVisible(false);
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

		JLabel lblBookTitle = new JLabel("Book Title ");
		lblBookTitle.setBounds(50, 141, 97, 16);
		AddIssuesedBook.add(lblBookTitle);

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
				AddIssueTable.Issuemodel
						.addRow(new Object[] { (on++), txtMember.getText(), txtBookTitle.getText(), txtQty.getText(),
								txtIssueYear.getText() + '-' + txtIssueMonth.getText() + '-' + txtIssueDay.getText(),
								txtDueYear.getText() + '-' + txtDueMonth.getText() + '-' + txtDueDay.getText(),
								txtPrice.getText() });
			}
		});
		lblIssuesedBook.setBackground(Color.GREEN);
		lblIssuesedBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssuesedBook.setBounds(738, 258, 219, 95);
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
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setBackground(Color.GREEN);
		button.setBounds(738, 137, 219, 95);
		AddIssuesedBook.add(button);
		ReturnBook2.add(ReturnBook.TotalBook());
		contentPane.add(ReturnBook2);
		ReturnBook2.setLayout(null);
		String[] AddIssuseHeadder = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] AddIssuseData = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		AddIssuesBook = new JTable(AddIssuseData, AddIssuseHeadder);
		JScrollPane ScrollAddIssuesBook = new JScrollPane(AddIssuesBook);
		ScrollAddIssuesBook.setBounds(50, 366, 903, 266);
		AddIssuesedBook.add(ScrollAddIssuesBook);

		// AddReturnedBook

		AddReturnedBook.setBackground(Color.WHITE);
		AddReturnedBook.setBounds(220, 133, 989, 645);
		AddReturnedBook.setVisible(false);
		ReturnedBook.setBackground(Color.WHITE);
		ReturnedBook.setBounds(220, 133, 989, 645);
		ReturnedBook.setVisible(true);
		ReturnedBook.setToolTipText("");

		JTable TableReturnedBook = new JTable(data, headder);
		JScrollPane ScrollTableReturnedBook = new JScrollPane(TableReturnedBook);
		ScrollTableReturnedBook.setBounds(12, 109, 965, 523);
		ReturnedBook.add(ScrollTableReturnedBook);

		ReturnedBook.setBackground(Color.WHITE);
		ReturnedBook.setBounds(220, 133, 989, 645);
		contentPane.add(ReturnedBook);
		ReturnedBook.setLayout(null);
		contentPane.add(ReturnedBook);
		ReturnedBook.setLayout(null);

		JLabel lblBookID = new JLabel("Book ID :");
		lblBookID.setBounds(12, 13, 100, 35);
		ReturnedBook.add(lblBookID);

		txtBookID = new JTextField();
		txtBookID.setColumns(10);
		txtBookID.setBounds(124, 15, 300, 35);
		ReturnedBook.add(txtBookID);

		JLabel lblMemberid = new JLabel("Menber ID :");
		lblMemberid.setBounds(436, 13, 100, 35);
		ReturnedBook.add(lblMemberid);

		txtMemberID = new JTextField();
		txtMemberID.setColumns(10);
		txtMemberID.setBounds(548, 13, 300, 35);
		ReturnedBook.add(txtMemberID);

		JButton btnok = new JButton("OK");
		btnok.setBackground(new Color(0, 0, 102));
		btnok.setForeground(Color.WHITE);
		btnok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnok.setBounds(860, 13, 115, 35);
		ReturnedBook.add(btnok);

		ReturnedBook.setVisible(false);
		BookInput.setVisible(false);

		// Input Book

		BookInput.setBackground(Color.WHITE);
		BookInput.setBounds(220, 133, 989, 645);
		contentPane.add(BookInput);
		BookInput.setLayout(null);

		txtFristname = new JTextField();
		txtFristname.setBounds(43, 62, 288, 34);
		BookInput.add(txtFristname);
		txtFristname.setColumns(10);

		JLabel lblBooktitle = new JLabel("Book title");
		lblBooktitle.setBounds(43, 34, 97, 16);
		BookInput.add(lblBooktitle);

		JLabel lblLastName = new JLabel("Language");
		lblLastName.setBounds(438, 34, 97, 16);
		BookInput.add(lblLastName);

		txtLanguage = new JTextField();
		txtLanguage.setColumns(10);
		txtLanguage.setBounds(438, 62, 288, 34);
		BookInput.add(txtLanguage);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(43, 108, 97, 16);
		BookInput.add(lblAuthor);

		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(43, 136, 288, 34);
		BookInput.add(txtAuthor);

		JLabel lblPublish = new JLabel("Publish at   ( day / month / year )");
		lblPublish.setBounds(438, 108, 277, 16);
		BookInput.add(lblPublish);

		txtPublishDay = new JTextField();
		txtPublishDay.setColumns(10);
		txtPublishDay.setBounds(438, 136, 82, 34);
		BookInput.add(txtPublishDay);

		txtPublishMonth = new JTextField();
		txtPublishMonth.setColumns(10);
		txtPublishMonth.setBounds(532, 136, 82, 34);
		BookInput.add(txtPublishMonth);

		txtPublishYear = new JTextField();
		txtPublishYear.setColumns(10);
		txtPublishYear.setBounds(626, 136, 96, 34);
		BookInput.add(txtPublishYear);

		JLabel lblStatus = new JLabel("Category");
		lblStatus.setBounds(43, 182, 97, 16);
		BookInput.add(lblStatus);

		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(43, 210, 288, 34);
		BookInput.add(comboBox_1);

		JLabel labelStatus = new JLabel("Status");
		labelStatus.setBounds(438, 182, 97, 16);
		BookInput.add(labelStatus);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setBounds(438, 214, 288, 34);
		BookInput.add(comboBox_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(224, 310, 122, 34);
		BookInput.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAdd = new JLabel("Add");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(0, 0, 122, 34);
		panel_1.add(lblAdd);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(438, 310, 122, 34);
		BookInput.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblCancel = new JLabel("Cancel");
		lblCancel.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancel.setBounds(0, 0, 122, 34);
		panel_3.add(lblCancel);
		contentPane.add(MainMenu);

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
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);

		String[] row = { "No", "Book Title", "Book ID", "Member Name", "Member ID", "Issuesed Date", "Due Date",
				"Due Date" };

		String[][] col = {
				{ "1", "Book Title", "Book ID", "Member Name", "Member ID", "Issuesed Date", "Due Date", "Due Date" },
				{ "2", "Book Title", "Book ID", "Member Name", "Member ID", "Issuesed Date", "Due Date", "Due Date" } };

		// BOOK

		BookItem.setBackground(new Color(0, 0, 51));
		BookItem.setBounds(0, 263, 185, 475);
		BookItem.setLayout(null);
		BookItem.setVisible(false);
		Drawer.add(BookItem);

		BookItem.add(DrawerItem.drawerItem("Create category", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Create category");
//				MainMenu.setVisible(false);
//				MemberInput.setVisible(false);
//				MemberTable.setVisible(false);
//				BookTable.setVisible(false);
//				IssuesedBook.setVisible(false);
//				AboutUs.setVisible(false);
//				BookInput.setVisible(true);
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
			}
		}));
		BookItem.add(DrawerItem.drawerItem("Import Book", 46 * 2, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Import Book");
//				MainMenu.setVisible(false);
//				MemberInput.setVisible(false);
//				MemberTable.setVisible(false);
//				BookTable.setVisible(false);
//				IssuesedBook.setVisible(false);
//				AboutUs.setVisible(false);
//				BookInput.setVisible(true);
			}
		}));

		// Book Table
		MemberTable.setVisible(false);
		MemberInput.setVisible(false);
		BookTable.setVisible(false);
		BookTable.setToolTipText("");

		BookTable.setBackground(Color.WHITE);
		BookTable.setBounds(220, 133, 989, 645);
		contentPane.add(BookTable);
		BookTable.setLayout(null);

		JLabel lbBookID = new JLabel("Book ID");
		lbBookID.setBounds(12, 13, 158, 35);
		BookTable.add(lbBookID);

		txtBookID = new JTextField();
		txtBookID.setBounds(22, 61, 280, 35);
		BookTable.add(txtBookID);
		txtBookID.setColumns(10);

		JButton btFilterResults = new JButton("Search");
		btFilterResults.setBounds(728, 58, 200, 40);
		btFilterResults.setBackground(Color.WHITE);
		btFilterResults.setForeground(Color.GRAY);
		BookTable.add(btFilterResults);
		table = new JTable(datas, header);
		JScrollPane ScrollBookTable = new JScrollPane(table);
		ScrollBookTable.setBounds(12, 109, 965, 523);
		BookTable.add(ScrollBookTable);

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
				AddReturnedBook.setVisible(false);
				AddIssuesedBook.setVisible(false);
				ReturnBook2.setVisible(false);
				ProfileView.setVisible(false);
			}
		});

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setHorizontalAlignment(SwingConstants.LEFT);
		lblDashboard.setBounds(20, 0, 160, 46);
		lblDashboard.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		dashBoard.add(lblDashboard);
		lblDashboard.setForeground(Color.WHITE);

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
				ReturnedBook.setVisible(false);
				AddIssuesedBook.setVisible(true);

			}
		}));

		ReturnedbookItem.setBackground(new Color(0, 0, 51));
		ReturnedbookItem.setBounds(0, 263, 185, 475);
		ReturnedbookItem.setLayout(null);
		ReturnedbookItem.setVisible(false);
		Drawer.add(ReturnedbookItem);

		ReturnedbookItem.add(DrawerItem.drawerItem("Add Returned book", 0, new ButtonClick() {
			public void action() {
				lblNewLabel.setText("Add Returned book");
				MainMenu.setVisible(false);
				MemberTable.setVisible(false);
				BookTable.setVisible(false);
				BookInput.setVisible(false);
				IssuesedBook.setVisible(false);
				AboutUs.setVisible(false);
				ReturnedBook.setVisible(false);
				AddReturnedBook.setVisible(true);
			}
		}));
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

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		comboBox.setBounds(43, 136, 120, 34);
		MemberInput.add(comboBox);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(43, 182, 61, 16);
		MemberInput.add(lblMonth);

		final JComboBox<String> txtMonth = new JComboBox<String>();
		txtMonth.setModel(new DefaultComboBoxModel<String>(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		txtMonth.setBounds(43, 210, 204, 34);
		MemberInput.add(txtMonth);

		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(307, 182, 61, 16);
		MemberInput.add(lblDay);

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

		JLabel lblrole = new JLabel("Role");
		lblrole.setBounds(211, 108, 61, 16);
		MemberInput.add(lblrole);

		JComboBox<String> comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(211, 136, 120, 34);
		MemberInput.add(comboBox_2);

		JLabel lblAddress = new JLabel("Your birthday");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setBounds(736, 218, 102, 16);
		MemberInput.add(lblAddress);

		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(43, 259, 97, 16);
		MemberInput.add(lblAddress_1);

		final JTextArea txtAddress = new JTextArea();
		txtAddress.setBackground(new Color(204, 204, 204));
		txtAddress.setBounds(43, 287, 432, 147);
		MemberInput.add(txtAddress);

		JLabel lblCreate = new JLabel("Create");
		lblCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print(txtMonth.getSelectedItem().toString());
			}
		});
		lblCreate.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreate.setBounds(211, 525, 117, 34);
		MemberInput.add(lblCreate);

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

		JComboBox<String> comboBoxSex = new JComboBox<String>();
		comboBoxSex.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		comboBoxSex.setBounds(43, 136, 120, 34);
		MemberInput.add(comboBoxSex);

		JLabel lblMonths = new JLabel("Month");
		lblMonths.setBounds(43, 182, 61, 16);
		MemberInput.add(lblMonths);

		final JComboBox<String> txtMonths = new JComboBox<String>();
		txtMonths.setModel(new DefaultComboBoxModel<String>(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		txtMonths.setBounds(43, 210, 204, 34);
		MemberInput.add(txtMonths);

		JLabel lblDays = new JLabel("Day");
		lblDays.setBounds(307, 182, 61, 16);
		MemberInput.add(lblDays);

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

		JLabel lableMemberID = new JLabel("Member ID");
		lableMemberID.setBounds(12, 13, 158, 35);
		MemberTable.add(lableMemberID);

		txtMemberID = new JTextField();
		txtMemberID.setBounds(22, 61, 280, 35);
		MemberTable.add(txtMemberID);
		txtMemberID.setColumns(10);

		JButton btnFilterResult = new JButton("Search");
		btnFilterResult.setBounds(728, 58, 200, 40);
		MemberTable.add(btnFilterResult);

		JTable TableMember = new JTable(dates, headMember);
		JScrollPane SrcollTableMember = new JScrollPane(TableMember);
		SrcollTableMember.setBounds(12, 109, 965, 523);
		MemberTable.add(SrcollTableMember);

		// About Us

		AboutUs.setToolTipText("");

		AboutUs.setBackground(Color.WHITE);
		AboutUs.setBounds(220, 133, 989, 645);
		contentPane.add(AboutUs);
		AboutUs.setLayout(null);

		JLabel lblRUPP = new JLabel(new ImageIcon("D:\\JavaE1C21\\LibraryY3\\img\\rupp-logo.png"));
		lblRUPP.setBounds(29, 13, 100, 100);
		AboutUs.add(lblRUPP);

		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setBounds(349, 13, 630, 100);
		AboutUs.add(lblAboutUs);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(349, 126, 630, 506);
		AboutUs.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setBounds(12, 13, 150, 35);
		panel_4.add(lblProfessor);

		JLabel lblChiKoung = new JLabel("Chi Koung");
		lblChiKoung.setBounds(174, 13, 444, 35);
		panel_4.add(lblChiKoung);

		JLabel label_5 = new JLabel("New label");
		label_5.setBounds(174, 61, 170, 35);
		panel_4.add(label_5);

		JLabel lblGroupMembers = new JLabel("Group Members");
		lblGroupMembers.setBounds(12, 61, 150, 35);
		panel_4.add(lblGroupMembers);

		JLabel label_6 = new JLabel("New label");
		label_6.setBounds(356, 61, 170, 35);
		panel_4.add(label_6);

		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(174, 109, 170, 35);
		panel_4.add(label_7);

		JLabel lblOrnSophea = new JLabel("Orn Sophea");
		lblOrnSophea.setBounds(356, 109, 170, 35);
		panel_4.add(lblOrnSophea);

		JLabel lblPurposeOfThe = new JLabel("Purpose of the program");
		lblPurposeOfThe.setBounds(12, 157, 606, 50);
		panel_4.add(lblPurposeOfThe);

		JLabel lblPurpose = new JLabel("New label");
		lblPurpose.setBounds(12, 220, 606, 273);
		panel_4.add(lblPurpose);

		JLabel lblLibraryManagementSystem = new JLabel("Library Management System ");
		lblLibraryManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblLibraryManagementSystem.setBounds(12, 228, 325, 80);
		AboutUs.add(lblLibraryManagementSystem);

		JLabel lblVYear = new JLabel("Year 2019-2020 v1.0 ");
		lblVYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblVYear.setBounds(12, 321, 325, 80);
		AboutUs.add(lblVYear);

	}
}
