package resources;

import tools.Time;

public class Classroom extends Resource{

	public Classroom() {
		super();
	}
	
	public Classroom(String responsible, Time begin, Time end){
		super(responsible, begin, end);
	}
}
