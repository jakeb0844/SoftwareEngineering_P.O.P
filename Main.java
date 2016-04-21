package tmp;

public class Main 
{
	public static void main(String[] args)
	{
		AddressBook a = new AddressBook();
		Contact c = new Contact("Wheeless", "Cory", 6, 4, 4949, "394039294", "kdjfa;lkd");
		a.addContact(c);
	}
}
