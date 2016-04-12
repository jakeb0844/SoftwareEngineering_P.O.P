package Calendar;

//3/29/16
//added the feature to display the description of the event when the day is selected
//Fixed problem with the birthday selection that was rewriting to the previous event by making a new renderclass
//3/30/16
//fixed problem with the color when a event and birthday are on the same class
//3/31/16
//added the feature to display multiple events on same day.
//4/2/16
//added the feature to display multiple birthdays on same day. Also multiple birthdays and events on the same day
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectableChannel;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Events.Event2;
import Contact.Contact;
import Contact.countBirthdays;



public class calendarGui2 {

	static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    public static JPanel pnlCalendar;
    public static int realYear, realMonth, realDay, currentYear;
	public static int currentMonth;
	public static JComboBox comboBox;
    public static JScrollPane scrollPane;
    public static JTextArea textArea;
    
    public calendarGui2(){
    	run();
    }
    
    
    public static void run(){
    	 //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
		
       
   
        //Create controls
        lblMonth = new JLabel ("January");
        lblMonth.setBounds(146, 25, 180, 25);
        lblYear = new JLabel ("Change year:");
        btnPrev = new JButton ("Previous");
        btnPrev.setBounds(10, 25, 75, 25);
        btnNext = new JButton ("Next");
        btnNext.setBounds(235, 25, 75, 25);
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        stblCalendar.setBounds(10, 50, 300, 250);
        pnlCalendar = new JPanel(null);
        textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		Font f = new Font(Font.SANS_SERIF, 10, 11);
		textArea.setFont(f);

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 310, 530, 205);
      
       
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        
        //Add controls to pane
      
        pnlCalendar.setLayout(null);
       
        pnlCalendar.add(lblMonth);
       
       // pnlCalendar.add(describePanel);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        pnlCalendar.add(scrollPane);
        //Set bounds
        //pnlCalendar.setBounds(0, 0, 320, 335);
        pnlCalendar.setBounds(0,0, 300, 310);
        
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
            
