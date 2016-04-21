package tmp;
//Cory Wheeless
//3-18


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/*
 * Since many of the classes use some type of event to notify the user of something upcoming, i made a class. 
 * When an event is created, it stores the day of the event. Ideally, when the user starts up the application, some routine
 * would run similar to the check date below, but would check for all events.
 * */

@SuppressWarnings("rawtypes")
public class EventCollection
	extends PackageCollection implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	
	public EventCollection()
	{
		super();
	}
	
	public void addEvent(Event2 e)
	{
		super.addElement(e);
		CountEvents.clearArray();
		CountEvents.countEm();
	}
	
	public Event2 getEvent(int i)
	{
		return (Event2)super.getElement(i);
	}
	/*
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
	*/
}