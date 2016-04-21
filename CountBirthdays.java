
package tmp;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

//import Events.Event2;

public class CountBirthdays {
	
	public static int numOfBdays = 20;
	public static ArrayList<Contact[][]> Cmonths = new ArrayList<Contact[][]>();

//The exact thing as the count events except with birthdays... EVERYTHING!	
@SuppressWarnings("unchecked")
public static void countBdays(){
		
		clearCmonthsArray();
	
		int count =0;
		int day1,month;
		String des;
		ArrayList<Contact> clone;
		
		//AddressBook a = new AddressBook();
		/*File f = new File("sers/Addressbook.ser");
		if(f.exists())
		{
			a.load("sers/AddressBook");
			clone = a.getCollection();
		}
		else
		{
			clone = new ArrayList<Contact>();
		}*/
		
		PackageCollection a = new PackageCollection();
		
		a = ContactGui.addressbook;

		for(int i=0; i < a.getSize(); i++){
			Contact tmp = (Contact) a.getElement(i);
			day1 = tmp.getBirthday()-1;
			//System.out.println(day1);
			
			month = tmp.getBirthMonthNum()-1;
			//System.out.println(month);
			
			des=tmp.getFirstName() + " " + tmp.getLastName();
			//System.out.println(des);
			
			for(int x =0; x < Cmonths.get(month).length; x++){
				//System.out.println(x);
				if(x == day1){
					
					if(Cmonths.get(month)[x][count] != null){
						//System.out.println("in the if" +count);
					
						while(Cmonths.get(month)[x][count] != null){
							//System.out.println("in the while " + count);
							count++;
						}
											
						Contact person = new Contact(tmp.getLastName(), tmp.getFirstName(), tmp.getBirthMonthNum(),tmp.getBirthYear(),
								tmp.getBirthday(), tmp.getPhoneNumber(), tmp.getAddress());
					
						Cmonths.get(month)[x][count] = person;
						count=0;
						
					}
					else{
						Contact person = new Contact(tmp.getLastName(), tmp.getFirstName(), tmp.getBirthMonthNum(),tmp.getBirthYear(),
								tmp.getBirthday(), tmp.getPhoneNumber(), tmp.getAddress());
						//System.out.println(i);
						
						Cmonths.get(month)[x][count] = person; 
					}
				}
			  
			}
		}
		
		
		
	//prints the number of events on the days	
	for(int mon =0; mon < 12; mon++){	
		//System.out.println(months.get(mon).length+"printing length");
		for(int row = 0; row < Cmonths.get(mon).length; row++){
			 for(int col = 0; col < numOfBdays; col++){
				 //March[row][col] = col;
				 if(Cmonths.get(mon)[row][col] != null){
				//System.out.println(" Month: " + mon + " [" + row +"][" + col + "] "+Cmonths.get(mon)[row][col].getFirstName() );
				 }
			 }
		 }
		}

	
			
		
	}

@SuppressWarnings("deprecation")
public static  void startArray(){
	Date now = new Date();
	

	
	GregorianCalendar cal = new GregorianCalendar(now.getYear(),0,1);
    int NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
	//System.out.println(NumOfDays);
	
	Contact January[][] = new Contact[NumOfDays][numOfBdays];
	
	cal = new GregorianCalendar(now.getYear(),1,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
	Contact February[][] = new Contact[NumOfDays][numOfBdays];
	
	cal = new GregorianCalendar(now.getYear(),2,1);
    NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    //System.out.println(NumOfDays);
    
	 Contact March[][] = new Contact [NumOfDays][numOfBdays];
	 
	 cal = new GregorianCalendar(now.getYear(),3,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact April[][] = new Contact [NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),4,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact May[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),5,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact June[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),6,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact July[][] = new Contact[NumOfDays][numOfBdays];
	
     cal = new GregorianCalendar(now.getYear(),7,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact August[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),8,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact September[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),9,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    // System.out.println(NumOfDays);
     
     Contact October[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),10,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
     //System.out.println(NumOfDays);
     
     Contact November[][] = new Contact[NumOfDays][numOfBdays];
     
     cal = new GregorianCalendar(now.getYear(),11,1);
     NumOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    // System.out.println(NumOfDays);
     
     Contact December[][] = new Contact[NumOfDays][numOfBdays];
     //System.out.println(December.length);
		 
	 Cmonths.add(January);
	 Cmonths.add(February);
	 Cmonths.add(March);
	 Cmonths.add(April);
	 Cmonths.add(May);
	 Cmonths.add(June);
	 Cmonths.add(July);
	 Cmonths.add(August);
	 Cmonths.add(September);
	 Cmonths.add(October);
	 Cmonths.add(November);
	 Cmonths.add(December);
	 
	 
}

public static void clearCmonthsArray(){
	
	
	for(int mon=0; mon < 12; mon++){	
		for(int row =0; row < Cmonths.get(mon).length; row++){
			 for(int col = 0; col < numOfBdays; col++){
				 //March[row][col] = col;
				 if(Cmonths.get(mon)[row][col] != null){
						Cmonths.get(mon)[row][col] = null;
					}
				//System.out.println(" Month: " + mon + " [" + row +"][" + col + "] "+months.get(mon)[row][col].getDescription() );
				 }
		}
}
}

public static int getCountBirthday(int month, int day){
	int num=0;
	
	
		
		for(int col =0; col < numOfBdays; col++){
			if(Cmonths.get(month)[day][col] != null){
				num++;
			}
		}
		
	
	
	return num; 
}

}