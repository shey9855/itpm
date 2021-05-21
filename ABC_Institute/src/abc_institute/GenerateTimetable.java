package abc_institute;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import com.sun.jdi.connect.spi.Connection;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class GenerateTimetable extends JFrame {

	private JPanel contentPane;
	String selectedType = "lecturer_name";
	JComboBox<Object> dropdownList;
	
	private  JScrollPane scrollPane;
	private JTable timeTable;
	private JButton btnLecturerButton;
	private JButton btnStudent;
	private JButton btnlocation;
	private JButton btnPrint;
	
	public ArrayList<String> timeSlots = new ArrayList<String>();
	List<String> timeSlotList = Arrays.asList("08.30 - 09.30", "09.30 - 10.30", "10.30 - 11.30", "11.30 - 12.30", "12.30 - 13.30", "13.30 - 14.30","14.30 - 15.30","15.30-16.30","16.30-17.30","17.30-18.30","18.30-19.30");
	
	boolean allSessionsAddedtoTheTimeTable = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateTimetable frame = new GenerateTimetable();
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
	public GenerateTimetable() {
		setExtendedState(MAXIMIZED_BOTH);
		addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
				dropdownList.setModel(new DefaultComboBoxModel<Object>(getlecturerNames()));
				
			}

			
		
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(1200,720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Time Table");
		
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel= new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		contentPane.setBackground(new Color(102, 153, 204));
		panel.setBounds(103,130,1434,70);
		contentPane.add(panel);		
		panel.setLayout(null);
		
		JLabel label = new JLabel("Lecturer");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(256,220,165,46);
		contentPane.add(label);
		
		btnLecturerButton = new JButton("Lecturer");
		btnLecturerButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLecturerButton.setFocusable(false);
		btnLecturerButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnLecturerButton.setBounds(25, 10, 150, 40);
		panel.add(btnLecturerButton);
		
		btnStudent = new JButton("Student Group");
		btnStudent.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStudent.setFocusable(false);
		btnStudent.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnStudent.setBounds(225, 10, 150, 40);
		panel.add(btnStudent);
		
		btnlocation = new JButton("Location");
		btnlocation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnlocation.setFocusable(false);
		btnlocation.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnlocation.setBounds(425, 10,150,40);
		panel.add(btnlocation);
		
		btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					timeTable.print();
					} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setFocusable(false);
		btnPrint.setBorder(BorderFactory.createEmptyBorder(4, 4, 2, 20));
		btnPrint.setBounds(1200,10,150,40);
		panel.add(btnPrint);
		
		dropdownList = new JComboBox<Object>(new Object[]{});
		dropdownList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dropdownList.setBackground(Color.WHITE);
		dropdownList.setBounds(415, 225, 859, 36);
		contentPane.add(dropdownList);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 280, 1350, 485);
		contentPane.add(scrollPane);
		
		timeTable = new JTable();
		scrollPane.setViewportView(timeTable);
		timeTable.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Time slots");
		model.addColumn("Monday");
		model.addColumn("Tuesday");
		model.addColumn("Wednesday");
		model.addColumn("Thursday");		
		model.addColumn("Friday");
		
		timeTable.setModel(model);
		timeTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		timeTable.setFillsViewportHeight(true);
		timeTable.setRowHeight(41);
		timeTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(23, 118, 1474, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setBounds(24, 17, 466, 80);
		contentPane.add(lblNewLabel);
		
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
		btnNewButton.setBackground(Color.WHITE);
		Image imgH = new ImageIcon(this.getClass().getResource("/abc_institute/home1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgH));
		btnNewButton.setBounds(23, 130, 70, 70);
		contentPane.add(btnNewButton);
		
		timeSlots.addAll(timeSlotList);
		
		for(int i=0; i<11 ; i++) {
			model.addRow(new Object[]{
				" "+timeSlots.get(i),
			});;
		}
		
		btnLecturerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				label.setText("Lecturer");
				btnLecturerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnlocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
				selectedType = "lecturer_name";
				dropdownList.setModel(new DefaultComboBoxModel<Object>(getlecturerNames()));
				
			}
		});
		
		btnStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				label.setText("Student Group");
				btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnLecturerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnlocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
				selectedType = "StudentGroup";
				dropdownList.setModel(new DefaultComboBoxModel<Object>(loadStudentGroups()));
				
			}
		});

		btnlocation.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		label.setText("Rooms");
		btnlocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLecturerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		selectedType = "Location";
		dropdownList.setModel(new DefaultComboBoxModel<Object>(loadLocations()));
		
	}
});
	
		dropdownList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.sql.Connection connection = DBConnect.getConnection();
				String selectedItem = String.valueOf(dropdownList.getSelectedItem());
				String selectedItemType = selectedType;
				
				if(selectedType.equals("lecturer_name")) {
					
					boolean mondayAvailability = lecturerNotAvailableDays("monday",selectedItem,connection);
					boolean tuesdayAvailability = lecturerNotAvailableDays("tuesday",selectedItem,connection);
					boolean wednesdayAvailability = lecturerNotAvailableDays("wednesday",selectedItem,connection);
					boolean thursdayAvailability = lecturerNotAvailableDays("thursday",selectedItem,connection);
					boolean fridayAvailability = lecturerNotAvailableDays("friday",selectedItem,connection);
					
					String[] sessionListArrayforTheLecturerStrings = getAvailableSessionStrings(selectedItem,connection);
					
					if(!mondayAvailability) {
						
						for(int i=0; i<11; i++) {
							timeTable.setValueAt("- - -", i, 1);
						}
					}else {
						
						for(int i=0; i<11; i++) {
							
							timeTable.setValueAt(null, i, 1);
						}
						for(int i=0; i<sessionListArrayforTheLecturerStrings.length; i++) {
							
							if(sessionListArrayforTheLecturerStrings[i].contains("Lecture") && !(sessionListArrayforTheLecturerStrings[i].contains("Tutorial"))) {
								
								timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 1);

								
							}
							if(!tuesdayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Lecture In Lab")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 1);
								}
							}
						}
						
					}
					
					if(!tuesdayAvailability) {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt("- - -", i, 2);
						}
					}else {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt(null, i, 2);
						}
						
						for(int i=0; i<sessionListArrayforTheLecturerStrings.length; i++) {
							
							if(sessionListArrayforTheLecturerStrings[i].contains("Lecture In Lab")) {
								timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 2);
							}
							if(!mondayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Lecture")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 2);
								}
							}
						}
					}
					

					if(!wednesdayAvailability) {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt("- - -", i, 3);
						}
					}else {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt(null, i, 3);
						}
						for(int i=0; i<sessionListArrayforTheLecturerStrings.length; i++) {
							
							if(sessionListArrayforTheLecturerStrings[i].contains("Tutorial")) {
								timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 3);
							}
							
							if(!thursdayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Lab")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 4);
								}
							}
						}
					}
					
					if(!thursdayAvailability) {
						for(int i=0; i<11 ; i++) {
							timeTable.setValueAt("- - -", i, 4);
						}
					}
					else {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt(null, i, 4);
						}
						for (int i=0; i<sessionListArrayforTheLecturerStrings.length; i++) {
							if(sessionListArrayforTheLecturerStrings[i].contains("Lab")) {
								timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 4);
							}
							if(!wednesdayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Tutorial")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 4);
								}
							}
							
							if(!fridayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Evaluation")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 4);
								}
							}
						}
					}
					if(!fridayAvailability) {
						for(int i=0; i<11; i++) {
							timeTable.setValueAt("- - -", i, 5);
						}
					}
					else {
						for(int i=0; i<11 ;i++) {
							timeTable.setValueAt(null, i, 5);
						}
						for(int i=0; i<sessionListArrayforTheLecturerStrings.length ; i++) {
							if(sessionListArrayforTheLecturerStrings[i].contains("Evaluation")) {
								timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 5);
							}
							
							if(!thursdayAvailability) {
								if(sessionListArrayforTheLecturerStrings[i].contains("Lab")) {
									timeTable.setValueAt(sessionListArrayforTheLecturerStrings[i], i, 4);
								}
							}
						}
					}

				}
				
				if(selectedType.equals("Location")) {
					String[] getSessionAccordingToSelectedLocation = getSessionAccordingToSelectedLocation(selectedItem, connection);
					
					for(int i=0; i<getSessionAccordingToSelectedLocation.length;i++) {
						
						if(getSessionAccordingToSelectedLocation[i].contains("Lecture")&& !(getSessionAccordingToSelectedLocation)[i].contains("Tutorial")){
							timeTable.setValueAt(getSessionAccordingToSelectedLocation[i], i, 1);
						}
						
						if(getSessionAccordingToSelectedLocation[i].contains("Lecture In Lab")) {
							timeTable.setValueAt(getSessionAccordingToSelectedLocation[i], i, 2);
						}
						if(getSessionAccordingToSelectedLocation[i].contains("Tutorial")) {
							timeTable.setValueAt(getSessionAccordingToSelectedLocation[i], i, 3);
						}
						if(getSessionAccordingToSelectedLocation[i].contains("Lab")) {
							timeTable.setValueAt(getSessionAccordingToSelectedLocation[i], i, 4);
						}
						if(getSessionAccordingToSelectedLocation[i].contains("Evaluation")) {
							timeTable.setValueAt(getSessionAccordingToSelectedLocation[i], i, 5);
						}
					}
					
				}
				
				if(selectedType.equals("StudentGroup")) {
					
					String[] getSessionAccordingToSelectedStudentGroup = getSessionAccordingToSelectedGroup(selectedItem, connection);
					
					for(int i=0; i<getSessionAccordingToSelectedStudentGroup.length; i++) {
						if(getSessionAccordingToSelectedStudentGroup[i].contains("lecturer_name")&& !(getSessionAccordingToSelectedStudentGroup[i].contains("Tutorial"))){
							timeTable.setValueAt(getSessionAccordingToSelectedStudentGroup[i], i, 1);
						}
						
						if(getSessionAccordingToSelectedStudentGroup[i].contains("Lecture In Lab")) {
							timeTable.setValueAt(getSessionAccordingToSelectedStudentGroup[i], i, 2);
						}
						
						if(getSessionAccordingToSelectedStudentGroup[i].contains("Tutorial")) {
							timeTable.setValueAt(getSessionAccordingToSelectedStudentGroup[i], i, 3);
						}
						
						if(getSessionAccordingToSelectedStudentGroup[i].contains("Lab")) {
							timeTable.setValueAt(getSessionAccordingToSelectedStudentGroup[i], i, 4);
						}
						
						if(getSessionAccordingToSelectedStudentGroup[i].contains("Evaluation")) {
							timeTable.setValueAt(getSessionAccordingToSelectedStudentGroup[i], i, 5);
						}
					}
				}
				
			}
		});
		
	}
	
	private String [] getlecturerNames() {
		
		
		String[] lecturerNameArrayStrings = null;
		List<String> list = new ArrayList<>();
		
		try {
			
			java.sql.Connection connection = DBConnect.getConnection();
			
			String sql = "Select lecturer_name from lecturer";
			PreparedStatement st  = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			
			
			list.add("Select a Lecturer");
			while(rs.next()) {
				
				list.add(rs.getString("lecturer_name"));
			}
			lecturerNameArrayStrings = list.toArray(new String[0]);
			
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		return lecturerNameArrayStrings;
		
		
	}
	
	private String[] loadStudentGroups(){
		
		java.sql.Connection connection = DBConnect.getConnection();
		
		String[] groupIdArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		
		try {
			
			String sql = "Select * from student_grp";
			java.sql.Statement st  = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			list.add("Select a Student Group");
			while(rs.next()) {
				singleRoom = rs.getString("group_id");
				
				list.add(singleRoom);
				
			}
			groupIdArray = list.toArray(new String[0]);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return groupIdArray;
		
	}
		
	private String[] loadLocations() {
		
		java.sql.Connection connection = DBConnect.getConnection();
		
		String[] locationArray = null;
		List<String> list = new ArrayList<>();
		String singleRoom;
		
		try {
			
			String sql = "Select * from location";
			java.sql.Statement st  = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			list.add("Select a Room ");
			while(rs.next()) {
				singleRoom = rs.getString("room");
				
				list.add(singleRoom);
				
			}
			locationArray = list.toArray(new String[0]);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return locationArray;
		
	}
	
	public boolean lecturerNotAvailableDays(String day, String lecturer_name,java.sql.Connection connection2) {
		
		boolean availability = true;
		
		try {
			
			String sql ="select * from lecturer where "+day+" = '0' and lecturer_name = '"+lecturer_name+"'";
			java.sql.Statement st  = ((java.sql.Connection) connection2).createStatement();
			ResultSet rSet = st.executeQuery(sql);
			
			if(rSet.next()) {
				availability = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			availability=true;
			System.out.println(e.getMessage());
		}
		
		return availability;
	}
	
	private String [] getAvailableSessionStrings (String lecturerName, java.sql.Connection connection2) {
		
		String[] sessionListArrayforTheLecturerStrings = null;
		List<String> list = new ArrayList<>();
		String singleSessionSignature;
		
		try {
			
			String sql = "select * from session where lecturer_1 = '"+lecturerName+"' or lecturer_2= '"+lecturerName+"'";
			java.sql.Statement statement = ((java.sql.Connection) connection2).createStatement();
			ResultSet rSet = statement.executeQuery(sql);
			
			while(rSet.next()) {
				
				singleSessionSignature = lecturerName + ", "+rSet.getString("subjectName")+ "(" +rSet.getString("subjectCode") + "), " +rSet.getString("tag") + ", " + rSet.getString("noOfStudents") + ", " + rSet.getString("duration");
				list.add(singleSessionSignature);
			}
			sessionListArrayforTheLecturerStrings = list.toArray(new String[0]);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return sessionListArrayforTheLecturerStrings;
	}
	
	public String [] getSessionAccordingToSelectedLocation(String selectedRoomName, java.sql.Connection connection) {
		
		String[] sessionListArrayforRoom = null;
		List<String> list = new ArrayList<>();
		String singleSessionSignature;
		
		try {
			String sql = "SELECT * from session WHERE room = '"+selectedRoomName+"'";
			java.sql.Statement st  = ((java.sql.Connection) connection).createStatement();
			ResultSet rSet = st.executeQuery(sql);
			
			while(rSet.next()) {
				
				singleSessionSignature = rSet.getString("lecturer_1") + "and"+rSet.getString("lecturer_2")+","+rSet.getString("subjectName") + "(" +rSet.getString("subjectCode") + ")," +rSet.getString("tag") + "," + rSet.getString("noOfStudents") + "," + rSet.getString("duration");
				list.add(singleSessionSignature);
				
			}
			sessionListArrayforRoom = list.toArray(new String[0]);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sessionListArrayforRoom;
	}
	
	public String[] getSessionAccordingToSelectedGroup(String selectedStudentGroup, java.sql.Connection connection) {
		
		String[] sessionListArrayforStudentGroup = null;
		List<String> list = new ArrayList<String>();
		String singleSessionSignature;
		
		try {
			
			String sql ="select * from session where groupID = '"+selectedStudentGroup+"'";
			java.sql.Statement st  = ((java.sql.Connection) connection).createStatement();
			ResultSet rSet = st.executeQuery(sql);
			
			while(rSet.next()) {
				
				singleSessionSignature = rSet.getString("lecturer_1") + "and"+rSet.getString("lecturer_2")+","+rSet.getString("subjectName") + "(" +rSet.getString("subjectCode") + ")," +rSet.getString("tag") + "," + rSet.getString("noOfStudents") + "," + rSet.getString("duration");
				list.add(singleSessionSignature);
				
			}
			sessionListArrayforStudentGroup = list.toArray(new String[0]);
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return sessionListArrayforStudentGroup;
	}
}
