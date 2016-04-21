package tmp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;  //creates a global content pane
	private static JTextArea textArea;  //creates a global textArea
	//private ArrayList<Course> c = new ArrayList<>();
	
	
	//collections
	Semester semester = new Semester();
	Course course = new Course();
	AddressBook addressbook = new AddressBook();
	Notebook notebook = new Notebook();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course WC = new Course("Web Centric", "TR", 8, 3, "Spring", 2016);
					Course SE = new Course("Software Engineering", "TR", 8, 3, "Spring", 2016);
					Course PE = new Course("Introduction to Psychology", "MWF", 12, 3, "Spring", 2016);
					Course DS = new Course("Discrete Structures", "TR", 8, 3, "Spring", 2016);
					//Course MA = new Course("Macroeconomics", "MWF", 12, 3);
					//Course CO = new Course("Computer Organization", "MWF", 12, 3);
					Course PY = new Course("Python", "R", 2, 1, "Spring", 2016);
					
					Assignment tmp = new Assignment("Web Application Project", 3, 27, 2016);
					WC.addAssignment(tmp);
					
					tmp = new Assignment("PIP Package Project", 3, 27, 2016);
					SE.addAssignment(tmp);
					
					tmp = new Assignment("Section 4 Assignment", 3, 30, 2016);
					PY.addAssignment(tmp);
					
					tmp = new Assignment("Take Home Test", 3, 15, 2016);
					DS.addAssignment(tmp);
					Window frame = new Window();
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
	public Window() {
		start();
		
		File test = new File("sers/Semester.ser");
		if(test.exists())
		{
			semester.load("Semester");

		}
		test = new File("sers/Courses.ser");
		if(test.exists())
		{
			course.load("course");

		}
		
		test = new File("sers/Notebook.ser");
		if(test.exists())
		{
			notebook.load("Notebook");

		}
			
		test = new File("sers/AddressBook");
		if(test.exists())
		{
			addressbook.load("Addressbook");

		}
	}
	
	public void start(){
		
		//creates a Course label
		setTitle("Course");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel CourseLabel = new JLabel("Course");
		CourseLabel.setBounds(10, 11, 66, 18);
		CourseLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(CourseLabel);
		
		//Creates a Days label
		JLabel DaysLabel = new JLabel("Days");
		DaysLabel.setBounds(193, 6, 46, 28);
		DaysLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(DaysLabel);
		
		//Creates a Days Misses label
		JLabel DMLabel = new JLabel("Days Missed");
		DMLabel.setBounds(269, 10, 102, 20);
		DMLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(DMLabel);
		
		//Creates a Max Skip Days label
		JLabel lblNewLabel_1 = new JLabel("Max Skip Days");
		lblNewLabel_1.setBounds(401, 5, 128, 31);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		//Creates a scrollpane outside the textArea
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 518, 169);
		contentPane.add(scrollPane);
		
		//Initializes the textArea 
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		//Button for adding new course
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			//When pressed, a create course window pops up
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				CreateCourseWindow win = new CreateCourseWindow();
				win.show();
			}
		});
		btnAddCourse.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAddCourse.setBounds(10, 470, 147, 23);
		contentPane.add(btnAddCourse);
		
		//button for adding new assignment
		JButton btnAddAssignment = new JButton("Add Assignment");
		btnAddAssignment.addActionListener(new ActionListener() {
			//when pressed, an add assignment window pops up
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				AddAssignmentWindow aaw = new AddAssignmentWindow();	
					aaw.show();
				
			}
		});
		btnAddAssignment.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAddAssignment.setBounds(379, 470, 149, 23);
		contentPane.add(btnAddAssignment);
		
		
		
		//printCourse on content pane
		printCourse(semester);
		
		/*for(int i = 0; i < Course.Course.size(); i++){
			makeLabel(Course.Course.get(i), x, y, w, h);
			y = y + 25;
		}*/
		
		//prints assignments on textarea
		printAssignments(course);
		
		/*for(int i = 0; i < Course.Course.size(); i++){
			if(Course.Course.get(i).a.size() > 0)
			textArea.append(Course.Course.get(i).showAssignments());
		}*/
		
	}
	
	public static void makeLabel(Course a, int x, int y, int w, int h){
		
				//Prints the course's Title
				JLabel lblNewLabel = new JLabel(a.getCourseTitle());
				lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel.setBounds(x, y, w, h);
				contentPane.add(lblNewLabel);
				
				//Prints the days the course meets
				JLabel lblNewLabel_2 = new JLabel(a.getMd());
				lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_2.setBounds(x+200, y, 46, h);
				contentPane.add(lblNewLabel_2);
				
				//Prints the amount of days skipped
				JLabel lblNewLabel_3 = new JLabel(String.valueOf(a.getAbs()));
				lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(x+300, y, 46, h);
				contentPane.add(lblNewLabel_3);
				
				//prints the max amount of days a person can skip
				JLabel lblNewLabel_4 = new JLabel(String.valueOf(a.getPabs()));
				lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_4.setBounds(x+440, y, 46, h);
				contentPane.add(lblNewLabel_4);
				
				//creates an add button to the right of the days skipped label
				JButton button = new JButton("+");
				button.setFont(new Font("Verdana", Font.PLAIN, 4));
				button.setBounds(x+325, y, 37, 23);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a.skipped(); //adds a skipped day
						//contentPane.repaint();
						lblNewLabel_3.setText(String.valueOf(a.getAbs()));
					}
				});
				contentPane.add(button);
				
				//creates a minus button that brings the value of the days skipped label down
				JButton button_1 = new JButton("-");
				button_1.setFont(new Font("Verdana", Font.PLAIN, 6));
				button_1.setBounds(x+250, y, 37, 23);
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						a.errSkip(); //subtracts a skip day		
						lblNewLabel_3.setText(String.valueOf(a.getDaysSkipped()));
					}
				});
				contentPane.add(button_1);
							
	}
	
	//method used to print Assignments on textArea
	/*
	public static void printAssignments(){
		textArea.setText("");
		for(int i = 0; i < Course.Course.size(); i++){
			if(Course.Course.get(i).a.size() > 0)
			textArea.append(Course.Course.get(i).showAssignments());
		}
	}
	*/
	
	//Cory --- i think this is a quicker, more elegant way
	public static void printAssignments(Course course)
	{
		textArea.setText("");
		for(int i = 0; i < course.getSize(); i++)
		{
			textArea.append(course.getElement(i).toString());
		}
	}
	
	/*
	//prints Course on the content pain
	public static void printCourse(){
		int x = 10;
		int y = 40;
		int w = 200;
		int h = 14;
		for(int i = 0; i < Course.Course.size(); i++){
			makeLabel(Course.Course.get(i), x, y, w, h);
			y = y + 25;
		}
	}
	*/
	
	public static void printCourse(Semester semester)
	{
		int x = 10;
		int y = 40;
		int w = 200;
		int h = 14;
		for(int i = 0; i < semester.getSize(); i++)
		{
			makeLabel((Course)semester.getElement(i), x, y, w, h);
		}
	}
	
	
}