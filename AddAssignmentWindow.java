import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class AddAssignmentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField aTitle;
	private JTextField Month;
	private JTextField Day;
	private JTextField Year;
	int x = 10;
	int y = 120;
	int w = 200;
	int h = 25;
	private JRadioButton rdbtn;
	private boolean s;
	private JRadioButton cat; //0
	private JRadioButton dog; //1
	private JRadioButton rat; //2
	private JRadioButton monkey; //3
	private JRadioButton lion; //4
	private JRadioButton tiger; //5
	private JRadioButton pig; //6
	private JRadioButton bear; //7
	private JRadioButton bird; //8
	private ButtonGroup group = new ButtonGroup();
	
	int[] array = new int[9];
	ArrayList<JRadioButton> j = new ArrayList<JRadioButton>();{
	j.add(cat);
	j.add(dog);
	j.add(rat);
	j.add(monkey);
	j.add(lion);
	j.add(tiger);
	j.add(pig);
	j.add(bear);
	j.add(bird);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAssignmentWindow frame = new AddAssignmentWindow();
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
	public AddAssignmentWindow() {
		setType(Type.POPUP);
		setForeground(Color.LIGHT_GRAY);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("Add Assignment");
		setBounds(500, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel AssignmentTitle = new JLabel("Assignment");
		AssignmentTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		AssignmentTitle.setBounds(99, 11, 114, 14);
		contentPane.add(AssignmentTitle);
		
		aTitle = new JTextField();
		aTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		aTitle.setBounds(10, 36, 264, 20);
		contentPane.add(aTitle);
		aTitle.setColumns(10);
		
		JLabel DueDate = new JLabel("DueDate");
		DueDate.setFont(new Font("Verdana", Font.PLAIN, 12));
		DueDate.setBounds(99, 69, 80, 14);
		contentPane.add(DueDate);
		
		Month = new JTextField();
		Month.setText("MM");
		Month.setFont(new Font("Verdana", Font.PLAIN, 12));
		Month.setBounds(73, 94, 26, 20);
		contentPane.add(Month);
		Month.setColumns(10);
		
		Day = new JTextField();
		Day.setFont(new Font("Verdana", Font.PLAIN, 12));
		Day.setText("DD");
		Day.setBounds(109, 94, 26, 20);
		contentPane.add(Day);
		Day.setColumns(10);
		
		Year = new JTextField();
		Year.setText("YYYY");
		Year.setFont(new Font("Verdana", Font.PLAIN, 12));
		Year.setBounds(147, 94, 53, 20);
		contentPane.add(Year);
		Year.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			//Adds assignment to course
			public void actionPerformed(ActionEvent e) {
				String a = aTitle.getText();
				int m = Integer.parseInt(Month.getText()) - 1;
				int d = Integer.parseInt(Day.getText());
				int y = Integer.parseInt(Year.getText());
				
					//Here's the problem
				//System.out.println(true);
					/*if(rdbtn.isSelected()){
						System.out.println(true);
						System.out.println(rdbtn.getText());
						Courses.getCourse(rdbtn.getText()).addAssignment(a, m, d, y);
					}*/
					//window.printCourses();
					
					window.printAssignments();
					
				/*	for(int i = 0; i < Courses.courses.size(); i++){
						if(Courses.courses.get(i).a.size() > 0)
							System.out.println(Courses.courses.get(i).showAssignments());
					}*/
				
				
				
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAdd.setBounds(10, 277, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCancel.setBounds(185, 277, 89, 23);
		contentPane.add(btnCancel);
		
		/*radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(10, 141, 109, 23);
		contentPane.add(radioButton);*/
		
		if(Courses.courses.size() == 0){
			CreateCourseWindow z = new CreateCourseWindow();
			z.show();
		}else{
		
			for(int i = 0; i < Courses.courses.size(); i++){
				makeRadioButtons(Courses.courses.get(i), x, y, w, h, i);
				y = y + 20;
			}
		
		}
	}
	
	public void makeRadioButtons(Courses a,  int x, int y, int w, int h, int i){
		cat = new JRadioButton(a.getCourseTitle());
		rdbtn.setFont(new Font("Verdana", Font.PLAIN, 12));
		rdbtn.setBounds(x, y, w, h);
		group.add(rdbtn);
		rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn.isSelected()){
					System.out.println(true);
					System.out.println(a.getCourseTitle());
					System.out.println(rdbtn.getText());
				}
				
			}
		});
		contentPane.add(rdbtn); 
		
	}
	
	public JRadioButton vName(int v){
		return j.get(v);
	}
	
}
