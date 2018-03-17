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


public class item_details_page extends JFrame {

	private JPanel contentPane;
	public static String[][] pt=new  String[5][5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					item_details_page frame = new item_details_page();
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
	public item_details_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnBack.setBounds(299, 201, 89, 31);
		contentPane.add(btnBack);
		
		JButton btnAdddeleteItems = new JButton("ADD/DELETE ITEM");
		btnAdddeleteItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_delete ad=new add_delete();
				ad.setBounds(100,100, 450,300);
				ad.setVisible(true);
				dispose();
			}
		});
		btnAdddeleteItems.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdddeleteItems.setBounds(140, 112, 184, 31);
		contentPane.add(btnAdddeleteItems);
		
		JButton btnViewDetails = new JButton("VIEW ITEM DETAILS");
		btnViewDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				details d=new details();
				d.setBounds(100, 100, 450, 300);
				d.setVisible(true);
				dispose();
			}
		});
		btnViewDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnViewDetails.setBounds(140, 59, 184, 31);
		contentPane.add(btnViewDetails);
	}
}
