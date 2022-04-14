import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Giris extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris frame = new Giris();
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
	public Giris() {
		setTitle("Login To The System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton patientButton = new JButton("Patient");
		patientButton.setBackground(Color.ORANGE);
		patientButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		patientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			patientRegister giris = null;
			try {
				giris = new patientRegister();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			giris.setVisible(true);			
			dispose();
			}
		});
		patientButton.setBounds(0, 0, 213, 263);
		contentPane.add(patientButton);
		
		JButton doctorButton = new JButton("Doctor");
		doctorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorLogin giris = new doctorLogin();
				giris.setVisible(true);			
				dispose();			
			}
		});
		doctorButton.setFont(new Font("Tahoma", Font.PLAIN, 40));
		doctorButton.setBounds(213, 0, 213, 263);
		contentPane.add(doctorButton);
	}
}
