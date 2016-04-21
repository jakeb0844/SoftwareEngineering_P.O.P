package tmp;

import java.io.Serializable;

@SuppressWarnings("rawtypes")
public class Course 
	extends PackageCollection implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 45;
	private String title;  //represents the title of the class
	private String meetDays; //represents the days the class meets
	private int pAbs; //represents max amount of days that can be missed
	private int abs = 0;  //represents days missed
	private int Fgrade;  //represents final grade
	private int creditHours;
	private String term;
	private int year;
	
	public Course()
	{
		super();
	}
	
	public Course(String title, String meetDays, int pAbs, int creditHours)
	{
		this.title = title;
		this.meetDays = meetDays;
		this.pAbs = pAbs;
		this.creditHours = creditHours;
	}
	
	public Course(String title, String meetDays, int pAbs, int creditHours, String term, int year)
	{
		this.title = title;
		this.meetDays = meetDays;
		this.pAbs = pAbs;
		this.creditHours = creditHours;
		this.term = term;
		this.year = year;
	}
	
	public String getCourseTitle()
	{
		return title;
	}
	
	//sets the name of the course
	public void setCourse(String c)
	{  
		title = c;
	}
	
	public int getCreditHours()
	{
		return creditHours;
	}
	
	public String getTerm()
	{
		return term;
	}
	
	public int getYear()
	{
		return year;
	}
	
	//Sets Days you meet for class
	public void setMD(String md)
	{ 
		meetDays = md;
	}
	
	public String getMd()
	{
		return meetDays;
	}
	
	//Max Days that can be missed
	public void setDays(int i)
	{  
		pAbs = i;
	}
	
	//skip class
	public void skipped()
	{   
		abs++;
	}
	
	public int getPabs()
	{
		return pAbs;
	}
	
	public int getDaysSkipped()
	{
		return abs;
	}
	
	//returns possible days skipped
	public int daysLeft()
	{   
		
		return pAbs - abs;
	}
	
	public int getAbs()
	{
		return abs;
	}
	
	public void errSkip()
	{
		abs--;
	}
	
	//lets you know your final grade for the course
	public void setFinalGrade(int g)
	{  
		Fgrade = g;
	}
	
	public int getFinalGrade()
	{
		return Fgrade;
	}
	
	//Assignment(String title, int month, int day, int year
	//add an assignment to the course
	@SuppressWarnings("unchecked")
	public void addAssignment(Assignment tmp)
	{  
		super.addElement(tmp);
	}
	
	/*
	//removes a specific assignment from the course
	public void deleteAssignment(Assignment b)
	{  
		assignments.remove(b);
	}
	
	//Clears all assignments for the course
	public void clearAssignments()
	{  
		assignments.clear();
	}
	*/
	
	/*
	need calender to complete!!!
	public Assignments nextDue(){
		Assignments next = new Assignments();
		for(int i=0; i <= 15; i++){
			if(a.get(i).getDueDate() ;
			
		}
		
		return next;
	}
	*/
	
	/*
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < assignments.size(); i++)
		{
			result += assignments.get(i).toString();
		}
		return result;
	}
	*/
}