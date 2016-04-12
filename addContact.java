package Contact;
//The exact thing as the add Events

	public class addContact {
		public static void add(Contact c){
			//add the contact to the arraylist
			Contact.contacts.add(c);
			//clear the count birthdays array
			countBirthdays.clearCmonthsArray();
			//re count the birthdays
			countBirthdays.countBdays();
			
	}
}
