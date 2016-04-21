package tmp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class CreateCourseWindow extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private JPanel contentPane;
	private JTextField CourseTitle;
	private JTextField CourseMeetDays;
	private JTextField MaxAbs;
	private JTextField CourseHours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCourseWindow frame = new CreateCourseWindow();
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
	public CreateCourseWindow() {
		setType(Type.POPUP);
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Add Course");
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creates a textfield for the input of a course title
		CourseTitle = new JTextField();
		CourseTitle.setText("ex. Software Eng.");
		CourseTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		CourseTitle.setBounds(25, 34, 144, 20);
		contentPane.add(CourseTitle);
		CourseTitle.setColumns(10);
		
		//creates course title label
		JLabel lblCourseTitle = new JLabel("Course Title");
		lblCourseTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCourseTitle.setBounds(26, 11, 85, 14);
		contentPane.add(lblCourseTitle);
		
		//creates course meet days label
		JLabel CourseMeetDayslbl = new JLabel("Days Course Meet");
		CourseMeetDayslbl.setFont(new Font("Verdana", Font.PLAIN, 12));
		CourseMeetDayslbl.setBounds(25, 65, 123, 14);
		contentPane.add(CourseMeetDayslbl);
		
		//creates a course meet days text field
		CourseMeetDays = new JTextField();
		CourseMeetDays.setText("ex. MWF");
		CourseMeetDays.setFont(new Font("Verdana", Font.PLAIN, 12));
		CourseMeetDays.setBounds(25, 90, 59, 20);
		contentPane.add(CourseMeetDays);
		CourseMeetDays.setColumns(10);
		
		//creates a max abs label
		JLabel lblNewLabel = new JLabel("Max Absensces");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 121, 123, 14);
		contentPane.add(lblNewLabel);
		
		//creates a max abs text field
		MaxAbs = new JTextField();
		MaxAbs.setText("ex. 8");
		MaxAbs.setFont(new Font("Verdana", Font.PLAIN, 12));
		MaxAbs.setBounds(25, 146, 51, 20);
		contentPane.add(MaxAbs);
		MaxAbs.setColumns(10);
		
		//creates a course hours label
		JLabel lblCourseHours = new JLabel("Course Hours");
		lblCourseHours.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCourseHours.setBounds(25, 177, 94, 14);
		contentPane.add(lblCourseHours);
		
		//creates a course hours text field
		CourseHours = new JTextField();
		CourseHours.setText("ex. 3");
		CourseHours.setFont(new Font("Verdana", Font.PLAIN, 12));
		CourseHours.setBounds(25, 202, 51, 20);
		contentPane.add(CourseHours);
		CourseHours.setColumns(10);
		
		//creates a button that enables a user to add course
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			//Action Listener adds the course
			public void actionPerformed(ActionEvent e) {
				String cTitle =CourseTitle.getText();
				String cMd = CourseMeetDays.getText();
				int cMaxD = Integer.parseInt(MaxAbs.getText());
				int cHrs = Integer.parseInt(CourseHours.getText());
				
				//public Course(String title, String meetDays, int pAbs, int creditHours, String term, int year)
				Course x = new Course(cTitle, cMd, cMaxD, cHrs);
				Semester tmp = new Semester();
				tmp.load("Courses");
				tmp.addCourse(x);
				
				Window.printCourse(semester);
				contentPane.repaint();
				
				/*for(int i=0; i<Courses.courses.size(); i++){
					System.out.println(Courses.courses.get(i).toString());
				}*/
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAdd.setBounds(185, 168, 89, 23);
		contentPane.add(btnAdd);
		
		//creates a cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			//Action listener should close window
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCancel.setBounds(185, 201, 89, 23);
		contentPane.add(btnCancel);
	}
}