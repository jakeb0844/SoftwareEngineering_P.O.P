//Cory Wheeless
//3-18
package eng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * It seemed like the easiest and most intuitive thing to do would be to store the note as a file.  In the finished version,
 * i imagine the constructor being passes a string from a textarea on the gui.
 * 
 * 
 * 3/23 	Reverted back to where the class is not sending to a file for now
 * 
 * 4/1		Now have object persistence by serializing object to files in tmp
 * */

public class Note 
	implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String content;
	
	public Note(String title, String content) 
	{
		super();
		this.title = title;
		this.content = content;
	}
	
	//Just Trying to get load to work with constructor
	public Note()
	{
		this.title = null;
		this.content = null;
	}
	
	public void save()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(new File("tmp/" + title + ".ser"));
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
	
	public Note load(String fileName)
	{
		Note result = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("tmp/" + fileName + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			result = (Note)in.readObject();
			this.title = result.getTitle();
			this.content = result.getContent();
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
	
	public String getTitle()
	{
		return title;
	}
	
	public String getContent()
	{
		return content;
	}
	
	public String toString()
	{
		return title + "\n\n" + content;
	}
}
