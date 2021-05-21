package abc_institute;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.CardLayout;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.sun.jdi.connect.spi.Connection;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
	private JSpinner spin_grpid;
	private JSpinner spin_subgrpid;
	private JComboBox combo_acdisplay;
	private JComboBox combo_proDisplay;
	private JComboBox combo_acedamic;
	private JComboBox combo_prgrm;
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
	private JLabel lbl_academic;
	private JLabel lbl_prgm;
	private JLabel lbl_grpno;
	private JLabel lbl_subno;

	/**
	 * Launch the application.
	 */
	
	
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
		setTitle("Student Groups");
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1494, 784);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(22, 21, 466, 80);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(54, 116, 1426, 2);
		contentPane.add(separator);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(124, 192, 1333, 600);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Add_Student_group = new JPanel();
		Add_Student_group.setBackground(new Color(255, 255, 255));
		Add_Student_group.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		layeredPane.add(Add_Student_group, "name_50114292143300");
		Add_Student_group.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(55, 32, 1246, 499);
		Add_Student_group.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Add Student Groups");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(493, 10, 291, 38);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Academic Year & Semester");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(69, 84, 204, 38);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Programme");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(69, 175, 168, 38);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Group Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(69, 264, 168, 38);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Sub Group Number");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(69, 357, 168, 38);
		panel.add(lblNewLabel_5);
		
		JSpinner spin_grpid = new JSpinner();
		spin_grpid.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				lbl_grpno.setText("");
			}
		});
		spin_grpid.setBounds(283, 270, 176, 32);
		panel.add(spin_grpid);
		
		JSpinner spin_subgrpid = new JSpinner();
		spin_subgrpid.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				lbl_subno.setText("");
			}
		});
		spin_subgrpid.setBounds(283, 363, 176, 32);
		panel.add(spin_subgrpid);
		
		JComboBox combo_acedamic = new JComboBox(new Object[]{"Select","Y1S1","Y1S2","Y2S1","Y2S2","Y3S1","Y3S2","Y4S1","Y4S2"});
		combo_acedamic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_academic.setText("");
			}
		});
		combo_acedamic.setBounds(283, 89, 176, 32);
		panel.add(combo_acedamic);
		
		JComboBox combo_prgrm = new JComboBox(new Object[]{"Select","IT","DS","CS","IM","ISE","SE","CSNE","Curtin IT","Curtin CSNE"});
		combo_prgrm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lbl_prgm.setText("");
			}
		});
		combo_prgrm.setBounds(283, 181, 176, 30);
		panel.add(combo_prgrm);
		
		panel_1 = new JPanel();
		panel_1.setBounds(786, 84, 432, 240);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btn_generate = new JButton("Generate IDs");
		btn_generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String acedemic = (String)combo_acedamic.getSelectedItem();
				String program = (String)combo_prgrm.getSelectedItem();
				int grp_id = (int) spin_grpid.getValue();
				int subgrp_id =(int) spin_subgrpid.getValue();
				
				if(combo_acedamic.getSelectedItem() == "Select" && combo_prgrm.getSelectedItem() == "Select" && (int)spin_grpid.getValue() == 0 && (int)spin_subgrpid.getValue() == 0 )  {
					lbl_academic.setText("Select an Academic Year");
					lbl_prgm.setText("Select a Programme");
					lbl_grpno.setText("Select a group ID");
					lbl_subno.setText("Select a Sub group ID");
				}else if(combo_acedamic.getSelectedItem() == "Select") {
					lbl_academic.setText("Select an Academic Year");
				}else if(combo_prgrm.getSelectedItem() == "Select") {
					lbl_prgm.setText("Select a Programme");
				}else if((int)spin_grpid.getValue() == 0 ) {
					lbl_grpno.setText("Select a group ID");
				}else if((int)spin_subgrpid.getValue() == 0) {
					lbl_subno.setText("Select a Sub group ID");
				}
				
			
				
				else {
				String answer = acedemic + "." + program + "." + grp_id;
				txt_grpid.setText(answer);
				
				String answer2 = acedemic + "." + program + "." + grp_id + "." + subgrp_id;
				txt_subgrpid.setText(answer2);
				}
				
			}
		});
		btn_generate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_generate.setBounds(265, 22, 126, 27);
		panel_1.add(btn_generate);
		
		lblNewLabel_6 = new JLabel("Group ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(22, 88, 103, 21);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Sub Group ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(22, 167, 103, 21);
		panel_1.add(lblNewLabel_7);
		
		txt_grpid = new JTextField();
		txt_grpid.setColumns(10);
		txt_grpid.setBounds(200, 88, 191, 34);
		panel_1.add(txt_grpid);
		
		txt_subgrpid = new JTextField();
		txt_subgrpid.setColumns(10);
		txt_subgrpid.setBounds(200, 167, 191, 34);
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
				
				
				
				
				if(combo_acedamic.getSelectedItem() == "Select" && combo_prgrm.getSelectedItem() == "Select" && (int)spin_grpid.getValue() == 0 && (int)spin_subgrpid.getValue() == 0 )  {
					lbl_academic.setText("Select an Academic Year");
					lbl_prgm.setText("Select a Programme");
					lbl_grpno.setText("Select a group ID");
					lbl_subno.setText("Select a Sub group ID");
				}else if(combo_acedamic.getSelectedItem() == "Select") {
					lbl_academic.setText("Select an Academic Year");
				}else if(combo_prgrm.getSelectedItem() == "Select") {
					lbl_prgm.setText("Select a Programme");
				}else if((int)spin_grpid.getValue() == 0 ) {
					lbl_grpno.setText("Select a group ID");
				}else if((int)spin_subgrpid.getValue() == 0) {
					lbl_subno.setText("Select a Sub group ID");
				}else {
				
					
					
					
					 
				
				
				try {
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					java.sql.Connection connection = DBConnect.getConnection();
					String query = "INSERT INTO student_grp values(000,'" + acedemic +"','" + program + "','" + grp_id + "','" + subgrp_id + "','" + txt_grp + "','" + txt_subgrp + "')";
					
					
					Statement statement = connection.createStatement();
					statement.executeUpdate(query);
					
					
					
					JOptionPane.showMessageDialog(null, "Data Added Successfully" );
						
					
						
						
					
					 
						
						
					
					
					 connection.close();
					
					
					
					
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "The Record is Alredy Exist");
				}
				
				
				}
				
				
			}
		});
		
		
		
		
		
		btn_save.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_save.setBounds(925, 416, 116, 27);
		panel.add(btn_save);
		
		
		
		
		btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				combo_acedamic.setSelectedIndex(0);
				combo_prgrm.setSelectedIndex(0);
				spin_grpid.setValue(0);
				spin_subgrpid.setValue(0);
				txt_grpid.setText("");
				txt_subgrpid.setText("");
			
				
			}
		});
		btn_clear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_clear.setBounds(1102, 416, 116, 27);
		panel.add(btn_clear);
		
		lbl_academic = new JLabel("");
		lbl_academic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_academic.setForeground(Color.RED);
		lbl_academic.setBounds(283, 131, 176, 13);
		panel.add(lbl_academic);
		
		lbl_prgm = new JLabel("");
		lbl_prgm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_prgm.setForeground(Color.RED);
		lbl_prgm.setBounds(283, 221, 176, 13);
		panel.add(lbl_prgm);
		
		lbl_grpno = new JLabel("");
		lbl_grpno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_grpno.setForeground(Color.RED);
		lbl_grpno.setBounds(283, 311, 176, 13);
		panel.add(lbl_grpno);
		
		lbl_subno = new JLabel("");
		lbl_subno.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lbl_subno.setForeground(Color.RED);
		lbl_subno.setBounds(283, 410, 176, 13);
		panel.add(lbl_subno);
		
		View_groups = new JPanel();
		View_groups.setBackground(new Color(255, 255, 255));
		View_groups.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		layeredPane.add(View_groups, "name_50140384754300");
		View_groups.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(23, 72, 479, 500);
		View_groups.add(panel_2);
		
		lblNewLabel_9 = new JLabel("Acedamic Year & Semester");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 24, 194, 38);
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Programme");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(10, 72, 168, 38);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Group Number");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(10, 126, 168, 38);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Sub Group Number");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(10, 174, 168, 38);
		panel_2.add(lblNewLabel_12);
		
		spin_grpno = new JSpinner();
		spin_grpno.setBounds(224, 132, 176, 32);
		panel_2.add(spin_grpno);
		
		spin_subgrpno = new JSpinner();
		spin_subgrpno.setBounds(224, 180, 176, 32);
		panel_2.add(spin_subgrpno);
		
		combo_acdisplay = new JComboBox(new Object[]{"Select","Y1S1","Y1S2","Y2S1","Y2S2","Y3S1","Y3S2","Y4S1","Y4S2"});
		combo_acdisplay.setMaximumRowCount(10);
		combo_acdisplay.setBounds(224, 29, 176, 27);
		panel_2.add(combo_acdisplay);
		
		combo_proDisplay = new JComboBox(new Object[]{"Select","IT","DS","CS","IM","ISE","SE","CSNE","Curtin IT","Curtin CSNE"});
		combo_proDisplay.setMaximumRowCount(10);
		combo_proDisplay.setBounds(224, 78, 176, 27);
		panel_2.add(combo_proDisplay);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(10, 247, 390, 185);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(204, 10, 160, 27);
		panel_3.add(btnNewButton_1);
		
		lblNewLabel_13 = new JLabel("Group ID");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(10, 55, 103, 21);
		panel_3.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Sub Group ID");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
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
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
						 String query = "UPDATE student_grp set academic_year_sem='"+acedemic_update+"', programme='"+program_update+"', group_no='"+grp_id_update+"', subGroup_no='"+subgrp_id_update+"' ,group_id='"+txt_grp_update+"',subGroup_id='"+txt_subgrp_update+"' where sg_id='"+id+"'";
						 PreparedStatement pst = connection.prepareStatement(query);
							
						  pst.executeUpdate(query);

						
				             JOptionPane.showMessageDialog(btn_update,"Student Group details successfully updated");
				         

	                    
	                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     
			 	try {
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
			 		
			 		java.sql.Connection connection = DBConnect.getConnection();
					
					String query = "select sg_id as 'ID',academic_year_sem as 'Acedamic Year & Sem',programme as 'Programme',group_no as 'GroupNo',subGroup_no as 'SubGroupNo',group_id as 'Group ID',subGroup_id as 'SubGroup ID'  from student_grp";
	                    
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
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_update.setBounds(26, 452, 116, 27);
		panel_2.add(btn_update);
		
		JButton btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_stgrp.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_stgrp.getModel();
			     String sg_id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 //java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
			    	 
			    	 java.sql.Connection connection = DBConnect.getConnection();
						
						String query = "DELETE  FROM student_grp WHERE sg_id = "+sg_id;
						PreparedStatement pst = connection.prepareStatement(query);
						int rs = pst.executeUpdate(query);		  
						
						if (rs == 0) {
				             JOptionPane.showMessageDialog(btn_delete, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_delete,"Student Group details successfully Deleted");
				         }
				         connection.close();
	                   
						
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
			     
			     
			     try {
						//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
			    	 
			    	 java.sql.Connection connection = DBConnect.getConnection();
						
						String query = "select sg_id as 'ID',academic_year_sem as 'Acedamic Year & Sem',programme as 'Programme',group_no as 'GroupNo',subGroup_no as 'SubGroupNo',group_id as 'Group ID',subGroup_id as 'SubGroup ID'  from student_grp";
		                    
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
		btn_delete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_delete.setBounds(171, 452, 116, 27);
		panel_2.add(btn_delete);
		
		JButton btn_view_clear = new JButton("Clear");
		btn_view_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 combo_acdisplay.setSelectedIndex(0);
			     combo_proDisplay.setSelectedIndex(0);
					spin_grpno.setValue(0);
					spin_subgrpno.setValue(0);
					txt_disgrp_id.setText("");
					txt_disgrp_subid.setText("");
			}
		});
		btn_view_clear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_view_clear.setBounds(325, 452, 116, 27);
		panel_2.add(btn_view_clear);
		
		lblNewLabel_8 = new JLabel("Update/Delete Student Group Details ");
		lblNewLabel_8.setBounds(23, 24, 330, 38);
		View_groups.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(0, 0, 102));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(554, 64, 2, 526);
		View_groups.add(separator_1_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(606, 131, 698, 445);
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
					txt_disgrp_id.setText(model.getValueAt(row, 5).toString());
					txt_disgrp_subid.setText(model.getValueAt(row, 6).toString());					
					
					
					String sg_ID =(table_stgrp.getModel().getValueAt(row, 0).toString());
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					java.sql.Connection connection = DBConnect.getConnection();
					
					 String query = "select academic_year_sem,programme,group_no,subGroup_no,group_id,subGroup_id from student_grp  where sg_id ='"+sg_ID+"'" ;
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                    while(rs.next()) {
			            	 
			            	combo_acdisplay.setSelectedItem("academic_year_sem");
			            	combo_proDisplay.setSelectedItem("programme");
			            	spin_grpno.setValue(rs.getString("group_no"));
			            	spin_subgrpno.setValue(rs.getString("subGroup_no"));
			            	txt_disgrp_id.setText(rs.getString("group_id"));
			            	txt_disgrp_subid.setText(rs.getString("subGroup_id"));
			            	 			            	 
			             }
	                    	                    
	                    st.close();	                    
	                   					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
								
			}
		});
			
		 model = new DefaultTableModel();
		Object[] column = {"ID","Acedamic Year & Sem","Programme","GroupNo","SubGroupNo","Group ID","SubGroup ID"};
		final Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		table_stgrp.setModel(model);
		
		
		
		
		scrollPane.setViewportView(table_stgrp);
		
		JLabel lblNewLabel_8_1 = new JLabel("Manage Student Groups");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_8_1.setBounds(653, 10, 291, 38);
		View_groups.add(lblNewLabel_8_1);
		
		//Connection connection = null;
		
		JButton btn_details = new JButton("View Details");
		btn_details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					java.sql.Connection connection = DBConnect.getConnection();
					
					 String query = "select sg_id as 'ID',academic_year_sem as 'Acedamic Year & Sem',programme as 'Programme',group_no as 'GroupNo',subGroup_no as 'SubGroupNo',group_id as 'Group ID',subGroup_id as 'SubGroup ID'  from student_grp";
	                    
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
		
		btn_details.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_details.setBounds(1177, 94, 126, 27);
		View_groups.add(btn_details);
		
		lblNewLabel_16 = new JLabel("Search By Program");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_16.setBounds(964, 52, 147, 21);
		View_groups.add(lblNewLabel_16);
		
		txt_search = new JTextField();
		txt_search.setToolTipText("");
		txt_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
                       
                    String query = "select * from student_grp where programme=?";
                    PreparedStatement st = (PreparedStatement) connection.prepareStatement(query);
                    st.setNString(1, txt_search.getText());
                    ResultSet rs = st.executeQuery();
                   
                    table_stgrp.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    
                    st.close();
                    
			 } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
				
				
			}
		});
		txt_search.setBounds(1121, 42, 185, 32);
		View_groups.add(txt_search);
		txt_search.setColumns(10);
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Student Group  Details");
		lblNewLabel_8_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_8_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8_1_1_1.setBounds(824, 90, 291, 38);
		View_groups.add(lblNewLabel_8_1_1_1);
		
		JButton btn_view_groups = new JButton("View Student Groups");
		btn_view_groups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(View_groups);
			}
		});
		btn_view_groups.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_view_groups.setBounds(1268, 129, 189, 34);
		contentPane.add(btn_view_groups);
		
		btn_add_grp = new JButton("Add Student Groups");
		btn_add_grp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(Add_Student_group);
			}
		});
		btn_add_grp.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_add_grp.setBounds(1056, 129, 167, 34);
		contentPane.add(btn_add_grp);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main main = new Main();
				main.show();
			}
		});
		btnNewButton.setBackground(new Color(102, 153, 204));
		btnNewButton.setIcon(new ImageIcon(grp_student.class.getResource("/abc_institute/home1.png")));
		btnNewButton.setBounds(39, 129, 54, 47);
		contentPane.add(btnNewButton);
	}
}
