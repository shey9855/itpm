package project_abc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Nonoverlap extends JFrame {

	private JPanel contentPane;
	private JTable table_sessionnon;
	
	private JTable table_nonoverlap;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nonoverlap frame = new Nonoverlap();
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
	public Nonoverlap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1479, 860);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 100, 1497, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(187, 164, 2, 649);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 170, 1176, 301);
		contentPane.add(scrollPane);
		
		table_sessionnon = new JTable();
		scrollPane.setViewportView(table_sessionnon);
		
		
		
		JButton btn_loadsession = new JButton("Load Details");
		btn_loadsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					//load details from session table
					 String query = "select id as 'ID',sessionCode as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from session";
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                   table_sessionnon.setModel(DbUtils.resultSetToTableModel(rs));
	                   
	                   st.close();
	                   
	                   //load details from consecutive table
	                   String query2 = "select non_id as 'ID',non_Code as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from nonoverlap";
	                    
						 PreparedStatement st1 =  connection.prepareStatement(query2);
		                    ResultSet rs1 = st1.executeQuery();
			                   
		                   table_nonoverlap.setModel(DbUtils.resultSetToTableModel(rs1)); 
	                    
	                    st1.close();
	                   
	                    
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btn_loadsession.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_loadsession.setBounds(1285, 122, 116, 27);
		contentPane.add(btn_loadsession);
		
		JButton btn_loadsession_1 = new JButton("Add Session");
		btn_loadsession_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
				TableModel model1 =  table_sessionnon.getModel();
				int indexs[] = table_sessionnon.getSelectedRows();
				
				Object[] row = new Object[10];
				
				
				DefaultTableModel model2 = (DefaultTableModel) table_nonoverlap.getModel();
				
				for (int i=0; i<indexs.length; i++)
				{
					row[0] = model1.getValueAt(indexs[i], 0).toString();
					row[1] = model1.getValueAt(indexs[i], 1).toString();
					row[2] = model1.getValueAt(indexs[i], 2).toString();
					row[3] = model1.getValueAt(indexs[i], 3).toString();
					row[4] = model1.getValueAt(indexs[i], 4).toString();
					row[5] = model1.getValueAt(indexs[i], 5).toString();
					row[6] = model1.getValueAt(indexs[i], 6).toString();
					row[7] = model1.getValueAt(indexs[i], 7).toString();
					row[8] = model1.getValueAt(indexs[i], 8).toString();
					row[9] = model1.getValueAt(indexs[i], 9).toString();
					
					model2.addRow(row);
					
					
					String query = "insert into nonoverlap(non_id,non_Code,lecturer_1,lecturer_2,subjectName,subjectCode,groupID,tag,noOfStudents,duration) values (?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement prepstmt = connection.prepareStatement(query);
					
					prepstmt.setString(1,(String) row[0]);
					prepstmt.setString(2,(String) row[1]);
					prepstmt.setString(3,(String) row[2]);
					prepstmt.setString(4,(String) row[3]);
					prepstmt.setString(5,(String) row[4]);
					prepstmt.setString(6,(String) row[5]);
					prepstmt.setString(7,(String) row[6]);
					prepstmt.setString(8,(String) row[7]);
					prepstmt.setString(9,(String) row[8]);
					prepstmt.setString(10,(String) row[9]);
					
					prepstmt.execute();
					
					
					
				}
				
				
				JOptionPane.showMessageDialog(null, "Data Added Successfully" );
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "The Record is Already Exist");
				}
			}
		});
		btn_loadsession_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_loadsession_1.setBounds(1285, 522, 116, 27);
		contentPane.add(btn_loadsession_1);
		
		JButton btn_nondelete = new JButton("Delete Nonoverlapping Rows");
		btn_nondelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_nonoverlap.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_nonoverlap.getModel();
			     String non_id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						String query = "DELETE  FROM nonoverlap WHERE non_id = "+non_id;
						PreparedStatement pst = connection.prepareStatement(query);
						int rs = pst.executeUpdate(query);		  
						
						if (rs == 0) {
				             JOptionPane.showMessageDialog(btn_nondelete, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_nondelete,"Student Group details successfully Deleted");
				         }
				         connection.close();
	                   
						
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
			     
			     try {
						java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
						
						
		                   
		                   //load details from consecutive table
		                   String query2 = "select non_id as 'ID',non_Code as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from nonoverlap";
		                    
							 PreparedStatement st1 =  connection.prepareStatement(query2);
			                    ResultSet rs1 = st1.executeQuery();
				                   
			                   table_nonoverlap.setModel(DbUtils.resultSetToTableModel(rs1)); 
		                    
		                    st1.close();
		                   
		                    
		                    
		                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			     
			  
                 
                  
                  
                  
				
			
			     
			     
			}
		});
		btn_nondelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_nondelete.setBounds(951, 522, 225, 27);
		contentPane.add(btn_nondelete);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(225, 565, 1176, 227);
		contentPane.add(scrollPane_1);
		
		table_nonoverlap = new JTable();
		scrollPane_1.setViewportView(table_nonoverlap);
	}
}
