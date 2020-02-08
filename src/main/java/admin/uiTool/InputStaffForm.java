package admin.uiTool;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import configDB.JDBC;

public class InputStaffForm {
	JPanel staffInput() {
		JPanel StaffInput = new JPanel();
StaffInput.setToolTipText("");
		
		
		StaffInput.setBackground(Color.WHITE);
		StaffInput.setBounds(220, 133, 989, 645);
		StaffInput.setLayout(null);

		JTextField txtFristname;
		JTextField txtLastname;
		final JTextField txtDay;
		JTextField txtYear;
		JTextField txtPhoneNumber;
		txtFristname = new JTextField();
		txtFristname.setBounds(43, 62, 288, 34);
		StaffInput.add(txtFristname);
		txtFristname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Frist name");
		lblNewLabel_1.setBounds(43, 34, 97, 16);
		StaffInput.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(438, 34, 97, 16);
		StaffInput.add(lblLastName);
		
		txtLastname = new JTextField();
		txtLastname.setColumns(10);
		txtLastname.setBounds(436, 62, 288, 34);
		StaffInput.add(txtLastname);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(43, 108, 97, 16);
		StaffInput.add(lblSex);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(43, 136, 120, 34);
		StaffInput.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Month");
		lblNewLabel_3.setBounds(43, 182, 61, 16);
		StaffInput.add(lblNewLabel_3);
		
		final JComboBox txtMonth = new JComboBox();
		txtMonth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		txtMonth.setBounds(43, 210, 204, 34);
		StaffInput.add(txtMonth);
		
		JLabel lblNewLabel_4 = new JLabel("Day");
		lblNewLabel_4.setBounds(307, 182, 61, 16);
		StaffInput.add(lblNewLabel_4);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(549, 182, 61, 16);
		StaffInput.add(lblYear);
		
		
		txtDay = new JTextField();
		txtDay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				String day = txtDay.getText();
				int lenght = day.length();
				char event = evt.getKeyChar();
				if(event>='0'&&event<='9') {
					if(lenght<2) {
						txtDay.setEditable(true);
					}else {
						txtDay.setEditable(false);
					}
				}else {
					if(evt.getExtendedKeyCode()==KeyEvent.VK_BACK_SPACE||evt.getExtendedKeyCode()==KeyEvent.VK_DELETE) {
						txtDay.setEditable(true);
					}else {
						txtDay.setEditable(false);
					}
				}
			}
		});
		txtDay.setBounds(307, 209, 175, 34);
		StaffInput.add(txtDay);
		txtDay.setColumns(10);
		
		
		txtYear = new JTextField();
		txtYear.setBounds(549, 209, 175, 34);
		StaffInput.add(txtYear);
		txtYear.setColumns(10);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(436, 135, 288, 34);
		StaffInput.add(txtPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(438, 108, 109, 16);
		StaffInput.add(lblPhoneNumber);
		
		JLabel lblNewLabel_5 = new JLabel("Role");
		lblNewLabel_5.setBounds(211, 108, 61, 16);
		StaffInput.add(lblNewLabel_5);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(211, 136, 120, 34);
		StaffInput.add(comboBox_2);
		
		JLabel lblAddress = new JLabel("Your birthday");
		lblAddress.setForeground(Color.LIGHT_GRAY);
		lblAddress.setBounds(736, 218, 102, 16);
		StaffInput.add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setBounds(43, 259, 97, 16);
		StaffInput.add(lblAddress_1);
		
		final JTextArea txtAddress = new JTextArea();
		txtAddress.setBackground(new Color(204, 204, 204));
		txtAddress.setBounds(43, 287, 432, 147);
		StaffInput.add(txtAddress);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(211, 525, 117, 34);
		StaffInput.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Create");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.print(txtMonth.getSelectedItem().toString());
				JDBC.setKey("version","start_at","SecUser_id","role_id","person_id");
				try {
					JDBC.insert("Staff", "2","2020-02-07","2","2",txtDay.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(0, 0, 117, 34);
		panel_1.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(498, 525, 117, 34);
		StaffInput.add(panel_2);
		return StaffInput;
	}
}
