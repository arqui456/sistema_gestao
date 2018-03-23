package tests;

import resources.Resource;
import tools.Time;
import tools.Date;
import tools.DateExtended;

public class ResourseTest {
	
	public static void main(String[] args) {
		Resource resourse = new Resource("Sala de aula","Willy", new Time(new Date(9,2,2018), new DateExtended(2,43, false)), new Time(new Date(10,2,2018), new DateExtended(12,0,false)) );
		System.out.println(resourse);
	}
}
