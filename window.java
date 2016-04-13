import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
public class window extends JFrame {

	private static JPanel contentPane;  //creates a global content pane
	private static JTextArea textArea;  //creates a global textArea
	//private ArrayList<Courses> c = new ArrayList<>();
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Courses WC = new Courses("Web Centric", "TR", 8, 3);
					Courses SE = new Courses("Software Engineering", "TR", 8, 3);
					Courses PE = new Courses("Introduction to Psychology", "MWF", 12, 3);
					Courses DS = new Courses("Discrete Structures", "TR", 8, 3);
					//Courses MA = new Courses("Macroeconomics", "MWF", 12, 3);
					//Courses CO = new Courses("Computer Organization", "MWF", 12, 3);
					Courses PY = new Courses("Python", "R", 2, 1);
					WC.addAssignment("Web Application Project", 3, 27, 2016);
					SE.addAssignment("PIP Package Project", 3, 27, 2016);
					PY.addAssignment("Section 4 Assignment", 3, 30, 2016);
					DS.addAssignment("Take Home Test", 3, 15, 2016);
					window frame = new window();
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
	public window() {
		start();
	}
	
	public void start(){
		
		//creates a Course label
		setTitle("Courses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel CoursesLabel = new JLabel("Courses");
		CoursesLabel.setBounds(10, 11, 66, 18);
		CoursesLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(CoursesLabel);
		
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
			public void actionPerformed(ActionEvent e) {
				AddAssignmentWindow aaw = new AddAssignmentWindow();	
					aaw.show();
				
			}
		});
		btnAddAssignment.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAddAssignment.setBounds(379, 470, 149, 23);
		contentPane.add(btnAddAssignment);
		
		
		
		//printCourses on content pane
		printCourses();
		
		/*for(int i = 0; i < Courses.courses.size(); i++){
			makeLabel(Courses.courses.get(i), x, y, w, h);
			y = y + 25;
		}*/
		
		//prints assignments on textarea
		printAssignments();
		
		/*for(int i = 0; i < Courses.courses.size(); i++){
			if(Courses.courses.get(i).a.size() > 0)
			textArea.append(Courses.courses.get(i).showAssignments());
		}*/
		
	}
	
	public static void makeLabel(Courses a, int x, int y, int w, int h){
		
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
				JLabel lblNewLabel_3 = new JLabel(a.daysSkipped());
				lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(x+300, y, 46, h);
				contentPane.add(lblNewLabel_3);
				
				//prints the max amount of days a person can skip
				JLabel lblNewLabel_4 = new JLabel(a.getPabs());
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
						lblNewLabel_3.setText(a.daysSkipped());
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
						lblNewLabel_3.setText(a.daysSkipped());
					}
				});
				contentPane.add(button_1);
							
	}
	
	//method used to print Assignments on textArea
	public static void printAssignments(){
		textArea.setText("");
		for(int i = 0; i < Courses.courses.size(); i++){
			if(Courses.courses.get(i).a.size() > 0)
			textArea.append(Courses.courses.get(i).showAssignments());
		}
	}
	
	//prints courses on the content pain
	public static void printCourses(){
		int x = 10;
		int y = 40;
		int w = 200;
		int h = 14;
		for(int i = 0; i < Courses.courses.size(); i++){
			makeLabel(Courses.courses.get(i), x, y, w, h);
			y = y + 25;
		}
	}
}
