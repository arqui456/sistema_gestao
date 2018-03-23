package resources;

import tools.Time;

public class Resource {
	
	private Time start;
	private Time end;
	private String responsible;
	
	public Resource(){

	}
	
	public Resource(String responsible, Time start, Time end) {
		this.responsible = responsible;
		this.start = start;
		this.end = end;
	}
	
	public Time getStart() {
		return start;
	}

	public void setStart(Time start) {
		this.start = start;
	}

	public Time getEnd() {
		return end;
	}

	public void setEnd(Time end) {
		this.end = end;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	@Override
	public String toString() {
		return "Resourse [start=" + start + ", end="
				+ end + ", responsible=" + responsible + "]";
	}
}
