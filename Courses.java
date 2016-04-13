import java.time.Instant;
import java.util.*; 

public class Courses {
	@SuppressWarnings("unused")
	private String course;  //represents the title of the class
	private String meetDays; //represents the days the class meets
	ArrayList<Assignments> a = new ArrayList<>(); //holds the assignments for the course
	public static ArrayList<Courses> courses= new ArrayList<Courses>();
	private int pAbs; //represents max amount of days that can be missed
	private int abs = 0;  //represents days missed
	private String Fgrade;  //represents final grade
	private int hours; //represents hours per course
	@SuppressWarnings("deprecation")
	private long date = Instant.now().getEpochSecond();
	
	public Courses(){
		course = "null";
	}
	//(Course, Days the course meets, max possible miss days, hours)
	public Courses(String c, String md, int pd, int h){  
		course = c;
		meetDays = md;
		pAbs = pd;
		hours = h;
		courses.add(this);
	}
	public static Courses getCourse(String s){
		int r = 0;
		int l = 0;
		for(int i = 0; i<courses.size(); i++){
			if(courses.get(i).getCourseTitle().equalsIgnoreCase(s)){
				r = i;
			}else{
				for(int j = 0; i<courses.size(); i++){
					if(courses.get(i).getCourseTitle().compareToIgnoreCase(s) > l){
						l = courses.get(i).getCourseTitle().compareToIgnoreCase(s);
						r = i;
					}
				}
				
			}
		}
		return courses.get(r);
	}
	
	public void setCourse(String c){  //sets the name of the course
		course = c;
	}
	
	public void setMD(String md){ //Sets Days you meet for class ex.MWF or TR
		meetDays = md;
	}
	
	public String getMd(){
		return meetDays;
	}
	
	public void setDays(int i){  //Max Days that can be missed
		pAbs = i;
	}
	
	public void skipped(){   //skip class
		if(abs < pAbs)
			abs++;
	}
	
	public void errSkip(){//subtracts from skipped class
		if(abs > 0)
			abs--;
	}
	
	public String daysSkipped(){ //days skipped as a string 
		String x = "" + abs;
		return x;
	}
	
	public int daysLeft(){   //returns possible days skipped
		
		return pAbs - abs;
	}
	
	public String getPabs(){
		String x = "" + pAbs;
		return x;
	}
	
	public void setFinalGrade(String g){  //lets you know your final grade for the course
		Fgrade = g;
	}
	
	public String getFinalGrade(){
		return Fgrade;
	}
	
	public String getCourseTitle(){
		return course; 
	}
	
	//Assignment(String title, int month, int day, int year
	public void addAssignment(String t, int m, int d, int y){  //add an assignment to the course
		Assignments aS = new Assignments(t, m, d, y);
		a.add(aS);
	}
	
	//Assignment(String title, int month, int day, int year, int time
	public void addAssignment(String t, int m, int d, int y, int tt){  //add an assignment to the course
		Assignments aS = new Assignments(t, m, d, y, tt);
		a.add(aS);
	}
	
	public void deleteAssignment(Assignments b){  //removes a specific assignment from the course
		a.remove(b);
	}
	
	public void clearAssignments(){  //Clears all assignments for the course
		a.clear();
	}

	public long getDate() {  //gets current date
		return date;
	}
	
	public int getHours(){
		return hours;
	}
	
	public void setHours(int a){
		hours = a;
	}

	public Assignments nextDue(){   //returns the next assignment thats due for the course
	
		Assignments next = new Assignments();	
		
		long min = -1 ;
		for(int i=0; i < a.size(); i++){
					if(next.getAssignment() == null){  //sets next equal to the first assignment
						
					    next.alterAssignment( a.get(i).getAssignment(), a.get(i).getMonth(), a.get(i).getDay(), a.get(i).getYear());
						//next = (Assignments) a.get(i).clone();
						min = next.UnixTime();
					}else{
						if(a.get(i).UnixTime() - date >= 0 && a.get(i).UnixTime() < min){
							next.alterAssignment( a.get(i).getAssignment(), a.get(i).getMonth(), a.get(i).getDay(), a.get(i).getYear());
							//next = (Assignments) a.get(i).clone();
							min = next.UnixTime();
						}
					}
		}
		return next;
	}
	

	public String showAssignments(){
		String r = course + ":\n";
			for(int i=0; i<a.size(); i++){
				r = r + a.get(i).getAssignment() + "\n";
			}
			return r + "\n";
	}
	
	
	public String toString(){
		String r = "Course: " + this.course + " " + this.meetDays + " " + this.hours + ".0 hours";
		return r;
	}
	
	
}


