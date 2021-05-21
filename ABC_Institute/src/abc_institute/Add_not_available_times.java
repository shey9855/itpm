package abc_institute;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import session_manage.session_main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Add_not_available_times extends JFrame {

	Connection con = null;
	PreparedStatement pst;
	String val;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_not_available_times frame = new Add_not_available_times();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void connect(){
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm","root", "aruni077/");
		
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
	/**
	 * Create the frame.
	 */
	
	JLayeredPane layeredPane = new JLayeredPane();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
    
    
	public Add_not_available_times() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(22, 21, 466, 80);
		//lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
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
		Image imgH = new ImageIcon(this.getClass().getResource("/abc_institute/home1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imgH));
		btnNewButton_1.setBounds(22, 141, 70, 70);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(215, 143, 2, 649);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Not Available Times");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(731, 139, 272, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Add lectures,Group,Sub group,Session & Rooms");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(450, 181, 416, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Time And Date");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Time_Date add_Time_Date= new Add_Time_Date();
				add_Time_Date.show();
				
				dispose();
			}
		});
		btnNewButton_2.setBounds(876, 181, 416, 40);
		contentPane.add(btnNewButton_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(new Color(255, 255, 255));
		layeredPane.setBounds(276, 241, 1135, 541);
		layeredPane.setLayout(new CardLayout(0, 0));
		contentPane.add(layeredPane);
		
		
		
		JPanel panel = new JPanel();
		//panel.setBackground(Color.CYAN);
		panel.setBackground(new Color(255, 255, 255));
		layeredPane.add(panel, "name_493231858852700");
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_493236590396900");
		panel_1.setLayout(null);
		
		JPanel panel_i = new JPanel();
		panel_i.setBackground(new Color(204, 204, 255));
		panel_i.setBounds(24, 35, 599, 406);
		panel.add(panel_i);
		panel_i.setLayout(null);
		
		JLabel lblNewLabel_2_1_1_3_1_2 = new JLabel("Select Lecturer:");
		lblNewLabel_2_1_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_2.setBounds(44, 65, 124, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_2);
		
		JLabel lblNewLabel_2_1_1_3_1_3 = new JLabel("Select Group:");
		lblNewLabel_2_1_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_3.setBounds(44, 132, 107, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_3);
		
		JLabel lblNewLabel_2_1_1_3_1_4 = new JLabel("Select  Sub Group:");
		lblNewLabel_2_1_1_3_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_4.setBounds(44, 196, 153, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_4);
		
		JLabel lblNewLabel_2_1_1_3_1_5 = new JLabel("Select Rooms:");
		lblNewLabel_2_1_1_3_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_5.setBounds(44, 270, 124, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_5);
		
		JLabel lblNewLabel_2_1_1_3_1_6 = new JLabel("Select Session:");
		lblNewLabel_2_1_1_3_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_6.setBounds(44, 343, 124, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_6);
		
		
		
		
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(262, 65, 206, 21);
		panel_i.add(comboBox_1);
		
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(262, 132, 206, 21);
		panel_i.add(comboBox_1_1);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setBounds(262, 196, 206, 21);
		panel_i.add(comboBox_1_2);
		
		JComboBox comboBox_1_3 = new JComboBox();
		comboBox_1_3.setBounds(262, 270, 206, 21);
		panel_i.add(comboBox_1_3);
		
		JComboBox comboBox_1_4 = new JComboBox();
		comboBox_1_4.setBounds(262, 343, 206, 21);
		panel_i.add(comboBox_1_4);
		
		try {
			//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
			
			Connection connection = DBConnect.getConnection();
            String query = "SELECT lecturer_name FROM lecturer";
            String query1 = "SELECT group_id FROM student_grp";
            String query2 = "SELECT subGroup_id FROM student_grp";
            String query3 = "SELECT sessionCode FROM session";
            String query4 = "SELECT room FROM location";
            Statement sta = connection.createStatement();
            Statement sta1 = connection.createStatement();
            Statement sta2 = connection.createStatement();
            Statement sta3 = connection.createStatement();
            Statement sta4 = connection.createStatement();
           // Statement sta1 = connection.createStatement();
            ResultSet rs1 = sta.executeQuery(query);
            ResultSet rs2 = sta1.executeQuery(query1);
            ResultSet rs3 = sta2.executeQuery(query2);
            ResultSet rs4 = sta3.executeQuery(query3);
            ResultSet rs5 = sta4.executeQuery(query4);
          //  ResultSet rs2 = sta1.executeQuery(query1);
            while(rs1.next()) {
            	String lec = rs1.getString("lecturer_name");
            	comboBox_1.addItem(lec);
            }
            while(rs2.next()) {
            	String lec = rs2.getString("group_id");
            	comboBox_1_1.addItem(lec);
            }
            while(rs3.next()) {
            	String lec = rs3.getString("subGroup_id");
            	comboBox_1_2.addItem(lec);
            }
            while(rs4.next()) {
            	String lec = rs4.getString("sessionCode");
            	comboBox_1_4.addItem(lec);
            }
            while(rs5.next()) {
            	String lec = rs5.getString("room");
            	comboBox_1_3.addItem(lec);
            }
            
           
            connection.close();
        } catch (Exception exception) {
        	
            exception.printStackTrace();
        }
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("Lecturer");
		comboBox_2.addItem("Group");
		comboBox_2.addItem("Sub Group");
		comboBox_2.addItem("Rooms");
		comboBox_2.addItem("Session");
		comboBox_2.setBackground(new Color(204, 204, 255));
		comboBox_2.setBounds(802, 67, 153, 21);
		panel.add(comboBox_2);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(SystemColor.inactiveCaptionBorder);
		textArea_2.setBackground(new Color(204, 204, 255));
		textArea_2.setBounds(803, 147, 152, 22);
		panel.add(textArea_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Monday");
		comboBox.addItem("Tuesday");
		comboBox.addItem("Wednsday");
		comboBox.addItem("Thursday");
		comboBox.addItem("Friday");
		comboBox.addItem("Saturday");
		comboBox.addItem("Sunday");
		//comboBox.setBackground(SystemColor.desktop);
		comboBox.setBackground(new Color(204, 204, 255));
		comboBox.setBounds(803, 230, 153, 21);
		panel.add(comboBox);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			String category = comboBox_2.getSelectedItem().toString();
			
			if(category == "Lecturer") {
				val = comboBox_1.getSelectedItem().toString();
			}
			if(category == "Group") {
				val = comboBox_1_1.getSelectedItem().toString();
				System.out.println(category);
				System.out.println(val);
			}
			if(category == "Sub Group") {
				val = comboBox_1_2.getSelectedItem().toString();
			}
			if(category == "Rooms") {
				val = comboBox_1_3.getSelectedItem().toString();
			}
			if(category == "Session") {
				val = comboBox_1_4.getSelectedItem().toString();
			}
			
			String time = textArea_2.getText();
			String day = comboBox.getSelectedItem().toString();
			
			
			
			try {
				//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
				
				Connection connection = DBConnect.getConnection();
                String query = "INSERT INTO not_available_time values(0,'" + val + "','" + time + "','" + day + "')";

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
		});
		btnNewButton_3.setBounds(741, 315, 228, 35);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2_1_1_3_1 = new JLabel("Time:");
		lblNewLabel_2_1_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1.setBounds(721, 149, 66, 17);
		panel.add(lblNewLabel_2_1_1_3_1);
		
		JLabel lblNewLabel_2_1_1_3_1_1 = new JLabel("Day:");
		lblNewLabel_2_1_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_1.setBounds(721, 230, 106, 17);
		panel.add(lblNewLabel_2_1_1_3_1_1);
		
		
		
		
		
		JLabel lblNewLabel_2_1_1_3_1_7 = new JLabel("Category:");
		lblNewLabel_2_1_1_3_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_7.setBounds(721, 67, 83, 17);
		panel.add(lblNewLabel_2_1_1_3_1_7);
		

				
	
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Manage Not Available Times");
		lblNewLabel_2_1_1.setBounds(402, 31, 237, 21);
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_i_1 = new JPanel();
		panel_i_1.setLayout(null);
		panel_i_1.setBackground(new Color(204, 204, 255));
		panel_i_1.setBounds(688, 60, 325, 396);
		panel_1.add(panel_i_1);
		
		JLabel lblNewLabel_2_1_1_3_1_2_1 = new JLabel("ID:");
		lblNewLabel_2_1_1_3_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_2_1.setBounds(44, 49, 124, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_2_1);
		
		JLabel lblNewLabel_2_1_1_3_1_3_1 = new JLabel("Category Details:");
		lblNewLabel_2_1_1_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_3_1.setBounds(44, 97, 124, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_3_1);
		
		JLabel lblNewLabel_2_1_1_3_1_4_1 = new JLabel("Day:");
		lblNewLabel_2_1_1_3_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_4_1.setBounds(46, 153, 153, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_4_1);
		
		JLabel lblNewLabel_2_1_1_3_1_5_1 = new JLabel("Time:");
		lblNewLabel_2_1_1_3_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_5_1.setBounds(44, 206, 124, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_5_1);
		
	
		
		JButton btnNewButton_6_3 = new JButton("Delete");
		btnNewButton_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int selectedRow = table.getSelectedRow();
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//String id = (model.getValueAt(selectedRow, 1).toString());
				int id = Integer.parseInt(textField.getText());
				try {
					//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
					String query = "DELETE FROM not_available_time WHERE idNot_Available_Time = "+id;
                    PreparedStatement sta = connection.prepareStatement(query);
                    int rss = sta.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "succesfully Deleted");
					
                   
                   
                    
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
			}
		});
		btnNewButton_6_3.setBackground(Color.WHITE);
		btnNewButton_6_3.setBounds(141, 321, 85, 34);
		panel_i_1.add(btnNewButton_6_3);
		
		JButton btnNewButton_6_4 = new JButton("Update");
		btnNewButton_6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int id = Integer.parseInt(textField.getText());
				String CategoryDetail = textField_1.getText();
        	 	String Time = textField_2.getText();
        	 	String Day = textField_3.getText();
				
				try {
					//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
					 PreparedStatement sta1;
					 sta1 = connection.prepareStatement("update not_available_time set CategoryDetail= ?,Time= ?,Day= ? where idNot_Available_Time =?");
					 sta1.setString(1, CategoryDetail);
					 sta1.setString(2,Time);
					 sta1.setString(3, Day);
					 sta1.setLong(4, id);
					 sta1.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Updated Successfully");
					 

//					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
					
				}
			}
		});
		btnNewButton_6_4.setBackground(Color.WHITE);
		btnNewButton_6_4.setBounds(236, 321, 85, 34);
		panel_i_1.add(btnNewButton_6_4);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					int id = 0;
					//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
					String query = "select * from not_available_time where idNot_Available_Time =?";
					
                    PreparedStatement stat = (PreparedStatement) connection.prepareStatement(query);
                    stat.setNString(1,textField.getText());
                    ResultSet rS = stat.executeQuery();
                    if(rS.next()==true) {
                    	 id = rS.getInt(1);
                    	 	String CategoryDetail = rS.getString(2);
                    	 	String Time = rS.getString(3);
                    	 	String Day = rS.getString(4);
                    	//textField_1.setText(String.valueOf(id));
                    	//spinner11.setValue(id);
                    	textField_1.setText(CategoryDetail);
                    	textField_2.setText(Time);
                    	textField_3.setText(Day);
                    	//textField_4.setText(String.valueOf(No_of_working_H));
                    	//textField_5.setText(String.valueOf(No_of_Working_M));
 
                    	
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
		textField.setBounds(208, 50, 96, 19);
		panel_i_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 98, 96, 19);
		panel_i_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 154, 96, 19);
		panel_i_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 207, 96, 19);
		panel_i_1.add(textField_3);
		textField_3.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(103, 62, 534, 412);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"idNot_Available_Time", "CategoryDetail", "Time", "Day"
				}
			));
		//scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);
		JButton btnNewButton_6 = new JButton("View");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_1);
				layeredPane.repaint();
			    layeredPane.revalidate();
			}
		});
		
		btnNewButton_6.setBounds(1434, 394, 85, 34);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Back");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_7.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel);
				layeredPane.repaint();
			    layeredPane.revalidate();
			      
				
			}
		});
		
		btnNewButton_7.setBounds(1434, 623, 85, 34);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_6_1 = new JButton("Clear");
		btnNewButton_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_6_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(panel_1);
				layeredPane.repaint();
			    layeredPane.revalidate();
			}
		});
		btnNewButton_6_1.setBackground(UIManager.getColor("ToggleButton.highlight"));
		btnNewButton_6_1.setBounds(1434, 503, 85, 34);
		contentPane.add(btnNewButton_6_1);
		
		//JButton btnNewButton = new JButton("");
		//btnNewButton.addActionListener(new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				
			//	Main main = new Main();
			//	main.show();
				
			//	dispose();
			//}
		//});
		
		JButton btnNewButton_6_2 = new JButton("Refresh");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/abc?useSSL=false", "root", "ABCroot@1");
					
					Connection connection = DBConnect.getConnection();
                    String query = "SELECT * FROM not_available_time";
                    //String query1 = "SELECT * FROM time_slots";
                    Statement sta = connection.createStatement();
                    //Statement sta1 = connection.createStatement();
                    ResultSet rs1 = sta.executeQuery(query);
                   // ResultSet rs2 = sta1.executeQuery(query1);
                    
                    table.setModel(DbUtils.resultSetToTableModel(rs1));
                    //table_1.setModel(DbUtils.resultSetToTableModel(rs2));
                    connection.close();
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			}
		});
		btnNewButton_6_2.setBackground(Color.WHITE);
		btnNewButton_6_2.setBounds(25, 321, 85, 34);
		panel_i_1.add(btnNewButton_6_2);
		
		JButton btnNewButton_1_2_2 = new JButton("Add Session");
		btnNewButton_1_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Session session = new Session();
				session.show();
				
				dispose();
			}
		});
		btnNewButton_1_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_1_2_2.setBounds(23, 241, 155, 47);
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
		btnNewButton_1_2_1.setBounds(23, 331, 155, 47);
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
		btnNewButton_1_2.setBounds(23, 424, 155, 47);
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
		btnNewButton_1_3.setBounds(23, 516, 155, 47);
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
		btnNewButton_1_4.setBounds(23, 606, 155, 47);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Not Available Time");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Add_not_available_times add_not_available_times = new Add_not_available_times();
				add_not_available_times.show();
				
				dispose();
			}
		});
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1_5.setBounds(23, 698, 155, 47);
		contentPane.add(btnNewButton_1_5);
		
	}
}
