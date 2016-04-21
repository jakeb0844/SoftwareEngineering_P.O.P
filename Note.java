//Cory Wheeless
//3-18
package tmp;

import java.io.Serializable;

/*
 * It seemed like the easiest and most intuitive thing to do would be to store the note as a file.  In the finished version,
 * i imagine the constructor being passes a string from a textarea on the gui.
 * 
 * 
 * Cory		3/23 	Reverted back to where the class is not sending to a file for now
 * Cory		3/24	added save method. For some reason I have to declare FileOutputStream and ObjectOutputStream
 * 					inside class for some reason though. otherwise i get an exception	
 * 					added load method. this reads the info from .ser file and return Note object	
 * 
 * 
 * 					adksfja;lksdfja;lskdjfa;lksdfj;alksdfja;lkdfjakdjf;oi
 * */

public class Note 
	implements Serializable
{	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private String title;
	private String content;
	
	public Note(String title, String content) 
	{
		super();
		this.title = title;
		this.content = content;
	}
	
	public Note()
	{
		
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String toString()
	{
		return title + "\n\n" + content + "\n";
	}
}
