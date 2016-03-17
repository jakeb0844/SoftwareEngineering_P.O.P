/*This class is a simple example of a calendar
 * Right now it can take the years from 2012-2016.
 * Not even close to finish but I thought it was a good start.
 * Will probably make this into a gui of some sort. 
 * I have an idea, but im done for the night. Peace
 */
public class calendarMethod {
	//start days for each january of a year
	public static int start2012=1;
	final static int start2013=3;
	final static int start2014=4;
	final static int start2015=5;
	final static int start2016=6;

	public static void main(String[] args) {
		
		calendar(start2012);
		
	}
	
	
	public static void calendar(int startDate){
		//the days in each month
		int[] monthDays={31,28,31,30,31,30,31,31,30,31,30,31};
		int first = startDate;
		int count = 0;
		//String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thurday"
		//		,"Friday","Saturday"};
		
		//some how this works
		count=first-1;
		int num=0;
		int year= 0;

//main while loop goes twice, simulating two years	
while(!(year==2)){	
	//text to just divide the years
	System.out.println("The year 2012************** \n\n\n");
	
	//while loop that goes for 12 rounds simulating 12 months
	while(!(num==11)){
		//just prints text for debugging purposes
		if(num>0){
			System.out.println(count + " the count");
			
			
			//first=count;
			System.out.println(first + " the first");
		}
		
		//prints the number of days for each month, debugging purposes
		System.out.println( monthDays[num]);
		
		for(int i= -(first)+1; i <= monthDays[num]; i++){
			
			//if i is neg then print spaces
			if(i<0){
				System.out.print("\t");
			}
			
			//if i is >=1 print the numbers with a tab, count increments
			if(i >= 1){
				System.out.print(i+"\t");
				count++;
			}
			//if count if >=7, then print line and set count to 0.
			//simulates the number of days in a week
			if(count >=7){
				System.out.println("");
				count =0;
			}
			
		}//end for
		//separates the months
		System.out.println("\n \n \n" );
			num++;
			
			first=count+1;
		
}//end while
	num=0;
	
	year++;

}//end big while
	}
}
