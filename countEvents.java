package Events;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import Contact.*;

public class countEvents {
	
	public static ArrayList<Event2[][]> months = new ArrayList<Event2[][]>();
	public static final int numEvents=50;

	//int year, int month, int day, String description
	//public static void main(String[] args){
	public static void countEm(){
		
	//starts off by clearing the arraylists of arrays of months
	clearArray();	
	
	int count =0;
	int day1,month;
	String des;
	ArrayList<Event2> clone = new ArrayList<Event2>();
	
	//clone the event arraylist to clone arraylist. So nothing is erased from the event arraylist
	clone.addAll(Event2.the);
	
	//Time to start counting the events
	//outer for gets the attributes for the events
	for(int i=0; i < clone.size(); i++){
		day1 = clone.get(i).getDay()-1;
		month = clone.get(i).getMonth()-1;
		des=clone.get(i).getDescription();
		
		//inner for counts the events on that specific day
		//
		for(int x =0; x < months.get(month).length; x++){
	
		
			if(x == day1){
				//if the array index for the month ISNT empty then go to while loop
				if(months.get(month)[x][count] != null){
					
					//while the array index for the month isnt null then keep incrementing the count
					while(months.get(month)[x][count] != null){
						
						count++;
					}
					//Basically making a dublicate of the event in the event class					
					Event2 p = new Event2(clone.get(i).getYear(),clone.get(i).getMonth(),clone.get(i).getDay(),clone.get(i).getDescription());
					
					//adds it to the arraylist of arrays of months
					months.get(month)[x][count] = p;
					//set count to 0
					count=0;
					
				}//end if for months.get(month)
				//This else is for when the array index IS empty
				else{
					Event2 p = new Event2(clone.get(i).getYear(),clone.get(i).getMonth(),clone.get(i).getDay(),clone.get(i).getDescription());
										
					months.get(month)[x][count] = p; 
				}//end else
			}//end if x == day1
		  
		}//end innner
	}//end outter
	
	
	
//prints the number of events on the days
//Dont need but i liked it for debugging
	/*
for(int mon =0; mon < 12; mon++){	
	//System.out.println(months.get(mon).length+"printing length");
	for(int row = 0; row < months.get(mon).length; row++){
		 for(int col = 0; col < numEvents; col++){
			 //March[row][col] = col;
			 if(months.get(mon)[row][col] != null){
			System.out.println(" Month: " + mon + " [" + row +"][" + col + "] "+months.get(mon)[row][col].getDescription() );
			 }
		 }
	 }
	}
*/
	//clear the clone of events
	clone.clear();
}//end countem
	
	
	//creates the array of months.. prolly redundant but only way i knew of
	public static  void startArray(){
		Date now = new Date();
		
			
		GregorianCalendar cal = new GregorianCalendar(now.getYear(),0,1);
        int NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		//System.out.println(NumOfDays);
        
        //Gets the number of days in each month. Sets that as the length or num of rows 
		
		Event2 January[][] = new Event2[NumOfDays][numEvents];
		
		cal = new GregorianCalendar(now.getYear(),1,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
		Event2 February[][] = new Event2[NumOfDays][numEvents];
		
		cal = new GregorianCalendar(now.getYear(),2,1);
        NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        //System.out.println(NumOfDays);
        
		 Event2 March[][] = new Event2 [NumOfDays][numEvents];
		 
		 cal = new GregorianCalendar(now.getYear(),3,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 April[][] = new Event2 [NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),4,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 May[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),5,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 June[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),6,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 July[][] = new Event2[NumOfDays][numEvents];
		
         cal = new GregorianCalendar(now.getYear(),7,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 August[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),8,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 September[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),9,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        // System.out.println(NumOfDays);
         
         Event2 October[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),10,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
         //System.out.println(NumOfDays);
         
         Event2 November[][] = new Event2[NumOfDays][numEvents];
         
         cal = new GregorianCalendar(now.getYear(),11,1);
         NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        // System.out.println(NumOfDays);
         
         Event2 December[][] = new Event2[NumOfDays][numEvents];
         //System.out.println(December.length);
		
         //adds to the arraylist
		 months.add(January);
		 months.add(February);
		 months.add(March);
		 months.add(April);
		 months.add(May);
		 months.add(June);
		 months.add(July);
		 months.add(August);
		 months.add(September);
		 months.add(October);
		 months.add(November);
		 months.add(December);
		 
		 
	}
	
	//clears the arraylist of arrays
	public static void clearArray(){
		
		for(int mon =0; mon < 12; mon++){	
			//System.out.println(months.get(mon).length+"printing length");
			for(int row = 0; row < months.get(mon).length; row++){
				 for(int col = 0; col < numEvents; col++){
					 //March[row][col] = col;
					 if(months.get(mon)[row][col] != null){
						 months.get(mon)[row][col]=null;
					//System.out.println(" Month: " + mon + " [" + row +"][" + col + "] "+months.get(mon)[row][col].getDescription() );
					 }
					 
				 }
			 }
		}
	}//end clear array	
		
	
	
	//gets the number of events on that day
	public static int getCountEvents(int month, int day){
		int num=0;
		
		
			
			for(int col =0; col < numEvents; col++){
				if(months.get(month)[day][col] != null){
					num++;
				}
			}
			
		return num; 
		
	}//end getCountEvents
	

	
}//end count Events class
