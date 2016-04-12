package Events;

public class addEvents {

	public static void add(Event2 e){
		
		//add the Event2 e which is a parameter
		Event2.the.add(e);
		//clear the arrays, basically reset the counts
		Events.countEvents.clearArray();
		//count the events back up
		Events.countEvents.countEm();
		
	}
	
}
