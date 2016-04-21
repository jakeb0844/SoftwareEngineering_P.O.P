package tmp;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddAssignmentWindow extends Window {

	private JPanel contentPane;
	private JTextField aTitle;
	private JTextField Month;
	private JTextField Day;
	private JTextField Year;

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
		
		//creates the radio buttons... look at radioButtons class		
		RadioButtons r = new RadioButtons();
		contentPane.add(RadioButtons.radioPanel);
		
		//adds a new button... not yet completed
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			//Adds assignment to course
			public void actionPerformed(ActionEvent e) {
				
				//Parameters for the asssignment object
				String a = aTitle.getText();
				int m = Integer.parseInt(Month.getText()) - 1;
				int d = Integer.parseInt(Day.getText());
				int y = Integer.parseInt(Year.getText());
				
					
					//writes out the assignments... the method is in the window class
					Window.printAssignments(course);
				
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnAdd.setBounds(10, 277, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 12));
		btnCancel.setBounds(185, 277, 89, 23);
		contentPane.add(btnCancel);
		
		//if an assignment is added but no courses then pops up a window to create a new course
		if(course.getSize() == 0){
			CreateCourseWindow z = new CreateCourseWindow();
			z.show();
		}
	}
	
}