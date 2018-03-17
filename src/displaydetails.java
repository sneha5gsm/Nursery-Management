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


public class displaydetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displaydetails frame = new displaydetails();
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
	public displaydetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(42, 84, 77, 37);
		contentPane.add(lblName);
		
		JLabel label = new JLabel(details.name);
		label.setBounds(125, 84, 166, 37);
		contentPane.add(label);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblQuantity.setBounds(42, 132, 99, 37);
		contentPane.add(lblQuantity);
		
		JLabel label_1 = new JLabel(Integer.toString(details.q));
		label_1.setBounds(151, 132, 190, 32);
		contentPane.add(label_1);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPrice.setBounds(42, 180, 77, 37);
		contentPane.add(lblPrice);
		
		JLabel label_2 = new JLabel(Float.toString(details.price));
		label_2.setBounds(125, 180, 117, 37);
		contentPane.add(label_2);
		
		JLabel lblDept = new JLabel("DEPT:");
		lblDept.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDept.setBounds(42, 43, 77, 37);
		contentPane.add(lblDept);
		
		JLabel label_3 = new JLabel(details.dept);
		label_3.setBounds(129, 43, 148, 38);
		contentPane.add(label_3);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				details d=new details();
				d.setBounds(100, 100, 450, 300);
				d.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(99, 228, 89, 23);
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
		btnLogout.setBounds(267, 229, 117, 23);
		contentPane.add(btnLogout);
	}

}
