import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class patientRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNS;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private JTextField textField_chronic;
	private JTextField textField_allergy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					patientRegister frame = new patientRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
Connection connection = null;

private JTextField textFieldGender;
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public patientRegister() throws ParseException {
		connection = database.connect();
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TCKN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 0, 135, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNamesurname = new JLabel("Name&Surname");
		lblNamesurname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNamesurname.setBounds(10, 28, 135, 47);
		contentPane.add(lblNamesurname);
		
		JLabel lblChronicDeseaseInformation = new JLabel("Chronic Desease Information (can be null)");
		lblChronicDeseaseInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChronicDeseaseInformation.setBounds(10, 208, 343, 27);
		contentPane.add(lblChronicDeseaseInformation);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDateOfBirth.setBounds(10, 171, 107, 27);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(10, 57, 135, 47);
		contentPane.add(lblUsername);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGender.setBounds(10, 127, 54, 47);
		contentPane.add(lblGender);
		
		
		
		
		JFormattedTextField frmtdtxtfldTCKN = new JFormattedTextField();
		frmtdtxtfldTCKN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frmtdtxtfldTCKN.setBounds(67, 15, 149, 19);
		contentPane.add(frmtdtxtfldTCKN);
		
		textFieldNS = new JTextField();
		textFieldNS.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldNS.setBounds(141, 43, 189, 19);
		contentPane.add(textFieldNS);
		textFieldNS.setColumns(10);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(91, 72, 149, 19);
		contentPane.add(textFieldUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(10, 95, 135, 47);
		contentPane.add(lblPassword); 
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 112, 149, 19);
		contentPane.add(passwordField);
		
		textFieldGender = new JTextField();
		textFieldGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(67, 143, 64, 21);
		contentPane.add(textFieldGender);
		
		
		
		MaskFormatter date = new MaskFormatter("##/##/####");
		
		JFormattedTextField formattedTextFieldDateofBirth = new JFormattedTextField(date);
		formattedTextFieldDateofBirth.setFont(new Font("Tahoma", Font.PLAIN, 17));
		formattedTextFieldDateofBirth.setBounds(117, 178, 123, 19);
		contentPane.add(formattedTextFieldDateofBirth);
		
		JLabel lblAllergyInformationcan = new JLabel("Allergy Information (can be null)");
		lblAllergyInformationcan.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAllergyInformationcan.setBounds(10, 236, 288, 27);
		contentPane.add(lblAllergyInformationcan);
		
		textField_chronic = new JTextField();
		textField_chronic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_chronic.setColumns(10);
		textField_chronic.setBounds(286, 212, 182, 19);
		contentPane.add(textField_chronic);
		
		textField_allergy = new JTextField();
		textField_allergy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_allergy.setColumns(10);
		textField_allergy.setBounds(257, 241, 182, 19);
		contentPane.add(textField_allergy);

		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {			
			try {
				String query = "insert into patient (tckn, name_surname, username, password, gender, date_of_birth, chronic_desease_info, allergy_info) values (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pst;
				pst = connection.prepareStatement(query);
				pst.setString(1,frmtdtxtfldTCKN.getText());
				pst.setString(2,textFieldNS.getText());
				pst.setString(3,textFieldUsername.getText());
				pst.setString(4,passwordField.getText());
				pst.setString(5,textFieldGender.getText());
				pst.setString(6,formattedTextFieldDateofBirth.getText());
				pst.setString(7,textField_chronic.getText());
				pst.setString(8,textField_allergy.getText());
				
				pst.execute();
				JOptionPane.showMessageDialog(null, "Data Saved");
				
				pst.close();
				patientLogin login = new patientLogin();
				login.setVisible(true);			
				dispose();	
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
			}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(166, 273, 151, 54);
		contentPane.add(btnNewButton);
	}
}

