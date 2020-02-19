package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import admin.AdminHome;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField passwordtxt;
	private JTextField usernametxt;
	private JLabel lblNewLabel_2;
	private JLabel lblPassword;
	static Login frame = new Login();
	int count = 0;

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
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 0, 444, 38);
		contentPane.add(lblNewLabel);

		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		usernametxt.setBounds(108, 53, 325, 38);
		contentPane.add(usernametxt);

		passwordtxt = new JPasswordField();
		passwordtxt.setBounds(108, 103, 325, 38);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(17, 178, 416, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		final JLabel lblNewLabel_1 = new JLabel("Login\n");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (usernametxt.getText().length() == 0 || passwordtxt.getText().length() == 0) {
					JOptionPane.showMessageDialog(contentPane, "Please insert username and password", "Fail",
							JOptionPane.WARNING_MESSAGE);
				} else if (usernametxt.getText().equals("admin") && passwordtxt.getText().equals("admin")) {
					frame.setVisible(false);
					AdminHome home;
					try {
						home = new AdminHome();
						home.setVisible(true);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "Incorrect UserName Password", "Fail",
							JOptionPane.WARNING_MESSAGE);
					usernametxt.setText("");
					passwordtxt.setText("");
					usernametxt.requestFocusInWindow();	
					count++;
					if (count == 3) System.exit(0);
				}
			}
		});
		lblNewLabel_1.setBounds(0, 0, 416, 38);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(16, 53, 80, 38);
		contentPane.add(lblNewLabel_2);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(17, 103, 80, 38);
		contentPane.add(lblPassword);

		final JCheckBox showpassword = new JCheckBox("show password");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JPasswordField) passwordtxt).setEchoChar(
						showpassword.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
			}
		});
		showpassword.setBounds(304, 143, 129, 23);
		contentPane.add(showpassword);
	}
}
