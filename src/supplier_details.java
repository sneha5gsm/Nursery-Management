import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class supplier_details extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public supplier_details() {
		getContentPane().setLayout(null);
		
		JLabel lblSupplierId = new JLabel("SUPPLIER ID:");
		lblSupplierId.setBounds(44, 36, 142, 16);
		getContentPane().add(lblSupplierId);
		lblSupplierId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblSupplierName = new JLabel("SUPPLIER NAME:");
		lblSupplierName.setBounds(44, 82, 131, 16);
		getContentPane().add(lblSupplierName);
		lblSupplierName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("ITEM ID:");
		lblNewLabel.setBounds(44, 133, 131, 16);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBounds(246, 33, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(suppid.id1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 79, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(suppid.suppname);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(246, 130, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(suppid.itemid);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				suppid w;
				
				try {
					w = new suppid();
					w.setBounds(100,100,450,300);
					w.setVisible(true);
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		btnNewButton.setBounds(44, 200, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 l=new login1();
				l.setBounds(100,100,450,300);
				l.setVisible(true);
				dispose();
			}
		});
		btnExit.setBounds(252, 200, 97, 25);
		getContentPane().add(btnExit);
	}

}
