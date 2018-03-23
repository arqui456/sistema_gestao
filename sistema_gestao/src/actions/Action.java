package actions;

import tools.Time;
import resources.Resource;

public class Action {

	private String title;
	private String detais;
	private String responsible;
	private Resource resourceActive;
	private Time start;
	private Time end;
	
	public Action(){
		
	}
	
	public Action(String title, String detais, String responsible,Resource resource, Time start, Time end) {
		this.title = title;
		this.detais = detais;
		this.start = start;
		this.end = end;
		this.responsible = responsible;
		this.resourceActive = resource;
	}
	
	public String getResponsible() {
		return responsible;
	}
	
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetais() {
		return detais;
	}

	public void setDetais(String detais) {
		this.detais = detais;
	}

	public Resource getResourseActive() {
		return resourceActive;
	}

	public void setResourseActive(Resource resourseActive) {
		this.resourceActive = resourseActive;
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

	@Override
	public String toString() {
		return "Action [title=" + title + ", detais=" + detais
				+ ", responsible=" + responsible + ", resourceActive="
				+ resourceActive + ", start=" + start + ", end=" + end + "]";
	}	
	
}
