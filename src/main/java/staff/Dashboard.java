package staff;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import admin.function.ButtonClick;
import admin.table.IssueBook;
import admin.table.ReturnBook;
import admin.table.ReuseTable;
import admin.uiTool.DrawerItem;
import admin.uiTool.MenuItem;
import configDB.JDBC;
import picture.GetIcon;
import picture.Icons;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;

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
	private JTextField txtFristname;
	private JTextField txtLastname;
	private JTextField txtDay;
	private JTextField txtYear;
	private JTextField txtPhoneNumber;
	private JTextField textField;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTable AddIssuse;

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
		ProfileIcon.setHorizontalAlignment(SwingConstants.CENTER);
		ProfileIcon.setBounds(0, 0, 185, 146);
		Drawer.add(ProfileIcon);
		ProfileIcon.setIcon(GetIcon.setIcon(Icons.MaleUser));

		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(0, 143, 185, 41);
		Drawer.add(lblNewLabel_2);

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
		ReturnBook2.add(ReturnBook.TotalBook());
		contentPane.add(ReturnBook2);
		ReturnBook2.setLayout(null);

// AddIssuesedBook==============================================

		AddIssuesedBook.setBackground(Color.WHITE);
		AddIssuesedBook.setBounds(220, 133, 989, 645);
		AddIssuesedBook.setVisible(false);
		contentPane.add(AddIssuesedBook);
		AddIssuesedBook.setLayout(null);

		JLabel lblMenberName = new JLabel("Menber Name");
		lblMenberName.setBounds(50, 67, 97, 16);
		AddIssuesedBook.add(lblMenberName);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(50, 95, 679, 34);
		AddIssuesedBook.add(textField_9);

		JLabel lblBookId = new JLabel("Book Title ");
		lblBookId.setBounds(50, 141, 97, 16);
		AddIssuesedBook.add(lblBookId);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(50, 169, 319, 34);
		AddIssuesedBook.add(textField_10);

		JLabel lblIssuesDate = new JLabel("Issues Date ( day / month / year )");
		lblIssuesDate.setBounds(445, 141, 277, 16);
		AddIssuesedBook.add(lblIssuesDate);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(445, 169, 82, 34);
		AddIssuesedBook.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(539, 169, 82, 34);
		AddIssuesedBook.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(633, 169, 96, 34);
		AddIssuesedBook.add(textField_13);

		JButton lblIssuesedBook = new JButton("Add");
		lblIssuesedBook.setBackground(Color.GREEN);
		lblIssuesedBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblIssuesedBook.setBounds(738, 258, 219, 95);
		AddIssuesedBook.add(lblIssuesedBook);

		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(50, 216, 97, 16);
		AddIssuesedBook.add(lblQty);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(50, 244, 319, 34);
		AddIssuesedBook.add(textField_14);

		JLabel lblDueDate = new JLabel("Due Date ( day / month / year )");
		lblDueDate.setBounds(445, 216, 277, 16);
		AddIssuesedBook.add(lblDueDate);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(445, 244, 82, 34);
		AddIssuesedBook.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(539, 244, 82, 34);
		AddIssuesedBook.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(633, 244, 96, 34);
		AddIssuesedBook.add(textField_17);

		JLabel lblBookPrices = new JLabel("Book Prices ");
		lblBookPrices.setBounds(50, 291, 97, 16);
		AddIssuesedBook.add(lblBookPrices);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(50, 319, 319, 34);
		AddIssuesedBook.add(textField_18);

		JButton button = new JButton("Issuesed Book");
		button.setHorizontalAlignment(SwingConstants.CENTER);
		button.setBackground(Color.GREEN);
		button.setBounds(738, 137, 219, 95);
		AddIssuesedBook.add(button);
		
		String[] head = { "No", "Title", "Book Number", "Qty", "Price" };

		String[][] date = { { "1", "All The Light You Can`t See", "001", "23", "40.00" },
				{ "2", "Leadership", "002", "34", "40.50" } };

		AddIssuse = new JTable(date, head);
		AddIssuse.setBounds(50, 631, 907, -256);
		AddIssuesedBook.add(AddIssuse);

		IssuesedBook.setBackground(Color.WHITE);
		IssuesedBook.setBounds(220, 133, 989, 645);
		contentPane.add(IssuesedBook);
		IssuesedBook.setLayout(null);

		// AddReturnedBook
		AddReturnedBook.setBackground(Color.WHITE);
		AddReturnedBook.setBounds(220, 133, 989, 645);
		AddReturnedBook.setVisible(false);

		// MainMenu

		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		MainMenu.setVisible(true);
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

		JLabel lblNewLabel_1 = new JLabel("Book title");
		lblNewLabel_1.setBounds(43, 34, 97, 16);
		BookInput.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Language");
		lblLastName.setBounds(438, 34, 97, 16);
		BookInput.add(lblLastName);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(438, 62, 288, 34);
		BookInput.add(textField_4);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(43, 108, 97, 16);
		BookInput.add(lblAuthor);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(43, 136, 288, 34);
		BookInput.add(textField_5);

		JLabel lblPublish = new JLabel("Publish at   ( day / month / year )");
		lblPublish.setBounds(438, 108, 277, 16);
		BookInput.add(lblPublish);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(438, 136, 82, 34);
		BookInput.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(532, 136, 82, 34);
		BookInput.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(626, 136, 96, 34);
		BookInput.add(textField_8);

		JLabel lblStatus = new JLabel("Category");
		lblStatus.setBounds(43, 182, 97, 16);
		BookInput.add(lblStatus);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(43, 210, 288, 34);
		BookInput.add(comboBox_1);

		JLabel label_2 = new JLabel("Status");
		label_2.setBounds(438, 182, 97, 16);
		BookInput.add(label_2);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(438, 214, 288, 34);
		BookInput.add(comboBox_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(224, 310, 122, 34);
		BookInput.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Add");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 122, 34);
		panel_1.add(lblNewLabel_6);

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

		// About Us

		AboutUs.setToolTipText("");

		AboutUs.setBackground(Color.WHITE);
		AboutUs.setBounds(220, 133, 989, 645);
		contentPane.add(AboutUs);
		AboutUs.setLayout(null);

		// Book Table
		MemberTable.setVisible(false);
		MemberInput.setVisible(false);
		BookTable.setVisible(false);
		IssuesedBook.setVisible(false);
		BookTable.setToolTipText("");

		BookTable.setBackground(Color.WHITE);
		BookTable.setBounds(220, 133, 989, 645);
		contentPane.add(BookTable);
		BookTable.setLayout(null);

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

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBox.setBounds(43, 136, 120, 34);
		MemberInput.add(comboBox);

		JLabel lblNewLabel_3 = new JLabel("Month");
		lblNewLabel_3.setBounds(43, 182, 61, 16);
		MemberInput.add(lblNewLabel_3);

		final JComboBox txtMonth = new JComboBox();
		txtMonth.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December" }));
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

		JComboBox comboBox_2 = new JComboBox();
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

		JComboBox comboBoxSex = new JComboBox();
		comboBoxSex.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		comboBoxSex.setBounds(43, 136, 120, 34);
		MemberInput.add(comboBoxSex);

		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(43, 182, 61, 16);
		MemberInput.add(lblMonth);

		final JComboBox txtMonths = new JComboBox();
		txtMonths.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November", "December" }));
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
		
	}
}
