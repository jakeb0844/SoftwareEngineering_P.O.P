package Gui;
//3-23-16
//Modified by Jake to incorporate the new event class also added the textfields, buttons, and labels to the calendarGui2 pane
//3-29-16
//Modified by Jake to incorporate the contact class and the contact gui
//4/3/16
//added the feature to remove an event
//4/7/16
//fixed the problem with the remove an event
//add check if the user enters a duplicate event on same day

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Calendar.calendarGui2;
import Contact.contactGui;
import Contact.countBirthdays;
import Events.Event2;
import Events.countEvents;




public class NewTabbedCalendar {

	private JFrame frame;
	private JTextField yearField;
	private JTextField monthField;
	private JTextField dayField;
	private JTextField descripField;
	 public static JPanel contacts;
	 public static String descrip="";
	 public static int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewTabbedCalendar window = new NewTabbedCalendar();
					Events.countEvents.startArray();
					Contact.countBirthdays.startArray();

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
		contactGui gui2 = new contactGui();
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		//frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		
		frame.setBounds(100, 150, 600, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates the tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane();//JTabbedPane.TOP);
		tabbedPane.setBounds(17, 6, 550,550 );
		//adds the tabbed pane to the frame
		frame.getContentPane().add(tabbedPane);
		
		
				
		//adds the pnlCalendar panel to the tabbed pane
		//adds the contact panel to the tabbed pane
		tabbedPane.addTab("My Calendar", null, calendarGui2.pnlCalendar, null);
		tabbedPane.addTab("Contacts", null, contactGui.yoyo, null);
		
		
		yearField = new JTextField();
		yearField.setBounds(408, 46, 86, 20);
		yearField.setText("2016");
		calendarGui2.pnlCalendar.add(yearField);
		
		yearField.setColumns(10);
		
		monthField = new JTextField();
		monthField.setBounds(408, 77, 86, 20);
		calendarGui2.pnlCalendar.add(monthField);
		monthField.setColumns(10);
		
		dayField = new JTextField();
		dayField.setBounds(408, 108, 86, 20);
		calendarGui2.pnlCalendar.add(dayField);
		dayField.setColumns(10);
		
		descripField= new JTextField();
		descripField.setBounds(408, 139, 86, 20);
		calendarGui2.pnlCalendar.add(descripField);
		descripField.setColumns(10);
		
		
		JButton btnAddEvent = new JButton("Add Event");
		JButton btnRemoveEvent = new JButton("Remove Event");
		JLabel yearLabel = new JLabel("Year:");
		JLabel monthLabel = new JLabel("Month:");
		JLabel dayLabel = new JLabel("Day:");
		JLabel descripLabel = new JLabel("Describe:");
		JLabel length = new JLabel("Length: "+count);
		yearLabel.setBounds(355, 46, 30, 10);
		monthLabel.setBounds(355, 77, 40,10);
		dayLabel.setBounds(355,108,30,10);
		descripLabel.setBounds(355, 139, 80, 10);
		calendarGui2.pnlCalendar.add(yearLabel);
		calendarGui2.pnlCalendar.add(monthLabel);
		calendarGui2.pnlCalendar.add(dayLabel);
		calendarGui2.pnlCalendar.add(descripLabel);
		
		
		
	//Button action listener that checks if the year, month, and day are in the appropriate range.. Year is only for 2016!! 	
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String year = yearField.getText();
				String month = monthField.getText();
				String paragraph=descripField.getText();
				int length = paragraph.length();
				//System.out.println(length);
			
				if(year.matches("2016")){
					if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12 ){
					
						//method at the end of class	
					
						if(checkDateRange()){
							//adds the events to an arraylist if describeField is <= 53 (length)...idk if this is true anymore
							//addEvents a = new addEvents(yearField.getText(),monthField.getText(),dayField.getText());
					    if(length !=0){		
					    	
							if(length <= 84){
								
								if(checkDuplicate(paragraph,dayField.getText(), month)){
									
									Event2 e = new Event2(Integer.parseInt(yearField.getText()), Integer.parseInt(monthField.getText()), Integer.parseInt(dayField.getText())
											, descripField.getText());
									
									Events.addEvents.add(e);
							
							
									//after the event is added. Sets the desripField to empty
									descripField.setText(null);
									
									//Have to refresh the calendar after every event is added
									calendarGui2.refreshCalendar(calendarGui2.currentMonth, calendarGui2.currentYear);
								}//end check duplicate if
								else{
									JOptionPane.showMessageDialog(null,"You already added that event!");
								}//end check duplicate else
							}//end length if
							
							else{
								JOptionPane.showMessageDialog(null,"Describe length is too long");
							}//end length else
					    }//end length != 0 if
					    else{
							JOptionPane.showMessageDialog(null,"No description was entered.");
						}//end else
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
			
			
	}//end action Perfomed method			
		});
		
		btnRemoveEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeEvent();
				
			}});
		btnAddEvent.setBounds(400, 210, 89, 23);
		btnRemoveEvent.setBounds(395,240,102,23);
		
		//adds the button to pnlCalendar
		calendarGui2.pnlCalendar.add(btnAddEvent);
		calendarGui2.pnlCalendar.add(btnRemoveEvent);
		
		
	}
	
	public void removeEvent(){
		//create a new frame
		final JFrame frame2 = new JFrame();
		frame2.setBounds(700, 100, 500, 500);
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		//create a new button remove
		final JButton remove = new JButton("Remove");
		remove.setBounds(140,250,100,30);
		frame2.getContentPane().add(remove);
		
		int count=0;
				
		final DefaultListModel listModel = new DefaultListModel();
		
//This adds the events to the listModel above, to make it clear for the user to select
		for(int months =0; months < 12; months++){
			for(int days =0; days < countEvents.months.get(months).length; days++){
				//count equals the number of events on that day
				count = countEvents.getCountEvents(months, days);
				
				for(int i = 0; i < count; i++){
					
					//if an event falls on the day, add to the listModel
					if(countEvents.months.get(months)[days][i] != null){
						
						listModel.addElement((months+1)+"/"+(days+1)+"/"+calendarGui2.currentYear+"  "+countEvents.months.get(months)[days][i].getDescription());
						
				}//end if
			}//end i for
				
		}//end days for
	}//end months for
		
		if(listModel.size() == 0){
			listModel.removeAllElements();
			listModel.addElement("--No Elements--");
		}
		
		//creates the list model. Mainly this is just for the looks. No functionality except for the select item
		final JList list = new JList(listModel);
		
		
		//listen for a selection
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				//if item is selected
				if(list.getValueIsAdjusting()){
					
				//gets the descrip that was selected
				   descrip = (String) list.getSelectedValue();
				   
				   //gets the date and description from the selected item
					String date="";
					final String sen;
					final int d;
					final int m;
					final int y;
					for(int i =0; i < descrip.length(); i++){
						if(descrip.charAt(i) != ' '){
							date+=descrip.charAt(i);
						}
						else{
							break;
						}
					}
					//the date
					m=Integer.parseInt(date.substring(0, date.indexOf("/")));
					d=Integer.parseInt(date.substring(date.indexOf("/")+1,date.lastIndexOf("/")));
					y=Integer.parseInt(date.substring(date.lastIndexOf("/")+1,date.length()));
					//System.out.println(m + " "+d + " " +y);
				
					//the description
					sen= descrip.substring(descrip.indexOf(" ")+2, descrip.length());
					
					//System.out.println(sen);
					
					
					
		//this is the code for the remove event button. This runs when the button is clicked			
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//loop through the events	
				for(int i =0; i < Events.Event2.the.size(); i++){
					//compare the descriptions to the selected description aka sen					
					if(sen.equals(Events.Event2.the.get(i).getDescription())){
						//if the sen is == to description in the events array.. check the day
						if(d == Events.Event2.the.get(i).getDay()){
							//if == check the month
							if(m == Events.Event2.the.get(i).getMonth()){
								//if == check the year
								if(y== Events.Event2.the.get(i).getYear()){
									
									//now remove i which will be the Event object
										Events.Event2.the.remove(i);
									//Have to re-count the events
										countEvents.countEm();
											
										//now remove the item in the listmodel
										//Loop through the list and find the items that are equal and remove the item
											for(int x =0; x < listModel.getSize(); x++){
												if(listModel.get(x).equals(descrip)){
													System.out.println(listModel.get(x));
													System.out.println(descrip);
													listModel.remove(x);
													
													//if the size is == 0.. then add the text "No Events"
													if(listModel.size() == 0){
														listModel.addElement("--No Events--");
											}//end no eventsif
										}//end listmodel equals descrip if
									}//end for loop for the listmodel if
								}//end y if
							}//end m if
							
						
						}//end d if
					}//end sen equals if
				}//end outside for
				
				//refresh calendar	
				calendarGui2.refreshCalendar(calendarGui2.currentMonth, calendarGui2.currentYear);
					
			}});//end actionPerformed
		}//end getValueIsAdjusting
				
	}});//end valueChanged
		
		//scrollpane that holds the list/listModel
		JScrollPane scrolly = new JScrollPane(list);
		scrolly.setBounds(5, 5, 475, 200);
		
		//sets the vertical scroll
		scrolly.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		//add scroll pane to the frame
		frame2.getContentPane().add(scrolly);

		
	}
	
	//method that checks if there are duplicate events on the same day
	public Boolean checkDuplicate(String des, String day, String month){
		
	int len=	Events.countEvents.getCountEvents(Integer.parseInt(month)-1, Integer.parseInt(day)-1);
	
		boolean check=true;
		
		for(int i =0; i < len; i++){
			
			if(Events.countEvents.months.get(Integer.parseInt(month)-1)[Integer.parseInt(day)-1][i].getDescription().toLowerCase().equals(des.toLowerCase())){
				check=false;
			}
			
		}
		
		return check;
		
		
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
