package tests;

import tools.Time;
import tools.DateExtended;
import tools.Date;

public class ToolsTest {
	
	public static void main(String[] args) {
		
		Time time = new Time(new Date(9,2,2018), new DateExtended(01,37,false));
		System.out.println(time);
		
		Time time1 = new Time(new Date(28,2,2018), new DateExtended(3,37,true,"PM"));
		time1.printAM();
	}
}
