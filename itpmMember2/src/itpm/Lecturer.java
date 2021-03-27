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
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;

public class Lecturer extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panellec;
	private JPanel panellecdetail;
	private JPanel panelDayshours;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textFieldName;
	private JTextField textFieldEmpID;
	private JTextField textFieldupdaterank;
	private JTextField textFieldSeacrh;
	private JTable table;
	private JTextField textFieldMon;
	private JTextField textFieldTue;
	private JTextField textFieldWed;
	private JTextField textFieldThurs;
	private JTextField textFieldFri;
	private JTextField textFieldSat;
	private JTextField textFieldSun;
	private JTextField textFieldSearchDays;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTable table_1;

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
		lblNewLabel_2_2.setBounds(21, 40, 209, 24);
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
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 40, 282, 26);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 89, 282, 26);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Level");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_1.setBounds(21, 135, 93, 24);
		panel.add(lblNewLabel_2_2_1_1);
		
		Choice choice = new Choice();
		choice.setBounds(187, 141, 353, 26);
		panel.add(choice);
		
		JButton btnNewButtongeneraterank = new JButton("Generate Rank");
		btnNewButtongeneraterank.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtongeneraterank.setBounds(89, 184, 324, 31);
		panel.add(btnNewButtongeneraterank);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(187, 242, 282, 26);
		panel.add(textField_3);
		
		JLabel lblNewLabel_2_2_5_1 = new JLabel("Faculty");
		lblNewLabel_2_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5_1.setBounds(21, 291, 149, 24);
		panel.add(lblNewLabel_2_2_5_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(187, 297, 353, 18);
		panel.add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(187, 343, 353, 18);
		panel.add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(187, 390, 353, 18);
		panel.add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(187, 435, 353, 18);
		panel.add(choice_4);
		
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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(213, 78, 282, 26);
		panel_1.add(textField);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(213, 125, 282, 26);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(213, 172, 282, 26);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(213, 219, 282, 26);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(213, 266, 282, 26);
		panel_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(213, 313, 282, 26);
		panel_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(213, 362, 282, 26);
		panel_1.add(textField_9);
		
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
		btnNewButtonSavelec.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtonSavelec.setBounds(944, 539, 101, 37);
		panellec.add(btnNewButtonSavelec);
		
		JButton btnClear = new JButton("Clear");
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
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(187, 40, 221, 26);
		panelLecDetail.add(textFieldName);
		
		textFieldEmpID = new JTextField();
		textFieldEmpID.setColumns(10);
		textFieldEmpID.setBounds(187, 89, 221, 26);
		panelLecDetail.add(textFieldEmpID);
		
		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("Level");
		lblNewLabel_2_2_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_1_2.setBounds(21, 135, 93, 24);
		panelLecDetail.add(lblNewLabel_2_2_1_1_2);
		
		Choice choiceLevel = new Choice();
		choiceLevel.setBounds(187, 141, 275, 18);
		panelLecDetail.add(choiceLevel);
		
		JButton btnNewButtongeneraterankNew = new JButton("Generate Rank");
		btnNewButtongeneraterankNew.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButtongeneraterankNew.setBounds(89, 184, 243, 31);
		panelLecDetail.add(btnNewButtongeneraterankNew);
		
		textFieldupdaterank = new JTextField();
		textFieldupdaterank.setColumns(10);
		textFieldupdaterank.setBounds(187, 225, 221, 26);
		panelLecDetail.add(textFieldupdaterank);
		
		JLabel lblNewLabel_2_2_5_1_1 = new JLabel("Faculty");
		lblNewLabel_2_2_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_5_1_1.setBounds(21, 271, 149, 24);
		panelLecDetail.add(lblNewLabel_2_2_5_1_1);
		
		Choice choiceFac = new Choice();
		choiceFac.setBounds(187, 277, 275, 18);
		panelLecDetail.add(choiceFac);
		
		Choice choiceDept = new Choice();
		choiceDept.setBounds(188, 320, 275, 18);
		panelLecDetail.add(choiceDept);
		
		Choice choiceCent = new Choice();
		choiceCent.setBounds(188, 362, 275, 18);
		panelLecDetail.add(choiceCent);
		
		Choice choiceBuild = new Choice();
		choiceBuild.setBounds(188, 405, 275, 18);
		panelLecDetail.add(choiceBuild);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(21, 464, 106, 31);
		panelLecDetail.add(btnUpdate);
		
		JButton btnClear_1 = new JButton("Clear");
		btnClear_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear_1.setBounds(302, 464, 106, 31);
		panelLecDetail.add(btnClear_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(161, 464, 106, 31);
		panelLecDetail.add(btnDelete);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh.setBounds(1188, 21, 106, 31);
		panellecdetail.add(btnRefresh);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch.setBounds(1188, 100, 106, 31);
		panellecdetail.add(btnSearch);
		
		textFieldSeacrh = new JTextField();
		textFieldSeacrh.setColumns(10);
		textFieldSeacrh.setBounds(958, 102, 221, 31);
		panellecdetail.add(textFieldSeacrh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(492, 164, 802, 406);
		panellecdetail.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Emp ID", "Level", "Rank", "Faculty", "Department", "Center", "Building"
			}
		));
		scrollPane.setViewportView(table);
		
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
		lblNewLabel_2_2_1_2_7.setBounds(73, 23, 106, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7);
		
		textFieldMon = new JTextField();
		textFieldMon.setColumns(10);
		textFieldMon.setBounds(175, 115, 241, 26);
		panel_1_1.add(textFieldMon);
		
		textFieldTue = new JTextField();
		textFieldTue.setColumns(10);
		textFieldTue.setBounds(175, 161, 241, 26);
		panel_1_1.add(textFieldTue);
		
		textFieldWed = new JTextField();
		textFieldWed.setColumns(10);
		textFieldWed.setBounds(175, 207, 241, 26);
		panel_1_1.add(textFieldWed);
		
		textFieldThurs = new JTextField();
		textFieldThurs.setColumns(10);
		textFieldThurs.setBounds(175, 254, 241, 26);
		panel_1_1.add(textFieldThurs);
		
		textFieldFri = new JTextField();
		textFieldFri.setColumns(10);
		textFieldFri.setBounds(175, 301, 241, 27);
		panel_1_1.add(textFieldFri);
		
		textFieldSat = new JTextField();
		textFieldSat.setColumns(10);
		textFieldSat.setBounds(175, 353, 241, 27);
		panel_1_1.add(textFieldSat);
		
		textFieldSun = new JTextField();
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
		btnUpdate_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate_1.setBounds(25, 467, 106, 31);
		panel_1_1.add(btnUpdate_1);
		
		JButton btnClear_2 = new JButton("Clear");
		btnClear_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear_2.setBounds(310, 467, 106, 31);
		panel_1_1.add(btnClear_2);
		
		JButton btnDelete_3 = new JButton("Delete");
		btnDelete_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete_3.setBounds(167, 467, 106, 31);
		panel_1_1.add(btnDelete_3);
		
		JLabel lblNewLabel_2_2_1_2_7_1 = new JLabel("Lecturer Name");
		lblNewLabel_2_2_1_2_7_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_7_1.setBounds(242, 23, 116, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7_1);
		
		JLabel lblNewLabel_2_2_1_2_7_2 = new JLabel("Monday");
		lblNewLabel_2_2_1_2_7_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1_2_7_2.setBounds(25, 117, 154, 24);
		panel_1_1.add(lblNewLabel_2_2_1_2_7_2);
		
		textField_10 = new JTextField();
		textField_10.setBackground(SystemColor.control);
		textField_10.setBounds(56, 57, 143, 26);
		panel_1_1.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(SystemColor.control);
		textField_11.setColumns(10);
		textField_11.setBounds(226, 57, 143, 26);
		panel_1_1.add(textField_11);
		
		JButton btnRefresh_1 = new JButton("Refresh");
		btnRefresh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRefresh_1.setBounds(1188, 25, 106, 31);
		panelDayshours.add(btnRefresh_1);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSearch_1.setBounds(1188, 96, 106, 31);
		panelDayshours.add(btnSearch_1);
		
		textFieldSearchDays = new JTextField();
		textFieldSearchDays.setColumns(10);
		textFieldSearchDays.setBounds(937, 96, 241, 31);
		panelDayshours.add(textFieldSearchDays);
		
		JLabel lblNewLabel_2_2_6_1_1_1 = new JLabel("Details of Active Days and Hours");
		lblNewLabel_2_2_6_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_2_2_6_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_2_2_6_1_1_1.setBounds(659, 66, 366, 24);
		panelDayshours.add(lblNewLabel_2_2_6_1_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(487, 159, 790, 412);
		panelDayshours.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Emp ID", "Lecturer Name", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
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
