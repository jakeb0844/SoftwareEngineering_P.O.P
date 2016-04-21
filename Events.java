package tmp;

import java.io.Serializable;
/*
 * Cory		4/1		Collection that holds events		
 * */

@SuppressWarnings("rawtypes")
public class Events
	extends PackageCollection implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	public Events()
	{
		super();
	}
	
	/*
	public ArrayList<Event2> getAllEvents()
	{
		ArrayList<Event2> result = new ArrayList<Event2>();
		
		for(int i = 0; i < super.getSize(); i++)
		{
			result.add((Event2)super.getElement(i));
		}
		
		return result;
	}
	*/
}