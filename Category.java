//Cory Wheeless
//3-18
package eng;

import java.util.*;

/*
 * Child class of Notebook. Parent class of Note.  Stores notes by category
 * */
public class Category 
{
	private String name;			//Name of Category
	private ArrayList<Note> notes;	//Contains notes
	
	public Category(String name) 
	{
		super();
		this.name = name;
		this.notes = new ArrayList<Note>(25);
	}
	
	public String getName()
	{
		return name;
	}
	
	public void addNote(Note n)
	{
		notes.add(n);
	}
}
