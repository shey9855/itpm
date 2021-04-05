package project_abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JToolBar;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.jdi.connect.spi.Connection;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class grp_student extends JFrame {

	private JPanel contentPane;
	private JPanel Add_Student_group;
	private JPanel View_groups;
	private JLayeredPane layeredPane;
	private JButton btn_add_grp;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_1;
	private JButton btn_generate;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPanel panel_2;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JSpinner spin_grpno;
	private JSpinner spin_subgrpno;
	private JComboBox combo_acdisplay;
	private JComboBox combo_proDisplay;
	private JPanel panel_3;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextPane txt_disgrp_id;
	private JTextPane txt_disgrp_subid;
	private JButton btn_save;
	private JButton btn_clear;
	private JSeparator separator_1_1;
	private JTable table_stgrp;
	private JScrollPane scrollPane;
	private JTextField txt_grpid;
	private JTextField txt_subgrpid;
	DefaultTableModel model;
	private JLabel lblNewLabel_16;
	private JTextField txt_search;

	/**
	 * Launch the application.
	 */
	
	public void refreshSt_grp()
	{
		 try {
	    	 
			 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");

	         String query = "SELECT * FROM Student_grp ";
	     
	         PreparedStatement pst = connection.prepareStatement(query);
	         ResultSet rs=pst.executeQuery();
	         table_stgrp.setModel(DbUtils.resultSetToTableModel(rs));
	         
	        
	     } catch (Exception exception) {
	         exception.printStackTrace();
	     }
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grp_student frame = new grp_student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void switchPanels(JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
	
	

	/**
	 * Create the frame.
	 */
	public grp_student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1494, 784);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(353, 24, 513, 82);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(54, 104, 1426, 2);
		contentPane.add(separator);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 192, 1500, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Add_Student_group = new JPanel();
		Add_Student_group.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		layeredPane.add(Add_Student_group, "name_50114292143300");
		Add_Student_group.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(28, 32, 1421, 499);
		Add_Student_group.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Add Student Groups");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(459, 5, 291, 38);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Acedamic Year & Semester");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(69, 84, 168, 38);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Programme");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(69, 175, 168, 38);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Group Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(69, 264, 168, 38);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Sub Group Number");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(69, 357, 168, 38);
		panel.add(lblNewLabel_5);
		
		JSpinner spin_grpid = new JSpinner();
		spin_grpid.setBounds(283, 270, 176, 32);
		panel.add(spin_grpid);
		
		JSpinner spin_subgrpid = new JSpinner();
		spin_subgrpid.setBounds(283, 363, 176, 32);
		panel.add(spin_subgrpid);
		
		JComboBox combo_acedamic = new JComboBox(new Object[]{"Y1S1","Y1S2","Y2S1"});
		combo_acedamic.setBounds(283, 89, 176, 32);
		panel.add(combo_acedamic);
		
		JComboBox combo_prgrm = new JComboBox(new Object[]{"IT","DS","CS"});
		combo_prgrm.setBounds(283, 181, 176, 30);
		panel.add(combo_prgrm);
		
		panel_1 = new JPanel();
		panel_1.setBounds(885, 84, 432, 240);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btn_generate = new JButton("Generate IDs");
		btn_generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acedemic = (String)combo_acedamic.getSelectedItem();
				String program = (String)combo_prgrm.getSelectedItem();
				int grp_id = (int) spin_grpid.getValue();
				int subgrp_id =(int) spin_subgrpid.getValue();
				
			
				
				
				String answer = acedemic + "." + program + "." + grp_id;
				txt_grpid.setText(answer);
				
				String answer2 = acedemic + "." + program + "." + grp_id + "." + subgrp_id;
				txt_subgrpid.setText(answer2);
				
				
			}
		});
		btn_generate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_generate.setBounds(275, 22, 116, 27);
		panel_1.add(btn_generate);
		
		lblNewLabel_6 = new JLabel("Group ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(22, 88, 103, 21);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Sub Group ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(22, 167, 103, 21);
		panel_1.add(lblNewLabel_7);
		
		txt_grpid = new JTextField();
		txt_grpid.setColumns(10);
		txt_grpid.setBounds(200, 88, 145, 19);
		panel_1.add(txt_grpid);
		
		txt_subgrpid = new JTextField();
		txt_subgrpid.setColumns(10);
		txt_subgrpid.setBounds(200, 167, 145, 19);
		panel_1.add(txt_subgrpid);
		
		btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String acedemic = (String)combo_acedamic.getSelectedItem();
				String program = (String)combo_prgrm.getSelectedItem();
				int grp_id = (int) spin_grpid.getValue();
				int subgrp_id =(int) spin_subgrpid.getValue();
				String txt_grp = txt_grpid.getText();
				String txt_subgrp = txt_subgrpid.getText();
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					String query = "INSERT INTO Student_grp values(000,'" + acedemic +"','" + program + "','" + grp_id + "','" + subgrp_id + "','" + txt_grp + "','" + txt_subgrp + "')";
					
					
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
		btn_save.setBounds(970, 416, 116, 27);
		panel.add(btn_save);
		
		btn_clear = new JButton("Clear");
		btn_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_clear.setBounds(1201, 416, 116, 27);
		panel.add(btn_clear);
		
		View_groups = new JPanel();
		View_groups.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		layeredPane.add(View_groups, "name_50140384754300");
		View_groups.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(23, 90, 479, 500);
		View_groups.add(panel_2);
		
		lblNewLabel_9 = new JLabel("Acedamic Year & Semester");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 24, 168, 38);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Programme");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(10, 72, 168, 38);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Group Number");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_11.setBounds(10, 126, 168, 38);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Sub Group Number");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 174, 168, 38);
		panel_2.add(lblNewLabel_12);
		
		spin_grpno = new JSpinner();
		spin_grpno.setBounds(224, 132, 176, 32);
		panel_2.add(spin_grpno);
		
		spin_subgrpno = new JSpinner();
		spin_subgrpno.setBounds(224, 180, 176, 32);
		panel_2.add(spin_subgrpno);
		
		combo_acdisplay = new JComboBox(new Object[]{"Y1S1","Y1S2","Y2S1"});
		combo_acdisplay.setBounds(224, 29, 176, 32);
		panel_2.add(combo_acdisplay);
		
		combo_proDisplay = new JComboBox(new Object[]{"IT","DS","CS"});
		combo_proDisplay.setBounds(224, 78, 176, 30);
		panel_2.add(combo_proDisplay);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 247, 341, 185);
		panel_2.add(panel_3);
		
		btnNewButton_1 = new JButton("Generate IDs");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acedemic_1 = (String)combo_acdisplay.getSelectedItem();
				String program_1 = (String)combo_proDisplay.getSelectedItem();
				int grp_id_1 = (int) spin_grpno.getValue();
				int subgrp_id_1 =(int) spin_subgrpno.getValue();
				
			
				
				
				String answer = acedemic_1 + "." + program_1 + "." + grp_id_1;
				txt_disgrp_id.setText(answer);
				
				String answer2 = acedemic_1 + "." + program_1 + "." + grp_id_1 + "." + subgrp_id_1;
				txt_disgrp_subid.setText(answer2);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(204, 10, 116, 27);
		panel_3.add(btnNewButton_1);
		
		lblNewLabel_13 = new JLabel("Group ID");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_13.setBounds(10, 55, 103, 21);
		panel_3.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Sub Group ID");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_14.setBounds(10, 101, 103, 21);
		panel_3.add(lblNewLabel_14);
		
		txt_disgrp_id = new JTextPane();
		txt_disgrp_id.setBounds(134, 57, 160, 19);
		panel_3.add(txt_disgrp_id);
		
		txt_disgrp_subid = new JTextPane();
		txt_disgrp_subid.setBounds(134, 103, 160, 19);
		panel_3.add(txt_disgrp_subid);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(10, 222, 401, 3);
		panel_2.add(separator_1);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acedemic_update = (String)combo_acdisplay.getSelectedItem();
				String program_update = (String)combo_proDisplay.getSelectedItem();
				int grp_id_update = (int) spin_grpno.getValue();
				int subgrp_id_update =(int) spin_subgrpno.getValue();
				String txt_grp_update = txt_disgrp_id.getText();
				String txt_subgrp_update = txt_disgrp_subid.getText();
				
				
				int selectedRow = table_stgrp.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_stgrp.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						 String query = "UPDATE Student_grp set academic_year_sem='"+acedemic_update+"', programme='"+program_update+"', group_no='"+grp_id_update+"', subGroup_no='"+subgrp_id_update+"' ,group_id='"+txt_grp_update+"',subGroup_id='"+txt_subgrp_update+"' where sg_id='"+id+"'";
						 PreparedStatement pst = connection.prepareStatement(query);
							
						 int x = pst.executeUpdate(query);

						if (x == 0) {
				             JOptionPane.showMessageDialog(btn_update, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_update,
				                "Student Group details successfully updated");
				         }

	                    
	                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btn_update.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_update.setBounds(26, 452, 116, 27);
		panel_2.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_stgrp.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_stgrp.getModel();
			     String sg_id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						String query = "DELETE  FROM Student_grp WHERE sg_id = "+sg_id;
						PreparedStatement pst = connection.prepareStatement(query);
						int rs = pst.executeUpdate(query);		  
						
						if (rs == 0) {
				             JOptionPane.showMessageDialog(btn_delete, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_delete,"Customer details successfully Deleted");
				         }
				         connection.close();
	                   
						
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
			     
			     combo_acdisplay.setSelectedItem("");
			     combo_proDisplay.setSelectedItem("");
					spin_grpno.setValue("");
					spin_subgrpno.setValue("");
					
					refreshSt_grp();
				
			}
		});
		btn_delete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_delete.setBounds(171, 452, 116, 27);
		panel_2.add(btn_delete);
		
		JButton btn_view_clear = new JButton("Clear");
		btn_view_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 combo_acdisplay.setSelectedItem("");
			     combo_proDisplay.setSelectedItem("");
					//spin_grpno.setValue("");
					//spin_subgrpno.setValue("");
					txt_disgrp_id.setText("");
					txt_disgrp_subid.setText("");
			}
		});
		btn_view_clear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_view_clear.setBounds(325, 452, 116, 27);
		panel_2.add(btn_view_clear);
		
		lblNewLabel_8 = new JLabel("Update/Delete Student Group Details ");
		lblNewLabel_8.setBounds(111, 42, 291, 38);
		View_groups.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(554, 64, 2, 526);
		View_groups.add(separator_1_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(606, 131, 869, 445);
		View_groups.add(scrollPane);
		
		table_stgrp = new JTable();
		table_stgrp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					int row = table_stgrp.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel) table_stgrp.getModel(); 
					
					combo_acdisplay.setSelectedItem(model.getValueAt(row, 1).toString());
					combo_proDisplay.setSelectedItem(model.getValueAt(row, 2).toString());
					spin_grpno.setValue(model.getValueAt(row, 3));
					spin_subgrpno.setValue(model.getValueAt(row, 4));
					
					
					
					String sg_ID =(table_stgrp.getModel().getValueAt(row, 0).toString());
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					 String query = "select academic_year_sem,programme,group_no,subGroup_no from student_grp  where sg_id ='"+sg_ID+"'" ;
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                    while(rs.next()) {
			            	 
			            	combo_acdisplay.setSelectedItem("academic_year_sem");
			            	combo_proDisplay.setSelectedItem("programme");
			            	spin_grpno.setValue(rs.getString("group_no"));
			            	spin_subgrpno.setValue(rs.getString("subGroup_no"));
			            	 
			            	 
			            	 
			             }
	                    
	                    
	                    st.close();
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
		
	
		 model = new DefaultTableModel();
		Object[] column = {"sg_id","academic_year_sem","programme","group_no","subGroup_no"};
		final Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table_stgrp.setModel(model);
		
		
		
		
		scrollPane.setViewportView(table_stgrp);
		
		JLabel lblNewLabel_8_1 = new JLabel("Manage Student Groups");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.BLACK);
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8_1.setBounds(555, 10, 291, 38);
		View_groups.add(lblNewLabel_8_1);
		
		//Connection connection = null;
		
		JButton btn_details = new JButton("View Details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					 String query = "select * from student_grp";
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                   table_stgrp.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			}
		});
		btn_details.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_details.setBounds(1374, 94, 116, 27);
		View_groups.add(btn_details);
		
		lblNewLabel_16 = new JLabel("Search");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(1156, 52, 103, 21);
		View_groups.add(lblNewLabel_16);
		
		txt_search = new JTextField();
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}
		});
		txt_search.setBounds(1269, 42, 152, 32);
		View_groups.add(txt_search);
		txt_search.setColumns(10);
		
		JButton btn_view_groups = new JButton("View Student Groups");
		btn_view_groups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(View_groups);
			}
		});
		btn_view_groups.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_view_groups.setBounds(1281, 129, 167, 34);
		contentPane.add(btn_view_groups);
		
		btn_add_grp = new JButton("Add Student Groups");
		btn_add_grp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Add_Student_group);
			}
		});
		btn_add_grp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_add_grp.setBounds(1073, 129, 167, 34);
		contentPane.add(btn_add_grp);
	}
}
