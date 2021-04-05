package project_abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class tags extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txt_tag;
	private JTextField txt_code;
	private JComboBox<String> combo_tag;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tags frame = new tags();
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
	public tags() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1397, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBounds(5, 5, 1373, 62);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 51));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(49, 98, 1426, 2);
		contentPane.add(separator);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setBounds(24, 158, 1409, 610);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(518, 60, 2, 540);
		panel.add(separator_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(31, 92, 458, 494);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Tag Name");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 64, 129, 38);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Tag Code");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1.setBounds(10, 168, 129, 38);
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Related Tag");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2.setBounds(10, 284, 129, 38);
		panel_1.add(lblNewLabel_9_2);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String txt_1 = txt_tag.getText();
				String txt_2 = txt_code.getText();
				String combo = (String) combo_tag.getSelectedItem();
				
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					String query = "INSERT INTO Tag values(000,'" + txt_1 +"','" + txt_2 + "','" + combo + "')";
					
					
					Statement statement = connection.createStatement();
					
					int x = statement.executeUpdate(query);
					
					
					 if(x == 0) {
						JOptionPane.showMessageDialog(btn_save, "This is alredy exist");
						
					}else {
						JOptionPane.showMessageDialog(btn_save, "Welcome");
						
					}
					
					 connection.close();
					 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
			}
		});
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_save.setBounds(43, 420, 116, 27);
		panel_1.add(btn_save);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_clear.setBounds(270, 420, 116, 27);
		panel_1.add(btn_clear);
		
	 combo_tag = new JComboBox(new Object[]{"Lecture","Tute","Lab"});
		combo_tag.setBounds(159, 292, 194, 27);
		panel_1.add(combo_tag);
		
		txt_tag = new JTextField();
		txt_tag.setBounds(160, 76, 193, 19);
		panel_1.add(txt_tag);
		txt_tag.setColumns(10);
		
		txt_code = new JTextField();
		txt_code.setBounds(158, 187, 208, 19);
		panel_1.add(txt_code);
		txt_code.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Add Tag Details");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_8.setBounds(113, 44, 291, 38);
		panel.add(lblNewLabel_8);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(530, 346, 841, 2);
		panel.add(separator_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(593, 407, 744, 181);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_9_3 = new JLabel("Tag Name");
		lblNewLabel_9_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_3.setBounds(20, 22, 129, 38);
		panel_2.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Tag Code");
		lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_1_1.setBounds(20, 74, 129, 38);
		panel_2.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Related Tag");
		lblNewLabel_9_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9_2_1.setBounds(20, 122, 129, 38);
		panel_2.add(lblNewLabel_9_2_1);
		
		JTextPane textPane_2_2 = new JTextPane();
		textPane_2_2.setBounds(197, 34, 194, 27);
		panel_2.add(textPane_2_2);
		
		JTextPane textPane_2_1_1 = new JTextPane();
		textPane_2_1_1.setBounds(197, 85, 194, 27);
		panel_2.add(textPane_2_1_1);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setBounds(197, 130, 194, 27);
		panel_2.add(comboBox_2_1);
		
		JButton btn_update = new JButton("Update");
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_update.setBounds(580, 33, 116, 27);
		panel_2.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_delete.setBounds(580, 85, 116, 27);
		panel_2.add(btn_delete);
		
		JButton btn_view_clear = new JButton("Clear");
		btn_view_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_view_clear.setBounds(580, 133, 116, 27);
		panel_2.add(btn_view_clear);
		
		JLabel lblNewLabel_8_1 = new JLabel("Update/Delete Tag Details");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.BLACK);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_8_1.setBounds(825, 359, 291, 38);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Mange Tag Details");
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8_1_1.setBounds(808, 10, 291, 38);
		panel.add(lblNewLabel_8_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(553, 121, 830, 215);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btn_details = new JButton("View Details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_details.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_details.setBounds(1283, 60, 116, 27);
		panel.add(btn_details);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Tag Details");
		lblNewLabel_8_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_1_1_1.setBounds(808, 73, 291, 38);
		panel.add(lblNewLabel_8_1_1_1);
	}
}
