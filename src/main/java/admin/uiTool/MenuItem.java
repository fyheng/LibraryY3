package admin.uiTool;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import admin.function.ClickMethod;
import picture.GetIcon;
import picture.Icons;

public class MenuItem {
	//This is function
	public static JPanel menu(String title,int dataQty,Icons icon,final Color color,final Color hoverColor,int x,int y,final ClickMethod buttonClick) {
		final JPanel TotalBookBtn = new JPanel();
		final JLabel label = new JLabel("");
		TotalBookBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				TotalBookBtn.setBackground(color);
				label.setText("");
			}
		});
		TotalBookBtn.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				TotalBookBtn.setBackground(hoverColor);
				label.setText("View more");
			}
		});
		TotalBookBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buttonClick.action();
			}
		});
		TotalBookBtn.setBackground(color);
		TotalBookBtn.setBounds(x, y, 224, 119);
		TotalBookBtn.setLayout(null);
		
		
		
		JLabel lblNewLabel_1 = new JLabel(title);
		lblNewLabel_1.setBounds(27, 78, 197, 41);
		TotalBookBtn.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Seravek", Font.BOLD, 20));
		
		JLabel TotalBookIcon = new JLabel("");
		TotalBookIcon.setIcon(GetIcon.setIcon(icon));
		TotalBookIcon.setBounds(124, 0, 100, 119);
		TotalBookBtn.add(TotalBookIcon);
		
		JLabel qty = new JLabel(dataQty+"");
		qty.setForeground(Color.WHITE);
		qty.setFont(new Font("Seravek", Font.BOLD, 30));
		qty.setBounds(27, 16, 61, 41);
		TotalBookBtn.add(qty);
		
		
		label.setForeground(Color.WHITE);
		label.setBounds(75, 50, 100, 16);
		TotalBookBtn.add(label);
		
		return TotalBookBtn;
	}
}
