import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;



public class tempTabbedCalendar {

	private JFrame frame;
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tempTabbedCalendar window = new tempTabbedCalendar();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tempTabbedCalendar() {
		calendarGui2 gui = new calendarGui2();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		//System.out.println(width + " " + height);
		frame = new JFrame();
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		frame.setBounds(100, 200, 550, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(17, 6, 318,413 );
		frame.getContentPane().add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("My Calendar", null, calendarGui2.pnlCalendar, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		yearField = new JTextField();
		yearField.setBounds(438, 46, 86, 20);
		yearField.setText("2016");
		frame.getContentPane().add(yearField);
		yearField.setColumns(10);
		
		monthField = new JTextField();
		monthField.setBounds(438, 77, 86, 20);
		frame.getContentPane().add(monthField);
		monthField.setColumns(10);
		
		dayField = new JTextField();
		dayField.setBounds(438, 108, 86, 20);
		frame.getContentPane().add(dayField);
		dayField.setColumns(10);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String year = yearField.getText();
				String month = monthField.getText();
				
				if(year.matches("2016")){
					if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12 ){
					if(checkDateRange()){
				
				addEvents a = new addEvents(yearField.getText(),monthField.getText(),dayField.getText());
				calendarGui2.refreshCalendar(calendarGui2.currentMonth, calendarGui2.currentYear);
				
			}
					else{
						JOptionPane.showMessageDialog(null,"Date not in range");
					}
		}
					else{
						JOptionPane.showMessageDialog(null,"Month not in range");

					}
			
			
		}
				else{
					JOptionPane.showMessageDialog(null,"Year not 2016");
				}
	}			
		});
		btnAddEvent.setBounds(435, 221, 89, 23);
		frame.getContentPane().add(btnAddEvent);
		
		
	}
	
	public Boolean checkDateRange(){
		
		int month = Integer.parseInt(monthField.getText()) -1 ;
		
		GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(yearField.getText()), month, 1);
        int NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        
       
        
        if(Integer.parseInt(dayField.getText())>= 1){ 
        if(Integer.parseInt(dayField.getText()) <= NumOfDays){
        	return true;
        }
        }
        
        return false;
		
	}
}
