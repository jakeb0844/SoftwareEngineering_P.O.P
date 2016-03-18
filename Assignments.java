
public class Assignments {

	private String title, grade; 
	private int month, day, year;
	
	public Assignments(){
		title = "null";
	}
	
	public Assignments(String t, int m, int d, int y){
		title = t;  //constructs the assignment's title
		month = m;   //month
		day = d;     //day
		year = y;    //year
	}
	
	public String getAssignment()
	{
		return title;
	}
	
	public String getDueDate()
	{
		String r = month + "/" + day + "/" + year;
		return r;
	}

	
	public void addAssignment(String t, int m, int d, int y)
	{
		title = t;
		month = m;
		day = d; 
		year = y;
	}
	
	public void setDueDate(int m, int d, int y)
	{
		month = m;
		day = d; 
		year = y;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setGrade(String g){
		grade = g;
	}
	
	public String getGrade(){
		return grade;
	}
	
	
}
