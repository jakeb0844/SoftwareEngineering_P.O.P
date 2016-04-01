//Cory Wheeless
//3-18
package eng;

import java.util.*;

/*
 * Can store notes in a category arraylist or just in a note arraylist uncategorized
 * Cory		4/1		Back to using this class.
 * */

public class Notebook 
{
	private ArrayList<Note> notes;
	
	public Notebook(Note n)
	{
		this.notes.add(n);
	}
	
	public void addNote(Note n)
	{
		this.notes.add(n);
	}
}
