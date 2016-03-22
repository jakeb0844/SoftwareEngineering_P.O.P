import java.util.ArrayList;

public class addEvents {
	
	static ArrayList<Event> the = new ArrayList<Event>();


	//public static void main(String[] args) {
		
		//public Event(int year, int month, int day)
	public addEvents(String year, String month, String day){	
		/*Event day = new Event(2016,3,20);
		 
		
		
		the.add(day);
		
		
		
		
		//System.out.println(day2.getYear());
		//System.out.println(the.size());
		//System.out.println(the.get(0).getDay());
		//day.checkDate();
		
		//day.printEvent();
		*/
		
		int y=Integer.parseInt(year);
		int m= Integer.parseInt(month);
		int d = Integer.parseInt(day);
		
		
		Event e = new Event(y,m,d);
		
		the.add(e);
		
 }
	
	public void printAll(){
		for(int i =0; i < the.size(); i++){
			
			System.out.println("the year " + the.get(i).getYear());
			System.out.println("the month " + the.get(i).getMonth());
			System.out.println("the day " + the.get(i).getDay());
			System.out.println();
			
			
		}
	}
}


