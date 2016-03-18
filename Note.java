//Cory Wheeless
//3-18
package eng;

import java.util.*;
import java.io.*;

/*
 * It seemed like the easiest and most intuitive thing to do would be to store the note as a file.  In the finished version,
 * i imagine the constructor being passes a string from a textarea on the gui.
 * */

public class Note 
{
	private String title;
	private File content;
	private PrintStream out;
	private Scanner in;
	
	public Note(String title, String c) 
		throws FileNotFoundException
	{
		super();
		this.title = title;
		this.out = new PrintStream(content = new File(title));
		out.println(c);
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String output()
		throws FileNotFoundException
	{
		String result = "";
		in = new Scanner(content);
		while(in.hasNextLine())
		{
			result = in.nextLine();
		}
		return result;
	}
}
