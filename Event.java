package tmp;

import java.util.Calendar;
import java.util.Date;

public class Event 
{
	private Calendar calendar;
	private Date current;
	private Date event;
	private int theYear;
	private int theMonth;
	private int theDay;
	private String theDescription;
	
	public Event(int year, int month, int day, String description)
	{
		calendar = Calendar.getInstance();
		current = calendar.getTime();

		calendar.set(year, month, day);
		event = calendar.getTime();
		
		 theYear = year;
		 theMonth= month;
		 theDay= day;
		 theDescription=description;
	}
	
	public Event()
	{
		
	}
	
	public int getYear(){
		return theYear;
	}
	
	public int getMonth(){
		return theMonth;
	}
	
	public int getDay(){
		return theDay;
	}
	
	public String getDescription(){
		return theDescription;
	}
	
	public String toString()
	{
		String result = "";
		result = theDescription + "\n" + theYear + "\n";
		return result;
	}
}
