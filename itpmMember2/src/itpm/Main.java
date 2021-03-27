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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setExtendedState(MAXIMIZED_BOTH);
		JLabel back;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1864, 980);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 51));
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("ABC Institute");
		lblNewLabel.setBackground(new Color(204, 204, 255));
		lblNewLabel.setForeground(new Color(153, 153, 255));
		lblNewLabel.setBounds(477, 24, 608, 80);
		lblNewLabel.setFont(new Font("Roboto Slab", Font.BOLD, 70));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Working Days and Hours    ");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(153, 204, 204));
		Image imgW = new ImageIcon(this.getClass().getResource("/itpm/calendar.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgW));
		btnNewButton.setFont(new Font("Ink Free", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(148, 178, 308, 138);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Subject Details          ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Subject subject = new Subject();
				subject.show();
				
				dispose();
			}
		});
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(230, 230, 250));
		Image imgS = new ImageIcon(this.getClass().getResource("/itpm/sub.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(imgS));
		btnNewButton_1.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_1.setBounds(148, 380, 308, 138);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Statistics                ");
		btnNewButton_2.setBackground(new Color(153, 204, 204));
		Image imgSt = new ImageIcon(this.getClass().getResource("/itpm/stat.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(imgSt));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_2.setBounds(148, 580, 308, 138);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lecturer Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Lecturer lecturer = new Lecturer();
				lecturer.show();
				
				dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(230, 230, 250));
		Image imgL = new ImageIcon(this.getClass().getResource("/itpm/lec.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(imgL));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_3.setBounds(618, 177, 308, 138);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Tags                   ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBackground(new Color(153, 204, 204));
		Image imgT = new ImageIcon(this.getClass().getResource("/itpm/tag.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(imgT));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFont(new Font("Ink Free", Font.BOLD, 17));
		btnNewButton_4.setBounds(618, 380, 308, 138);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Manage Sessions   ");
		btnNewButton_5.setBackground(new Color(230, 230, 250));
		Image imgM = new ImageIcon(this.getClass().getResource("/itpm/session.png")).getImage();
		btnNewButton_5.setIcon(new ImageIcon(imgM));
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(618, 580, 308, 138);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Student Groups    ");
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBackground(new Color(153, 204, 204));
		Image imgSg = new ImageIcon(this.getClass().getResource("/itpm/student.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon(imgSg));
		btnNewButton_6.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_6.setBounds(1078, 177, 308, 138);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Locations            ");
		btnNewButton_7.setBackground(new Color(230, 230, 250));
		Image imgLo = new ImageIcon(this.getClass().getResource("/itpm/location.png")).getImage();
		btnNewButton_7.setIcon(new ImageIcon(imgLo));
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setFont(new Font("Ink Free", Font.BOLD, 17));
		btnNewButton_7.setBounds(1078, 380, 308, 138);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Generate Timetables");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setBorderPainted(false);
		btnNewButton_8.setBackground(new Color(153, 204, 204));
		Image imgGt = new ImageIcon(this.getClass().getResource("/itpm/time.png")).getImage();
		btnNewButton_8.setIcon(new ImageIcon(imgGt));
		btnNewButton_8.setFont(new Font("Ink Free", Font.BOLD, 16));
		btnNewButton_8.setBounds(1078, 580, 308, 138);
		contentPane.add(btnNewButton_8);
		
		
		
	}
}
