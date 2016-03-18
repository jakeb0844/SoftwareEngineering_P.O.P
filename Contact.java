//Cory Wheeless
//3-18
package eng;

/*
 * Represents a contact by storing personal information
 * */

public class Contact 
{
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
	{
		String result = "";
		result += firstName + " " + lastName + "\n" +
				  birthMonth + " " + birthday + " " + birthYear + "\n" +
				  phoneNumber + "\n";
		return result;
	}
}
