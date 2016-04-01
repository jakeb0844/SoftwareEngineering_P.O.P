//Cory Wheeless
//3-18
package eng;

import java.util.ArrayList;

/*
 * Array list that stores all created contacts
 * 
 * Cory		4/1		Back to using this class instead of static array in contact class
 * */

public class Contacts 
{
	private ArrayList<Contact> contacts;	
	
	public Contacts()
	{
		contacts = new ArrayList<Contact>();
	}
	
	public void addContact(Contact c)
	{
		contacts.add(0, c);
	}
	
	public String toString()
	{
		String result = "";
		int latest = contacts.size() - 1;
		for(int i = latest; i >= 0; i--)
		{
			result += contacts.get(i).toString() + "\n";
		}
		
		return result;
	}
}
