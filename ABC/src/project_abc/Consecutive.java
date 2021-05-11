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
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Consecutive extends JFrame {

	private JPanel contentPane;
	private JTable table_session;
	private JTable table_consecutive;
	//TableModel model1;
	DefaultTableModel model2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consecutive frame = new Consecutive();
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
	public Consecutive() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1468, 756);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 80, 1497, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(186, 115, 2, 649);
		contentPane.add(separator_1);
		
		JButton btnNewButton_1_2_2 = new JButton("Add Session");
		btnNewButton_1_2_2.setBounds(10, 138, 155, 47);
		contentPane.add(btnNewButton_1_2_2);
		
		JButton btnNewButton_1_2_1 = new JButton("Consecutive");
		btnNewButton_1_2_1.setBounds(10, 226, 155, 47);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2 = new JButton("Parallel ");
		btnNewButton_1_2.setBounds(10, 336, 155, 47);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Non-overlapping");
		btnNewButton_1_3.setBounds(10, 445, 155, 47);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Session Rooms");
		btnNewButton_1_4.setBounds(10, 544, 155, 47);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Not Available Time");
		btnNewButton_1_5.setBounds(10, 648, 155, 47);
		contentPane.add(btnNewButton_1_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 170, 1176, 301);
		contentPane.add(scrollPane);
		
		table_session = new JTable();
		table_session.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		scrollPane.setViewportView(table_session);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(229, 544, 1172, 175);
		contentPane.add(scrollPane_1);
		
		table_consecutive = new JTable();
		table_consecutive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		 model2 = new DefaultTableModel();
			Object[] column = {"ID","Session Code","Lecture1","Lecture2","Subject Name","Subject Code","Group ID","Tag","No of Students","Duration"};
			final Object[] row = new Object[0];
			model2.setColumnIdentifiers(column);
			table_consecutive.setModel(model2);
		scrollPane_1.setViewportView(table_consecutive);
		
		
		JButton btn_loadsession = new JButton("Load Details");
		btn_loadsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
					 String query = "select id as 'ID',sessionCode as 'Session Code',lecturer_1 as 'Lecture1',lecturer_2 as 'Lecture2',subjectName as 'Subject Name',subjectCode as 'Subject Code',groupID as 'Group ID',tag as 'Tag',noOfStudents as 'No of Students',duration as 'Duration'  from session";
	                    
					 PreparedStatement st =  connection.prepareStatement(query);
	                    ResultSet rs = st.executeQuery();
		                   
	                   table_session.setModel(DbUtils.resultSetToTableModel(rs));
	                    
	                    
	                    st.close();
	                    
	                    
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btn_loadsession.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_loadsession.setBounds(1262, 119, 116, 27);
		contentPane.add(btn_loadsession);
		
		JButton btn_addsession = new JButton("Add Session");
		
		btn_addsession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					java.sql.Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "Highschool23*");
					
				TableModel model1 =  table_session.getModel();
				int indexs[] = table_session.getSelectedRows();
				
				Object[] row = new Object[10];
				
				
				DefaultTableModel model2 = (DefaultTableModel) table_consecutive.getModel();
				
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
					
					
					String query = "insert into consecutive(con_id,con_Code,lecturer_1,lecturer_2,subjectName,subjectCode,groupID,tag,noOfStudents,duration) values (?,?,?,?,?,?,?,?,?,?)";
					
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
		btn_addsession.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_addsession.setBounds(1218, 481, 116, 27);
		contentPane.add(btn_addsession);
	}
}
