//Cory Wheeless
//3-18
package eng;

import java.io.File;
import java.util.*;

/*
 * Can store notes in a category arraylist or just in a note arraylist uncategorized
 * Cory		4/1		Back to using this class.
 * */

public class Notebook 
{
	private ArrayList<Note> notes;
	
	public Notebook()
	{
		notes = new ArrayList<Note>();
	}
	
	public Notebook(Note n)
	{
		this.notes.add(n);
	}
	
	public void save()
	{
		for(Note temp : notes)
		{
			temp.save();
		}
	}
	
	public void load()
	{
		File dir = new File("Notes/");
		File[] allFiles = dir.listFiles();
		
		Note n = new Note();
		String title;
		
		for(File f : allFiles)
		{
			title = f.getName();
			n.load(noExtension(title));
			notes.add(n);
		}
	}
	
	private String noExtension(String s)
	{
		String result = "";
		char index;
		
		for(int i = 0; i < s.length(); i++)
		{
			index = s.charAt(i);
			if(index == '.')
			{
				result = s.substring(0, i);
				break;
			}
		}
		return result;
	}
	
	public void addNote(Note n)
	{
		this.notes.add(n);
	}
}
