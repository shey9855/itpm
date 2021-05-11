package itpm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Lecturer extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panellec;
	private JPanel panellecdetail;
	private JPanel panelDayshours;
	private JTextField textField_lecName;
	private JTextField textField_empID;
	private JTextField textField_rank;
	private JTextField monday;
	private JTextField tuesday;
	private JTextField wednesday;
	private JTextField thursday;
	private JTextField friday;
	private JTextField saturday;
	private JTextField sunday;
	private JTextField textFieldName_1;
	private JTextField textFieldEmpID_1;
	private JTextField textFieldupdaterank;
	private JTextField textFieldSeacrh;
	private JTable table_lecturer;
	private JComboBox comboBox_Faculty;
	private JComboBox comboBox_Dept;
	private JComboBox comboBox_Center;
	private JComboBox comboBox_Build;
	private JComboBox comboBox_Lev;
	private JComboBox comboBox_Lev2;
	private JComboBox comboBox_Fac2;
	private JComboBox comboBox_Dept2;
	private JComboBox comboBox_Cent2;
	private JComboBox comboBox_Build2;
	private JTextField textFieldMon;
	private JTextField textFieldTue;
	private JTextField textFieldWed;
	private JTextField textFieldThurs;
	private JTextField textFieldFri;
	private JTextField textFieldSat;
	private JTextField textFieldSun;
	private JTextField textFieldSearchDays;
	private JTable table_hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lecturer frame = new Lecturer();
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
	public Lecturer() {
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
		lblNewLabel.setBounds(20, 21, 479, 80);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 127, 1497, 2);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(5, 5, 98, 109);
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
		layeredPane.setBounds(111, 182, 1304, 597);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panellec = new JPanel();
		panellec.setBackground(new Color(255, 255, 255));
		layeredPane.add(panellec, "name_382272480634800");
		panellec.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Add Lecturers");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setBounds(37, 20, 209, 24);
		panellec.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(37, 67, 510, 509);
		panellec.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Lecturer Name");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(21, 40, 154, 24);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Employee ID");
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(21, 87, 154, 24);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Building");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_2.setBounds(21, 429, 93, 24);
		panel.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Center");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_3.setBounds(21, 384, 119, 24);
		panel.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_4 = new JLabel("Department");
		lblNewLabel_2_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_4.setBounds(21, 337, 139, 24);
		panel.add(lblNewLabel_2_2_4);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Rank");
		lblNewLabel_2_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5.setBounds(21, 242, 209, 24);
		panel.add(lblNewLabel_2_2_5);
		
		JLabel lblNewLabel_name_required = new JLabel("");
		lblNewLabel_name_required.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_name_required.setForeground(Color.RED);
		lblNewLabel_name_required.setBounds(187, 66, 282, 13);
		panel.add(lblNewLabel_name_required);
		
		JLabel lblNewLabel_ID_required = new JLabel("");
		lblNewLabel_ID_required.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_ID_required.setForeground(Color.RED);
		lblNewLabel_ID_required.setBounds(187, 114, 282, 13);
		panel.add(lblNewLabel_ID_required);
		
		textField_lecName = new JTextField();
		textField_lecName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_lecName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_name_required.setText("");
			}
		});
		textField_lecName.setColumns(10);
		textField_lecName.setBounds(187, 40, 282, 26);
		panel.add(textField_lecName);
		
		textField_empID = new JTextField();
		textField_empID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_empID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_ID_required.setText("");
				
			}
		});
		textField_empID.setColumns(10);
		textField_empID.setBounds(187, 89, 282, 26);
		panel.add(textField_empID);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Level");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_1.setBounds(21, 135, 93, 24);
		panel.add(lblNewLabel_2_2_1_1);
		
		textField_rank = new JTextField();
		textField_rank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_rank.setColumns(10);
		textField_rank.setBounds(187, 242, 282, 26);
		panel.add(textField_rank);
		
		JLabel lblNewLabel_level_required_1 = new JLabel("");
		lblNewLabel_level_required_1.setForeground(Color.RED);
		lblNewLabel_level_required_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_level_required_1.setBounds(187, 159, 282, 13);
		panel.add(lblNewLabel_level_required_1);
		
		JButton btnNewButtongeneraterank = new JButton("Generate Rank");
		btnNewButtongeneraterank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String empid = (String)textField_empID.getText();
				String levelS = (String)comboBox_Lev.getSelectedItem();
				
				if(comboBox_Lev.getSelectedItem()== "(select)") {
					lblNewLabel_level_required_1.setText("Level is required");	
				}else {
					String rankString = levelS+"."+empid;
					textField_rank.setText(rankString);
					lblNewLabel_level_required_1.setText("");
				}	
			}
		});
		btnNewButtongeneraterank.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtongeneraterank.setBounds(90, 189, 324, 31);
		panel.add(btnNewButtongeneraterank);
		
		
		
		JLabel lblNewLabel_2_2_5_1 = new JLabel("Faculty");
		lblNewLabel_2_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5_1.setBounds(21, 291, 149, 24);
		panel.add(lblNewLabel_2_2_5_1);
		
		String [] fac = {"(select)", "IT", "Engineering", "Business Management", "Humanities & Sciences"};
		comboBox_Faculty = new JComboBox(fac);
		comboBox_Faculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_Faculty.getSelectedItem().equals("IT")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept.removeAllItems();
					comboBox_Dept.addItem("(select)");
					comboBox_Dept.addItem("IT");
					comboBox_Dept.addItem("CSSE");
					comboBox_Dept.addItem("CSE");
					
				}
				else if(comboBox_Faculty.getSelectedItem().equals("Engineering")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept.removeAllItems();
					comboBox_Dept.addItem("(select)");
					comboBox_Dept.addItem("Mechanical E");
					comboBox_Dept.addItem("Electronic E");
					comboBox_Dept.addItem("Materials E");
					comboBox_Dept.addItem("Civil E");
					comboBox_Dept.addItem("QS");
					}
				else if(comboBox_Faculty.getSelectedItem().equals("Business Management")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept.removeAllItems();
					comboBox_Dept.addItem("(select)");
					comboBox_Dept.addItem("Accounting & Finance");
					comboBox_Dept.addItem("Management");
					comboBox_Dept.addItem("Marketing");
					
				}
				else if(comboBox_Faculty.getSelectedItem().equals("Humanities & Sciences")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept.removeAllItems();
					comboBox_Dept.addItem("(select)");
					comboBox_Dept.addItem("English");
					comboBox_Dept.addItem("Nursing");
					comboBox_Dept.addItem("Law");
					comboBox_Dept.addItem("Physical Sciences");					
			}
			}
		});
		comboBox_Faculty.setBounds(187, 295, 282, 21);
		panel.add(comboBox_Faculty);
		
		
		comboBox_Dept = new JComboBox();
		comboBox_Dept.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Dept.setBounds(187, 341, 282, 21);
		panel.add(comboBox_Dept);
		
		String [] cen = {"(select)","Malabe", "Kandy", "Kurunagala","Colombo","Matara"};
		comboBox_Center = new JComboBox(cen);
		comboBox_Center.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Center.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_Center.getSelectedItem().equals("Malabe")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build.removeAllItems();
					comboBox_Build.addItem("(select)");
					comboBox_Build.addItem("New Building");
					comboBox_Build.addItem("New CyberLab");
					comboBox_Build.addItem("A501");
					comboBox_Build.addItem("B7L2");
					comboBox_Build.addItem("Architecture Building");

					
				}
				else if(comboBox_Center.getSelectedItem().equals("Kandy")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build.removeAllItems();
					comboBox_Build.addItem("(select)");
					comboBox_Build.addItem("301");
					comboBox_Build.addItem("302");
					comboBox_Build.addItem("201 Lab");
					
					}
				else if(comboBox_Center.getSelectedItem().equals("Kurunagala")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build.removeAllItems();
					comboBox_Build.addItem("(select)");
					comboBox_Build.addItem("IT Building");
					comboBox_Build.addItem("New SoftwareLab");
					comboBox_Build.addItem("Electrical Lab");
					
				}
				else if(comboBox_Center.getSelectedItem().equals("Colombo")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build.removeAllItems();
					comboBox_Build.addItem("(select)");
					comboBox_Build.addItem("BM New");
					comboBox_Build.addItem("IT Old");
					comboBox_Build.addItem("Physical lab");					
			}
				
				
			}
			
		});
		comboBox_Center.setBounds(187, 388, 282, 21);
		panel.add(comboBox_Center);
		
		comboBox_Build = new JComboBox();
		comboBox_Build.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Build.setBounds(187, 433, 282, 21);
		panel.add(comboBox_Build);
	
		String [] level = {"(select)", "1", "2", "3", "4", "5","6"};
		comboBox_Lev = new JComboBox(level);
		comboBox_Lev.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_Lev.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lblNewLabel_level_required_1.setText("");
			}
		});
		comboBox_Lev.setBounds(187, 139, 282, 21);
		panel.add(comboBox_Lev);
	
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(681, 97, 510, 417);
		panellec.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Days");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_1_1_1.setBounds(25, 10, 93, 24);
		panel_1.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Hours");
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_1_1_1_1.setBounds(213, 10, 93, 24);
		panel_1.add(lblNewLabel_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Monday");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2.setBounds(25, 80, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2);
		
		monday = new JTextField();
		monday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		monday.setColumns(10);
		monday.setBounds(213, 78, 282, 26);
		panel_1.add(monday);
		
		tuesday = new JTextField();
		tuesday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tuesday.setColumns(10);
		tuesday.setBounds(213, 125, 282, 26);
		panel_1.add(tuesday);
		
		wednesday = new JTextField();
		wednesday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		wednesday.setColumns(10);
		wednesday.setBounds(213, 172, 282, 26);
		panel_1.add(wednesday);
		
		thursday = new JTextField();
		thursday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		thursday.setColumns(10);
		thursday.setBounds(213, 219, 282, 26);
		panel_1.add(thursday);
		
		friday = new JTextField();
		friday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		friday.setColumns(10);
		friday.setBounds(213, 266, 282, 26);
		panel_1.add(friday);
		
		saturday = new JTextField();
		saturday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		saturday.setColumns(10);
		saturday.setBounds(213, 313, 282, 26);
		panel_1.add(saturday);
		
		sunday = new JTextField();
		sunday.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sunday.setColumns(10);
		sunday.setBounds(213, 362, 282, 26);
		panel_1.add(sunday);
		
		JLabel lblNewLabel_2_2_1_2_1 = new JLabel("Sunday");
		lblNewLabel_2_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_1.setBounds(25, 362, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_1);
		
		JLabel lblNewLabel_2_2_1_2_2 = new JLabel("Saturday");
		lblNewLabel_2_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_2.setBounds(25, 313, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_2);
		
		JLabel lblNewLabel_2_2_1_2_3 = new JLabel("Friday");
		lblNewLabel_2_2_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_3.setBounds(25, 266, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_3);
		
		JLabel lblNewLabel_2_2_1_2_4 = new JLabel("Thursday");
		lblNewLabel_2_2_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_4.setBounds(25, 219, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_4);
		
		JLabel lblNewLabel_2_2_1_2_5 = new JLabel("Wednesday");
		lblNewLabel_2_2_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_5.setBounds(25, 172, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_5);
		
		JLabel lblNewLabel_2_2_1_2_6 = new JLabel("Tuesday");
		lblNewLabel_2_2_1_2_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_6.setBounds(25, 127, 154, 24);
		panel_1.add(lblNewLabel_2_2_1_2_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Active Days and Hours");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(681, 20, 209, 24);
		panellec.add(lblNewLabel_2_1);
		
		JButton btnNewButtonSavelec = new JButton("ADD");
		btnNewButtonSavelec.setBorder(new LineBorder(new Color(0, 153, 0)));
		btnNewButtonSavelec.setForeground(new Color(0, 0, 0));
		btnNewButtonSavelec.setBackground(new Color(0, 153, 0));
		btnNewButtonSavelec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lec_name = textField_lecName.getText();
				String lec_id_emp = textField_empID.getText();
				String level =(String)comboBox_Lev.getSelectedItem();
				String rank = textField_rank.getText();
				String fac = (String)comboBox_Faculty.getSelectedItem();
				String dep = (String)comboBox_Dept.getSelectedItem();
				String cent = (String)comboBox_Center.getSelectedItem();
				String build = (String)comboBox_Build.getSelectedItem();
				String mon = monday.getText();
				String tue = tuesday.getText();
				String wedn = wednesday.getText();
				String thurs = thursday.getText();
				String fri = friday.getText();
				String sat = saturday.getText();
				String sun = sunday.getText();
				
				if(textField_lecName.getText().trim().isEmpty() && textField_empID.getText().trim().isEmpty()) {
					lblNewLabel_name_required.setText("Lecturer's name is required!");
					lblNewLabel_ID_required.setText("Lecturer's Employee ID Number is required!");
				}
				
				else if(textField_lecName.getText().trim().isEmpty()) {
					lblNewLabel_name_required.setText("Lecturer's name is required!");
                }
                else if(textField_empID.getText().trim().isEmpty()) {
                	lblNewLabel_ID_required.setText("Lecturer's Employee ID Number is required!");
                }
				
                else {
                	try {
                		Class.forName("com.mysql.cj.jdbc.Driver");
                		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

                		String query = "INSERT INTO lecturer values(0,'" + lec_name + "','" + lec_id_emp + "','" + level + "','" + rank + "','"+fac+"','"+dep+"','"+cent+"','"+build+"','" + mon + "','" + tue + "','" + wedn + "','"+thurs+"','"+fri+"','"+sat+"','"+sun+"')";                                                                                                       
                		Statement sta = connection.createStatement();
                		int x = sta.executeUpdate(query);
                   
                		connection.close();
                		JOptionPane.showMessageDialog(null, "Inserted Successfully");
                		lblNewLabel_name_required.setText("");
                		lblNewLabel_ID_required.setText("");
                   

                    }catch (Exception exception) {
                    	exception.printStackTrace();
                    	JOptionPane.showMessageDialog(null, "Lecturer ID is already taken");
                    }
			    }
			}
		});
		btnNewButtonSavelec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtonSavelec.setBounds(944, 539, 101, 37);
		panellec.add(btnNewButtonSavelec);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(new LineBorder(new Color(153, 204, 204)));
		btnClear.setBackground(new Color(153, 204, 204));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_lecName.setText("");
				textField_empID.setText("");
				comboBox_Lev.setSelectedItem("(select)");
				textField_rank.setText("");
				comboBox_Faculty.setSelectedItem("(select)");
				comboBox_Dept.setSelectedItem("(select)");
				comboBox_Center.setSelectedItem("(select)");
				comboBox_Build.setSelectedItem("(select)");
				monday.setText("");
				tuesday.setText("");
				wednesday.setText("");
				thursday.setText("");
				friday.setText("");
				saturday.setText("");
				sunday.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(1090, 539, 101, 37);
		panellec.add(btnClear);
		
		panellecdetail = new JPanel();
		panellecdetail.setBackground(new Color(255, 255, 255));
		layeredPane.add(panellecdetail, "name_382276716383600");
		panellecdetail.setLayout(null);
		
		JPanel panelLecDetail = new JPanel();
		panelLecDetail.setBackground(new Color(204, 204, 255));
		panelLecDetail.setLayout(null);
		panelLecDetail.setBounds(29, 65, 430, 505);
		panellecdetail.add(panelLecDetail);
		
		JLabel lblNewLabel_2_2_6 = new JLabel("Lecturer Name");
		lblNewLabel_2_2_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_6.setBounds(21, 40, 209, 24);
		panelLecDetail.add(lblNewLabel_2_2_6);
		
		JLabel lblNewLabel_2_2_1_3 = new JLabel("Employee ID");
		lblNewLabel_2_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_3.setBounds(21, 87, 154, 24);
		panelLecDetail.add(lblNewLabel_2_2_1_3);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Building");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_2_1.setBounds(21, 399, 93, 24);
		panelLecDetail.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_2_3_1 = new JLabel("Center");
		lblNewLabel_2_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_3_1.setBounds(21, 356, 119, 24);
		panelLecDetail.add(lblNewLabel_2_2_3_1);
		
		JLabel lblNewLabel_2_2_4_1 = new JLabel("Department");
		lblNewLabel_2_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_4_1.setBounds(21, 314, 139, 24);
		panelLecDetail.add(lblNewLabel_2_2_4_1);
		
		JLabel lblNewLabel_2_2_5_2 = new JLabel("Rank");
		lblNewLabel_2_2_5_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5_2.setBounds(21, 225, 209, 24);
		panelLecDetail.add(lblNewLabel_2_2_5_2);
		
		textFieldName_1 = new JTextField();
		textFieldName_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldName_1.setColumns(10);
		textFieldName_1.setBounds(187, 40, 221, 26);
		panelLecDetail.add(textFieldName_1);
		
		textFieldEmpID_1 = new JTextField();
		textFieldEmpID_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldEmpID_1.setColumns(10);
		textFieldEmpID_1.setBounds(187, 89, 221, 26);
		panelLecDetail.add(textFieldEmpID_1);
		
		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("Level");
		lblNewLabel_2_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_2.setBounds(21, 135, 93, 24);
		panelLecDetail.add(lblNewLabel_2_2_1_1_2);
		
		JButton btnNewButtongeneraterankNew = new JButton("Generate Rank");
		btnNewButtongeneraterankNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String empid2 = (String)textFieldEmpID_1.getText();
				String levelS2 = (String)comboBox_Lev2.getSelectedItem();
				
				String rankString2 = levelS2+"."+empid2;
				textFieldupdaterank.setText(rankString2);
			}
		});
		btnNewButtongeneraterankNew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtongeneraterankNew.setBounds(89, 184, 243, 31);
		panelLecDetail.add(btnNewButtongeneraterankNew);
		
		textFieldupdaterank = new JTextField();
		textFieldupdaterank.setFont(new Font("Dialog", Font.PLAIN, 13));
		textFieldupdaterank.setColumns(10);
		textFieldupdaterank.setBounds(187, 225, 221, 26);
		panelLecDetail.add(textFieldupdaterank);
		
		JLabel lblNewLabel_2_2_5_1_1 = new JLabel("Faculty");
		lblNewLabel_2_2_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5_1_1.setBounds(21, 271, 149, 24);
		panelLecDetail.add(lblNewLabel_2_2_5_1_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(255, 204, 51));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lec_name = textFieldName_1.getText();
				String lec_id = textFieldEmpID_1.getText();
				String level = (String)comboBox_Lev2.getSelectedItem();
				String rank = textFieldupdaterank.getText();
				String facString = (String)comboBox_Fac2.getSelectedItem();
				String deptString = (String)comboBox_Dept2.getSelectedItem();
				String centString = (String)comboBox_Cent2.getSelectedItem();
				String buildString = (String)comboBox_Build2.getSelectedItem();

				int selectedRow = table_lecturer.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_lecturer.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "UPDATE lecturer set lecturer_name='"+lec_name+"', lecturer_ID='"+lec_id+"', lecturer_level='"+level+"', lecturer_rank='"+rank+"', faculty = '"+facString+"' , department = '"+deptString+"', center = '"+centString+"', building = '"+buildString+"'where id="+id;
			     
			         PreparedStatement pst = connection.prepareStatement(query);
			        
			         int x = pst.executeUpdate(query);
			         
			         connection.close();
			         JOptionPane.showMessageDialog(null, "Updated Successfully");
			     } catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
				//int selectedRow=table.getSelectedRow();
                DefaultTableModel model1=(DefaultTableModel) table_lecturer.getModel();
				//String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                    String query = "select id as 'ID', lecturer_name as 'Lecturer Name', lecturer_ID as 'Lecturer ID', lecturer_level as 'Level', lecturer_rank as 'Rank', faculty as 'Faculty', department as 'Department', center as 'Center', building as 'Building' from lecturer";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table_lecturer.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                                       
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(21, 453, 106, 31);
		panelLecDetail.add(btnUpdate);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldName_1.setText("");
				textFieldEmpID_1.setText("");
				comboBox_Lev2.setSelectedItem("(select)");
				textFieldupdaterank.setText("");
				comboBox_Fac2.setSelectedItem("(select)");
				comboBox_Dept2.setSelectedItem("(select)");
				comboBox_Cent2.setSelectedItem("(select)");
				comboBox_Build2.setSelectedItem("(select)");
			}
		});
		btnClear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear_1.setBounds(302, 453, 106, 31);
		panelLecDetail.add(btnClear_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 51, 0));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = table_lecturer.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_lecturer.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
			     
				
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
					
					String sql = "DELETE  FROM lecturer WHERE id = "+id;
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
                   String query = "select id as 'ID', lecturer_name as 'Lecturer Name', lecturer_ID as 'Lecturer ID', lecturer_level as 'Level', lecturer_rank as 'Rank', faculty as 'Faculty', department as 'Department', center as 'Center', building as 'Building' from lecturer";
                   Statement sta = connection.createStatement();
                   ResultSet rs1 = sta.executeQuery(query);
                   
                   table_lecturer.setModel(DbUtils.resultSetToTableModel(rs1));
                   connection.close();
                   
                   
                   
               } catch (Exception exception) {
               	
                   exception.printStackTrace();
               }
				textFieldName_1.setText("");
				textFieldEmpID_1.setText("");
				comboBox_Lev2.setSelectedItem("(select)");
				textFieldupdaterank.setText("");
				comboBox_Fac2.setSelectedItem("(select)");
				comboBox_Dept2.setSelectedItem("(select)");
				comboBox_Cent2.setSelectedItem("(select)");
				comboBox_Build2.setSelectedItem("(select)");
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(162, 453, 106, 31);
		panelLecDetail.add(btnDelete);
		
		String [] fac2 = {"(select)", "IT", "Engineering", "Business Management", "Humanities & Sciences"};
		comboBox_Fac2 = new JComboBox(fac2);
		comboBox_Fac2.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBox_Fac2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_Fac2.getSelectedItem().equals("IT")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept2.removeAllItems();
					comboBox_Dept2.addItem("(select)");
					comboBox_Dept2.addItem("IT");
					comboBox_Dept2.addItem("CSSE");
					comboBox_Dept2.addItem("CSE");
					
				}
				else if(comboBox_Fac2.getSelectedItem().equals("Engineering")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept2.removeAllItems();
					comboBox_Dept2.addItem("(select)");
					comboBox_Dept2.addItem("Mechanical E");
					comboBox_Dept2.addItem("Electronic E");
					comboBox_Dept2.addItem("Materials E");
					comboBox_Dept2.addItem("Civil E");
					comboBox_Dept2.addItem("QS");
					}
				else if(comboBox_Fac2.getSelectedItem().equals("Business Management")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept2.removeAllItems();
					comboBox_Dept2.addItem("(select)");
					comboBox_Dept2.addItem("Accounting & Finance");
					comboBox_Dept2.addItem("Management");
					comboBox_Dept2.addItem("Marketing");
					
				}
				else if(comboBox_Fac2.getSelectedItem().equals("Humanities & Sciences")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Dept2.removeAllItems();
					comboBox_Dept2.addItem("(select)");
					comboBox_Dept2.addItem("English");
					comboBox_Dept2.addItem("Nursing");
					comboBox_Dept2.addItem("Law");
					comboBox_Dept2.addItem("Physical Sciences");					
				}
			}				
			
		});
		comboBox_Fac2.setBounds(187, 275, 221, 21);
		panelLecDetail.add(comboBox_Fac2);
		
		comboBox_Dept2 = new JComboBox();
		comboBox_Dept2.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBox_Dept2.setBounds(187, 318, 221, 21);
		panelLecDetail.add(comboBox_Dept2);
		
		String [] cen2 = { "(select)","Malabe", "Kandy", "Kurunagala","Colombo","Matara"};
		comboBox_Cent2 = new JComboBox(cen2);
		comboBox_Cent2.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBox_Cent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_Cent2.getSelectedItem().equals("Malabe")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build2.removeAllItems();
					comboBox_Build2.addItem("(select)");
					comboBox_Build2.addItem("New Building");
					comboBox_Build2.addItem("New CyberLab");
					comboBox_Build2.addItem("A501");
					comboBox_Build2.addItem("B7L2");
					comboBox_Build2.addItem("Architecture Building");

					
				}
				else if(comboBox_Cent2.getSelectedItem().equals("Kandy")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build2.removeAllItems();
					comboBox_Build2.addItem("(select)");
					comboBox_Build2.addItem("301");
					comboBox_Build2.addItem("302");
					comboBox_Build2.addItem("201 Lab");
					
					}
				else if(comboBox_Cent2.getSelectedItem().equals("Kurunagala")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build2.removeAllItems();
					comboBox_Build2.addItem("(select)");
					comboBox_Build2.addItem("IT Building");
					comboBox_Build2.addItem("New SoftwareLab");
					comboBox_Build2.addItem("Electrical Lab");
					
				}
				else if(comboBox_Cent2.getSelectedItem().equals("Colombo")) {
					
					//comboBox_dept.setSelectedItem(null);
					comboBox_Build2.removeAllItems();
					comboBox_Build2.addItem("(select)");
					comboBox_Build2.addItem("BM New");
					comboBox_Build2.addItem("IT Old");
					comboBox_Build2.addItem("Physical lab");					
			}
				
				
			}
		});
		comboBox_Cent2.setBounds(187, 360, 221, 21);
		panelLecDetail.add(comboBox_Cent2);
		
		comboBox_Build2 = new JComboBox();
		comboBox_Build2.setFont(new Font("Dialog", Font.PLAIN, 13));
		comboBox_Build2.setBounds(187, 403, 221, 21);
		panelLecDetail.add(comboBox_Build2);
		
		String [] level2 = {"(select)", "1", "2", "3", "4", "5","6"};
		comboBox_Lev2 = new JComboBox(level2);
		comboBox_Lev2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox_Lev2.setBounds(187, 139, 221, 21);
		panelLecDetail.add(comboBox_Lev2);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow=table.getSelectedRow();
                DefaultTableModel model=(DefaultTableModel) table_lecturer.getModel();
				//String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                    String query = "select id as 'ID', lecturer_name as 'Lecturer Name', lecturer_ID as 'Lecturer ID', lecturer_level as 'Level', lecturer_rank as 'Rank', faculty as 'Faculty', department as 'Department', center as 'Center', building as 'Building' from lecturer";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table_lecturer.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                                       
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(1188, 21, 106, 31);
		panellecdetail.add(btnRefresh);
		
		textFieldSeacrh = new JTextField();
		textFieldSeacrh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSeacrh.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					
					 String search = textFieldSeacrh.getText();
					
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "select id as 'ID', lecturer_name as 'Lecturer Name', lecturer_ID as 'Lecturer ID', lecturer_level as 'Level', lecturer_rank as 'Rank', faculty as 'Faculty', department as 'Department', center as 'Center', building as 'Building' FROM lecturer where lecturer_name LIKE '%"+search+"%'";
			     
			         PreparedStatement pst = connection.prepareStatement(query);

			         ResultSet rs=pst.executeQuery();
			         table_lecturer.setModel(DbUtils.resultSetToTableModel(rs));
			         

					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
			}
		});
		textFieldSeacrh.setColumns(10);
		textFieldSeacrh.setBounds(954, 104, 221, 31);
		panellecdetail.add(textFieldSeacrh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 164, 802, 406);
		panellecdetail.add(scrollPane);
		
		table_lecturer = new JTable();
		table_lecturer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_lecturer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table_lecturer.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_lecturer.getModel();
				
				textFieldName_1.setText(model.getValueAt(selectedRow, 1).toString());
				textFieldEmpID_1.setText(model.getValueAt(selectedRow, 2).toString());
				comboBox_Lev2.setSelectedItem(model.getValueAt(selectedRow, 3).toString());;
				textFieldupdaterank.setText(model.getValueAt(selectedRow, 4).toString());
				comboBox_Fac2.setSelectedItem(model.getValueAt(selectedRow, 5).toString());;
				comboBox_Dept2.setSelectedItem(model.getValueAt(selectedRow, 6).toString());;
				comboBox_Cent2.setSelectedItem(model.getValueAt(selectedRow, 7).toString());;
				comboBox_Build2.setSelectedItem(model.getValueAt(selectedRow, 8).toString());;
			}
		});
		table_lecturer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Emp ID", "Level", "Rank", "Faculty", "Department", "Center", "Building"
			}
		));
		scrollPane.setViewportView(table_lecturer);
		
		JLabel lblNewLabel_2_2_6_1 = new JLabel("Update / Delete Details");
		lblNewLabel_2_2_6_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_2_6_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_6_1.setBounds(29, 21, 209, 24);
		panellecdetail.add(lblNewLabel_2_2_6_1);
		
		JLabel lblNewLabel_2_2_6_2 = new JLabel("Lecturer Details");
		lblNewLabel_2_2_6_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_2_6_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_6_2.setBounds(805, 65, 209, 24);
		panellecdetail.add(lblNewLabel_2_2_6_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(1188, 104, 106, 31);
		panellecdetail.add(btnSearch);
		
		panelDayshours = new JPanel();
		panelDayshours.setBackground(new Color(255, 255, 255));
		layeredPane.add(panelDayshours, "name_382280115736200");
		panelDayshours.setLayout(null);
		
		JLabel lblNewLabel_2_2_6_1_1 = new JLabel("Update / Delete Active Days and Hours");
		lblNewLabel_2_2_6_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_2_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_6_1_1.setBounds(33, 32, 366, 24);
		panelDayshours.add(lblNewLabel_2_2_6_1_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(204, 204, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(32, 66, 426, 508);
		panelDayshours.add(panel_1_1);
		
		JLabel lblNewLabel_2_2_1_2_7 = new JLabel("Employee ID");
		lblNewLabel_2_2_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_7.setBounds(25, 23, 106, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7);
		
		textFieldMon = new JTextField();
		textFieldMon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldMon.setColumns(10);
		textFieldMon.setBounds(175, 115, 241, 26);
		panel_1_1.add(textFieldMon);
		
		textFieldTue = new JTextField();
		textFieldTue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldTue.setColumns(10);
		textFieldTue.setBounds(175, 161, 241, 26);
		panel_1_1.add(textFieldTue);
		
		textFieldWed = new JTextField();
		textFieldWed.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldWed.setColumns(10);
		textFieldWed.setBounds(175, 207, 241, 26);
		panel_1_1.add(textFieldWed);
		
		textFieldThurs = new JTextField();
		textFieldThurs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldThurs.setColumns(10);
		textFieldThurs.setBounds(175, 254, 241, 26);
		panel_1_1.add(textFieldThurs);
		
		textFieldFri = new JTextField();
		textFieldFri.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldFri.setColumns(10);
		textFieldFri.setBounds(175, 301, 241, 27);
		panel_1_1.add(textFieldFri);
		
		textFieldSat = new JTextField();
		textFieldSat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSat.setColumns(10);
		textFieldSat.setBounds(175, 353, 241, 27);
		panel_1_1.add(textFieldSat);
		
		textFieldSun = new JTextField();
		textFieldSun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldSun.setColumns(10);
		textFieldSun.setBounds(175, 402, 241, 26);
		panel_1_1.add(textFieldSun);
		
		JLabel lblNewLabel_2_2_1_2_1_1 = new JLabel("Sunday");
		lblNewLabel_2_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_1_1.setBounds(25, 400, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_1_1);
		
		JLabel lblNewLabel_2_2_1_2_2_1 = new JLabel("Saturday");
		lblNewLabel_2_2_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_2_1.setBounds(25, 352, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_2_1);
		
		JLabel lblNewLabel_2_2_1_2_3_1 = new JLabel("Friday");
		lblNewLabel_2_2_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_3_1.setBounds(25, 304, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_3_1);
		
		JLabel lblNewLabel_2_2_1_2_4_1 = new JLabel("Thursday");
		lblNewLabel_2_2_1_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_4_1.setBounds(25, 256, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_4_1);
		
		JLabel lblNewLabel_2_2_1_2_5_1 = new JLabel("Wednesday");
		lblNewLabel_2_2_1_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_5_1.setBounds(25, 209, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_5_1);
		
		JLabel lblNewLabel_2_2_1_2_6_1 = new JLabel("Tuesday");
		lblNewLabel_2_2_1_2_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_6_1.setBounds(25, 163, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_6_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String monString = textFieldMon.getText();
				String tueString = textFieldTue.getText();
				String wedString = textFieldWed.getText();
				String thurString = textFieldThurs.getText();
				String friString = textFieldFri.getText();
				String satString = textFieldSat.getText();
				String sunString = textFieldSun.getText();

				
				int selectedRow = table_hours.getSelectedRow();
			     DefaultTableModel model = (DefaultTableModel) table_hours.getModel();
			     String id =(model.getValueAt(selectedRow, 0).toString());
				
				try {
			    	 
			         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "UPDATE lecturer set monday='"+monString+"', tuesday='"+tueString+"', wednesday='"+wedString+"', thursday='"+thurString+"', friday = '"+friString+"' , saturday = '"+satString+"', sunday = '"+sunString+"'where lecturer_ID="+id;
			     
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
                    String query = "select lecturer_ID as 'Lecturer ID', lecturer_name as 'Lecturer Name', monday, tuesday, wednesday, thursday, friday, saturday, sunday from lecturer";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table_hours.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                    
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
				
			}
		});
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate_1.setBounds(83, 455, 116, 31);
		panel_1_1.add(btnUpdate_1);
		
		JLabel lblNewLabel_empID = new JLabel("");
		lblNewLabel_empID.setForeground(SystemColor.textInactiveText);
		lblNewLabel_empID.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_empID.setBounds(25, 57, 106, 13);
		panel_1_1.add(lblNewLabel_empID);
		
		JLabel lblNewLabel_empName = new JLabel("");
		lblNewLabel_empName.setForeground(SystemColor.textInactiveText);
		lblNewLabel_empName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_empName.setBounds(175, 57, 241, 13);
		panel_1_1.add(lblNewLabel_empName);
		
		JButton btnClear_2 = new JButton("Clear");
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel_empID.setText("");
				lblNewLabel_empName.setText("");
				textFieldMon.setText("");
				textFieldTue.setText("");
				textFieldWed.setText("");
				textFieldThurs.setText("");
				textFieldFri.setText("");
				textFieldSat.setText("");
				textFieldSun.setText("");
				
			}
		});
		btnClear_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear_2.setBounds(226, 455, 116, 31);
		panel_1_1.add(btnClear_2);
		
		JLabel lblNewLabel_2_2_1_2_7_1 = new JLabel("Lecturer Name");
		lblNewLabel_2_2_1_2_7_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_7_1.setBounds(175, 23, 116, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7_1);
		
		JLabel lblNewLabel_2_2_1_2_7_2 = new JLabel("Monday");
		lblNewLabel_2_2_1_2_7_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_7_2.setBounds(25, 117, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7_2);
		
		
		
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow=table.getSelectedRow();
                DefaultTableModel model2=(DefaultTableModel) table_hours.getModel();
				//String id=(model.getValueAt(selectedRow, 0).toString());
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");
                    String query = "select lecturer_ID as 'Lecturer ID', lecturer_name as 'Lecturer Name', monday, tuesday, wednesday, thursday, friday, saturday, sunday from lecturer";
                    Statement sta = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    
                    table_hours.setModel(DbUtils.resultSetToTableModel(rs1));
                    connection.close();
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnRefresh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh_1.setBounds(1188, 25, 106, 31);
		panelDayshours.add(btnRefresh_1);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setBackground(SystemColor.activeCaption);
		btnSearch_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch_1.setBounds(1188, 108, 106, 31);
		panelDayshours.add(btnSearch_1);
		
		textFieldSearchDays = new JTextField();
		textFieldSearchDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldSearchDays.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
					 String search2 = textFieldSearchDays.getText();
					
					 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "ABCroot@1");

			         String query = "SELECT lecturer_ID, lecturer_name,monday,tuesday,wednesday,thursday,friday,saturday,sunday FROM lecturer where lecturer_name LIKE '%"+search2+"%'";
			     
			         PreparedStatement pst = connection.prepareStatement(query);

			         ResultSet rs=pst.executeQuery();
			         table_hours.setModel(DbUtils.resultSetToTableModel(rs));
			         

					
				}
				catch (Exception exception) {
			         exception.printStackTrace();
			     }
				
			}
		});
		textFieldSearchDays.setColumns(10);
		textFieldSearchDays.setBounds(937, 108, 241, 31);
		panelDayshours.add(textFieldSearchDays);
		
		JLabel lblNewLabel_2_2_6_1_1_1 = new JLabel("Details of Active Days and Hours");
		lblNewLabel_2_2_6_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_2_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_6_1_1_1.setBounds(661, 62, 366, 24);
		panelDayshours.add(lblNewLabel_2_2_6_1_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(487, 169, 807, 402);
		panelDayshours.add(scrollPane_1);
		
		table_hours = new JTable();
		table_hours.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table_hours.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int selectedRow = table_hours.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table_hours.getModel();
				
				lblNewLabel_empID.setText(model.getValueAt(selectedRow, 0).toString());
				lblNewLabel_empName.setText(model.getValueAt(selectedRow, 1).toString());
				textFieldMon.setText(model.getValueAt(selectedRow, 2).toString());
				textFieldTue.setText(model.getValueAt(selectedRow, 3).toString());
				textFieldWed.setText(model.getValueAt(selectedRow, 4).toString());
				textFieldThurs.setText(model.getValueAt(selectedRow, 5).toString());
				textFieldFri.setText(model.getValueAt(selectedRow, 6).toString());
				textFieldSat.setText(model.getValueAt(selectedRow, 7).toString());
				textFieldSun.setText(model.getValueAt(selectedRow, 8).toString());
				
			}
		});
		table_hours.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp ID", "Lecturer Name", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		));
		scrollPane_1.setViewportView(table_hours);
		
		JButton btnNewButtonAddlec = new JButton("Add Lecturer Details");
		btnNewButtonAddlec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panellec);
			}
		});
		btnNewButtonAddlec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtonAddlec.setBounds(731, 141, 187, 31);
		contentPane.add(btnNewButtonAddlec);
		
		JButton btnNewButton_1_1 = new JButton("View Active Days and Hours");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panelDayshours);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(1171, 141, 243, 31);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("View Lecturer Details");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(panellecdetail);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1_1.setBounds(928, 141, 233, 31);
		contentPane.add(btnNewButton_1_1_1);
	}
}
