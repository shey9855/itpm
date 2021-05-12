package itpm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.PreparableStatement;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Session extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1_2;
	private JButton btnNewButton_1_3;
	private JButton btnNewButton_1_4;
	private JButton btnNewButton_1_5;
	private JButton btnNewButton_1_2_1;
	private JButton btnNewButton_1_2_2;
	private JPanel add_panel;
	private JPanel panel_manage;
	private JTextField textFieldSessionCode;
	private JTextField textField_noOfstu;
	private JTextField textField;
	private JTextField session_code_1;
	private JTextField textField_studentCount;
	private JTable table_session;
	private JTextField textField_1_seacrh;
	private JComboBox comboBox_Lec1;
	private JComboBox comboBox_sub;
	private JComboBox comboBox_code;
	private JComboBox comboBox_tag;
	private JComboBox comboBox_grp;
	private JComboBox comboBox_Lec2;
	private JComboBox combo_lec2_1;
	private JComboBox combo_lec2;
	private JComboBox combo_sub2;
	private JComboBox combo_lec2_subcode;
	private JComboBox combo_sess_grpid;
	private JComboBox combo_sess_tag;
	private JSpinner spinnerSession;
	private JLabel lblNewLabel_level_required_1;
	private JSpinner spinner_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session frame = new Session();
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
	
	public void fillComboBoxLec()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		     Connection conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
		       
		       String query = "select*from lecturer";
		       PreparedStatement pStatement = conne.prepareStatement(query);
		       ResultSet rSet=pStatement.executeQuery();
		       
		       while (rSet.next()) {
		    	   comboBox_Lec1.addItem(rSet.getString("lecturer_name"));
		    	   comboBox_Lec2.addItem(rSet.getString("lecturer_name"));
		    	   combo_lec2_1.addItem(rSet.getString("lecturer_name"));
		    	   combo_lec2.addItem(rSet.getString("lecturer_name"));
			}
		       conne.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void fillComboBoxSubName()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
		       
		       String query = "select*from subject";
		       PreparedStatement pStatement = conne.prepareStatement(query);
		       ResultSet rSet=pStatement.executeQuery();
		       
		       while (rSet.next()) {
		    	   comboBox_sub.addItem(rSet.getString("sub_name"));
		    	   combo_sub2.addItem(rSet.getString("sub_name"));
			}
		       conne.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fillComboBoxSubcode()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
		       
		       String query = "select*from subject";
		       PreparedStatement pStatement = conne.prepareStatement(query);
		       ResultSet rSet=pStatement.executeQuery();
		       
		       while (rSet.next()) {
		    	   comboBox_code.addItem(rSet.getString("sub_code"));
		    	   combo_lec2_subcode.addItem(rSet.getString("sub_code"));
			}
		       conne.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fillComboBoxGrpID()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
		       
		       String query = "select*from student_grp";
		       PreparedStatement pStatement = conne.prepareStatement(query);
		       ResultSet rSet=pStatement.executeQuery();
		       
		       while (rSet.next()) {
		    	   comboBox_grp.addItem(rSet.getString("group_id"));
		    	   combo_sess_grpid.addItem(rSet.getString("group_id"));
			}
		       conne.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void fillComboBoxTag()
	{
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conne = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
		       
		       String query = "select*from tag";
		       PreparedStatement pStatement = conne.prepareStatement(query);
		       ResultSet rSet=pStatement.executeQuery();
		       
		       while (rSet.next()) {
		    	   comboBox_tag.addItem(rSet.getString("related_tag"));
		    	   combo_sess_tag.addItem(rSet.getString("related_tag"));
			}
		       conne.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	public Session() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBounds(22, 21, 466, 80);
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 127, 1497, 2);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(22, 0, 142, 129);
		//lblNewLabel_1.setIcon(new ImageIcon(Session.class.getResource("/itpm/logo.png")));
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(32, 139, 70, 70);
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
		Image imgH = new ImageIcon(this.getClass().getResource("/itpm/home1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgH));
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(215, 143, 2, 649);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		contentPane.add(separator_1);
		
		btnNewButton_1_2 = new JButton("Parallel ");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2.setBounds(36, 425, 155, 47);
		contentPane.add(btnNewButton_1_2);
		
		btnNewButton_1_3 = new JButton("Non-overlapping");
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_3.setBounds(36, 517, 155, 47);
		contentPane.add(btnNewButton_1_3);
		
		btnNewButton_1_4 = new JButton("Session Rooms");
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_4.setBounds(36, 607, 155, 47);
		contentPane.add(btnNewButton_1_4);
		
		btnNewButton_1_5 = new JButton("Not Available Time");
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_5.setBounds(36, 699, 155, 47);
		contentPane.add(btnNewButton_1_5);
		
		btnNewButton_1_2_1 = new JButton("Consecutive");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2_1.setBounds(36, 332, 155, 47);
		contentPane.add(btnNewButton_1_2_1);
		
		btnNewButton_1_2_2 = new JButton("Add Session");
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2_2.setBounds(36, 242, 155, 47);
		contentPane.add(btnNewButton_1_2_2);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(245, 179, 1260, 594);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		add_panel = new JPanel();
		add_panel.setBackground(Color.WHITE);
		layeredPane.add(add_panel, "name_689253134182800");
		add_panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Add Sessions");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(572, 21, 137, 30);
		add_panel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(93, 81, 1074, 491);
		add_panel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Session Code");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(70, 34, 119, 19);
		panel.add(lblNewLabel_3);
		
		textFieldSessionCode = new JTextField();
		textFieldSessionCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSessionCode.setColumns(10);
		textFieldSessionCode.setBounds(256, 34, 284, 26);
		panel.add(textFieldSessionCode);
		
		JLabel lblNewLabel_3_1 = new JLabel("Select Lecturer(s)");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(70, 93, 144, 19);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_3 = new JLabel("Select Subject");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(70, 154, 119, 19);
		panel.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Select Group");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(70, 216, 119, 19);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Number of \r\nStudents");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_1.setBounds(70, 273, 161, 19);
		panel.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Subject Code");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_2.setBounds(569, 154, 119, 19);
		panel.add(lblNewLabel_3_4_2);
		
		JLabel lblNewLabel_3_4_3 = new JLabel("Select Tag");
		lblNewLabel_3_4_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_3.setBounds(569, 216, 119, 19);
		panel.add(lblNewLabel_3_4_3);
		
		JLabel lblNewLabel_3_4_4 = new JLabel("Duration");
		lblNewLabel_3_4_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_4.setBounds(569, 273, 119, 19);
		panel.add(lblNewLabel_3_4_4);
		
		comboBox_Lec1 = new JComboBox();
		comboBox_Lec1.setBounds(256, 93, 284, 21);
		panel.add(comboBox_Lec1);
		
		comboBox_sub = new JComboBox();
		comboBox_sub.setBounds(256, 154, 284, 21);
		panel.add(comboBox_sub);
		
		comboBox_code = new JComboBox();
		comboBox_code.setBounds(698, 154, 301, 21);
		panel.add(comboBox_code);
		
		comboBox_tag = new JComboBox();
		comboBox_tag.setBounds(698, 214, 301, 21);
		panel.add(comboBox_tag);
		
		comboBox_grp = new JComboBox();
		comboBox_grp.setBounds(256, 216, 284, 21);
		panel.add(comboBox_grp);
		
		textField_noOfstu = new JTextField();
		textField_noOfstu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_noOfstu.setColumns(10);
		textField_noOfstu.setBounds(256, 266, 284, 26);
		panel.add(textField_noOfstu);
		
		spinnerSession = new JSpinner();
		spinnerSession.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinnerSession.setBounds(698, 266, 301, 26);
		panel.add(spinnerSession);
		
		comboBox_Lec2 = new JComboBox();
		comboBox_Lec2.setBounds(569, 94, 284, 21);
		panel.add(comboBox_Lec2);
		
		JButton session_generate = new JButton("Generate Session");
		session_generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//String sCode = (String)textFieldSessionCode.getText();
				String lec1 = (String)comboBox_Lec1.getSelectedItem();
				String lec2 = (String)comboBox_Lec2.getSelectedItem();
				String subName = (String)comboBox_sub.getSelectedItem();
				String subCode = (String)comboBox_code.getSelectedItem();
				String stdgrp = (String)comboBox_grp.getSelectedItem();
				String tag = (String)comboBox_tag.getSelectedItem();
				String num = (String)textField_noOfstu.getText();
				int dur = (int)spinnerSession.getValue();
				
				
					String session = "     "+lec1+"  - ("+lec2+") -  "+subName+"  -  "+subCode+"  -  "+stdgrp+"  -  "+tag+"  -  "+num+"  -  "+dur;
					textField.setText(session);
					//lblNewLabel_level_required_1.setText("");
					
			}
		});
		session_generate.setFont(new Font("Tahoma", Font.BOLD, 14));
		session_generate.setBounds(463, 321, 181, 31);
		panel.add(session_generate);
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 51, 102));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(256, 369, 597, 38);
		panel.add(textField);
		
		JButton Add = new JButton("Add Session");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sess_code = textFieldSessionCode.getText();
				String lec_1 =(String)comboBox_Lec1.getSelectedItem();
				String lec_2 =(String)comboBox_Lec2.getSelectedItem();
				String sub_name =(String)comboBox_sub.getSelectedItem();
				String sub_code =(String)comboBox_code.getSelectedItem();
				String group_id =(String)comboBox_grp.getSelectedItem();
				String tag =(String)comboBox_tag.getSelectedItem();
				String no_of_students = textField_noOfstu.getText();
				int duration = (int) spinnerSession.getValue();
				
				try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
			       Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

                   String query = "INSERT INTO session values(000,'" + sess_code + "','" + lec_1 + "','" + lec_2 + "','" + sub_name + "','"+sub_code+"','"+group_id+"','"+tag+"','"+no_of_students+"','"+duration+"')";                                                                                                       
                   Statement sta = connection2.createStatement();
                   int x = sta.executeUpdate(query);
                   
                   JOptionPane.showMessageDialog(null, "Inserted Successfully");
                   //subject_name_required.setText(""); 
                   //subject_code_required_1.setText(""); 
                   connection2.close();
                                      
               } catch (Exception exception) {
               	
                   exception.printStackTrace();
                   //JOptionPane.showMessageDialog(null, "Already Exist");
               }
			}
		});
		Add.setFont(new Font("Tahoma", Font.BOLD, 14));
		Add.setBounds(376, 435, 135, 33);
		panel.add(Add);
		
		JButton clear = new JButton("Clear Fields");
		clear.setFont(new Font("Tahoma", Font.BOLD, 14));
		clear.setBounds(596, 435, 135, 33);
		panel.add(clear);
		
		lblNewLabel_level_required_1 = new JLabel("");
		lblNewLabel_level_required_1.setForeground(Color.RED);
		lblNewLabel_level_required_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_level_required_1.setBounds(256, 70, 282, 13);
		panel.add(lblNewLabel_level_required_1);
		
		panel_manage = new JPanel();
		panel_manage.setBackground(Color.WHITE);
		layeredPane.add(panel_manage, "name_689261342226900");
		panel_manage.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(24, 81, 404, 489);
		panel_manage.add(panel_1);
		
		JLabel lblSessionCode = new JLabel("Session Code");
		lblSessionCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSessionCode.setBounds(25, 28, 119, 19);
		panel_1.add(lblSessionCode);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDuration.setBounds(25, 375, 157, 19);
		panel_1.add(lblDuration);
		
		spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner_1.setBounds(172, 375, 206, 20);
		panel_1.add(spinner_1);
		
		JButton updateSession = new JButton("Update");
		updateSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		updateSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		updateSession.setBounds(25, 435, 85, 33);
		panel_1.add(updateSession);
		
		JButton ClearSession = new JButton("Clear");
		ClearSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		ClearSession.setBounds(293, 435, 85, 33);
		panel_1.add(ClearSession);
		
		JButton DeleteSession = new JButton("Delete");
		DeleteSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_session.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_session.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					String sql = "DELETE  FROM session WHERE id = "+id;
					PreparedStatement pst = connection.prepareStatement(sql);
			        int rs=pst.executeUpdate(sql);
			        
			        connection.close();
	                   JOptionPane.showMessageDialog(null, "Deleted Successfully");
 
	               }
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                   Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                   String query = "select * from session";
                   Statement sta = connection.createStatement();
                   ResultSet rs1 = sta.executeQuery(query);
                   
                   table_session.setModel(DbUtils.resultSetToTableModel(rs1));
                   connection.close();
                   
                   
                   
               } catch (Exception exception) {
               	
                   exception.printStackTrace();
               }
								
			}
		});
		DeleteSession.setFont(new Font("Tahoma", Font.BOLD, 13));
		DeleteSession.setBounds(156, 435, 85, 33);
		panel_1.add(DeleteSession);
		
		JLabel lblNumberOfStudents = new JLabel("Number of Students");
		lblNumberOfStudents.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumberOfStudents.setBounds(25, 331, 157, 19);
		panel_1.add(lblNumberOfStudents);
		
		JLabel lblGroupId = new JLabel("Group ID");
		lblGroupId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGroupId.setBounds(25, 243, 137, 19);
		panel_1.add(lblGroupId);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubjectCode.setBounds(25, 199, 137, 19);
		panel_1.add(lblSubjectCode);
		
		JLabel lblSelectLecturers = new JLabel("Select Lecturer(s)");
		lblSelectLecturers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectLecturers.setBounds(25, 72, 137, 19);
		panel_1.add(lblSelectLecturers);
		
		session_code_1 = new JTextField();
		session_code_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		session_code_1.setColumns(10);
		session_code_1.setBounds(172, 28, 206, 19);
		panel_1.add(session_code_1);
		
		JLabel lblNewLabelSub_1_1_1 = new JLabel("Select Subject");
		lblNewLabelSub_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelSub_1_1_1.setBounds(25, 155, 137, 19);
		panel_1.add(lblNewLabelSub_1_1_1);
		
		combo_lec2 = new JComboBox(new Object[]{});
		combo_lec2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_lec2.setBounds(172, 105, 206, 21);
		panel_1.add(combo_lec2);
		
		combo_lec2_1 = new JComboBox(new Object[]{});
		combo_lec2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_lec2_1.setBounds(172, 72, 206, 21);
		panel_1.add(combo_lec2_1);
		
		combo_sub2 = new JComboBox(new Object[]{});
		combo_sub2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_sub2.setBounds(172, 155, 206, 21);
		panel_1.add(combo_sub2);
		
		combo_lec2_subcode = new JComboBox(new Object[]{});
		combo_lec2_subcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_lec2_subcode.setBounds(172, 199, 206, 21);
		panel_1.add(combo_lec2_subcode);
		
		combo_sess_grpid = new JComboBox(new Object[]{});
		combo_sess_grpid.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_sess_grpid.setBounds(172, 243, 206, 21);
		panel_1.add(combo_sess_grpid);
		
		textField_studentCount = new JTextField();
		textField_studentCount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_studentCount.setColumns(10);
		textField_studentCount.setBounds(172, 331, 206, 19);
		panel_1.add(textField_studentCount);
		
		JLabel lblTag = new JLabel("Tag");
		lblTag.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTag.setBounds(25, 287, 137, 19);
		panel_1.add(lblTag);
		
		combo_sess_tag = new JComboBox(new Object[]{});
		combo_sess_tag.setFont(new Font("Tahoma", Font.PLAIN, 13));
		combo_sess_tag.setBounds(172, 287, 206, 21);
		panel_1.add(combo_sess_tag);
		
		JLabel lblNewLabel_4 = new JLabel("Update / Delete Session Details");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(24, 34, 299, 21);
		panel_manage.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(464, 140, 769, 427);
		panel_manage.add(scrollPane);
		
		table_session = new JTable();
		table_session.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table_session.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_session.getModel();
				
				session_code_1.setText(model.getValueAt(selectedRow, 1).toString());
				combo_lec2_1.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
				combo_lec2.setSelectedItem(model.getValueAt(selectedRow, 3).toString());;
				combo_sub2.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
				combo_lec2_subcode.setSelectedItem(model.getValueAt(selectedRow, 5).toString());;
				combo_sess_grpid.setSelectedItem(model.getValueAt(selectedRow, 6).toString());;
				combo_sess_tag.setSelectedItem(model.getValueAt(selectedRow, 7).toString());;
				textField_studentCount.setText(model.getValueAt(selectedRow, 8).toString());;
				spinner_1.setValue(model.getValueAt(selectedRow, 9));
			}
		});
		table_session.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Session Code", "Lecturer_1", "Lecturer_2", "Subject Name", "Subject Code", "Group ID", "Tag", "No. of Students", "Duration"
			}
		));
		scrollPane.setViewportView(table_session);
		
		JButton btnRefresh_session = new JButton("Refresh");
		btnRefresh_session.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow=table.getSelectedRow();
                DefaultTableModel model2=(DefaultTableModel) table_session.getModel();
				//String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                    String query = "select id as 'ID', sessionCode as 'Session Code', lecturer_1 as 'Lecturer 1', lecturer_2 as 'Lecturer 2', subjectName as 'Subject Name', subjectCode as 'Subject Code', groupID as 'Group ID', tag as 'Tag',noOfStudents as 'No. of Students', duration as 'Duration' from session";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table_session.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnRefresh_session.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh_session.setBounds(1135, 18, 98, 33);
		panel_manage.add(btnRefresh_session);
		
		JLabel lblNewLabel_4_1 = new JLabel("Session Details");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(761, 71, 145, 21);
		panel_manage.add(lblNewLabel_4_1);
		
		JButton btnSearch_session = new JButton("Search");
		btnSearch_session.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch_session.setBackground(SystemColor.activeCaption);
		btnSearch_session.setBounds(1135, 89, 98, 33);
		panel_manage.add(btnSearch_session);
		
		textField_1_seacrh = new JTextField();
		textField_1_seacrh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1_seacrh.setColumns(10);
		textField_1_seacrh.setBounds(919, 89, 206, 33);
		panel_manage.add(textField_1_seacrh);
		
		JButton add_button = new JButton("Add Session");
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(add_panel);
			}
		});
		add_button.setFont(new Font("Tahoma", Font.BOLD, 14));
		add_button.setBounds(1121, 139, 181, 31);
		contentPane.add(add_button);
		
		JButton btnNewButtonManagePage = new JButton("View Session Details");
		btnNewButtonManagePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel_manage);
			}
		});
		btnNewButtonManagePage.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtonManagePage.setBounds(1312, 139, 193, 31);
		contentPane.add(btnNewButtonManagePage);
		
		fillComboBoxLec();
		fillComboBoxSubName();
		fillComboBoxSubcode();
		fillComboBoxGrpID();
		fillComboBoxTag();
		
	}
}
