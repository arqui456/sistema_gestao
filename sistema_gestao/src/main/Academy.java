package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import resources.Auditorium;
import resources.Classroom;
import resources.Laboratory;
import resources.Projector;
import resources.Resource;
import users.Administrator;
import users.Doctorate;
import users.Graduation;
import users.Masters;
import users.Researcher;
import users.Teacher;
import users.User;
import actions.Action;
import actions.Allocated;
import actions.Completed;
import actions.InAllocationProcess;
import actions.InProgress;

public class Academy {

    private Scanner inputator = new Scanner(System.in);

    private List<Action> actions = new ArrayList<Action>();
    private List<User> users = new ArrayList<User>();
    
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
        Action action = new Action(rec);
        switch(rec){
        case 1:
        	resoursesInUse[0] += 1;
        	break;
        case 2:
        	resoursesInUse[1] += 1;
        	break;
        case 3: 
        	resoursesInUse[2] += 1;
        	break;
        case 4:
        	resoursesInUse[3] += 1;
        	break;
        case 5:
        	break;
    }
        actions.add(action);
        totalResourse++;
    }
    
    public void userAdd() {
    	
        System.out.println("Por favor insira o nome do usuario: ");
        String name = inputator.nextLine();
  
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
        
        users.add(user);
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
        boolean exist = false;
        boolean admin = false;
        for(int i = 0;i < totalUsers;i++) {
            if(users.get(i).getName().equals(name)) {
                exist = true;
                if(users.get(i) instanceof Administrator ) {
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
        	int input = frontEnd.resourceMenu3();
        
            Resource resource = new Resource();
            switch(input) {
                case 1:
                    resource = new Classroom();
                    break;
                case 2:
                	resource = new Auditorium();
                    break;
                case 3:
                	resource = new Projector();
                    break;
                case 4: 
                    resource = new Laboratory();
                    break;
                default:
                    break;  
            }
            
            for(int i = 0;i < totalResourse;i++) {
                if(actions.get(i).getResourseActive().getResponsible().equals(name)) {
                    if(actions.get(i).getResourseActive() != null) {
                        if(actions.get(i) instanceof Allocated) {
                            System.out.println("Encontramos um recurso alocado em seu nome, desejas confirmar a alocacao? 1 pra sim 0 caso contrario");
                            input = inputator.nextInt();
                            while(input != 0 && input != 1) {
                                System.out.println("entrada invalida, tente novamente: ");
                                input = inputator.nextInt();
                            }
                            if(input == 1) {
                            	Action action = actions.get(i);
                            	action = new InProgress();
                            	actions.remove(i);
                            	actions.add(action);
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
                            if(actions.get(i).getTitle().equals(title)) {
                                if(actions.get(i) instanceof InAllocationProcess ) {
                                    if(actions.get(i).getResourseActive() != null && 
                                       actions.get(i).getResourseActive().getResponsible() != null &&
                                       actions.get(i).getResourseActive().getStart() != null &&
                                       actions.get(i).getResourseActive().getEnd() != null) {
                                        System.out.println("Encontramos a atividade, deseja alocala? 1 para sim 0 caso contrario ");
                                        input = inputator.nextInt();
                                        while(input != 1 && input != 0) {
                                            System.out.println("Entrada invalida, tente novamente");
                                            input = inputator.nextInt();
                                        }
                                        if(input == 1 && admin == true) {
                                        	Action action = actions.get(i);
                                        	action = new Allocated();
                                        	actions.remove(i);
                                        	actions.add(action);
                                        }
                                        else {
                                            System.out.println("Usuario nao e admin, operacao cancelada");
                                        }
                                    }
                                    else {
                                        System.out.println("Recurso nao possui todas os dados basicos, cancelando operacao");
                                    }
                                }
                                else if(actions.get(i) instanceof InProgress ) {
                                    if(actions.get(i).getDetais() != null) {
                                        System.out.println("Encontramos a em andamento, deseja conclui-la? 1 para sim 0 caso contrario ");
                                        input = inputator.nextInt();
                                        while(input != 1 && input != 0) {
                                            System.out.println("Entrada invalida, tente novamente");
                                            input = inputator.nextInt();
                                        }
                                        if(input == 1 && admin == true) {
                                        	Action action = actions.get(i);
                                        	action = new Completed();
                                        	actions.remove(i);
                                        	actions.add(action);
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
