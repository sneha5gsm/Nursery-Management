import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;


public class adminpage1 extends JFrame {

	private JPanel contentPane;
	static float total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage1 frame = new adminpage1();
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
	public adminpage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnItemDetails = new JButton("ITEM DETAILS");
		btnItemDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				item_details_page i=new item_details_page();
				i.setBounds(100, 100, 450, 300);
				i.setVisible(true);
				dispose();
			}
		});
		btnItemDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnItemDetails.setBounds(93, 38, 237, 34);
		contentPane.add(btnItemDetails);
		
		JButton btnPayroll = new JButton("PAYROLL");
		btnPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				payroll p=new payroll();
				p.setBounds(100, 100, 450, 300);
				p.setVisible(true);
				dispose();
				//Calendar cal;
				//int d=cal.get
			}
		});
		btnPayroll.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnPayroll.setBounds(93, 83, 237, 34);
		contentPane.add(btnPayroll);
		
		JButton btnBudget = new JButton("BUDGET");
		btnBudget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
					
					Statement stmt=con.createStatement();  
					  
					//step4 execute query  
					ResultSet rs=stmt.executeQuery("select * from balance");
					rs.next();
					total=rs.getFloat(1);
					//step5 close the connection object  
					con.close();  
					  
					}catch(Exception ee){ System.out.println(e);} 
				budget b=new budget();
				b.setBounds(100, 100, 450, 300);
				b.setVisible(true);
				dispose();
					
			}
		});
		btnBudget.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBudget.setBounds(93, 128, 237, 41);
		contentPane.add(btnBudget);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 l=new login1();
				l.setBounds(100,100, 450, 300);
				l.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(307, 237, 117, 18);
		contentPane.add(btnExit);
	}

}
