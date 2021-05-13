import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Add_Time_Date extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Time_Date frame = new Add_Time_Date();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	
	JLayeredPane layeredPane = new JLayeredPane();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	public void switchPanels(JPanel panel)
    {
       layeredPane.removeAll();
       layeredPane.add(panel);
       layeredPane.repaint();
       layeredPane.revalidate();
      
    }
	
	
	public Add_Time_Date() {
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		//contentPane.setBackground(Color.CYAN);
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(393, 25, 664, 80);
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
		Image imgH = new ImageIcon(this.getClass().getResource("home1.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imgH));
		btnNewButton_1.setBounds(22, 141, 70, 70);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(215, 143, 2, 649);
		contentPane.add(separator_1);
		
		
		JButton btnNewButton_1_2 = new JButton("Parallel ");
		btnNewButton_1_2.setBounds(36, 425, 155, 47);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("Non-overlapping");
		btnNewButton_1_3.setBounds(36, 517, 155, 47);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("Session Rooms");
		btnNewButton_1_4.setBounds(36, 607, 155, 47);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Not Available Time");
		btnNewButton_1_5.setBounds(36, 699, 155, 47);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_2_1 = new JButton("Consecutive");
		btnNewButton_1_2_1.setBounds(36, 332, 155, 47);
		contentPane.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_2_2 = new JButton("Add Session");
		btnNewButton_1_2_2.setBounds(36, 242, 155, 47);
		contentPane.add(btnNewButton_1_2_2);
		JLabel lblNewLabel_2_1 = new JLabel("Not Available Times");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(831, 139, 272, 24);
		contentPane.add(lblNewLabel_2_1);
		
		
		
		
		JButton btnNewButton = new JButton("Add lectures,Group,Sub group,Session & Rooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_not_available_times add_not_available_times= new Add_not_available_times();
				add_not_available_times.show();
				
				dispose();
			}
		});
		btnNewButton.setBounds(540, 181, 416, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Add Time And Date");
		btnNewButton_2.setBounds(956, 181, 416, 40);
		contentPane.add(btnNewButton_2);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setOpaque(true);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setBounds(359, 275, 1039, 487);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		layeredPane.add(panel, "name_493503180320400");
		panel.setLayout(null);
		
		JPanel panel_i = new JPanel();
		panel_i.setLayout(null);
		panel_i.setBackground(new Color(204, 204, 255));
		panel_i.setBounds(98, 53, 857, 286);
		panel.add(panel_i);
		
		JLabel lblNewLabel_2_1_1_3_1_3 = new JLabel("Select Day:");
		lblNewLabel_2_1_1_3_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_3.setBounds(46, 149, 107, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_3);
		
		JLabel lblNewLabel_2_1_1_3_1_4 = new JLabel("Start Time:");
		lblNewLabel_2_1_1_3_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_4.setBounds(486, 94, 153, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_4);
		
		JLabel lblNewLabel_2_1_1_3_1_5 = new JLabel("End Time:");
		lblNewLabel_2_1_1_3_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_5.setBounds(486, 149, 124, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_5);
		
		JLabel lblNewLabel_2_1_1_3_1_6 = new JLabel("Select Session:");
		lblNewLabel_2_1_1_3_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_6.setBounds(44, 94, 124, 17);
		panel_i.add(lblNewLabel_2_1_1_3_1_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(191, 94, 206, 21);
		panel_i.add(comboBox_1);
		
		try {
			Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
            
            String query3 = "SELECT sessionCode FROM session";
            
            Statement sta3 = connection.createStatement();
            
           // Statement sta1 = connection.createStatement();
           
            ResultSet rs4 = sta3.executeQuery(query3);
          
          //  ResultSet rs2 = sta1.executeQuery(query1);
         
            while(rs4.next()) {
            	String lec = rs4.getString("sessionCode");
            	comboBox_1.addItem(lec);
            }
         
           
            connection.close();
        } catch (Exception exception) {
        	
            exception.printStackTrace();
        }
		
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.addItem("Monday");
		comboBox_1_2.addItem("Tuesday");
		comboBox_1_2.addItem("Wednsday");
		comboBox_1_2.addItem("Thursday");
		comboBox_1_2.addItem("Friday");
		comboBox_1_2.addItem("Saturday");
		comboBox_1_2.addItem("Sunday");
		comboBox_1_2.setBounds(191, 149, 206, 21);
		panel_i.add(comboBox_1_2);
		
		textField = new JTextField();
		textField.setBounds(602, 147, 206, 19);
		panel_i.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(602, 95, 206, 19);
		panel_i.add(textField_1);
		
		JButton btnNewButton_3 = new JButton("Add Time");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
					String sessionCode= comboBox_1.getSelectedItem().toString();
					String Day= comboBox_1_2.getSelectedItem().toString();
					String StartT = textField_1.getText();
					String StartE = textField.getText();
					
			
			
			
			try {
				Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
				 PreparedStatement sta1;
				 sta1 = connection.prepareStatement("update session set Day= ?,StartTime= ?,EndTime= ? where sessionCode =?");
				 sta1.setString(1, Day);
				 sta1.setString(2,StartT);
				 sta1.setString(3, StartE);
				 sta1.setString(4, sessionCode);
				 sta1.executeUpdate();
				 JOptionPane.showMessageDialog(null, "Inserted Successfully");
				 
                
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
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(203, 385, 228, 35);
		panel.add(btnNewButton_3);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		layeredPane.add(panel_1, "name_493521291407000");
		
		JButton btnNewButton_3_1 = new JButton("Manage Time");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panel);
			}
		});
		btnNewButton_3_1.setBackground(Color.WHITE);
		btnNewButton_3_1.setBounds(630, 385, 228, 35);
		panel.add(btnNewButton_3_1);
		
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Manage Assigned Date & Time");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(402, 31, 271, 21);
		panel_1.add(lblNewLabel_2_1_1);
		
		JPanel panel_i_1 = new JPanel();
		panel_i_1.setLayout(null);
		panel_i_1.setBackground(new Color(204, 204, 255));
		panel_i_1.setBounds(713, 72, 305, 388);
		panel_1.add(panel_i_1);
		
		JLabel lblNewLabel_2_1_1_3_1_3_1 = new JLabel(" Day:");
		lblNewLabel_2_1_1_3_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_3_1.setBounds(43, 102, 107, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_3_1);
		
		JLabel lblNewLabel_2_1_1_3_1_4_1 = new JLabel("Start Time:");
		lblNewLabel_2_1_1_3_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_4_1.setBounds(43, 158, 153, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_4_1);
		
		JLabel lblNewLabel_2_1_1_3_1_5_1 = new JLabel("End Time:");
		lblNewLabel_2_1_1_3_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_5_1.setBounds(43, 216, 124, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_5_1);
		
		JLabel lblNewLabel_2_1_1_3_1_6_1 = new JLabel("Enter a Session:");
		lblNewLabel_2_1_1_3_1_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1_1_3_1_6_1.setBounds(43, 49, 124, 17);
		panel_i_1.add(lblNewLabel_2_1_1_3_1_6_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 202, 107, 19);
		panel_i_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(185, 103, 114, 19);
		panel_i_1.add(textField_3);
		
		JButton btnNewButton_6_2 = new JButton("Refresh");
		btnNewButton_6_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
                    String query = "SELECT * FROM session";
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
		btnNewButton_6_2.setBounds(10, 344, 85, 34);
		panel_i_1.add(btnNewButton_6_2);
		
		JButton btnNewButton_6_3 = new JButton("Delete");
		btnNewButton_6_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sessionCode= textField_4.getText();
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					PreparedStatement sta1;
					sta1 = connection.prepareStatement("update session set Day= ?,StartTime= ?,EndTime= ? where sessionCode =?");
					 sta1.setString(1, null);
					 sta1.setString(2,null);
					 sta1.setString(3, null);
					 sta1.setString(4, sessionCode);
					 sta1.executeUpdate();
					 JOptionPane.showMessageDialog(null, "Deleted Successfully");
					
                   
                   
                    
					
				}
				catch(Exception exe)
				{
					exe.printStackTrace();
				}
			}
		});
		btnNewButton_6_3.setBackground(Color.WHITE);
		btnNewButton_6_3.setBounds(116, 344, 85, 34);
		panel_i_1.add(btnNewButton_6_3);
		
		JButton btnNewButton_6_4 = new JButton("Update");
		btnNewButton_6_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String sessionCode= textField_4.getText();
        	 	String Day = textField_3.getText();
        	 	String StartTime = textField_5.getText();
        	 	String EndTime = textField_2.getText();
				
				try {
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					 PreparedStatement sta1;
					 sta1 = connection.prepareStatement("update session set Day= ?,StartTime= ?,EndTime= ? where sessionCode =?");
					 sta1.setString(1, Day);
					 sta1.setString(2,StartTime);
					 sta1.setString(3, EndTime);
					 sta1.setString(4, sessionCode);
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
		btnNewButton_6_4.setBounds(219, 344, 85, 34);
		panel_i_1.add(btnNewButton_6_4);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter(){
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					int id = 0;
					Connection connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/itpm?useSSL=false", "root", "aruni077/");
					String query = "select * from session where sessionCode =?";
					
                    PreparedStatement stat = (PreparedStatement) connection.prepareStatement(query);
                    stat.setNString(1,textField_4.getText());
                    ResultSet rS = stat.executeQuery();
                    if(rS.next()==true) {
                    	 //id = rS.getInt(1);
                    		String sessionCode= rS.getString(2);
                    	 	String Day = rS.getString(11);
                    	 	String StartTime = rS.getString(12);
                    	 	String EndTime = rS.getString(13);
                    	//textField_1.setText(String.valueOf(id));
                    	//spinner11.setValue(id);
                    	 	textField_3.setText(Day);
                    	 	textField_5.setText(StartTime);
                    	 	textField_2.setText(EndTime);
                    	//textField_4.setText(String.valueOf(No_of_working_H));
                    	//textField_5.setText(String.valueOf(No_of_Working_M));
 
                    	
                    }
                    
                    table.setModel(DbUtils.resultSetToTableModel(rS));
                    stat.close();
                    
                 
                    
                } catch (Exception exception) {
                	
                    exception.printStackTrace();
                }
			
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(185, 50, 114, 19);
		panel_i_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(185, 159, 114, 19);
		panel_i_1.add(textField_5);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 65, 641, 412);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
	}
}
