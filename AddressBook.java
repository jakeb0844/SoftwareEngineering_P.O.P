//Cory Wheeless
//3-18
package tmp;

import java.io.Serializable;

/*
 * Array list that stores all created contacts
 * 
 * Cory		4/1		Back to using this class instead of static array in contact class
 * */

@SuppressWarnings("rawtypes")
public class AddressBook 
	extends PackageCollection implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	
	@SuppressWarnings("unchecked")
	public void addContact(Contact c)
	{
		super.addElement(c);
		CountBirthdays.clearCmonthsArray();
		CountBirthdays.countBdays();
	}
}
