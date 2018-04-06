package tests;

import resources.Classroom;
import resources.Resource;
import tools.Time;
import tools.Date;
import tools.DateExtended;

public class ResourseTest {
	
	public static void main(String[] args) {
		
		Time time1 = new Time(new Date(9,2,2018), new DateExtended(2,43, false));
		Time time2 = new Time(new Date(10,2,2018), new DateExtended(12,0,false));
		
		Resource resourse = new Classroom("Willy",time1,time2);
		System.out.println(resourse);
	}
}
