import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class patientLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientLogin frame = new patientLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public patientLogin() {
		connection = database.connect();
		setTitle("Patient Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(78, 28, 300, 201);
		contentPane.add(contentPane_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(10, 0, 135, 47);
		contentPane_1.add(lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(105, 15, 149, 19);
		contentPane_1.add(textField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(10, 44, 135, 47);
		contentPane_1.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 57, 149, 19);
		contentPane_1.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			try {
				String query = "select * from patient where username=? and password=? ";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1,textField.getText() );
				pst.setString(2,passwordField.getText() );
				
				ResultSet rs = pst.executeQuery();
				int count = 0;
				while (rs.next()) {
					count = count+1;
								}
				if (count == 1) {
					vaccineSelection selection = new vaccineSelection();
					selection.setVisible(true);			
					dispose();	
				}
				else if (count>1) {
					JOptionPane.showMessageDialog(null, "Duplicate Username and password");

				}
				else {
					JOptionPane.showMessageDialog(null, "Username and password is not correct");

				}						
			    rs.close();
			    pst.close();
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLogin.setBounds(48, 112, 151, 54);
		contentPane_1.add(btnLogin);
	}

}
