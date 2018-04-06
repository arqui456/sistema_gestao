package tools;
import java.util.Scanner;

public class Time {
	
	private Date date;
	private DateExtended dateExt;
	Scanner input = new Scanner(System.in);
	
	public Time(){

		String start = input.nextLine();
        String[] startAux = start.split("/");
        int day = Integer.parseInt(startAux[0]);
        int month = Integer.parseInt(startAux[1]);
        int year = Integer.parseInt(startAux[2]);
        
        System.out.println("Insira a Hora (hora:minuto): ");
        String hourr = input.nextLine();
        String[] hourAux = hourr.split(":");
        int hour = Integer.parseInt(hourAux[0]);
        int minute = Integer.parseInt(hourAux[1]);

        this.date = new Date(day, month, year);
        this.dateExt = new DateExtended(hour, minute, false);
	}

	public Time(Date date, DateExtended dateExt){
		this.date = date;
		this.dateExt = dateExt;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateExtended getDateExt() {
		return dateExt;
	}

	public void setDateExt(DateExtended dateExt) {
		this.dateExt = dateExt;
	}
	
	public void printAM() {
		System.out.println("Time: " + date + " at " + dateExt.getHour() + ":" + dateExt.getMinute() + " " + dateExt.getPm_am());
	}
	
	//return hour + ":" + minute + " " + pm_am;

	@Override
	public String toString() {
		return "Time: " + date + " at " + dateExt;
	}
}
