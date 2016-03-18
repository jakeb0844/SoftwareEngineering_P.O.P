import java.util.*; 

public class Courses {
	private String course;  //represents the title of the class
	private String meetDays; //represents the days the class meets
	ArrayList<Assignments> a = new ArrayList<>(10); //holds the assignments for the course
	private int pAbs; //represents max amount of days that can be missed
	private int abs = 0;  //represents days missed
	private String Fgrade;  //represents final grade
	
	public Courses(){
		course = "null";
	}
	
	public Courses(String c, String md, int pd){
		course = c;
		meetDays = md;
		pAbs = pd;
	}
	
	public void setCourse(String c){  //sets the name of the course
		course = c;
	}
	
	public void setMD(String md){ //Sets Days you meet for class
		meetDays = md;
	}
	
	public String getMd(){
		return meetDays;
	}
	
	public void setDays(int i){  //Max Days that can be missed
		pAbs = i;
	}
	
	public void skipped(){   //skip class
		abs++;
	}
	
	public int daysLeft(){   //returns possible days skipped
		
		return pAbs - abs;
	}
	
	public void setFinalGrade(String g){  //lets you know your final grade for the course
		Fgrade = g;
	}
	
	public String getFinalGrade(){
		return Fgrade;
	}
	
	//Assignment(String title, int month, int day, int year
	public void addAssignment(String t, int m, int d, int y){  //add an assignment to the course
		Assignments aS = new Assignments(t, m, d, y);
		a.add(aS);
	}
	
	public void deleteAssignment(Assignments b){  //removes a specific assignment from the course
		a.remove(b);
	}
	
	public void clearAssignments(){  //Clears all assignments for the course
		a.clear();
	}
	
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
	
}


