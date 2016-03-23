package Gui;
//3-23-16
//Modified by Jake to incorporate the new event class also added the textfields, buttons, and labels to the calendarGui2 pane
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Calendar.calendarGui2;
import Events.Event2;




public class NewTabbedCalendar {

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
					NewTabbedCalendar window = new NewTabbedCalendar();
					
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
	public NewTabbedCalendar() {
		//Have to create instance of calendarGui2 to access the Panel which contains the calendar
		//Probably can do this a different way, but this works for now
		calendarGui2 gui = new calendarGui2();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Dont mind this
		/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		//System.out.println(width + " " + height);
		*/
		frame = new JFrame();
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		frame.setBounds(100, 200, 800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates the tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane();//JTabbedPane.TOP);
		tabbedPane.setBounds(17, 6, 500,500 );
		//adds the tabbed pane to the frame
		frame.getContentPane().add(tabbedPane);
		
		
		//adds the pnlCalendar panel to the tabbed pane
		tabbedPane.addTab("My Calendar", null, calendarGui2.pnlCalendar, null);
		
		yearField = new JTextField();
		yearField.setBounds(398, 46, 86, 20);
		yearField.setText("2016");
		calendarGui2.pnlCalendar.add(yearField);
		yearField.setColumns(10);
		
		monthField = new JTextField();
		monthField.setBounds(398, 77, 86, 20);
		calendarGui2.pnlCalendar.add(monthField);
		monthField.setColumns(10);
		
		dayField = new JTextField();
		dayField.setBounds(398, 108, 86, 20);
		calendarGui2.pnlCalendar.add(dayField);
		dayField.setColumns(10);
	
		
		JButton btnAddEvent = new JButton("Add Event");
		JLabel yearLabel = new JLabel("Year:");
		JLabel monthLabel = new JLabel("Month:");
		JLabel dayLabel = new JLabel("Day:");
		yearLabel.setBounds(355, 46, 30, 10);
		monthLabel.setBounds(355, 77, 40,10);
		dayLabel.setBounds(355,108,30,10);
		calendarGui2.pnlCalendar.add(yearLabel);
		calendarGui2.pnlCalendar.add(monthLabel);
		calendarGui2.pnlCalendar.add(dayLabel);
		
	//Button action listener that checks if the year, month, and day are in the appropriate range.. Year is only for 2016!! 	
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String year = yearField.getText();
				String month = monthField.getText();
				
				if(year.matches("2016")){
					if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12 ){
					
						//method at the end of class	
					
						if(checkDateRange()){
							//adds the events to an arraylist
							//addEvents a = new addEvents(yearField.getText(),monthField.getText(),dayField.getText());
							
							Event2 e = new Event2(Integer.parseInt(yearField.getText()), Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText()));
							
							//Have to refresh the calendar after every event is added
							calendarGui2.refreshCalendar(calendarGui2.currentMonth, calendarGui2.currentYear);
				
			}//check date if
					else{
						JOptionPane.showMessageDialog(null,"Date not in range");
					}//check data else
						
		}//check month if
					
					else{
						JOptionPane.showMessageDialog(null,"Month not in range");

					}//check month else
			
			
		}//check year if
				else{
					JOptionPane.showMessageDialog(null,"Year not 2016");
				}//check year else
	}			
		});
		btnAddEvent.setBounds(400, 210, 89, 23);
		
		//adds the button to pnlCalendar
		calendarGui2.pnlCalendar.add(btnAddEvent);
		
		
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
