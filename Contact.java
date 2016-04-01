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
 * Represents a contact by storing personal information
 * 
 * Cory		3/23	put the arraylist from Contacts here instead of having it in its own class
 * 
 * Cory		 4/1		Now have object persistence by serializing object to files in tmp
 * */

public class Contact 
	implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Array of month names. The constructor takes in month number and uses this to store month string
	private static String[] months= new String[] {"January", "February", "March", "April", "May", "June", "July",
												  "August", "September", "October", "November", "December"};
	
	private String lastName;
	private String firstName;
	private String birthMonth;
	private int birthYear;
	private int birthday;
	private String phoneNumber;
	private String address;
	
	public Contact(String lastName, String firstName, int birthMonth, int birthYear, int birthday,
			String phoneNumber, String address) 
	{
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthMonth = monthNumberToString(birthMonth);
		this.birthYear = birthYear;
		this.birthday = birthday;
		this.phoneNumber = phonenumberFix(phoneNumber);
		this.address = address;
	}
	
	public Contact()
	{
		
	}
	
	public void save()
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream(new File("tmp/" + firstName + lastName + ".ser"));
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
	
	public Contact load(String fileName)
	{
		Contact result = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("tmp/" + fileName + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			result = (Contact)in.readObject();
			
			
			
			this.lastName = result.lastName;
			this.firstName = result.firstName;
			this.birthMonth = result.birthMonth;
			this.birthYear = result.birthYear;
			this.birthday = result.birthday;
			this.phoneNumber = result.phoneNumber;
			this.address = result.address;
			
			
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
	
	public String getLastName() 
	{
		return lastName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getBirthMonth() 
	{
		return birthMonth;
	}

	public int getBirthYear() 
	{
		return birthYear;
	}

	public int getBirthday() 
	{
		return birthday;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	//called by constructor to store month string instead of month number
	private String monthNumberToString(int num)
	{
		return months[num - 1];
	}
	
	//formats phone number to include dashes
	private String phonenumberFix(String num)
	{
		String result = "";
		//0123456789
		//6018628861
		result += num.substring(0, 3) + "-" + num.substring(3, 6) + "-" + num.substring(6);
		return result;
	}

	@Override
	public String toString() 
	{/*
		String result = "";
		result = result + lastName;
		
		return result;*/
		
		return firstName + " " + lastName;
	}
}
