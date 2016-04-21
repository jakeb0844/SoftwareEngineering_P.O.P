package tmp;

import java.io.Serializable;

@SuppressWarnings("rawtypes")
public class Semester
	extends PackageCollection implements Serializable
{

	private static final long serialVersionUID = 45;
	
	private double gpa;
	
	
	@SuppressWarnings("unchecked")
	public void addCourse(Course next)
	{
		super.addElement(next);
	}
	
	public void setGpa(double gpa)
	{
		this.gpa = gpa;
	}
	
	public double getGpa()
	{
		return gpa;
	}
}
