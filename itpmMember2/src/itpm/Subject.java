package itpm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;

public class Subject extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panelSub;
	private JPanel panelSubDetail;
	private JTextField textFieldName;
	private JTextField textField_1code;
	private JTextField textField_2Name;
	private JTextField textField_3Code;
	private JTable table;
	private JComboBox combotype;
	private JComboBox comboBox_offeredyear;
	private JTextField textFieldSearchSub;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject frame = new Subject();
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
	public Subject() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(477, 24, 608, 80);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 127, 1497, 2);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 1, 117, 116);
		//lblNewLabel_1.setIcon(new ImageIcon(FoodItem.class.getResource("/Final/resthouse125-removebg-preview.png")));
		contentPane.add(lblNewLabel_1);
		
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
		Image imgH = new ImageIcon(this.getClass().getResource("/itpm/home1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgH));
		btnNewButton.setBounds(22, 141, 70, 70);
		contentPane.add(btnNewButton);
		
		layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(100, 180, 1317, 601);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelSub = new JPanel();
		panelSub.setBackground(new Color(255, 255, 255));
		layeredPane.add(panelSub, "name_407348505329600");
		panelSub.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(89, 86, 1134, 446);
		panelSub.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Subject Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(81, 54, 119, 19);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Offered Semester");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(81, 279, 140, 19);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Offered Year");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(81, 203, 119, 19);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Subject Code");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBounds(81, 130, 119, 19);
		panel.add(lblNewLabel_3_3);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(250, 54, 231, 26);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textField_1code = new JTextField();
		textField_1code.setColumns(10);
		textField_1code.setBounds(250, 123, 231, 26);
		panel.add(textField_1code);
		
		
		
		JLabel lblNewLabel_3_4 = new JLabel("Number of Lecturer Hours");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4.setBounds(566, 54, 229, 19);
		panel.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Number of Lab Hours");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_1.setBounds(566, 130, 229, 19);
		panel.add(lblNewLabel_3_4_1);
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Number of Tutorial Hours");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_2.setBounds(566, 203, 229, 19);
		panel.add(lblNewLabel_3_4_2);
		
		JLabel lblNewLabel_3_4_2_1 = new JLabel("Number of Evaluation Hours");
		lblNewLabel_3_4_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_4_2_1.setBounds(566, 279, 229, 19);
		panel.add(lblNewLabel_3_4_2_1);
		
		
		
		rdbtnNewRadioButton = new JRadioButton("1st Semester");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton.isSelected())
				{
					rdbtnNewRadioButton_1.setSelected(false);
				}
				
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton.setBounds(250, 277, 103, 21);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("2nd Semester");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton_1.isSelected())
				{
					rdbtnNewRadioButton.setSelected(false);
				}
				
			}
		});
		rdbtnNewRadioButton_1.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_1.setBounds(378, 277, 103, 21);
		panel.add(rdbtnNewRadioButton_1);
		
		JSpinner spinnerLec = new JSpinner();
		spinnerLec.setBounds(805, 54, 237, 26);
		panel.add(spinnerLec);
		
		JSpinner spinnerLab = new JSpinner();
		spinnerLab.setBounds(805, 123, 237, 26);
		panel.add(spinnerLab);
		
		JSpinner spinnerTute = new JSpinner();
		spinnerTute.setBounds(805, 196, 237, 26);
		panel.add(spinnerTute);
		
		JSpinner spinnerEva = new JSpinner();
		spinnerEva.setBounds(805, 272, 237, 26);
		panel.add(spinnerEva);
		
		JLabel subject_name_required = new JLabel("");
		subject_name_required.setForeground(new Color(255, 0, 0));
		subject_name_required.setFont(new Font("Tahoma", Font.BOLD, 12));
		subject_name_required.setBounds(250, 90, 208, 13);
		panel.add(subject_name_required);
		
		JLabel subject_code_required_1 = new JLabel("");
		subject_code_required_1.setForeground(Color.RED);
		subject_code_required_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		subject_code_required_1.setBounds(250, 163, 208, 13);
		panel.add(subject_code_required_1);
		
		JLabel offered_year_required_ = new JLabel("");
		offered_year_required_.setForeground(Color.RED);
		offered_year_required_.setFont(new Font("Tahoma", Font.BOLD, 12));
		offered_year_required_.setBounds(250, 231, 208, 13);
		panel.add(offered_year_required_);
		
		
		JButton btnNewButton_2 = new JButton("Add Subject");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sub_name = textFieldName.getText();
				String sub_code = textField_1code.getText();
				String offerd_year1 =(String)comboBox_offeredyear.getSelectedItem();
				String offered_sem = null;
                if(rdbtnNewRadioButton.isSelected()) 
                	offered_sem="1st Semester";
                else {
                	offered_sem="2nd Semester";
                }                
                int No_of_lecHours = (int) spinnerLec.getValue();
                int No_of_tuteHours = (int) spinnerTute.getValue();
                int No_of_labHours = (int) spinnerLab.getValue();
                int No_of_evaHours = (int) spinnerEva.getValue();
                    				
                    if(textFieldName.getText().trim().isEmpty() && textField_1code.getText().trim().isEmpty())
                    {
                        subject_name_required.setText("Subject Name is required !"); 
                        subject_code_required_1.setText("Subject Code is required !");                    	
                    }
                    else if(textFieldName.getText().trim().isEmpty()) {
                    	subject_code_required_1.setText("Subject Name is required !");}
                    
                    else if(textField_1code.getText().trim().isEmpty()) {
                    	subject_code_required_1.setText("Subject Code is required !");}
                    
                    else {
                    
                    try {
                    	Class.forName("com.mysql.cj.jdbc.Driver");
    			       Connection connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

                       String query = "INSERT INTO subject values(000,'" + sub_name + "','" + sub_code + "','" + offerd_year1 + "','" + offered_sem + "','"+No_of_lecHours+"','"+No_of_tuteHours+"','"+No_of_labHours+"','"+No_of_evaHours+"')";                                                                                                       
                       Statement sta = connection2.createStatement();
                       int x = sta.executeUpdate(query);
                       
                       JOptionPane.showMessageDialog(null, "Inserted Successfully");
                       subject_name_required.setText(""); 
                       subject_code_required_1.setText(""); 
                       connection2.close();
                                          
                   } catch (Exception exception) {
                   	
                       exception.printStackTrace();
                       JOptionPane.showMessageDialog(null, "Already Exist");
                   }
                    }							
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(346, 363, 135, 33);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Clear Fields");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldName.setText("");
				textField_1code.setText("");
				comboBox_offeredyear.setSelectedItem("(select)");
				spinnerLec.setValue(0);
				spinnerLab.setValue(0);
				spinnerTute.setValue(0);
				spinnerEva.setValue(0);
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2_1.setBounds(566, 363, 135, 33);
		panel.add(btnNewButton_2_1);
		
		String[] offered_year = {"(select)","1st year", "2nd Year", "3rd Year", "4th Year"}; 
		comboBox_offeredyear = new JComboBox(offered_year);
		comboBox_offeredyear.setBounds(250, 198, 231, 21);
		panel.add(comboBox_offeredyear);
	
		JLabel lblNewLabel_2 = new JLabel("Add Subjects");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_2.setBounds(572, 30, 137, 30);
		panelSub.add(lblNewLabel_2);
		
		panelSubDetail = new JPanel();
		panelSubDetail.setBackground(new Color(255, 255, 255));
		layeredPane.add(panelSubDetail, "name_407363824052300");
		panelSubDetail.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(45, 75, 404, 489);
		panelSubDetail.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabelSub = new JLabel("Subject Name");
		lblNewLabelSub.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelSub.setBounds(25, 28, 119, 19);
		panel_1.add(lblNewLabelSub);
		
		JLabel lblEvaluationHours = new JLabel("Evaluation Hours");
		lblEvaluationHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEvaluationHours.setBounds(25, 381, 157, 19);
		panel_1.add(lblEvaluationHours);
		
		rdbtnNewRadioButton_2 = new JRadioButton("1st Semester");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton_2.isSelected())
				{
					rdbtnNewRadioButton_3.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_2.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton_2.setBounds(172, 164, 103, 21);
		panel_1.add(rdbtnNewRadioButton_2);
		
		rdbtnNewRadioButton_3 = new JRadioButton("2nd Semester");
		buttonGroup.add(rdbtnNewRadioButton_3);
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnNewRadioButton_3.isSelected())
				{
					rdbtnNewRadioButton_2.setSelected(false);
				}
			}
		});
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnNewRadioButton_3.setBackground(new Color(204, 204, 255));
		rdbtnNewRadioButton_3.setBounds(172, 197, 103, 21);
		panel_1.add(rdbtnNewRadioButton_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(172, 381, 206, 20);
		panel_1.add(spinner_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(172, 337, 206, 20);
		panel_1.add(spinner_1_1);
		
		JSpinner spinner_1_2 = new JSpinner();
		spinner_1_2.setBounds(172, 291, 206, 20);
		panel_1.add(spinner_1_2);
		
		JSpinner spinner_1_3 = new JSpinner();
		spinner_1_3.setBounds(172, 247, 206, 20);
		panel_1.add(spinner_1_3);
		
		JButton btnNewButtUpdate = new JButton("Update");
		btnNewButtUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sub_name = textField_2Name.getText();
				String code = textField_3Code.getText();
			    String ctype =(String)combotype.getSelectedItem();
				String sem = null;
                if(rdbtnNewRadioButton_2.isSelected()) 
                    sem="1st Semester";
                else if(rdbtnNewRadioButton_3.isSelected()) 
                        sem="2nd Semester";
			     int spinnerLect = (int) spinner_1_3.getValue();
			     int spinnerLabs = (int) spinner_1_2.getValue();
			     int spinnerTute = (int) spinner_1_1.getValue();
			     int spinnerEval = (int) spinner_1.getValue();
			     String driverName = "com.mysql.cj.jdbc.Driver";
			     
			     int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
			     try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "UPDATE subject set sub_name='"+sub_name+"', sub_code='"+code+"', offered_year='"+ctype+"', offered_sem='"+sem+"', num_lecHours = '"+spinnerLect+"' , num_labHours = '"+spinnerLabs+"', num_tuteHours = '"+spinnerTute+"', num_evaHours = '"+spinnerEval+"'where id="+id;
			     
			         PreparedStatement pst = connection.prepareStatement(query);
			        
			         int x = pst.executeUpdate(query);
			         
			         connection.close();
			         JOptionPane.showMessageDialog(null, "Updated Successfully");
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
			     
			     try {
						Class.forName("com.mysql.cj.jdbc.Driver");
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
	                    String query = "select * from subject";
	                    Statement sta = connection.createStatement();
	                    ResultSet rs1 = sta.executeQuery(query);
	                    
	                    table.setModel(DbUtils.resultSetToTableModel(rs1));
	                    connection.close();
	                    
	                    
	                    
	                } catch (Exception exception) {
	                	
	                    exception.printStackTrace();
	                }
			}
		});
		btnNewButtUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButtUpdate.setBounds(25, 435, 85, 33);
		panel_1.add(btnNewButtUpdate);
		
		JButton btnNewButtClear = new JButton("Clear");
		btnNewButtClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_2Name.setText("");
				textField_3Code.setText("");
				combotype.setSelectedItem("(select)");
				spinner_1.setValue(0);
				spinner_1_1.setValue(0);
				spinner_1_2.setValue(0);
				spinner_1_3.setValue(0);
				
			}
		});
		btnNewButtClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButtClear.setBounds(293, 435, 85, 33);
		panel_1.add(btnNewButtClear);
		
		JButton btnNewButtDelete = new JButton("Delete");
		btnNewButtDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					String sql = "DELETE  FROM subject WHERE id = "+id;
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
                    String query = "select * from subject";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnNewButtDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButtDelete.setBounds(156, 435, 85, 33);
		panel_1.add(btnNewButtDelete);
		
		JLabel lblTutorialHours = new JLabel("Tutorial Hours");
		lblTutorialHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTutorialHours.setBounds(25, 337, 157, 19);
		panel_1.add(lblTutorialHours);
		
		
		
		JLabel lblLabHours = new JLabel("Lab Hours");
		lblLabHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLabHours.setBounds(25, 292, 157, 19);
		panel_1.add(lblLabHours);
		
		JLabel lblLectureHours = new JLabel("Lecture Hours");
		lblLectureHours.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLectureHours.setBounds(25, 247, 157, 19);
		panel_1.add(lblLectureHours);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSubjectCode.setBounds(25, 73, 119, 19);
		panel_1.add(lblSubjectCode);
		
		textField_2Name = new JTextField();
		textField_2Name.setBounds(172, 28, 206, 19);
		panel_1.add(textField_2Name);
		textField_2Name.setColumns(10);
		
		textField_3Code = new JTextField();
		textField_3Code.setColumns(10);
		textField_3Code.setBounds(172, 73, 206, 19);
		panel_1.add(textField_3Code);
		
		JLabel lblNewLabelSub_1_1 = new JLabel("Offered Year");
		lblNewLabelSub_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelSub_1_1.setBounds(25, 119, 119, 19);
		panel_1.add(lblNewLabelSub_1_1);
		
		JLabel lblNewLabelSub_1_1_1 = new JLabel("Offered Semester");
		lblNewLabelSub_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabelSub_1_1_1.setBounds(25, 163, 137, 19);
		panel_1.add(lblNewLabelSub_1_1_1);
		
		String [] type = {"(select)", "1st year", "2nd Year", "3rd Year", "4th Year"};
		combotype = new JComboBox(type);
		combotype.setBounds(172, 120, 206, 21);
		panel_1.add(combotype);
		
		JLabel lblNewLabel_4 = new JLabel("Update / Delete Subject Details");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4.setBounds(45, 34, 299, 21);
		panelSubDetail.add(lblNewLabel_4);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow=table.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) table.getModel();
				//String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                    String query = "select * from subject";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRefresh.setBounds(1209, 22, 98, 33);
		panelSubDetail.add(btnRefresh);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(1209, 93, 98, 33);
		panelSubDetail.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(489, 149, 818, 412);
		panelSubDetail.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				textField_2Name.setText(model.getValueAt(selectedRow, 1).toString());
				textField_3Code.setText(model.getValueAt(selectedRow, 2).toString());
				combotype.setSelectedItem(model.getValueAt(selectedRow, 3).toString());;
				String semester = model.getValueAt(selectedRow, 4).toString();
				if(semester.equals("1st Semester")) {
					rdbtnNewRadioButton_2.setSelected(true);
				}else if(semester.equals("2nd Semester")){
					rdbtnNewRadioButton_3.setSelected(true);
				}
				spinner_1_3.setValue(model.getValueAt(selectedRow, 5));
				spinner_1_2.setValue(model.getValueAt(selectedRow, 6));
				spinner_1_1.setValue(model.getValueAt(selectedRow, 7));
				spinner_1.setValue(model.getValueAt(selectedRow, 8));
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Subject Name", "Subject Code", "Year", "Semester", "Lecture H", "Lab H", "Tutorial H", "Evaluation H"
			}
		));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		textFieldSearchSub = new JTextField();
		textFieldSearchSub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					 String search3 = textFieldSearchSub.getText();
					
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "SELECT id, sub_name, sub_code, offered_year, offered_sem, num_lecHours, num_labHours, num_tuteHours, num_evaHours FROM subject where sub_name LIKE '%"+search3+"%'";
			     
			         PreparedStatement pst = connection.prepareStatement(query);

			         ResultSet rs=pst.executeQuery();
			         table.setModel(DbUtils.resultSetToTableModel(rs));
			         

					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
			}
		});
		textFieldSearchSub.setColumns(10);
		textFieldSearchSub.setBounds(993, 93, 206, 33);
		panelSubDetail.add(textFieldSearchSub);
		
		JLabel lblNewLabel_4_1 = new JLabel("Subject Details");
		lblNewLabel_4_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_4_1.setBounds(835, 75, 145, 21);
		panelSubDetail.add(lblNewLabel_4_1);
		
		JButton btnNewButton_1 = new JButton("View Subject Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelSubDetail);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(1224, 139, 193, 31);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Add Subjects");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelSub);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(1033, 139, 181, 31);
		contentPane.add(btnNewButton_1_1);
		
	}
}
