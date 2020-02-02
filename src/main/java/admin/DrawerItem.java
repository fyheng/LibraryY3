package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DrawerItem {
	public static JPanel drawerItem(String title,int y,final ClickMethod buttonClick) {
		final JPanel item1 = new JPanel();
		item1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				item1.setBackground(new Color(0, 51, 102));
			}
		});
		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				item1.setBackground(new Color(0, 0, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonClick.action();
			}
		});
		item1.setBackground(new Color(0, 0, 51));
		item1.setBounds(0, y, 185, 46);
		item1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel(title);
		lblNewLabel_3.setBounds(20, 0, 160, 46);
		item1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);
		return item1;
	}
}

