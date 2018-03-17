import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class employee_details extends JFrame {
	public employee_details() {
		getContentPane().setLayout(null);
		
		JLabel lblSupplierId = new JLabel("EMPLOYEE ID:");
		lblSupplierId.setBounds(44, 36, 142, 16);
		getContentPane().add(lblSupplierId);
		lblSupplierId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblSupplierName = new JLabel("EMPLOYEE NAME:");
		lblSupplierName.setBounds(44, 82, 131, 16);
		getContentPane().add(lblSupplierName);
		lblSupplierName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel lblNewLabel = new JLabel("DESIGNATION :");
		lblNewLabel.setBounds(44, 133, 131, 16);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empid w;
				
				try {
					w = new empid();
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
		
		JLabel label = new JLabel(empid.id1);
		label.setBounds(190, 36, 158, 24);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel(empid.empname);
		label_1.setBounds(187, 71, 200, 31);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel(empid.designation);
		label_2.setBounds(163, 133, 200, 29);
		getContentPane().add(label_2);
	}
}

