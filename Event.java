//Cory Wheeless
//3-18
package eng;

import java.util.Calendar;
import java.util.Date;

/*
 * Since many of the classes use some type of event to notify the user of something upcoming, i made a class. 
 * When an event is created, it stores the day of the event. Ideally, when the user starts up the application, some routine
 * would run similar to the check date below, but would check for all events.
 * 
 * Cory 	4/1		Took out static arrayList
 * */

public class Event 
{
	private Calendar calendar;
	private Date current;
	private Date event;
	
	public Event(int year, int month, int day)
	{
		calendar = Calendar.getInstance();
		current = calendar.getTime();

		calendar.set(year, month, day);
		event = calendar.getTime();
	}
	
	public void checkDate()
	{
		long secondsBetween = event.getTime() - current.getTime();
		
		long fiveDays = 1000 * 86400 * 5;
		
		if(secondsBetween < fiveDays)
		{
			System.out.println("Upcoming event in " + (((secondsBetween / 1000) / 60) / 60) / 24 + " days");
			
		}
		else
		{
			System.out.println("No upcoming event");
		}
	}
	
	/*
	public Event getClosest()
	{
		long result = events[0].getEvent();
		
		for(int i = 0;i < events.size(); i++)
		{
			
		}
	}*/
}
