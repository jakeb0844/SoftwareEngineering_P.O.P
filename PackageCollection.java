package tmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class PackageCollection<T> 
	implements Serializable
{
	private static String[] packageTypes = {"notebook", "addressbook", "course", "semester"};
	
	private static final long serialVersionUID = 45;

	private final static int DEFAULT_CAPACITY = 25;
	
	private ArrayList<T> collection;
	
	public PackageCollection()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public PackageCollection(int initialCapacity)
	{
		collection = new ArrayList<T>(initialCapacity);
	}
	
	public void addElement(T element) 
	{
		collection.add(element);
	}
	
	public ArrayList<T> getCollection()
	{
		return collection;
	}
	
	public int getSize()
	{
		return collection.size();
	}
	
	//for gui countEvents to work
	public T getElement(int index)
	{
		return collection.get(index);
	}
	
	public void removeElement(int i)
	{
		collection.remove(i);
	}

	public void save(String fileName) 
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(new File("sers/" + fileName + ".ser"));
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("Everything Worked!");
		}
		catch(IOException i)
		{
			System.out.println("Everything Broke on save");
			i.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void load(String fileName)
	{
		PackageCollection result = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("sers/" + fileName + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			result = (PackageCollection)in.readObject();
			for(int i = 0; i < result.getSize(); i++)
			{
				T element = (T)result.collection.get(i);
				this.addElement(element);
			}
			fileIn.close();
			in.close();
		}
		catch(IOException i)
		{
			System.out.println("Everything broke on lead io exception");
			i.printStackTrace();
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Everything broke on load class not found exception");
			
			for(int i = 0; i < packageTypes.length; i++)
			{
				String filename = packageTypes[i];
				File file = new File("sers/" + filename + ".ser");
				this.save(filename);
			}
		}
	}
	
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < collection.size(); i++)
		{
			result += collection.get(i);
		}
		return result;
	}

}
