package admin.uiTool;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import admin.AdminHome;
import login.Login;
import picture.GetIcon;
import picture.Icons;

public class Header {
	static Login login = new Login();
	public static JPanel header() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 1240, 72);
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
		return panel;
	}
}
