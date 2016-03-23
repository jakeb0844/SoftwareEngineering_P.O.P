//Cory Wheeless
//3-18
package eng;

import java.util.*;

/*
 * It seemed like the easiest and most intuitive thing to do would be to store the note as a file.  In the finished version,
 * i imagine the constructor being passes a string from a textarea on the gui.
 * 
 * 
 * 3/23 	Reverted back to where the class is not sending to a file for now
 * */

public class Note 
{
	
	private static ArrayList<Note> notes = new ArrayList<Note>();
	private String title;
	private String content;
	
	public Note(String title, String content) 
	{
		super();
		this.title = title;
		this.content = content;
		notes.add(this);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String toString()
	{
		return title + "\n\n" + content;
	}
}
