package actions;

import tools.Time;
import users.User;
import resources.Resource;

public class Action {
	
	private String title;
	private String detais;
	private String responsible;
	
	private User userActive;
	private Resource resourseActive;

	private Time start;
	private Time end;
	
	public Action(String title, String detais, String responsible, String resourse, Time start, Time end) {
		this.title = title;
		this.detais = detais;
		this.start = start;
		this.end = end;
		this.responsible = responsible;
		
		this.resourseActive = new Resource(resourse, responsible, start, end);
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

	public User getUserActive() {
		return userActive;
	}

	public void setUserActive(User userActive) {
		this.userActive = userActive;
	}

	public Resource getResourseActive() {
		return resourseActive;
	}

	public void setResourseActive(Resource resourseActive) {
		this.resourseActive = resourseActive;
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
	
}
