package admin;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class AdminMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdminMenu() {
		setBackground(Color.GREEN);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(175, 141, 61, 16);
		add(lblNewLabel);

	}

}
