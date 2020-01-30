package admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Menu;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import picture.GetIcon;
import picture.Icons;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

public class Home extends JFrame {

	private JPanel contentPane;
	GetIcon icon;
//	AdminMenu menu = new AdminMenu();

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
	 */
	public Home() {
//		ImageIcon icon = new ImageIcon(Home.class.getResource("/picture/bookicon.png")); 
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
		
		JPanel MainMenu = new JPanel();
		MainMenu.setBackground(Color.WHITE);
		MainMenu.setBounds(220, 133, 989, 645);
		contentPane.add(MainMenu);
		MainMenu.setLayout(null);
		
		JPanel TotalBookBtn = new JPanel();
		TotalBookBtn.setBackground(new Color(57, 124, 188));
		TotalBookBtn.setBounds(31, 21, 224, 119);
		MainMenu.add(TotalBookBtn);
		TotalBookBtn.setLayout(null);
		
		JLabel TotalBookIcon = new JLabel("");
		TotalBookIcon.setIcon(GetIcon.setIcon(Icons.User));
		TotalBookIcon.setBounds(124, 0, 100, 119);
		TotalBookBtn.add(TotalBookIcon);
		
		JLabel lblNewLabel_1 = new JLabel("Total book");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Seravek", Font.BOLD, 20));
		lblNewLabel_1.setBounds(27, 78, 197, 41);
		TotalBookBtn.add(lblNewLabel_1);
		
		JPanel IssueBookBtn = new JPanel();
		IssueBookBtn.setBackground(new Color(75, 163, 97));
		IssueBookBtn.setBounds(267, 21, 224, 119);
		MainMenu.add(IssueBookBtn);
		IssueBookBtn.setLayout(null);
		
		JLabel IssueBookIcon = new JLabel("");
		IssueBookIcon.setBounds(124, 0, 100, 119);
		IssueBookBtn.add(IssueBookIcon);
		IssueBookIcon.setIcon(GetIcon.setIcon(Icons.User));
		
		JLabel lblIssueBook = new JLabel("Issue book");
		lblIssueBook.setForeground(Color.WHITE);
		lblIssueBook.setFont(new Font("Seravek", Font.BOLD, 20));
		lblIssueBook.setBounds(27, 78, 197, 41);
		IssueBookBtn.add(lblIssueBook);
		
		JPanel ReturnBookBtn = new JPanel();
		ReturnBookBtn.setBackground(new Color(231, 159, 62));
		ReturnBookBtn.setBounds(503, 21, 224, 119);
		MainMenu.add(ReturnBookBtn);
		ReturnBookBtn.setLayout(null);
		
		JLabel lblReturnbook = new JLabel("Book returned");
		lblReturnbook.setForeground(Color.WHITE);
		lblReturnbook.setFont(new Font("Seravek", Font.BOLD, 20));
		lblReturnbook.setBounds(27, 78, 197, 41);
		ReturnBookBtn.add(lblReturnbook);
		
		JLabel ReturnBookIcon = new JLabel("");
		ReturnBookIcon.setBounds(124, 0, 100, 119);
		ReturnBookBtn.add(ReturnBookIcon);
		ReturnBookIcon.setIcon(GetIcon.setIcon(Icons.User));
		
		JPanel StaffBtn = new JPanel();
		StaffBtn.setBackground(new Color(230, 113, 93));
		StaffBtn.setBounds(739, 21, 224, 119);
		MainMenu.add(StaffBtn);
		StaffBtn.setLayout(null);
		
		JLabel StaffIcon = new JLabel("");
		StaffIcon.setBounds(124, 0, 100, 119);
		StaffBtn.add(StaffIcon);
		StaffIcon.setIcon(GetIcon.setIcon(Icons.User));
		
		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setForeground(Color.WHITE);
		lblStaff.setFont(new Font("Seravek", Font.BOLD, 20));
		lblStaff.setBounds(27, 78, 197, 41);
		StaffBtn.add(lblStaff);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 23));
		lblNewLabel.setBounds(220, 83, 93, 38);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(220, 113, 155, 12);
		contentPane.add(separator);
		
//		menu.setVisible(true);
//		contentPane.add(menu);
	}
}
