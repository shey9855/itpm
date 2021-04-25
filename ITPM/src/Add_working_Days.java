import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils; 
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class Add_working_Days extends JFrame {
     
	
	String Working_Days1;
	Connection con = null;
	PreparedStatement pst;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_working_Days frame = new Add_working_Days();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//create a database connection
	
	public void connect(){
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm",
		"root", "aruni077/");
		
	     if(con != null) {
			
	    	 System.out.print("Successfully connected");
	     }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("connected");
			
		}
		
		
		


	}
	
	
	JLayeredPane layeredPane = new JLayeredPane();
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textFieldSearch;
	private JTable table_1;
    public void switchPanels(JPanel panel)
    {
       layeredPane.removeAll();
       layeredPane.add(panel);
       layeredPane.repaint();
       layeredPane.revalidate();
      
    }
   
	//private JTable table;
    public void switchPanels1(JPanel panel)
    {
       layeredPane.removeAll();
       layeredPane.add(panel);
       layeredPane.repaint();
       layeredPane.revalidate();
      
    }


	/**
	 * Create the frame.
	 */
	public Add_working_Days() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 70));
		lblNewLabel.setBackground(new Color(255, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(5, 5, 1530, 835);
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
		
		/*JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(Color.GREEN);
		btnNewButton_1.setBounds(22, 141, 70, 70);
		Image imgH = new ImageIcon(this.getClass().getResource("home1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imgH));
		btnNewButton_1.setFont(new Font("Ink Free", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.show();
				
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);*/
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Main main = new Main();
				main.show();
				
				dispose();
			}
		});
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		Image imgH = new ImageIcon(this.getClass().getResource("home1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imgH));
		btnNewButton_1.setBounds(22, 141, 70, 70);
		contentPane.add(btnNewButton_1);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(111, 207, 1402, 572);
		layeredPane.setLayout(new CardLayout(0, 0));
		contentPane.add(layeredPane);
		
		JPanel panelAdd = new JPanel();
		panelAdd.setBackground(new Color(255, 255, 255));
		layeredPane.add(panelAdd, "name_131838547041699");
		panelAdd.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Add Working Days And Hours");
		lblNewLabel_2.setBounds(460, 29, 272, 24);
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panelAdd.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(37, 80, 638, 442);
		panelAdd.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Number Of Working Days");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(22, 42, 184, 17);
		panel.add(lblNewLabel_1_1);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBackground(new Color(51, 0, 255));
		spinner_3.setForeground(new Color(0, 0, 255));
		spinner_3.setBounds(297, 43, 68, 28);
		panel.add(spinner_3);
		
		JLabel lblNewLabel_2_2 = new JLabel("Working Days");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(22, 88, 278, 13);
		panel.add(lblNewLabel_2_2);
		
		JCheckBox chckbxNewCheckBox_6_1 = new JCheckBox("Monday");
		chckbxNewCheckBox_6_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_6_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_6_1.setBounds(297, 77, 93, 34);
		panel.add(chckbxNewCheckBox_6_1);
		
		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("Tuesday");
		chckbxNewCheckBox_3_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_3_1.setBounds(297, 117, 93, 34);
		panel.add(chckbxNewCheckBox_3_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Wednsday");
		chckbxNewCheckBox_2.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_2.setBounds(297, 156, 93, 34);
		panel.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("Thursday");
		chckbxNewCheckBox_1_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_1_1.setBounds(297, 197, 93, 34);
		panel.add(chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_4_1 = new JCheckBox("Friday");
		chckbxNewCheckBox_4_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_4_1.setBounds(297, 237, 93, 34);
		panel.add(chckbxNewCheckBox_4_1);
		
		JCheckBox chckbxNewCheckBox_7_1 = new JCheckBox("Saturday");
		chckbxNewCheckBox_7_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_7_1.setBounds(297, 277, 93, 34);
		panel.add(chckbxNewCheckBox_7_1);
		
		JCheckBox chckbxNewCheckBox_5_1 = new JCheckBox("Sunday");
		chckbxNewCheckBox_5_1.setBackground(new Color(204, 204, 255));
		chckbxNewCheckBox_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxNewCheckBox_5_1.setBounds(297, 323, 93, 34);
		panel.add(chckbxNewCheckBox_5_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Working Time Per Day");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_2.setBounds(22, 383, 278, 13);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Hours");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_1_1.setBounds(297, 383, 93, 13);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		JSpinner spinner_1_1 = new JSpinner();
		spinner_1_1.setBounds(354, 378, 62, 28);
		panel.add(spinner_1_1);
		
		JLabel lblNewLabel_2_1_1_2_2 = new JLabel("Minutes");
		lblNewLabel_2_1_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_2.setBounds(442, 383, 83, 13);
		panel.add(lblNewLabel_2_1_1_2_2);
		
		JSpinner spinner_2_1 = new JSpinner();
		spinner_2_1.setBounds(524, 378, 62, 28);
		panel.add(spinner_2_1);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(375, 50, 253, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(442, 198, 130, 21);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setBounds(397, 411, 130, 21);
		panel.add(lblNewLabel_4_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(707, 80, 381, 423);
		panelAdd.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_3 = new JLabel("Time Slots:");
		lblNewLabel_2_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3.setBounds(25, 108, 79, 17);
		panel_1.add(lblNewLabel_2_1_1_3);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(96, 145, 131, 22);
		panel_1.add(textArea_2);
		
		JLabel lblNewLabel_2_1_1_2_1_1 = new JLabel("To");
		lblNewLabel_2_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_2_1_1.setBounds(156, 182, 18, 17);
		panel_1.add(lblNewLabel_2_1_1_2_1_1);
		
		JTextArea textArea_2_1 = new JTextArea();
		textArea_2_1.setBounds(96, 222, 131, 22);
		panel_1.add(textArea_2_1);
		
		JTextArea textArea_2_1_1 = new JTextArea();
		textArea_2_1_1.setBounds(96, 76, 131, 22);
		panel_1.add(textArea_2_1_1);
		//////
		
			    
		
	
	
		JButton btnNewButton = new JButton("Add Time Slots");
		 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              try {
					
					  String id = textArea_2_1_1.getText();
					  int id1 =Integer.parseInt(id);
				      Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
                      String query =  "SELECT No_of_working_H,No_of_Working_M FROM add_workinghd where ID ="+id;
					   Statement sta = connection.createStatement();
					   ResultSet srs = sta.executeQuery(query);
					   int total = 0;
					   while (srs.next()) {
				             int  No_of_working_H1 = srs.getInt("No_of_working_H");
				            int No_of_Working_M1 = srs.getInt("No_of_Working_M");
				             total = No_of_working_H1+No_of_Working_M1;
				            String val = Integer.toString(total);
				            //textField.setText(val);//aditional
				           
				            	
				            }
					 //  String st =textArea_2.getText();
					  // String en =textArea_2_1.getText();
					   
					   //for(int i=0;i<total;i++) {
						   String st =textArea_2.getText();
						   String en =textArea_2_1.getText();
				            
						   //Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
						   String query11 = "INSERT INTO time_slots values(0,'" + id1 + "','" + st + "','" + en + "')";

		                    Statement sta1 = connection.createStatement();
		                    int x1 = sta1.executeUpdate(query11);
		                    JOptionPane.showMessageDialog(null, "succesfully Inserted  ");
				            
				    
					   connection.close();
					   //}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("gdhhdhdh");
				}
                
				
			}
		});
	
		btnNewButton.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(131, 305, 179, 30);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_2_1_1_3_1 = new JLabel("Enter Data ID:");
		lblNewLabel_2_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1.setBounds(25, 43, 106, 17);
		panel_1.add(lblNewLabel_2_1_1_3_1);
		
		
		////
		
		
		JPanel panelManage = new JPanel();
		panelManage.setBackground(Color.WHITE);
		layeredPane.add(panelManage, "name_135919488577400");
		
		
		
		
		JButton btnAdd = new JButton("UPDATE");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAdd);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnAdd.setBounds(1159, 260, 179, 56);
		panelAdd.add(btnAdd);
		
		JButton btnUpdate_1_1 = new JButton("DELETE");
		btnUpdate_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelAdd);
			}
		});
		btnUpdate_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate_1_1.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnUpdate_1_1.setBounds(1159, 412, 179, 56);
		panelAdd.add(btnUpdate_1_1);
		
		//insert data
		
		JButton btnUpdate_1_2 = new JButton("ADD");
		btnUpdate_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Number_of_working_Days1 = (int) spinner_3.getValue();
				if(Number_of_working_Days1==0) {

					lblNewLabel_4.setText("Please Enter the data");
				}
				if(chckbxNewCheckBox_6_1.isSelected()) {
					Working_Days1 ="Monday";
				}
				if(chckbxNewCheckBox_3_1.isSelected()) {
					Working_Days1 ="Tuesday";
				}
				if(chckbxNewCheckBox_2.isSelected()) {
					Working_Days1 ="Wednsday";
				}
				if(chckbxNewCheckBox_1_1.isSelected()) {
					Working_Days1 ="Thursday";
				}
				if(chckbxNewCheckBox_4_1.isSelected()) {
					Working_Days1 ="Friday";
				}
				if(chckbxNewCheckBox_7_1.isSelected()) {
					Working_Days1 ="Saturday";
				}
				if(chckbxNewCheckBox_5_1.isSelected()) {
					Working_Days1 ="Sunday";
				}
				int No_of_working_H1 = (int) spinner_1_1.getValue();
				int No_of_Working_M1 =(int) spinner_2_1.getValue();
				
				if(Number_of_working_Days1==0 ) {
					
					lblNewLabel_4.setText("Please Enter the Number of Working Days");
				}
				/*else if(No_of_working_H1==0  && No_of_Working_M1==0 ) {
					lblNewLabel_4_1_1.setText("Text fileds are Empty");
				}
				else if( chckbxNewCheckBox_6_1.isSelected()== false&& chckbxNewCheckBox_7_1.isSelected()== false&&chckbxNewCheckBox_4_1.isSelected()== false&&chckbxNewCheckBox_1_1.isSelected()== false&&chckbxNewCheckBox_2.isSelected()== false&&chckbxNewCheckBox_3_1.isSelected()== false&&chckbxNewCheckBox_5_1.isSelected()== false  ) {
					lblNewLabel_4_1.setText("Select A day");
				}*/
				else {
				
				try {
					lblNewLabel_4.setText("");
					lblNewLabel_4_1_1.setText("");
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
                    String query = "INSERT INTO add_workinghd values(0,'" + Number_of_working_Days1 + "','" + Working_Days1 + "','" + No_of_working_H1 + "','" + No_of_Working_M1 + "')";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "succesfully Inserted");
                    
                    //String query1 = "SELECT * FROM add_workinghd";

                  //  Statement sta1 = connection.createStatement();
                  //  ResultSet rs1 = sta1.executeQuery(query1);
                   
                   // table.setModel(DbUtils.resultSetToTableModel(rs1));
                    
                    
                    connection.close();
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Duplicate Entry. Please Try Again");
                }
			}
			}
		});
		btnUpdate_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate_1_2.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnUpdate_1_2.setBounds(1159, 124, 179, 56);
		panelAdd.add(btnUpdate_1_2);
		panelManage.setLayout(null);
		
		
		//manage Working days and hours
		
		
		
		JLabel lblNewLabel_21 = new JLabel("Manage Working Days And Hours");
		lblNewLabel_21.setBounds(558, 5, 280, 21);
		lblNewLabel_21.setForeground(new Color(0, 0, 102));
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		panelManage.add(lblNewLabel_21);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(204, 204, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(39, 46, 426, 478);
		panelManage.add(panel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(20, 20, 84, 24);
		panel_1_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Number of Working Days:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(20, 83, 168, 24);
		panel_1_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Working Day:");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(20, 146, 121, 24);
		panel_1_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Number of Hourly Time Slots:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(20, 204, 215, 24);
		panel_1_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Number of 30 Minutes Time Slots:");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_3_1.setBounds(20, 271, 236, 24);
		panel_1_1.add(lblNewLabel_3_3_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(282, 126, 121, 19);
		panel_1_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(282, 182, 121, 19);
		panel_1_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(282, 242, 121, 19);
		panel_1_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(282, 311, 121, 19);
		panel_1_1.add(textField_5);
		textField_5.setColumns(10);
		
		JSpinner spinner11 = new JSpinner();
		spinner11.setBounds(282, 47, 121, 20);
		panel_1_1.add(spinner11);
		
		////////////////////////////////////update records////////////////////////////////////////////////////
		
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow = table.getSelectedRow();
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
			   // String id = (model.getValueAt(selectedRow, 1).toString());
				////
				String stat =textFieldSearch.getText();
				int id=(int) spinner11.getValue();
				int id1=6;
				int working_days = Integer.parseInt(textField_2.getText());
				String days = textField_3.getText();
				int hours =Integer.parseInt(textField_4.getText());
				int minutes=Integer.parseInt(textField_5.getText());
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					 PreparedStatement sta1;
					 sta1 = connection.prepareStatement("update add_workinghd set Number_of_working_Days= ?,Working_Days= ?,No_of_working_H= ?,No_of_Working_M= ? where ID =?");
					 sta1.setLong(1, working_days);
					sta1.setString(2, days);
					 sta1.setLong(3, hours);
					 sta1.setLong(4, minutes);
					 sta1.setLong(5, id);
					 sta1.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Updated Successfully");
					 
					 DefaultTableModel Model = (DefaultTableModel) table_1.getModel();
	                    int SelectedRowIndex = table_1.getSelectedRow();
	                    int idu = (int) Model.getValueAt(SelectedRowIndex, 0);
	                    String start = (String) Model.getValueAt(SelectedRowIndex, 2);
	                    String end =(String) Model.getValueAt(SelectedRowIndex, 3);
	                    //String end1 ="13.30";
	                    System.out.println(idu+start+end);
	                  // System.out.println(id1+start+end);
	                    Connection connection1 =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
	                    PreparedStatement sta2;
	                    sta2 = connection1.prepareStatement("update time_slots set start= ?,end= ? where idTime_slots =?");
						 sta2.setString(1,start );
						 sta2.setString(2, end);
						 sta2.setLong(3, idu);
						 
						 sta2.executeUpdate();
						 JOptionPane.showMessageDialog(null, "Updated  time Successfully");
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
					System.out.println("ghfjfjjjjjjjjj");
				}
			}
		});
		btnNewButton_4.setBounds(46, 424, 132, 32);
		panel_1_1.add(btnNewButton_4);
		//////////////////////////////////delete records//////////////////////////////////////////////////////
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow = table.getSelectedRow();
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//String id = (model.getValueAt(selectedRow, 1).toString());
				String stat =textFieldSearch.getText();
				int id=(int) spinner11.getValue();
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					String query = "DELETE FROM add_workinghd WHERE ID = "+id;
                    PreparedStatement sta = connection.prepareStatement(query);
                    int rss = sta.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "succesfully Deleted");
					
                    DefaultTableModel Model = (DefaultTableModel) table_1.getModel();
                    int SelectedRowIndex = table_1.getSelectedRow();
                    int id1 = (int) Model.getValueAt(SelectedRowIndex, 0);
                    System.out.println(id1);
                    Model.removeRow(SelectedRowIndex);
                    String query1 = "DELETE FROM time_slots WHERE idTime_slots = "+id1;
                    PreparedStatement sta1 = connection.prepareStatement(query1);
                    int rss1 = sta.executeUpdate(query1);
                    //System.out.println(SelectedRowIndex);
                    
                    
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(238, 424, 115, 32);
		panel_1_1.add(btnNewButton_5);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(526, 92, 534, 412);
		panelManage.add(scrollPane_1);
		
		//set table    
		
		
		
		table = new JTable();
		
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Number_of_working_Days", "Working_Days", "No_of_working_H", "No_of_Working_M"
				}
			));
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.show();
				
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(951, 541, 85, 21);
		panelManage.add(btnNewButton_2_1);
		
		JButton btnNewButton_2 = new JButton("Refresh");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
                    String query = "SELECT * FROM add_workinghd";
                    String query1 = "SELECT * FROM time_slots";
                    Statement sta = connection.createStatement();
                    Statement sta1 = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                    ResultSet rs2 = sta1.executeQuery(query1);
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                    table_1.setModel(DbUtils.resultSetToTableModel(rs2));
                    connection.close();
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnNewButton_2.setBounds(640, 541, 85, 21);
		panelManage.add(btnNewButton_2);
		
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					int id = 0;
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					String query = "select * from add_workinghd where Working_Days =?";
					
                    PreparedStatement stat = (PreparedStatement) connection.prepareStatement(query);
                    stat.setNString(1,textFieldSearch.getText());
                    ResultSet rS = stat.executeQuery();
                    if(rS.next()==true) {
                    	 id = rS.getInt(1);
                    	int Number_of_working_Days= rS.getInt(2);
                    	String Working_Days = rS.getString(3);
                    	int No_of_working_H = rS.getInt(4);
                    	int No_of_Working_M =rS.getInt(5);
                    	
                    	//textField_1.setText(String.valueOf(id));
                    	spinner11.setValue(id);
                    	textField_2.setText(String.valueOf(Number_of_working_Days));
                    	textField_3.setText(Working_Days);
                    	textField_4.setText(String.valueOf(No_of_working_H));
                    	textField_5.setText(String.valueOf(No_of_Working_M));
 
                    	
                    }
                    
                    table.setModel(DbUtils.resultSetToTableModel(rS));
                    stat.close();
                    
                   /* String query1 = "select start,end from time_slots where Working_Days =?";
                    PreparedStatement stat1 = (PreparedStatement) connection.prepareStatement(query1);
                    stat1.setNString(1,String.valueOf(id));
                    ResultSet rS1 = stat1.executeQuery();
                    if(rS1.next()==true) {
                    	String st1 =rS1.getString(1);
                    	String st2 =rS1.getString(2);
                    	

                    
                    }*/
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			
			}
		});
		textFieldSearch.setBounds(999, 49, 220, 19);
		panelManage.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Search");
		btnNewButton_3.setBounds(1229, 48, 85, 21);
		panelManage.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1064, 92, 200, 412);
		panelManage.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID","Working_days_&_Hours_ID", "Start Time", "End Time"
				}
			));
		//table_1.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(table_1);
		
		/*table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp ID", "Lecturer Name", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		));
		scrollPane_1.setViewportView(table_1);*/
	}
}
