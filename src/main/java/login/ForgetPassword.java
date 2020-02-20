package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ForgetPassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblConfirmPassword;
	private JPasswordField txtConfirmPassword;
	private JLabel lblVerifyCode;
	private JTextField txtVerifyCode;
	static ForgetPassword frame = new ForgetPassword();
	public Boolean check = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ForgetPassword frame = new ForgetPassword();
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
	public ForgetPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewPassword = new JLabel("Username");
		lblNewPassword.setBounds(16, 18, 130, 16);
		contentPane.add(lblNewPassword);

		txtUsername = new JTextField();
		txtUsername.setBounds(16, 46, 275, 37);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(16, 95, 139, 16);
		contentPane.add(lblNewLabel);

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(16, 123, 275, 37);
		contentPane.add(txtPassword);

		final JCheckBox chckbxShowPassword = new JCheckBox("show password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JPasswordField) txtPassword).setEchoChar(chckbxShowPassword.isSelected() ? '\u0000'
						: (Character) UIManager.get("PasswordField.echoChar"));
				((JPasswordField) txtConfirmPassword).setEchoChar(chckbxShowPassword.isSelected() ? '\u0000'
						: (Character) UIManager.get("PasswordField.echoChar"));
			}
		});
		chckbxShowPassword.setBounds(161, 249, 130, 23);
		contentPane.add(chckbxShowPassword);

		lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(16, 172, 139, 16);
		contentPane.add(lblConfirmPassword);

		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBounds(16, 200, 275, 37);
		contentPane.add(txtConfirmPassword);

		lblVerifyCode = new JLabel("Verify code");
		lblVerifyCode.setBounds(16, 281, 139, 16);
		contentPane.add(lblVerifyCode);

		txtVerifyCode = new JTextField();
		txtVerifyCode.setColumns(10);
		txtVerifyCode.setBounds(16, 309, 275, 37);
		contentPane.add(txtVerifyCode);

		JButton btnGetVerifyCode = new JButton("request code");
		btnGetVerifyCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> varlidateData = Validate.getUserName(txtUsername.getText());

				if (varlidateData != null) {

					if (txtUsername.getText().equals(varlidateData.get(3))) {//compare userName
						setBounds(100, 100, 430, 480);
						Validate.sendMail(varlidateData.get(5).toString());
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "UserName not Found!!!", "Fail", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnGetVerifyCode.setBounds(298, 51, 117, 29);
		contentPane.add(btnGetVerifyCode);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtPassword.getText().equals(txtConfirmPassword.getText())) {

					if (txtVerifyCode.getText().equals(Validate.confirmCode)) {
						JOptionPane.showMessageDialog(contentPane, "change password Success", "Success",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnConfirm.setBounds(65, 381, 117, 29);
		contentPane.add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		});
		btnCancel.setBounds(245, 381, 117, 29);
		contentPane.add(btnCancel);
	}
}
