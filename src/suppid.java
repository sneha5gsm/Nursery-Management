import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class suppid extends JFrame{
	private JTextField textField;
	static String id1;
	static String suppname;
	static String itemid;
	public suppid() throws ClassNotFoundException, SQLException {
		getContentPane().setLayout(null);
		
		JLabel lblEnterSupplierId = new JLabel("ENTER SUPPLIER ID:");
			lblEnterSupplierId.setBounds(23, 84, 154, 16);
		getContentPane().add(lblEnterSupplierId);
		lblEnterSupplierId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setBounds(218, 81, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		JButton btnEnter = new JButton("ENTER");
		btnEnter.setBounds(147, 164, 97, 25);
		getContentPane().add(btnEnter);
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
		Statement stmt=con.createStatement(); 
		ResultSet rs=stmt.executeQuery("select * from supplier"); 
		id1=textField.getText();
		int f=1;
		while(rs.next()) {
			if(id1.equals(rs.getString(1))){
				f=0;
				suppname=rs.getString(2);
				itemid=rs.getString(3);
				
			}
			
		
		}
		if(f==1){
			wronginfo w=new wronginfo();
			w.setBounds(100,100,450,300);
			w.setVisible(true);
			dispose();
		}
	
		btnEnter.setBounds(147, 164, 97, 25);
		getContentPane().add(btnEnter);
		btnEnter.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				supplier_details s=new supplier_details();
				s.setBounds(100,100, 450, 300);
				s.setVisible(true);
				dispose();
			}
		});
		
		
	}
}
