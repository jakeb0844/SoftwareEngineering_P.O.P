package tmp;
//4/3/16
//added a remove contact feature
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

//import Calendar.calendarGui2;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;

public class ContactGui {

	private JFrame frame;
	ListSelectionModel listSelection;
	private JTextField firstField;	
	static JTextField lastField;
	static JTextField BirthMonthField;
	static JTextField 	BirthYearField;
	static JTextField BirthDayField;
	static JTextField phoneField;
	static JTextField 	addressField;
	static DefaultListModel listModel;
	static Contact con;
	public static JPanel yoyo,panel2;
	public static JLabel lblFirstName,lblLastName,lblBirthMonth,lblBirthyear,lblBirthDay, lblPhoneNumber,lblAddress;
	public static JList list;
	public static ArrayList<String> holdNames = new ArrayList<String>();
	
	static AddressBook addressbook = new AddressBook();
	 

	public ContactGui() {
		
		File f = new File("sers/AddressBook");
		if(f.exists())
		{
			addressbook.load("AddressBook");
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		
	
		final JButton removeContact = new JButton("Remove");
		
		
		listModel = new DefaultListModel();
		 
		 yoyo = new JPanel();
		 yoyo.setBorder(BorderFactory.createTitledBorder("Contacts"));
		 panel2 = new JPanel();
		// panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		 panel2.setBounds(280, 30, 275, 300);
		 
		 panel2.setLayout(null);
			
		 list = new JList(listModel);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if(list.getValueIsAdjusting()){
			    String name = (String) list.getSelectedValue();
				String temp;
				
				
			for(int i =0; i < addressbook.getSize(); i++){	
				Contact tempContact = (Contact)addressbook.getElement(i);
				temp = tempContact.getFirstName() + " " + tempContact.getLastName();
				
				if(name.equals(temp)){
					panel2.removeAll();
					
					
					final JLabel firstName = new JLabel(tempContact.getFirstName());
					firstName.setBounds(0, 0, 75, 14);
					panel2.add(firstName);
					
					final JLabel lastName = new JLabel(tempContact.getLastName());
					lastName.setBounds(0,20,75,14);
					panel2.add(lastName);
					
					final JLabel birthMonth = new JLabel(tempContact.getBirthMonth());
					birthMonth.setBounds(0,40,75,14);
					panel2.add(birthMonth);
					
					final JLabel birthDay = new JLabel(Integer.toString(tempContact.getBirthday()));
					birthDay.setBounds(0,60,75,14);
					panel2.add(birthDay);
					
					final JLabel birthYear = new JLabel(Integer.toString(tempContact.getBirthYear()));
					birthYear.setBounds(0,80,75,14);
					panel2.add(birthYear);
					
					final JLabel phoneNum = new JLabel(tempContact.getPhoneNumber());
					phoneNum.setBounds(0,100,75,14);
					panel2.add(phoneNum);
					
					final JLabel address = new JLabel(tempContact.getAddress());
					address.setBounds(0,120,300,14);
					panel2.add(address);
					
					
					
					String extraLen = tempContact.getAddress();
					String word;
					if(extraLen.length() >= 43){
						word= extraLen.substring(43, extraLen.length());
						JLabel extra = new JLabel(word);
						extra.setBounds(0, 140, 300, 14);
						panel2.add(extra);
					}
					
					removeContact.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String name2 = (String)list.getSelectedValue();
							//System.out.println(name2);
							for(int x =0; x < addressbook.getSize(); x++){
								Contact tempContact = (Contact)addressbook.getElement(x);
								if(name2.equals(tempContact.getFirstName()+" " + tempContact.getLastName())){
									//tempContact.remove(x);======================================================================================NEED REMOVE FUNCTION FOR CONTACT
								}
							}
							
							
							for(int i=0; i < listModel.size(); i++){
								if(name2.equals(listModel.getElementAt(i))){
									listModel.remove(i);
									CountBirthdays.countBdays();
									firstName.setText(null);
									lastName.setText(null);
									birthMonth.setText(null);
									birthDay.setText(null);
									birthYear.setText(null);
									address.setText(null);
									phoneNum.setText(null);
									panel2.repaint();
									CalendarGui2.refreshCalendar(CalendarGui2.currentMonth, CalendarGui2.currentYear);
								}
							}
							

							
						}
					});
					
					
					yoyo.add(panel2);
					panel2.revalidate();
					panel2.repaint();
					
					
					
					
				}//end if
			}//end for
		}//end if adjusting
				
				
			}
		});
		yoyo.setLayout(null);
		
		
		
		JScrollPane scrolly = new JScrollPane(list);
		scrolly.setBounds(5, 30, 150, 350);
		
		scrolly.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	
		//frame.getContentPane().add(scrolly);
		yoyo.add(scrolly);
		
		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.setBounds(250, 350, 93, 23);
		removeContact.setBounds(350, 350, 93, 23);
		
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				window();
				

				
			}
		});
		//frame.getContentPane().add(btnAddContact);
		yoyo.add(btnAddContact);
		yoyo.add(removeContact);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(200, 30, 75, 14);
		yoyo.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(200, 50, 75, 14);
		yoyo.add(lblLastName);
			
        lblBirthMonth = new JLabel("BirthMonth:");
		lblBirthMonth.setBounds(200, 70, 75, 14);
		yoyo.add(lblBirthMonth);
			
		lblBirthDay = new JLabel("Birth Day:");
		lblBirthDay.setBounds(200, 90, 75, 14);
		yoyo.add(lblBirthDay);
		
		lblBirthyear = new JLabel("Birth Year:");
		lblBirthyear.setBounds(200, 110, 75, 14);
		yoyo.add(lblBirthyear);
			
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(200, 130, 75, 14);
		yoyo.add(lblPhoneNumber);
			
		lblAddress = new JLabel("Address:");
		lblAddress.setBounds(200, 150, 75, 14);
		yoyo.add(lblAddress);
			
		
	
	}
	
	public void window(){
		final JFrame frame2 = new JFrame();
		frame2.setBounds(700, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		firstField = new JTextField();
		firstField.setText("Jake");
		firstField.setBounds(146, 26, 86, 20);
		frame2.getContentPane().add(firstField);
		firstField.setColumns(10);
		
		JButton btnCreateContact = new JButton("Create Contact");
		btnCreateContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//public Contact(String lastName, String firstName, int birthMonth, int birthYear, int birthday,
				//		String phoneNumber, String address)
				String name = firstField.getText() + " " + lastField.getText();
				
				holdNames.add(name);
				sortContacts();
				
				listModel.clear();
				
				for(int i = 0; i < holdNames.size(); i++){
					listModel.addElement(holdNames.get(i));
				}
				
				//listModel.addElement(name);
					//System.out.println(firstField.getText());
						con = new Contact(lastField.getText(),firstField.getText(),Integer.parseInt(BirthMonthField.getText()),Integer.parseInt(BirthYearField.getText()),
						Integer.parseInt(BirthDayField.getText()),phoneField.getText(),addressField.getText());
				 
				 //addContact.add(con);
				 addressbook.addContact(con);
				 
				 CalendarGui2.refreshCalendar(CalendarGui2.currentMonth, CalendarGui2.currentYear);
				
   				frame2.dispose();
			}
		});
		btnCreateContact.setBounds(130, 227, 119, 23);
		frame2.getContentPane().add(btnCreateContact);
		
		 lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 29, 75, 14);
		frame2.getContentPane().add(lblFirstName);
		
		 lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 54, 75, 14);
		frame2.getContentPane().add(lblLastName);
		
		 lblBirthMonth = new JLabel("BirthMonth:");
		lblBirthMonth.setBounds(10, 79, 75, 14);
		frame2.getContentPane().add(lblBirthMonth);
		
		 lblBirthDay = new JLabel("Birth Day:");
		lblBirthDay.setBounds(10, 128, 75, 14);
		frame2.getContentPane().add(lblBirthDay);
		
		lblBirthyear = new JLabel("BirthYear:");
		lblBirthyear.setBounds(10, 103, 75, 14);
		frame2.getContentPane().add(lblBirthyear);
		
		 lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(10, 153, 75, 14);
		frame2.getContentPane().add(lblPhoneNumber);
		
		 lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 178, 75, 14);
		frame2.getContentPane().add(lblAddress);
		
		 lastField = new JTextField();
		 lastField.setText("Busby");
		lastField.setColumns(10);
		lastField.setBounds(146, 51, 86, 20);
		frame2.getContentPane().add(lastField);
		
		 BirthMonthField = new JTextField();
		 BirthMonthField.setText("9");
		BirthMonthField.setColumns(10);
		BirthMonthField.setBounds(146, 76, 86, 20);
		frame2.getContentPane().add(BirthMonthField);
		
		BirthYearField = new JTextField();
		BirthYearField.setText("1993");
		BirthYearField.setColumns(10);
		BirthYearField.setBounds(146, 100, 86, 20);
		frame2.getContentPane().add(BirthYearField);
		
		 BirthDayField = new JTextField();
		 BirthDayField.setText("15");
		BirthDayField.setColumns(10);
		BirthDayField.setBounds(146, 125, 86, 20);
		frame2.getContentPane().add(BirthDayField);
		
		 phoneField = new JTextField();
		 phoneField.setText("3182821852");
		phoneField.setColumns(10);
		phoneField.setBounds(146, 150, 86, 20);
		frame2.getContentPane().add(phoneField);
		
	 	addressField = new JTextField();
	 	//addressField.setText("183 Eaker Road Tallulah,LA 71282");
	 	addressField.setText("1111111111111111111111111111111111111111111");
		addressField.setColumns(10);
		addressField.setBounds(146, 175, 86, 20);
		frame2.getContentPane().add(addressField);
		
		
		
		frame2.setVisible(true);
		
	}
	
	public static void sortContacts(){
		Collections.sort(holdNames);
	}
}