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


public class budget extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					budget frame = new budget();
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
	public budget() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTotalBalance = new JLabel("TOTAL BALANCE:");
		lblTotalBalance.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalBalance.setBounds(79, 50, 142, 33);
		contentPane.add(lblTotalBalance);
		
		JLabel label = new JLabel(adminpage1.total+" Rupees");
		label.setBounds(231, 50, 135, 33);
		contentPane.add(label);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpage1 a=new adminpage1();
				a.setBounds(100, 100, 450, 300);
				a.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBack.setBounds(37, 173, 142, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("LOGOUT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login1 l=new login1();
				l.setBounds(100, 100, 450,300);
				l.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(231, 174, 117, 23);
		contentPane.add(btnExit);
	}

}
