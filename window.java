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

	private JPanel contentPane;
	//private ArrayList<Courses> c = new ArrayList<>();
	int x = 10;
	int y = 55;
	int w = 200;
	int h = 14; 

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
					Courses MA = new Courses("Macroeconomics", "MWF", 12, 3);
					Courses CO = new Courses("Computer Organization", "MWF", 12, 3);
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
		
		setTitle("Courses");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel CoursesLabel = new JLabel("Courses");
		CoursesLabel.setBounds(10, 26, 66, 18);
		CoursesLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(CoursesLabel);
		
		JLabel DaysLabel = new JLabel("Days");
		DaysLabel.setBounds(200, 21, 46, 28);
		DaysLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(DaysLabel);
		
		JLabel DMLabel = new JLabel("Days Missed");
		DMLabel.setBounds(270, 25, 102, 20);
		DMLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(DMLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Max Skip Days");
		lblNewLabel_1.setBounds(400, 20, 128, 31);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 283, 518, 169);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAddCourse.setBounds(20, 470, 137, 23);
		contentPane.add(btnAddCourse);
		
		JButton btnAddAssignment = new JButton("Add Assignment");
		btnAddAssignment.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAddAssignment.setBounds(379, 470, 149, 23);
		contentPane.add(btnAddAssignment);
		
		
		
		
		for(int i = 0; i < Courses.courses.size(); i++){
			makeLabel(Courses.courses.get(i), x, y, w, h);
			y = y + 30;
		}
		
		for(int i = 0; i < Courses.courses.size(); i++){
			if(Courses.courses.get(i).a.size() > 0)
			textArea.append(Courses.courses.get(i).showAssignments());
		}
		
		
		/*take out
		JLabel lblNewLabel = new JLabel("c0");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel.setBounds(78, 55, 163, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("c1");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(78, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C0");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(284, 55, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("c0");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(438, 55, 46, 14);
		contentPane.add(lblNewLabel_3); */
		
		
		
	}
	
	public void makeLabel(Courses a, int x, int y, int w, int h){
		
				
				JLabel lblNewLabel = new JLabel(a.getCourseTitle());
				lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel.setBounds(x, y, w, h);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_2 = new JLabel(a.getMd());
				lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_2.setBounds(x+200, y, 46, h);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel(a.daysSkipped());
				lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_3.setBounds(x+300, y, 46, h);
				contentPane.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel(a.getPabs());
				lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 12));
				lblNewLabel_4.setBounds(x+440, y, 46, h);
				contentPane.add(lblNewLabel_4);
				
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
}
