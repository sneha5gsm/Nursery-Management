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


public class add_delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add_delete frame = new add_delete();
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
	public add_delete() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemId = new JLabel("ITEM ID(add):");
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblItemId.setBounds(25, 55, 98, 24);
		contentPane.add(lblItemId);
		
		textField = new JTextField();
		textField.setBounds(133, 58, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDeptId = new JLabel("DEPT ID:");
		lblDeptId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeptId.setBounds(256, 55, 67, 24);
		contentPane.add(lblDeptId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(333, 55, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(25, 90, 67, 24);
		contentPane.add(lblName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 94, 103, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTypeifAny = new JLabel("TYPE(if any):");
		lblTypeifAny.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTypeifAny.setBounds(227, 90, 96, 24);
		contentPane.add(lblTypeifAny);
		
		textField_3 = new JTextField();
		textField_3.setBounds(333, 94, 91, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(25, 138, 86, 24);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setBounds(121, 141, 67, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(246, 138, 77, 20);
		contentPane.add(lblPrice);
		
		textField_5 = new JTextField();
		textField_5.setBounds(333, 141, 77, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int n,d,q;
				
				float p;
				String name,type;
				//n=Integer.parseInt(textField.getText());
				d=Integer.parseInt(textField_1.getText());
				//System.out.println(d);
				name=textField_2.getText();
				//System.out.println(name);
				type=textField_3.getText();
				//System.out.println(type);
				q=Integer.parseInt(textField_4.getText());
				//System.out.println(q);
				p=Float.parseFloat(textField_5.getText());
				//System.out.println(p);
				int n1;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				Statement stmt=con.createStatement();  
				
				ResultSet rs=stmt.executeQuery("select max(item_id) from dept_item");
				rs.next();
				int count=rs.getInt(1);
				//System.out.println(count);
				count++;
				  
				//step4 execute query  
				if(d==3)
				{
					
					
					n1=stmt.executeUpdate("insert into dept_item values("+count+","+d+")");
					System.out.println(n1);
					if(n1==1)
					{
					String sql="insert into plant values("+count+",'"+name+"','"+type+"',"+q+","+p+")";
					
					System.out.println(count);
					System.out.println("in");
				 n1=stmt.executeUpdate(sql);
					}
				System.out.println(n1);
				}
				else if(d==4)
				{
					n1=stmt.executeUpdate("insert into dept_item values("+count+","+d+")");
					if(n1==1)
					{
					stmt.executeUpdate("insert into fertiliser values("+count+",'"+name+"',"+q+","+p+")");
					
					}
				}
				else if(d==5)
				{
					n1=stmt.executeUpdate("insert into dept_item values("+count+","+d+")");
					if(n1==1)
					{
					stmt.executeUpdate("insert into tool values("+count+",'"+name+"',"+q+","+p+")");
					
					}
				}
				else
				{
					
					wronginfo w=new wronginfo();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				
				//System.out.println("in");
				con.close();
				modified m=new modified();
				m.setBounds(100, 100, 450, 300);
				m.setVisible(true);
				dispose();
				
				//Statement stmt1=con.createStatement();  
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddItem.setBounds(10, 205, 116, 23);
		contentPane.add(btnAddItem);
		
		JButton btnDeleteItem = new JButton("DELETE ITEM");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int n,d,q,count=50;
				float p;
				String name,type;
				n=Integer.parseInt(textField.getText());
				d=Integer.parseInt(textField_1.getText());
				//System.out.println(d);
				//name=textField_2.getText();
				//System.out.println(name);
				//type=textField_3.getText();
				//System.out.println(type);
				//q=Integer.parseInt(textField_4.getText());
				//System.out.println(q);
				//p=Float.parseFloat(textField_5.getText());
				//System.out.println(p);
				int n2;
				int flag=0;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				Statement stmt=con.createStatement();  
				if(d==3)
				{
					
				
				n2=stmt.executeUpdate("select * from plant where item_id="+n+"");
				System.out.println(n2);
				if(n2==1)
				{
					
					stmt.executeUpdate("delete from plant where item_id="+n+"");
					stmt.executeUpdate("delete from dept_item where item_id="+n+"");
				}
				else
				{
					flag=2;
					wronginfo w=new wronginfo();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				
				}
				else if(d==4)
				{
					n2=stmt.executeUpdate("select * from fertiliser where item_id="+n+"");
					System.out.println(n2);
					if(n2==1)
					{
						stmt.executeUpdate("delete from fertiliser where item_id="+n+"");
						stmt.executeUpdate("delete from dept_item where item_id="+n+"");
					}
					else
					{
						flag=1;
						wronginfo w=new wronginfo();
						w.setBounds(100, 100, 450, 300);
						w.setVisible(true);
						dispose();
					}
					
				}
				else if(d==5)
				{
					n2=stmt.executeUpdate("select * from tool where item_id="+n+"");
					System.out.println(n2);
					if(n2==1)
					{
						stmt.executeUpdate("delete from tool where item_id="+n+"");
						stmt.executeUpdate("delete from dept_item where item_id="+n+"");
					}
					else
					{
						flag=1;
						wronginfo w=new wronginfo();
						w.setBounds(100, 100, 450, 300);
						w.setVisible(true);
						dispose();
						
					}
					
				}
				else
				{
					wronginfo w=new wronginfo();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				
				
				//System.out.println("in");
				if(flag==0)
				{
				con.close();
				modified m=new modified();
				m.setBounds(100, 100, 450, 300);
				m.setVisible(true);
				dispose();
				}
				
				//Statement stmt1=con.createStatement();  
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				  
			}
		});
		btnDeleteItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeleteItem.setBounds(144, 205, 138, 23);
		contentPane.add(btnDeleteItem);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				adminpage1 ad=new adminpage1();
				ad.setBounds(100, 100, 450, 300);
				ad.setVisible(true);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnCancel.setBounds(307, 205, 112, 23);
		contentPane.add(btnCancel);
	}
}
