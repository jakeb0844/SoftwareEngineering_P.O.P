//Cory Wheeless
//3-18
package test;

import java.util.*;
import java.io.*;

/*
 * It seemed like the easiest and most intuitive thing to do would be to store the note as a file.  In the finished version,
 * i imagine the constructor being passes a string from a textarea on the gui.
 * 
 * 
 * Cory		3/23 	Reverted back to where the class is not sending to a file for now
 * Cory		3/24	added save method. For some reason I have to declare FileOutputStream and ObjectOutputStream
 * 					inside class for some reason though. otherwise i get an exception	
 * 					added load method. this reads the info from .ser file and return Note object	
 * */

public class Note 
	implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Note> notes = new ArrayList<Note>();
	private String title;
	private String content;
	//private FileOutputStream fileOut;
	//private ObjectOutputStream out;
	
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
	
	public void save()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(new File(title + ".ser"));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("Everything Worked!");
		}
		catch(IOException i)
		{
			System.out.println("Everything Broke");
			i.printStackTrace();
		}
	}
	
	public Note load()
	{
		Note result = null;
		try
		{
			FileInputStream fileIn = new FileInputStream(this.title + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			result = (Note)in.readObject();
			fileIn.close();
			in.close();
		}
		catch(IOException i)
		{
			System.out.println("Everything broke");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Everything broke");
		}
		return result;
	}
	
	
	public String toString()
	{
		return title + "\n\n" + content;
	}
}
