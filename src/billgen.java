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


public class billgen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billgen frame = new billgen();
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
	public billgen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBillHasBeen = new JLabel("BILL HAS BEEN GENERATED");
		lblBillHasBeen.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblBillHasBeen.setBounds(120, 11, 261, 73);
		contentPane.add(lblBillHasBeen);
		
		JButton btnNewPurchase = new JButton("NEW PURCHASE");
		btnNewPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cashierpage1 c=new cashierpage1();
				c.setBounds(100, 100, 450, 300);
				c.setVisible(true);
				dispose();
				
			}
		});
		btnNewPurchase.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewPurchase.setBounds(43, 210, 186, 40);
		contentPane.add(btnNewPurchase);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				login1 l=new login1();
				l.setBounds(100, 100, 450, 300);
				l.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(265, 210, 116, 40);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("TOTAL AMOUNT TO BE PAID "+cashierpage1.billamt);
		label.setBounds(122, 108, 212, 40);
		contentPane.add(label);
	}
}
