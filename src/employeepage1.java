import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class employeepage1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeepage1 frame = new employeepage1();
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
	public employeepage1() {
		
		
		
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblId.setBounds(10, 11, 23, 35);
		contentPane.add(lblId);
		
		JLabel label = new JLabel(Integer.toString(login1.id));
		label.setBounds(39, 11, 144, 35);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("NAME: ");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(189, 11, 63, 34);
		contentPane.add(lblName);
		//System.out.println(login1.name);
		//System.out.println(login1.desig);
		JLabel label_1 = new JLabel(login1.name);
		label_1.setBounds(258, 11, 166, 35);
		contentPane.add(label_1);
		
		JLabel lblDesignation = new JLabel("DESIGNATION: ");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDesignation.setBounds(10, 52, 104, 35);
		contentPane.add(lblDesignation);
		
		JLabel label_2 = new JLabel(login1.desig);
		label_2.setBounds(120, 52, 200, 35);
		contentPane.add(label_2);
		
		JLabel lblSalary = new JLabel("SALARY: ");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setBounds(10, 89, 77, 35);
		contentPane.add(lblSalary);
		
		JLabel label_3 = new JLabel(Double.toString(login1.salary));
		label_3.setBounds(93, 89, 144, 35);
		contentPane.add(label_3);
		
		JLabel lblDepartmentId = new JLabel("DEPARTMENT ID: ");
		lblDepartmentId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDepartmentId.setBounds(10, 130, 156, 35);
		contentPane.add(lblDepartmentId);
		
		JLabel label_4 = new JLabel(Integer.toString(login1.did));
		label_4.setBounds(172, 131, 200, 34);
		contentPane.add(label_4);
		
		JLabel lblAddress = new JLabel("ADDRESS: ");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAddress.setBounds(10, 171, 110, 35);
		contentPane.add(lblAddress);
		
		JLabel label_5 = new JLabel(login1.address);
		label_5.setBounds(93, 171, 331, 35);
		contentPane.add(label_5);
		
		JLabel lblPhoneNumber = new JLabel("PHONE NUMBER: ");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhoneNumber.setBounds(10, 201, 144, 35);
		contentPane.add(lblPhoneNumber);
		
		JLabel label_6 = new JLabel(Long.toString(login1.number));
		label_6.setBounds(160, 201, 212, 35);
		contentPane.add(label_6);
		
		JButton btnBack = new JButton("LOGOUT");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 l=new login1();
				l.setBounds(100, 100, 450, 300);
				l.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(327, 227, 97, 23);
		contentPane.add(btnBack);
	}
}
