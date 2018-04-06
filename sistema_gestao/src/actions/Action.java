package actions;

import tools.Time;
import resources.Auditorium;
import resources.Classroom;
import resources.Laboratory;
import resources.Projector;
import resources.Resource;
import java.util.Scanner;


public class Action {

	private String title;
	private String detais;
	private String responsible;
	private Resource resourceActive;
	private Time start;
	private Time end;
	
	private Scanner input = new Scanner(System.in);

	public Action() {
		
	}
	public Action(int rec){
		System.out.println("Por favor insira o titulo da atividade");
        this.title = input.nextLine();
        
        System.out.println("Insira a descricao da atividade: ");
        this.detais = input.nextLine();

        System.out.println("Insira seu nome: ");
        this.responsible = input.nextLine();

        System.out.println("Insira a Data de inicio (d/m/y): ");
        this.start = new Time();
        
        System.out.println("Insira a Data de termino (d/m/y): ");
        this.end = new Time();
        
        Resource resource = new Resource();
        switch(rec){
            case 1:
            	resource = new Classroom(responsible, this.start, this.end);
            	break;
            case 2:
            	resource = new Auditorium(responsible, this.start, this.end);
            	break;
            case 3: 
            	resource = new Projector(responsible, this.start, this.end);
            	break;
            case 4:
            	resource = new Laboratory(responsible, this.start, end);
            	break;
            case 5:
            	break;
        }
        
        this.resourceActive = resource;
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
