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


public class wronglogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wronglogin frame = new wronglogin();
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
	public wronglogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWrongCredentials = new JLabel("OOPS!  YOU HAVE PROVIDED WRONG CREDENTIALS");
		lblWrongCredentials.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblWrongCredentials.setBounds(40, 22, 384, 47);
		contentPane.add(lblWrongCredentials);
		
		JButton btnBackToLogin = new JButton("BACK TO LOGIN PAGE");
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				login1 l=new login1();
				l.setBounds(100,100, 450, 300);
				l.setVisible(true);
				dispose();
			}
		});
		btnBackToLogin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBackToLogin.setBounds(10, 158, 200, 25);
		contentPane.add(btnBackToLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBounds(246, 158, 170, 25);
		contentPane.add(btnExit);
	}

}
