import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class cashierpage1 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	static final cashierpage1 c1=new cashierpage1();
	static String bill="";
	static float billamt=0;
	int id,no;
	//System.out.println(dateFormat.format(cal.getTime()));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashierpage1 frame = new cashierpage1();
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
	public cashierpage1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDate = new JLabel("DATE: "+ dateFormat.format(cal.getTime()));
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDate.setBounds(25, 30, 166, 29);
		contentPane.add(lblDate);
		
		JLabel lblItemId = new JLabel("ITEM ID: ");
		lblItemId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblItemId.setBounds(25, 112, 70, 29);
		contentPane.add(lblItemId);
		
		textField = new JTextField();
		textField.setBounds(94, 113, 86, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantity = new JLabel("QUANTITY: ");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(214, 112, 86, 29);
		contentPane.add(lblQuantity);
		
		textField_1 = new JTextField();
		textField_1.setBounds(299, 117, 110, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAddItem = new JButton("ADD ITEM");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				id=Integer.parseInt(textField.getText());
				no=Integer.parseInt(textField_1.getText());
				float p;
				String name;
				//int item;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select dept_id from dept_item where item_id="+id+"");
				ResultSet rs1,rs2;
				
				int nn;
				
				if(rs.next())
				{
					int n1=rs.getInt(1);
					SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
				    //Date date = format1.parse("05/01/1999");
				    
				   Date datewt;
		
						datewt = format2.parse(format2.format(new Date()));
						 String dateWithoutTime=format2.format(datewt);
						System.out.println(format2.format(datewt));
						System.out.println(format2.format(datewt).length());
						//format2.format(datewt)
						//System.out.println(format2.format(dateWithoutTime));
					if(n1==3)
					{
					stmt.executeUpdate("update plant set plant_qty=plant_qty-"+no+" where item_id="+id+"");
					rs1=stmt.executeQuery("select * from plant where item_id="+id+"");
					rs1.next();
					name=rs1.getString(2);
					//type=rs1.getString(3);
					p=rs1.getFloat(5);
					
					p=p*no;
					billamt=billamt+p;
					bill=bill+id+" "+name+" "+no+" "+p+"\n";
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale+"+p+" where date1='"+dateWithoutTime+"'");
							System.out.println(nn);
						}
						else
						{
							nn=stmt.executeUpdate("insert into budget values(3,0,'"+dateWithoutTime+"',"+p+")");
							System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total+"+p+"");
						System.out.println(nn);

					//SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
					//System.out.println(format2.format(cal.get));
					//Date date = new Date();
			       // dateFormat.format2(date);
					//stmt.executeUpdate(sql)
					
					
					}
					else if(n1==4)
					{
						stmt.executeUpdate("update fertiliser set fertiliser_qty=fertiliser_qty-"+no+" where item_id="+id+"");
						rs1=stmt.executeQuery("select * from fertiliser where item_id="+id+"");
						rs1.next();
						name=rs1.getString(2);
						p=rs1.getFloat(4);
						p=p*no;
						billamt=billamt+p;
						bill=bill+id+" "+name+" "+no+" "+p+"\n";
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						System.out.println(rs2);
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale+"+p+" where date1='"+dateWithoutTime+"'");
							System.out.println(nn);
						}
						else
						{
							nn=stmt.executeUpdate("insert into budget values(4,0,'"+dateWithoutTime+"',"+p+")");
							System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total+"+p+"");
						System.out.println(nn);
					
						
						
						
						
					}
					else
					{
						stmt.executeUpdate("update tool set tool_qty=tool_qty-"+no+" where item_id="+id+"");
						rs1=stmt.executeQuery("select * from tool where item_id="+id+"");
						rs1.next();
						name=rs1.getString(2);
						p=rs1.getFloat(3);
						p=p*no;
						billamt=billamt+p;
						bill=bill+id+" "+name+" "+no+" "+p+"\n";
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale+"+p+" where date1='"+dateWithoutTime+"'");
							System.out.println(nn);
						}
						else
						{
							nn=stmt.executeUpdate("insert into budget values(5,0,'"+dateWithoutTime+"',"+p+")");
							System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total+"+p+"");
						System.out.println(nn);
					}
					
				}
				else
				{
					wronginfocash w=new wronginfocash();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				//add_deleteitem i=new add_deleteitem();
				//dispose();
				
				
				
				
				
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddItem.setBounds(10, 189, 110, 29);
		contentPane.add(btnAddItem);
		
		JButton btnDeleteItem = new JButton("DELETE ITEM");
		btnDeleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{

				id=Integer.parseInt(textField.getText());
				no=Integer.parseInt(textField_1.getText());
				float p;
				String name;
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
				
				Statement stmt=con.createStatement();  
				  
				//step4 execute query  
				ResultSet rs=stmt.executeQuery("select dept_id from dept_item where item_id="+id+"");
				ResultSet rs1,rs2;
				
				int nn;
				
				if(rs.next())
				{
					int n1=rs.getInt(1);
					SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
				    //Date date = format1.parse("05/01/1999");
				    
				   Date datewt;
		
						datewt = format2.parse(format2.format(new Date()));
						String dateWithoutTime=format2.format(datewt);
						//System.out.println(format2.format(datewt));
					if(n1==3)
					{
					stmt.executeUpdate("update plant set plant_qty=plant_qty+"+no+" where item_id="+id+"");
					rs1=stmt.executeQuery("select * from plant where item_id="+id+"");
					rs1.next();
					name=rs1.getString(2);
					p=rs1.getFloat(5);
					p=p*no;
					billamt=billamt-p;
					bill=bill+id+" "+name+" "+no+" "+"-"+p+"\n";
					
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale-"+p+" where date1='"+dateWithoutTime+"'");
							//System.out.println(nn);
						}
						else
						{
							float q=0-p;
							nn=stmt.executeUpdate("insert into budget values(3,0,'"+dateWithoutTime+"',"+q+")");
							//System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total-"+p+"");
						//System.out.println(nn);

					//SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
					//System.out.println(format2.format(cal.get));
					//Date date = new Date();
			       // dateFormat.format2(date);
					//stmt.executeUpdate(sql)
					
					
					}
					else if(n1==4)
					{
						stmt.executeUpdate("update fertiliser set fertiliser_qty=fertiliser_qty+"+no+" where item_id="+id+"");
						rs1=stmt.executeQuery("select * from fertiliser where item_id="+id+"");
						rs1.next();
						name=rs1.getString(2);
						p=rs1.getFloat(4);
						p=p*no;
						billamt=billamt-p;
						bill=bill+id+" "+name+" "+no+" "+"-"+p+"\n";
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale-"+p+" where date1='"+dateWithoutTime+"'");
							//System.out.println(nn);
						}
						else
						{
							float q=0-p;
							nn=stmt.executeUpdate("insert into budget values(4,0,'"+dateWithoutTime+"',"+q+")");
							System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total-"+p+"");
						//System.out.println(nn);
					
						
						
						
						
					}
					else
					{
						stmt.executeUpdate("update tool set tool_qty=tool_qty+"+no+" where item_id="+id+"");
						rs1=stmt.executeQuery("select * from tool where item_id="+id+"");
						rs1.next();
						name=rs1.getString(2);
						p=rs1.getFloat(3);
						p=p*no;
						billamt=billamt-p;
						bill=bill+id+" "+name+" "+no+" "+"-"+p+"\n";
						rs2=stmt.executeQuery("select * from budget where date1='"+dateWithoutTime+"'");
						if(rs2.next())
						{
							nn=stmt.executeUpdate("update budget set sale=sale-"+p+" where date1='"+dateWithoutTime+"'");
							//System.out.println(nn);
						}
						else
						{ float q=0-p;
							nn=stmt.executeUpdate("insert into budget values(5,0,'"+dateWithoutTime+"',"+q+")");
							//System.out.println(nn+1);
						}
						nn=stmt.executeUpdate("update balance set total=total-"+p+"");
						//System.out.println(nn);
					}
					
				}
				else
				{
					wronginfocash w=new wronginfocash();
					w.setBounds(100, 100, 450, 300);
					w.setVisible(true);
					dispose();
				}
				//add_deleteitem i=new add_deleteitem();
				//dispose();
				
				
				
				
				
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
				
				
		});
		btnDeleteItem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDeleteItem.setBounds(130, 190, 137, 27);
		contentPane.add(btnDeleteItem);
		
		JButton btnGenerateBill = new JButton("GENERATE BILL");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			System.out.println("BILL");
			System.out.println(bill);
			System.out.println("TOTAL AMOUTNT PAID:"+billamt);
			billgen b=new billgen();
			b.setBounds(100, 100, 450, 300);
			b.setVisible(true);
			dispose();
			
			}
		});
		btnGenerateBill.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGenerateBill.setBounds(275, 189, 149, 29);
		contentPane.add(btnGenerateBill);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 l1=new login1();
				l1.setBounds(100, 100,450, 300);
				l1.setVisible(true);
				dispose();
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnLogout.setBounds(157, 228, 143, 23);
		contentPane.add(btnLogout);
	}
}
