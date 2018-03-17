import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class payroll extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payroll frame = new payroll();
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
	public payroll() {
		String d="";
		String d2="";
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try{
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			Statement stmt1=con.createStatement();  
			  
			//step4 execute query  
			//ResultSet rs=stmt.executeQuery("select "); 
			ResultSet rs2=stmt1.executeQuery("select * from pay"); 
			ResultSet rs1;
			//rs.next();
			//Calendar now = Calendar.getInstance();
			//int year = now.get(Calendar.YEAR);
			//int month = now.get(Calendar.MONTH) ;
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
		    //Date date = format1.parse("05/01/1999");
		    
		   Date datewt;
			datewt = format2.parse(format2.format(new Date()));
			String dateWithoutTime=format2.format(datewt);
			System.out.println(dateWithoutTime);
			StringBuffer sb2=new StringBuffer();
			sb2.append(dateWithoutTime);
			
			while(	rs2.next())
			{
				
			
				d=rs2.getString(1);
			}
				
			
					StringBuffer sb=new StringBuffer();
					sb.append(d);
					if(Integer.parseInt(sb.substring(3, 5))!=Integer.parseInt(sb2.substring(3, 5)))
					{
						d2="NOT PAID";
					}
					else
					{
						d2="PAID";
					}

			con.close();  
			  
			}catch(Exception ee){ System.out.println(ee);} 
		
		
		JLabel lblSalaryPaidOn = new JLabel("LATEST SALARY PAID ON:");
		lblSalaryPaidOn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalaryPaidOn.setBounds(10, 62, 190, 25);
		contentPane.add(lblSalaryPaidOn);
		
		JLabel label = new JLabel(d);
		label.setBounds(210, 62, 114, 25);
		contentPane.add(label);
		
		JLabel lblCurrentMonthsSalary = new JLabel("CURRENT MONTH'S SALARY:");
		lblCurrentMonthsSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCurrentMonthsSalary.setBounds(10, 121, 216, 25);
		contentPane.add(lblCurrentMonthsSalary);
		
		
		
		
		JLabel label_1 = new JLabel(d2);
		label_1.setBounds(236, 121, 114, 25);
		contentPane.add(label_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				adminpage1 a=new adminpage1();
				a.setBounds(100, 100, 450, 300);
				a.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(72, 198, 105, 23);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				login1 l=new login1();
				l.setBounds(100, 100, 450, 300);
				l.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBounds(236, 198, 128, 23);
		contentPane.add(btnLogout);
	}

}
