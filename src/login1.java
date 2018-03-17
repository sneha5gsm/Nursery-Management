import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class login1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static String user;
	public static String pwd;
	public static String name ,address ,desig ;
	public static int id = 0,did=0;
	public static long number = 0;
	public static double salary = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login1 frame = new login1();
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
	public login1() {
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel(" USERNAME : ");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUsername.setBounds(58, 58, 113, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel(" PASSWORD : ");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(58, 98, 113, 32);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(157, 65, 172, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 105, 172, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		

		try{
			
		String d="",d1;
		int d2;
		SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
	    //Date date = format1.parse("05/01/1999");
	    
	   Date datewt;

			datewt = format2.parse(format2.format(new Date()));
			String dateWithoutTime=format2.format(datewt);
			System.out.println(dateWithoutTime);
			
		//java.util.Date date= new Date();
		
		//Calendar cal = Calendar.getInstance();
		//System.out.println(date);
		//Calendar now = Calendar.getInstance();
		//now.setTime(date);
		//int year = now.get(Calendar.YEAR);
		//int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
		//int day = now.get(Calendar.DAY_OF_MONTH);
		//d1=Calendar.DAY_OF_MONTH+"-"+Calendar.MONTH+"-"+Calendar.YEAR;
		//System.out.println(Calendar.DAY_OF_MONTH);
		//System.out.println(Calendar.MONTH);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			Statement stmt=con.createStatement();  
			Statement stmt1=con.createStatement();
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from pay"); 
			ResultSet rs1;
			//rs.next();

			rs.next();
				d=rs.getString(1);
			
			//rs.previous();
				System.out.println(d);
			
			StringBuffer sb=new StringBuffer();
			StringBuffer sb2=new StringBuffer();
			sb.append(d);
			sb2.append(dateWithoutTime);
			if(Integer.parseInt(sb2.substring(0, 2))>=Integer.parseInt(sb.substring(0,2)) && Integer.parseInt(sb.substring(3, 5))!=Integer.parseInt(sb2.substring(3, 5)))
			{
				System.out.println("in");
				float f;
			int n=stmt1.executeUpdate("insert into pay values('"+dateWithoutTime+"')");
			rs1=stmt1.executeQuery("select sum(salary) from employee1");
			rs1.next();
			
			
				f=rs1.getFloat(1);
				System.out.println(f);
				stmt.executeUpdate("update balance set total=total-"+f+"");
			}
			
			con.close();  
			  
		}catch(Exception ee){ System.out.println(ee);} 
	
			
			
			
			

	
			//Statement stmt1=con.createStatement();  
		
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				user=textField.getText();
				pwd=textField_1.getText();
				
				
				int f=0;
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					
					Statement stmt=con.createStatement();  
					  
					//step4 execute query  
					ResultSet rs=stmt.executeQuery("select * from employee1,username where employee1.employee_id=username.employee_id"); 
					//Statement stmt1=con.createStatement();  
					//ResultSet rs1=stmt1.executeQuery("select * from employee1,username where employee1.employee_id=username.employee_id"); 
					while(rs.next())  
					
					{
						//System.out.println(rs.getString(1));
						//System.out.println(rs.getString(2));
						
						//boolean b=user.equals(rs.getString(1));
						
						//System.out.println(b);
						if(user.equals(rs.getString(8)) && pwd.equals(rs.getString(9)))
						{
							f=1;
							if(rs.getString(10).equals("admin"))
							{
								adminpage1 a=new adminpage1();
								a.setBounds(100,100, 450, 300);
								a.setVisible(true);
								
							}
							else if(rs.getString(10).equals("employee"))
							{
								
								
								
								
									//Class.forName("oracle.jdbc.driver.OracleDriver");
									//Connection con1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
									//System.out.println("name");
									
									//System.out.println("name"); 
									//step4 execute query  
									 
									//System.out.println("name"); 
									name=rs.getString(2);
									//System.out.println("name"); 
									//System.out.println(name);
									id=rs.getInt(1);
									number=rs.getLong(7);
									salary=rs.getDouble(3);
									address=rs.getString(6);
									desig=rs.getString(4);
									did=rs.getInt(5);
									
										//System.out.println(rs.getString(1));
										//System.out.println(rs.getString(2));
										
										//boolean b=user.equals(rs.getString(1));
										
										//System.out.println(b);
										
									  
									//step5 close the connection object  
									//con.close();  
									  
									employeepage1 e1=new employeepage1();
									e1.setBounds(100,100 ,450, 300);
									e1.setVisible(true);	
							
								
								dispose();
								
							}
							else
							{
								cashierpage1 c=new cashierpage1();
								c.setBounds(100, 100, 450,300);
								c.setVisible(true);
								dispose();
							}
							break;
						}
					}
					if(f==0)
					{
						wronglogin w=new wronglogin();
						w.setBounds(100,100,450,300);
						w.setVisible(true);
						dispose();
					}
					  
					//step5 close the connection object  
					con.close();  
					  
					}catch(Exception ee){ System.out.println(e);} 
				
				
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogin.setBounds(66, 186, 113, 32);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(240, 183, 105, 35);
		contentPane.add(btnExit);
	}
}
