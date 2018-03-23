package main;

import java.util.Scanner;

import resources.Auditorium;
import resources.Classroom;
import resources.Laboratory;
import resources.Projector;
import resources.Resource;
import tools.Time;
import tools.DateExtended;
import tools.Date;
import users.Administrator;
import users.Doctorate;
import users.Graduation;
import users.Masters;
import users.Researcher;
import users.Teacher;
import users.User;
import actions.Action;

public class Academy {
    
    private static int MAX = 1000;
    
    private Action[] actions = new Action[MAX];
    private User[] users = new User[MAX];
    
    private Scanner inputator = new Scanner(System.in);
    
    private int actionsIndex = 0;
    private int usersIndex = 0;
    
    private int[] resoursesInUse = new int[4];
    private int totalResourse = 0;
    private int totalAloc = 0;
    private int totalUsers = 0;
    
    UI frontEnd = new UI();
    
    
    
    public void resourseMenu() {
    	int input = frontEnd.resourceMenu();
        alocarRecurso(input);
    }
    
    public void alocarRecurso(int rec) {
    	int input = frontEnd.resourceMenu2();
        
        
        String title;
        String detais = null;
        //User responsible;
        //String role;
        
        String responsible;
        String start;
        String[] startAux;
        String hourr;
        String[] hourAux;
        
        
        int day;
        int month;
        int year;
        int hour;
        int minute;
        
        Time begin;
        Time end;
        
        System.out.println("Por favor insira o titulo da atividade");
        title = inputator.nextLine();
        inputator.nextLine();
        System.out.println("Deseja inserir a descricao da atividade agora?\nDigite 1 para Sim e 0 para Nao");
        input = inputator.nextInt();
        while(input != 0 && input != 1) {
            System.out.println("Entrada invalida, tente novamente! ");
            input = inputator.nextInt();
        }
        if(input == 1) {
            System.out.println("Insira a descricao da atividade: ");
            detais = inputator.nextLine();
            inputator.nextLine();
        }
        System.out.println("Insira seu nome: ");
        responsible = inputator.nextLine();
        System.out.println("Insira a Data de inicio (d/m/y): ");
        start = inputator.nextLine();
        startAux = start.split("/");
        day = Integer.parseInt(startAux[0]);
        month = Integer.parseInt(startAux[1]);
        year = Integer.parseInt(startAux[2]);
        
        System.out.println("Insira a Hora de inicio (hora:minuto): ");
        hourr = inputator.nextLine();
        hourAux = hourr.split(":");
        hour = Integer.parseInt(hourAux[0]);
        minute = Integer.parseInt(hourAux[1]);
        
        begin = new Time(new Date(day,month,year), new DateExtended(hour,minute, false));
        
        System.out.println("Insira a Data de termino (d/m/y): ");
        start = inputator.nextLine();
        startAux = start.split("/");
        day = Integer.parseInt(startAux[0]);
        month = Integer.parseInt(startAux[1]);
        year = Integer.parseInt(startAux[2]);
        
        System.out.println("Insira a Hora do termino (hora:minuto): ");
        hourr = inputator.nextLine();
        hourAux = hourr.split(":");
        hour = Integer.parseInt(hourAux[0]);
        minute = Integer.parseInt(hourAux[1]);
        
        end = new Time(new Date(day,month,year), new DateExtended(hour,minute, false));
        
        Resource resource = new Resource();
        switch(rec){
            case 1:
            	resource = new Classroom(responsible, begin, end);
            	resoursesInUse[0] += 1;
            	break;
            case 2:
            	resource = new Auditorium(responsible, begin, end);
            	resoursesInUse[1] += 1;
            	break;
            case 3: 
            	resource = new Projector(responsible, begin, end);
            	resoursesInUse[2] += 1;
            	break;
            case 4:
            	resource = new Laboratory(responsible, begin, end);
            	resoursesInUse[3] += 1;
            	break;
            case 5:
            	break;
        }
        
        actions[actionsIndex] = new Action(title, detais, responsible, resource, begin, end);
        
        totalResourse++;
    }
    
    public void userAdd() {
    	
        System.out.println("Por favor insira o nome do usuario: ");
        String name = inputator.nextLine();
        inputator.nextLine();
        System.out.println("Por favor insira o email do usuario: ");
        String email = inputator.nextLine();
        
        int input = frontEnd.userMenu();
        
        User user = new User();
        switch(input) {
            case 1:
            	user = new Teacher(name, email);
                break;
            case 2:
            	user = new Researcher(name, email);
                break;
            case 3:
            	user = new Administrator(name, email);
                break;
            case 4:
            	user = new Graduation(name, email);
                break;
            case 5:
            	user = new Masters(name, email);
                break;
            case 6:
            	user = new Doctorate(name, email);
                break;
            case 7:
                System.out.println("Finalizando o programa");
                break;
            default:
                break;
        }
        
        users[usersIndex++] = user;
        totalUsers++;
        
        System.out.println("usuario cadastrado: " + user);
    }
    
    public void sit() {
        
        System.out.println("Total de usuarios no sistema: " + totalUsers);
        System.out.println("Numero de recursos em: \nProcesso de alocacao: " + resoursesInUse[0] + 
                           "\nAlocado: " + resoursesInUse[1] + "\nEm andamento: " + resoursesInUse[2] +
                           "\nConcluido: " + resoursesInUse[3]);
        System.out.println("Numero total de alocacoes: " + totalAloc);
    }
    
