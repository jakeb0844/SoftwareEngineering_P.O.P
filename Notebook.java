//Cory Wheeless
//3-18
package tmp;

import java.io.Serializable;

/*
 * Can store notes in a category arraylist or just in a note arraylist uncategorized
 * Cory		4/1		Back to using this class.
 * */

@SuppressWarnings("rawtypes")
public class Notebook 
	extends PackageCollection implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	
	@SuppressWarnings("unchecked")
	public void addNote(Note n)
	{
		super.addElement(n);
	}
	
	/*
	//check if no note of title
	public Note getNote(String title)
	{
		Note result = new Note();
		for(int i = 0; i < super.getSize(); i++)
		{
			result = notes.get(i);
			
			if(result.getTitle().equals(title))
			{
				break;
			}
		}
		return result;
	}*/
	/*
	public String toString()
	{
		String result = "";
		for(int i = 0; i < this.size(); i++)
		{
			result += notes.get(i).toString() + "\n";
		}
		return result;
	}*/
}
