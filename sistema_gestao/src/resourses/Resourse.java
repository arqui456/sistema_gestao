package resourses;

import tools.Time;

public class Resourse {
	
	private String status = "Em processo de alocacao";
	private Time start;
	private Time end;
	private String responsible;
	private String resourse;
	
	
	public Resourse(String resourse, String responsible, Time start, Time end) {
		this.resourse = resourse;
		this.responsible = responsible;
		this.start = start;
		this.end = end;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getResourse() {
		return resourse;
	}

	public void setResourse(String resourse) {
		this.resourse = resourse;
	}

	@Override
	public String toString() {
		return "Resourse: " + resourse + " ,Status: " + status + " ,Responsible: " + responsible + " ,Start: " + start + " ,End: " + end;
	}
	
	
	

}
