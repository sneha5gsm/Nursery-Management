import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class details extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	static String name;
	static int q;
	static float price;
	static String dept;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					details frame = new details();
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
	public details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("ITEM ID:");
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblItemId.setBounds(52, 77, 99, 50);
		contentPane.add(lblItemId);
		
		textField = new JTextField();
		textField.setBounds(157, 77, 200, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			String t=textField.getText();
			int id=Integer.parseInt(t);
			
			
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select dept_id from dept_item where item_id="+id+"");
				ResultSet rs1;
				if(rs.next())
				{
					int n1=rs.getInt(1);
					if(n1==3)
					{
						dept="Plant";
						rs1=stmt.executeQuery("select * from plant where item_id="+id+"");
						rs1.next();
					
					name=rs1.getString(2);
					q=rs1.getInt(4);
					price=rs1.getFloat(5);
					}
				
					else if(n1==4)
					{
						dept="Fertiliser";
						rs1=stmt.executeQuery("select * from fertiliser where item_id="+id+"");
						rs1.next();
						
						name=rs1.getString(2);
						q=rs1.getInt(3);
						price=rs1.getFloat(4);
					}
					else
					{
						dept="tool";
						rs1=stmt.executeQuery("select * from tool where item_id="+id+"");
						rs1.next();
						
						name=rs1.getString(2);
						q=rs1.getInt(4);
						price=rs1.getFloat(3);
					}
					displaydetails d=new displaydetails();
					d.setBounds(100, 100, 450, 300);
					d.setVisible(true);
					dispose();
						
					}
				else
				{
					wronginfo w=new wronginfo();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		btnOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnOk.setBounds(74, 189, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				item_details_page i=new item_details_page();
				i.setBounds(100, 100, 450, 300);
				i.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(211, 190, 89, 23);
		contentPane.add(btnBack);
	}

}
