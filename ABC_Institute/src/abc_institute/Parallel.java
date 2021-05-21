package abc_institute;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;
import session_manage.session_main;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Parallel extends JFrame {

	private JPanel contentPane;
	private JTable table_sessionpara;
	
	private JTable table_para;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parallel frame = new Parallel();
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
	public Parallel() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1539, 843);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(175, 125, 2, 649);
		contentPane.add(separator_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 170, 1176, 301);
		contentPane.add(scrollPane);
		
		table_sessionpara = new JTable();
		scrollPane.setViewportView(table_sessionpara);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 106, 1497, 2);
		contentPane.add(separator);
		
		
		
		JButton btn_loadsession = new JButton("Load Details");
		btn_loadsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
					//load details from session table
					 String query = "select id as 'ID',sessionCode as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from session";
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                   table_sessionpara.setModel(DbUtils.resultSetToTableModel(rs));
	                   
	                   st.close();
	                   
	                   
	                   //load details from consecutive table
	                   String query2 = "select par_id as 'ID',par_Code as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from parallel";
	                    
						 PreparedStatement st1 =  connection.prepareStatement(query2);
		                    ResultSet rs1 = st1.executeQuery();
			                   
		                   table_para.setModel(DbUtils.resultSetToTableModel(rs1)); 
	                    
	                    st1.close();
	                    
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btn_loadsession.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_loadsession.setBounds(1274, 125, 127, 27);
		contentPane.add(btn_loadsession);
		
		JButton btn_addsess = new JButton("Add Session");
		btn_addsess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
				TableModel model1 =  table_sessionpara.getModel();
				int indexs[] = table_sessionpara.getSelectedRows();
				
				Object[] row = new Object[10];
				
				
				DefaultTableModel model2 = (DefaultTableModel) table_para.getModel();
				
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
					
					
					String query = "insert into parallel(par_id,par_Code,lecturer_1,lecturer_2,subjectName,subjectCode,groupID,tag,noOfStudents,duration) values (?,?,?,?,?,?,?,?,?,?)";
					
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
				
				
				JOptionPane.showMessageDialog(null, "Parallel Sessions Added Successfully" );
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "The Record is Already Exist");
				}
			}
		});
		btn_addsess.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_addsess.setBounds(1274, 502, 127, 27);
		contentPane.add(btn_addsess);
		
		JButton btn_delpara = new JButton("Delete Parallel Rows");
		btn_delpara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_para.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_para.getModel();
			     String par_id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 //java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
						
			    	 Connection connection = DBConnect.getConnection();
						String query = "DELETE  FROM parallel WHERE par_id = "+par_id;
						PreparedStatement pst = connection.prepareStatement(query);
						int rs = pst.executeUpdate(query);		  
						
						if (rs == 0) {
				             JOptionPane.showMessageDialog(btn_delpara, "This is alredy exist");
				         } else {
				             JOptionPane.showMessageDialog(btn_delpara,"Parallel Sessions  details successfully Deleted");
				         }
				         connection.close();
	                   
						
					}
					catch (Exception exception) {
				         exception.printStackTrace();
				     }
			     try {
						//java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
						
			    	 Connection connection = DBConnect.getConnection();
		                   
		                   
		                   //load details from consecutive table
		                   String query2 = "select par_id as 'ID',par_Code as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from parallel";
		                    
							 PreparedStatement st1 =  connection.prepareStatement(query2);
			                    ResultSet rs1 = st1.executeQuery();
				                   
			                   table_para.setModel(DbUtils.resultSetToTableModel(rs1)); 
		                    
		                    st1.close();
		                    
		                    
		                    
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			     
			     
			}
		});
		btn_delpara.setFont(new Font("Tahoma", Font.BOLD, 13));
		btn_delpara.setBounds(928, 502, 242, 27);
		contentPane.add(btn_delpara);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(225, 540, 1176, 216);
		contentPane.add(scrollPane_1);
		
		table_para = new JTable();
		scrollPane_1.setViewportView(table_para);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 70));
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(22, 18, 466, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_8 = new JLabel("Manage Parallel Sessions");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(new Color(0, 0, 102));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_8.setBounds(633, 125, 364, 38);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1_5 = new JButton("Not Available Time");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_not_available_times add_not_available_times = new Add_not_available_times();
				add_not_available_times.show();
				
				dispose();
			}
		});
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_5.setBounds(10, 684, 155, 47);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main main = new Main();
				main.show();
				
				dispose();
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(20, 126, 70, 70);
		Image imgH = new ImageIcon(this.getClass().getResource("/abc_institute/home1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgH));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_2_2 = new JButton("Add Session");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Session session = new Session();
				session.show();
				
				dispose();
			}
		});
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2_2.setBounds(10, 227, 155, 47);
		contentPane.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Consecutive");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Consecutive con = new Consecutive();
				con.show();
				
				dispose();
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2_1.setBounds(10, 317, 155, 47);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2 = new JButton("Parallel ");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Parallel par = new Parallel();
				par.show();
				
				dispose();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2.setBounds(10, 410, 155, 47);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Non-overlapping");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				Nonoverlap nonoverlap = new Nonoverlap();
				nonoverlap.show();
				
				dispose();
			}
		});
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_3.setBounds(10, 502, 155, 47);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Session Rooms");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				session_main session_main = new session_main();
				session_main.show();
				
				dispose();
			}
		});
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_4.setBounds(10, 592, 155, 47);
		contentPane.add(btnNewButton_1_4);
	}
}
