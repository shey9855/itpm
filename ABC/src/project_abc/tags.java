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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;

public class tags extends JFrame {

	private JPanel contentPane;
	private JTextField txt_tag;
	private JTextField txt_code;
	private JComboBox<String> combo_tag;
	private JComboBox<String> combo_distag;
	private JTable table_tag;
	private JTextField txt_distag;
	private JTextField txt_discode;
	DefaultTableModel model;
	private JLabel lbl_tag;
	private JLabel lbl_code;
	private JLabel lbl_combo;
	
	

	

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
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1397, 789);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBounds(60, 10, 1373, 62);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 51));
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(57, 77, 1426, 2);
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
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 64, 129, 38);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_9_1 = new JLabel("Tag Code");
		lblNewLabel_9_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_1.setBounds(10, 168, 129, 38);
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Related Tag");
		lblNewLabel_9_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_2.setBounds(10, 284, 129, 38);
		panel_1.add(lblNewLabel_9_2);
		
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(txt_tag.getText().trim().isEmpty() && txt_code.getText().trim().isEmpty() && combo_tag.getSelectedItem() == "Select" ) {
					
					lbl_tag.setText("Tag Name filed is empty ");
					lbl_code.setText("Tag Code filed is empty");
					lbl_combo.setText("Please Select a tag");
				}else if(txt_tag.getText().trim().isEmpty()){
					
					lbl_tag.setText("Tag Name filed is empty ");
				}else if(txt_code.getText().trim().isEmpty()) {
					lbl_code.setText("Tag Code filed is empty");
				}else if(combo_tag.getSelectedItem() == "Select") {
					lbl_combo.setText("Please Select a tag");
				}
				
				else {
				
				
				String txt_1 = txt_tag.getText();
				String txt_2 = txt_code.getText();
				String combo = (String) combo_tag.getSelectedItem();
				
				 if(txt_tag.getText().equals(txt_1)) {
					 JOptionPane.showMessageDialog(null, "This is alredy exist");
				 }else {
				
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					String query = "INSERT INTO Tag values(000,'" + txt_1 +"','" + txt_2 + "','" + combo + "')";
					
					
					Statement statement = connection.createStatement();
					
					//int x = statement.executeUpdate(query);
					statement.execute(query);
					JOptionPane.showMessageDialog(null, "Welcome");

					 
						
						
					
						
						
					
					
					 connection.close();
					 
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
				
				 }
				}	
			}
		});
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_save.setBounds(43, 420, 116, 27);
		panel_1.add(btn_save);
		
		JButton btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_tag.setText("");
				txt_code.setText("");
				 combo_tag.setSelectedIndex(0);
			}
		});
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_clear.setBounds(270, 420, 116, 27);
		panel_1.add(btn_clear);
		
	 combo_tag = new JComboBox(new Object[]{"Select","Lecture","Tutorial","Lab","Lecture In Lab","Tutorial In Lab"});
	 combo_tag.addActionListener(new ActionListener() {
	 	public void actionPerformed(ActionEvent e) {
	 		
	 		lbl_combo.setText("");
	 	}
	 });
		combo_tag.setBounds(159, 292, 207, 27);
		panel_1.add(combo_tag);
		
		txt_tag = new JTextField();
		txt_tag.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lbl_tag.setText("");
			}
		});
		txt_tag.setBounds(160, 76, 206, 26);
		panel_1.add(txt_tag);
		txt_tag.setColumns(10);
		
		txt_code = new JTextField();
		txt_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lbl_code.setText("");
			}
		});
		txt_code.setBounds(158, 177, 208, 26);
		panel_1.add(txt_code);
		txt_code.setColumns(10);
		
		lbl_tag = new JLabel("");
		lbl_tag.setForeground(Color.RED);
		lbl_tag.setBounds(159, 122, 182, 13);
		panel_1.add(lbl_tag);
		
		lbl_code = new JLabel("");
		lbl_code.setForeground(Color.RED);
		lbl_code.setBounds(159, 225, 182, 13);
		panel_1.add(lbl_code);
		
		 lbl_combo = new JLabel("");
		 lbl_combo.setForeground(Color.RED);
		lbl_combo.setBounds(165, 339, 182, 13);
		panel_1.add(lbl_combo);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Add Tag Details");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
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
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_3.setBounds(20, 22, 129, 38);
		panel_2.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Tag Code");
		lblNewLabel_9_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_1_1.setBounds(20, 74, 129, 38);
		panel_2.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Related Tag");
		lblNewLabel_9_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9_2_1.setBounds(20, 122, 129, 38);
		panel_2.add(lblNewLabel_9_2_1);
		
	 combo_distag = new JComboBox(new Object[]{"Select","Lecture","Tutorial","Lab","Lecture In Lab","Tutorial In Lab"});
		combo_distag.setBounds(197, 130, 194, 27);
		panel_2.add(combo_distag);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String tag_update = txt_distag.getText();
				String code_update = txt_discode.getText();
				String combo_related = (String)combo_distag.getSelectedItem();
				
				

				
				int selectedRow = table_tag.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_tag.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						 String query = "UPDATE Tag set tag_name='"+tag_update+"', tag_code='"+code_update+"', related_tag='"+combo_related+"' where t_id='"+id+"'";
						 PreparedStatement pst = connection.prepareStatement(query);
							
						 int x = pst.executeUpdate(query);

						if (x == 0) {
				             JOptionPane.showMessageDialog(btn_update, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_update,
				                "Tad details successfully updated");
				         }

	                    
	                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     
			     
			     try {
						java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						 String query = "select t_id as 'ID',tag_name as 'Tag Name',tag_code as 'Tag Code',related_tag as 'Related Tag' from Tag";
		                    
						 PreparedStatement st =  connection.prepareStatement(query);
		                    ResultSet rs = st.executeQuery();
			                   
		                   table_tag.setModel(DbUtils.resultSetToTableModel(rs));
		                    
		                    
		                    st.close();
		                    
		                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_update.setBounds(580, 33, 116, 27);
		panel_2.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int selectedRow = table_tag.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_tag.getModel();
			     String tg_id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						String query = "DELETE  FROM Tag WHERE t_id = "+tg_id;
						PreparedStatement pst = connection.prepareStatement(query);
						int rs = pst.executeUpdate(query);		  
						
						if (rs == 0) {
				             JOptionPane.showMessageDialog(btn_delete, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_delete,"Tag details successfully Deleted");
				         }
				         connection.close();
	                   
						
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
			     
			     try {
						java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						 String query = "select t_id as 'ID',tag_name as 'Tag Name',tag_code as 'Tag Code',related_tag as 'Related Tag' from Tag";
		                    
						 PreparedStatement st =  connection.prepareStatement(query);
		                    ResultSet rs = st.executeQuery();
			                   
		                   table_tag.setModel(DbUtils.resultSetToTableModel(rs));
		                    
		                    
		                    st.close();
		                    
		                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				     
			     
			}
		});
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_delete.setBounds(580, 85, 116, 27);
		panel_2.add(btn_delete);
		
		JButton btn_view_clear = new JButton("Clear");
		btn_view_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txt_distag.setText("");
				txt_discode.setText("");
				 combo_distag.setSelectedIndex(0);
			}
		});
		btn_view_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_view_clear.setBounds(580, 133, 116, 27);
		panel_2.add(btn_view_clear);
		
		txt_distag = new JTextField();
		txt_distag.setBounds(199, 34, 192, 26);
		panel_2.add(txt_distag);
		txt_distag.setColumns(10);
		
		txt_discode = new JTextField();
		txt_discode.setColumns(10);
		txt_discode.setBounds(197, 86, 192, 26);
		panel_2.add(txt_discode);
		
		JLabel lblNewLabel_8_1 = new JLabel("Update/Delete Tag Details");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.BLACK);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_8_1.setBounds(825, 359, 291, 38);
		panel.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Mange Tag Details");
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8_1_1.setBounds(808, 10, 291, 38);
		panel.add(lblNewLabel_8_1_1);
		
		JButton btn_details = new JButton("View Details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					 String query = "select t_id as 'ID',tag_name as 'Tag Name',tag_code as 'Tag Code',related_tag as 'Related Tag' from Tag";
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                   table_tag.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				 
			}
		});
		btn_details.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_details.setBounds(1283, 60, 116, 27);
		panel.add(btn_details);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Tag Details");
		lblNewLabel_8_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1_1_1.setBounds(808, 73, 291, 38);
		panel.add(lblNewLabel_8_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(549, 103, 822, 229);
		panel.add(scrollPane);
		
		table_tag = new JTable();
		table_tag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table_tag.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table_tag.getModel(); 
					
					
					txt_distag.setText(model.getValueAt(row, 1).toString());
					txt_discode.setText(model.getValueAt(row, 2).toString());
					combo_distag.setSelectedItem(model.getValueAt(row, 3).toString());
					
					
					
					
					String tg_ID =(table_tag.getModel().getValueAt(row, 0).toString());
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					 String query = "select tag_name,tag_code,related_tag from Tag  where t_id ='"+tg_ID+"'" ;
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                    while(rs.next()) {
			            	 
	                    	txt_distag.setText(rs.getString("tag_name"));
	                    	txt_discode.setText(rs.getString("tag_code"));
			            	combo_distag.setSelectedItem("related_tag");

			            	 
			             }
	                    
	                    
	                    st.close();
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		

		 model = new DefaultTableModel();
			Object[] column = {"ID","Tag Name","Tag Code","Related Tag"};
			final Object[] row = new Object[0];
			model.setColumnIdentifiers(column);
			table_tag.setModel(model);
		scrollPane.setViewportView(table_tag);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(tags.class.getResource("/project_abc/home1.png")));
		btnNewButton.setBackground(new Color(102, 51, 255));
		btnNewButton.setBounds(117, 101, 54, 47);
		contentPane.add(btnNewButton);
	}
}
