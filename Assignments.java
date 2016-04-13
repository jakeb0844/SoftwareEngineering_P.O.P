import java.sql.Time;
import java.time.Month;
import java.util.Date;

public class Assignments {

	private String title, grade; 
	private int month, day, year;
	private int time, min; 
	

	public Assignments(){
		title = null;
	}
	
	public Assignments(String t){
		title= t;
	}
	
	//title, month, day, year
	public Assignments(String t, int m, int d, int y){
		title = t;  //constructs the assignment's title
		month = m;   //month
		day = d;     //day
		year = y;    //year
		
	}
	
	public Assignments(String t, int m, int d, int y, int tt){
		title = t;  //constructs the assignment's title
		month = m;   //month
		day = d;     //day
		year = y;    //year
		time = tt;   //time in hours
	
	}
	
	public String getAssignment() //gets the title of an assignment
	{
		return title + " " + getDueDate();
	}
	
	public Date getDueDate()  //gets the due date of an assignment
	{
		Date r = new Date(year,month,day);
		r.setHours(time);
		//r.setMinutes(15);
		return r;
	}
	
	public Date getDueDate(int d)  //gets the due date of an assignment
	{
		Date r = new Date(year,month,day);
		r.setHours(d);
		//r.setMinutes(15);
		return r;
	}

	
	public void alterAssignment(String t, int m, int d, int y) //alter assignment 
	{
		title = t;
		month = m;
		day = d; 
		year = y;
	}
	
	public void alterAssignment(String t, int m, int d, int y, int tt) //alter assignment 
	{
		title = t;
		month = m;
		day = d; 
		year = y;
		time = tt;
	}
	
	
	public void setDueDate(int m, int d, int y) //sets due date for a given assignment
	{
		month = m;
		day = d; 
		year = y;
	}
	
	public void setDueDate(int m, int d, int y, int tt) //sets due date for a given assignment
	{
		month = m;
		day = d; 
		year = y;
		time = tt;
	}
	
	public int getMonth(){  //gets the month of a given assignment
		return month;
	}
	
	public int getDay(){  //gets the day of a given assignment
		return day;
	}
	
	public int getYear(){  //gets the year of a given assignment
		return year;
	}
	
	public void setGrade(String g){  //sets the grade made on a given assignment 
		grade = g;
	}
	
	public String getGrade(){  //gets the grade made on a given assignment
		return grade; 
	}
	
	public long UnixTime(){ //converts a date to unix time
		long l = 0;
			
		l= getDueDate().getTime();
		
		return l;
	}
	
	public String toString(){
		String r;
		r = this.title + " " + this.getDueDate(time) + " ";
		return r;
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}

	public int getTime() {
		return this.getDueDate().getHours();
	}

	public void setTime(int t) {
		this.getDueDate().setHours(t);
	}
	
}
