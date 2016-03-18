//Cory Wheeless
//3-18
package eng;

import java.util.*;

/*
 * Parent class of category.  Can store notes in a category arraylist or just in a note arraylist uncategorized
 * */

public class Notebook 
{
	private ArrayList<Category> categories;
	private ArrayList<Note> notes;
	
	public Notebook(Category c)
	{
		this.categories.add(c);
	}
	
	public Notebook(Note n)
	{
		this.notes.add(n);
	}
	
	public void addCategory(Category c)
	{
		this.categories.add(c);
	}
	
	public void addNote(Note n)
	{
		this.notes.add(n);
	}
}