        //Refresh calendar
        refreshCalendar (realMonth, realYear); //Refresh calendar
    }
    
    public static void refreshCalendar(int month, int year){
        //Variables
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int NumOfDays, StartOfMonth; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear){btnPrev.setEnabled(false);} //Too early
        if (month == 11 && year >= realYear){btnNext.setEnabled(false);} //Too late
        lblMonth.setText(months[month]);
        
        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        StartOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        int row=0;
        int column=StartOfMonth-1;
        
      //draw the calendar 
        for(int i=1; i <= NumOfDays; i++){
             		
             	mtblCalendar.setValueAt(i, row, column);
             
             if(column<=5){
             	column++;
             }
             
           else{
           	column=0;
             row++;
            }
         }//end for loop
        
        //Apply renderers
        
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRendererBirth());
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRendererBoth());
        
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
           int day=0;
           int month=0;
           int year=0;
           int birthDay=0;
           int birthMonth=0;
           int numOfEvents=0;
            
           setBackground(new Color(255,255,255));
           
           //gives the date at the top of textArea
           if(selected){
        	  
        	   if(value != null){
        	 
        		   textArea.setText(null);
        		   textArea.append(currentMonth+1 + "/" + value + "/" + currentYear);
        		   
        	   }
           }
                   
          for(int i=0; i < Event2.the.size(); i++){
        	   day=Event2.the.get(i).getDay();
        	   month= Event2.the.get(i).getMonth()-1;
        	   year= Event2.the.get(i).getYear();
        	           
			    //paints 
			        if(currentYear == year ){	   
			        	if(currentMonth == month){   
			        		
			        	   if(value != null){
			        		   
			                   if (value.equals(day)){ //Week-end
			                      setBackground(new Color(255, 220, 220));
			                   }//end value == day if
			                  
			        	   }//end value != null if
			        	}//end currentmonth == month if
			        }//end currentYear == year if
			        
			   	  //appends the event description in the textarea.. only if there is an event on that day 
			      if(selected){
			    	  
			       	if(currentYear == year){
			    		if(currentMonth == month){
			        	
			    			if(value.equals(day)){
			    				
			    				numOfEvents=Events.countEvents.getCountEvents(month, (int) value-1);
			    				
			    				if(numOfEvents >= 1){
			    					//clears the textArea for the events
			    					textArea.setText(null);
			    					textArea.append((currentMonth+1) + "/" + day + "/" + currentYear + "\n");
				    				
			    					for(int multi = 0; multi < numOfEvents; multi++){
			    						
			    						textArea.append(Events.countEvents.months.get(month)[day-1][multi].getDescription()+"\n");
			    					}//end for loop
			    				}//end if num of events
			    				
			    			}//end value == day if
			    		}//end currentMonth if
			       	}//end currentYear if
			        
			      }//end selected if
			    
			   }//end Event forLoop
          
       
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                 }
                
                if(selected){
                	if(Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
                		textArea.setText(null);
    					textArea.append((currentMonth+1) + "/" + value + "/" + currentYear + "\n");
    					textArea.append("Today");
                	}
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    //This class is for the calendar renderer for the contacts birthdays
    static class tblCalendarRendererBirth extends tblCalendarRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            int day=0;
            int month=0;
            int year=0;
            int birthDay=0;
            int birthMonth=0;
            String name;
            int numOfBDays=0;
            
     for(int x=0; x < Contact.contacts.size(); x++){
  	   birthDay=Contact.contacts.get(x).getBirthday();
  	   birthMonth=Contact.contacts.get(x).getBirthMonthNum()-1;
  	   
  	   if(currentMonth==birthMonth){
      	   if(value!=null){
      		   if(value.equals(birthDay)){
      			   
      			   setBackground(Color.GREEN);
      		   }
      	   }
         }
    
  	         if(selected){
  		   
		    		if(currentMonth == birthMonth){
		    			 
		    			if(value.equals(birthDay)){
		    				
		    				numOfBDays=countBirthdays.getCountBirthday(birthMonth, (int)value-1);
		    				
		    				if(numOfBDays >= 1){
		    					
		    					textArea.setText(null);
		    					textArea.append((currentMonth+1) + "/" + birthDay + "/" + currentYear+"\n");
			    			
		    				for(int multi = 0; multi < numOfBDays; multi++){
		    					
		    					textArea.append((countBirthdays.Cmonths.get(birthMonth)[birthDay-1][multi].getFirstName() + " "
		    						+ countBirthdays.Cmonths.get(birthMonth)[birthDay-1][multi].getLastName()+ "'s Birthday\n"));
		    					
		    					}//end for loop
		    				}//end numOfBDays if
		    				
		    			}//end value == day if
		    		}//end currentMonth if
		       
		      }//end selected if
  	   
     }//end big for
     
     
	return this; 
     
 } 
}
    //For when an event andd birthday fall on the same day
    static class tblCalendarRendererBoth extends tblCalendarRendererBirth{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            int day=0;
            int month=0;
            int year=0;
            int birthDay=0;
            int birthMonth=0;
            int numOfEvents=0;
            int numOfBdays=0;
            String name="";
           
          if(Contact.contacts.size() > 0 && Event2.the.size() > 0){
        	  
               for(int i =0; i < Contact.contacts.size(); i++){
              	   name = Contact.contacts.get(i).getFirstName() + " " + Contact.contacts.get(i).getLastName();
            	   birthDay=Contact.contacts.get(i).getBirthday();
            	   birthMonth=Contact.contacts.get(i).getBirthMonthNum()-1;
            	   
            	   		for(int x =0; x < Event2.the.size(); x++){
            	   			day=Event2.the.get(x).getDay();
            	        	month= Event2.the.get(x).getMonth()-1;
            	        	year= Event2.the.get(x).getYear();
            	        	  
            	        	
            	        	   if(currentMonth == birthMonth && currentMonth == month){
            	        		  
            	        		   if(birthDay == day){
            	        			   
            	        			  if(value != null){
            	        				  
            	        			   if(value.equals(birthDay) && value.equals(day)){
            	        			   
            	        			   setBackground(Color.orange);
            	        		   }
            	        			   
            	        	   }
            	   		}
            	     }
            	        	   
            	   
            	 if(selected){
  		   
		    		if(currentMonth == birthMonth && currentMonth == month){
		        	
		    			if(value.equals(birthDay) && value.equals(day)){
		    				
		    				numOfEvents=Events.countEvents.getCountEvents(month, (int) value-1);
		    				numOfBdays=countBirthdays.getCountBirthday(birthMonth, (int)value-1);
		    				
		    				if(numOfEvents >= 1){
		    					textArea.setText(null);
		    					textArea.append((currentMonth+1) + "/" + day + "/" + currentYear+"\n");
			    				
		    					for(int multi = 0; multi < numOfEvents; multi++){
		    						textArea.append(Events.countEvents.months.get(month)[day-1][multi].getDescription()+"\n");
		    					}
		    				}
		    				
		    				if(numOfBdays >= 1){
		    					
		    					for(int multi = 0; multi < numOfBdays; multi++){
		    						textArea.append((countBirthdays.Cmonths.get(birthMonth)[birthDay-1][multi].getFirstName() + " "
				    						+ countBirthdays.Cmonths.get(birthMonth)[birthDay-1][multi].getLastName()+ "'s Birthday\n"));
		    					}
		    				}
		    				
		    			}//end value == day if
		    		}//end currentMonth if
		        
		      }//end selected if
  	  
   	   	  }//end in for
        }//end out for
  	   
     }//end the length if

	return this; 
     
 } 
}
   
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            
                currentMonth -= 1;
                
            
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
           
                currentMonth += 1;
                
            
            refreshCalendar(currentMonth, currentYear);
        }
    }
    
  }