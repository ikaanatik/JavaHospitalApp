import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class vaccineSelection extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String sorgu;
	DefaultTableModel modelvaccs = new DefaultTableModel();
	Object[] columns = {"Vaccine Name","Vaccine Country", "Vaccine Technology"};
	Object [] rows = new Object [3];
	private JLabel lblNewLabel;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vaccineSelection frame = new vaccineSelection();
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
	public vaccineSelection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 351, 338);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		database.connect();
		sorgu = "select * from vaccine_selection";
		modelvaccs.setColumnCount(0);
		modelvaccs.setRowCount(0);
		modelvaccs.setColumnIdentifiers(columns);
		
		
		ResultSet rs = database.listele(sorgu);
		
			try {
				while (rs.next()) {	
				rows[0] = (rs.getString("vaccine_name"));
				rows[1] = (rs.getString("vaccine_country"));
				rows[2] = (rs.getString("vaccine_technology"));				
				modelvaccs.addRow(rows);			
				}
				table.setModel(modelvaccs);
				
				lblNewLabel = new JLabel("Search");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				lblNewLabel.setBounds(391, 0, 111, 97);
				contentPane.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setBounds(361, 74, 96, 19);
				contentPane.add(textField);
				textField.setColumns(10);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	

	
	
	
	
	}

}