    public void status(){
        System.out.println("Por favor insira seu nome de usuario: ");
        String name = inputator.nextLine();
        inputator.nextLine();
        boolean exist = false;
        boolean admin = false;
        for(int i = 0;i < totalUsers;i++) {
            if(users[i].getName().equals(name)) {
                exist = true;
                if(users[i] instanceof Administrator ) {
                	admin = true;
                	break;
                }
                else {
                	System.out.println("Usuario nao e administrador");
                	break;
                }
            }
        }
        
        if(exist == true) {
            System.out.println("Que recurso desejas alterar o status? ");
            System.out.println("\nRecursos");
            System.out.println("    1. Sala de aula");
            System.out.println("    2. Auditorio");
            System.out.println("    3. Projetor");
            System.out.println("    4. Laboratorio");
            int inputa = inputator.nextInt();
            while(inputa <= 0 || inputa > 4) {
                System.out.println("Entrada invalida, tente novamente: ");
                inputa = inputator.nextInt();
            }
            String resourse = null;
            switch(inputa) {
                case 1:
                    resourse = "Sala de aula";
                    break;
                case 2:
                    resourse = "Auditorio";
                    break;
                case 3:
                    resourse = "Projetor";
                    break;
                case 4: 
                    resourse = "Laboratorio";
                    break;
                default:
                    break;  
            }
            
            for(int i = 0;i < totalResourse;i++) {
                if(actions[i].getResourseActive().getResponsible().equals(name)) {
                    if(actions[i].getResourseActive().getResourse().equals(resourse)) {
                        if(actions[i].getResourseActive().getStatus().equals("Alocado")) {
                            System.out.println("Encontramos um recurso alocado em seu nome, desejas confirmar a alocacao? 1 pra sim 0 caso contrario");
                            inputa = inputator.nextInt();
                            while(inputa != 0 && inputa != 1) {
                                System.out.println("entrada invalida, tente novamente: ");
                                inputa = inputator.nextInt();
                            }
                            if(inputa == 1) {
                                actions[i].getResourseActive().setStatus("Em andamento");
                                break;
                            }
                            else
                                break;
                        }
                        else {
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("Nenhum recurso deste tipo esta associado a seu nome, insira o titulo da atividade:");
                        String title = inputator.nextLine();
                        System.out.println("...Pesquisando por atividade...");
                        for(i = 0; i < totalResourse;i++) {
                            if(actions[i].getTitle().equals(title)) {
                                if(actions[i].getResourseActive().getStatus().equals("Em processo de alocacao")) {
                                    if(actions[i].getResourseActive().getResourse() != null && 
                                       actions[i].getResourseActive().getResponsible() != null &&
                                       actions[i].getResourseActive().getStart() != null &&
                                       actions[i].getResourseActive().getEnd() != null) {
                                        System.out.println("Encontramos a atividade, deseja alocala? 1 para sim 0 caso contrario ");
                                        inputa = inputator.nextInt();
                                        while(inputa != 1 && inputa != 0) {
                                            System.out.println("Entrada invalida, tente novamente");
                                            inputa = inputator.nextInt();
                                        }
                                        if(inputa == 1 && admin == true) {
                                            actions[i].getResourseActive().setStatus("Alocado");
                                        }
                                        else {
                                            System.out.println("Usuario nao e admin, operacao cancelada");
                                        }
                                    }
                                    else {
                                        System.out.println("Recurso nao possui todas os dados basicos, cancelando operacao");
                                    }
                                }
                                else if(actions[i].getResourseActive().getStatus().equals("Em andamento")) {
                                    if(actions[i].getDetais() != null) {
                                        System.out.println("Encontramos a em andamento, deseja conclui-la? 1 para sim 0 caso contrario ");
                                        inputa = inputator.nextInt();
                                        while(inputa != 1 && inputa != 0) {
                                            System.out.println("Entrada invalida, tente novamente");
                                            inputa = inputator.nextInt();
                                        }
                                        if(inputa == 1 && admin == true) {
                                            actions[i].getResourseActive().setStatus("Concluido");
                                        }
                                        else {
                                            System.out.println("Usuario nao e admin, operacao cancelada");
                                        }
                                    }
                                    else {
                                        System.out.println("Atividade nao contem descricao, cancelando a operacao");
                                    }
                                }
                                }
                            else {
                                System.out.println("Nenhum processo em andamento ou em processo de alocacao, cancelando a operacao");
                                }
                                break;
                        }
                    }
                }
            }
            
        }
        else {
            System.out.println("Usuario nao esta cadastrado no sistema, deseja fazer isso agora?\n 1 para sim 0 caso contrario");
            int choice = inputator.nextInt();
            while(choice != 0 && choice != 1) {
                System.out.println("Entrada invalida, tente novamente: ");
                choice = inputator.nextInt();
            }
            if(choice == 1)
                userAdd();
            else
                System.out.println("Finalizando o programa");
        }
        
    }
    
    public void run(){
    	boolean finished = false;
        int menu;
        while(finished == false) {
            menu = frontEnd.menu();
            switch(menu) {
                case 1:
                    resourseMenu();
                    break;
                case 2:
                    userAdd();
                    break;
                case 3:
                    sit();
                    break;
                case 4:
                    status();
                    break;
                case 5:
                    System.out.println("exiting program...");
                    finished = true;
                    break;
                default: 
                    break;
            }
            
        }
        inputator.close();
    }
}
