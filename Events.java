package eng;

import java.util.ArrayList;
/*
 * Cory		4/1		Collection that holds events		
 * */

public class Events 
{
	private ArrayList<Event> events; 
	
	public Events()
	{
		events = new ArrayList<Event>();
	}
	
	public void add(Event e)
	{
		events.add(e);
	}
}
