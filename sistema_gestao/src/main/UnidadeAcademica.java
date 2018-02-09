package main;

import java.util.Scanner;

import tools.Time;
import tools.DateExtended;
import tools.Date;
import users.User;
import actions.Action;

public class UnidadeAcademica {
    
    private static int MAX = 1000;
    
    private static Action[] actions = new Action[MAX];
    private static User[] users = new User[MAX];
    
    private static Scanner inputator = new Scanner(System.in);
    
    private static int actionsIndex = 0;
    private static int usersIndex = 0;
    
    private static int[] resoursesInUse = new int[4];
    private static int totalResourse = 0;
    private static int totalAloc = 0;
    private static int totalUsers = 0;
    
    
    private static int menu() {
        System.out.println("Selecione a acao que deseja realisar pelo numero:");
        System.out.println("1. Alocacao de recursos");
        System.out.println("2. Cadastro de usuarios");
        System.out.println("3. Relatorio do sistema");
        System.out.println("4. Alterar status de alocacao");
        System.out.println("5. Finalizar programa");
        
        int input = inputator.nextInt();
        while(input <= 0 || input > 5) {
            System.out.println("Acao invalida, tente novamente");
             input = inputator.nextInt();
        }
        
        return input;
    }
    
    private static void resourseMenu() {
        System.out.println("\nRecursos");
        System.out.println("    1. Sala de aula");
        System.out.println("    2. Auditorio");
        System.out.println("    3. Projetor");
        System.out.println("    4. Laboratorio");
        System.out.println("    5. Finalizar");
        
        System.out.println("Selecione um recurso utilizando seu numero: ");
        int input = inputator.nextInt();
        
        while(input <= 0 || input > 5){
            System.out.println("Entrada invalida, tente novamente");
            input = inputator.nextInt();
        }
        
        switch(input) {
            case 1:
                alocarRecurso("Sala de aula");
                break;
            case 2:
                alocarRecurso("Auditorio");
                break;
            case 3: 
                alocarRecurso("Projetor");
                break;
            case 4:
                alocarRecurso("Laboratorio");
                break;
            default:
                break;
        }
        
    }
    
    private static void alocarRecurso(String recurso) {
        System.out.println("Selecione a sua ocupacao pelo numero abaixo:");
        System.out.println("    1. Professor");
        System.out.println("    2. Pesquisador");
        System.out.println("    3. Administrador");
        System.out.println("    4. Finalizar programa");
        
        int input = inputator.nextInt();
        
        String title;
        String detais = null;
        User responsible;
        String role;
        
        String name;
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
        
        switch(input) {
            case 1:
                role = "Professor";
                break;
            case 2:
                role = "Pesquisador";
                break;
            case 3:
                role = "Administrador";
                break;
            default:
                break;
        }
        
        System.out.println("Por favor insira o titulo da atividade");
        title = inputator.nextLine();
        System.out.println("Deseja inserir a descricao da atividade agora?\nDigite 1 para Sim e 0 para Nao");
        input = inputator.nextInt();
        while(input != 0 && input != 1) {
            System.out.println("Entrada invalida, tente novamente! ");
            input = inputator.nextInt();
        }
        if(input == 1) {
            System.out.println("Insira a descricao da atividade: ");
            detais = inputator.nextLine();
        }
        System.out.println("Insira seu nome: ");
        name = inputator.nextLine();
        
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
        
        actions[actionsIndex] = new Action(title, detais, name, recurso, begin, end);
        
        resoursesInUse[0] += 1;
        totalResourse++;
    }
    
    private static void userAdd() {
        String name;
        System.out.println("Por favor insira o nome do usuario: ");
        String namae = inputator.nextLine();
        name = namae;
        System.out.println("Por favor insira o email do usuario: ");
        String email = inputator.nextLine();
        
        System.out.println("O usuario e pesquisador? se sim digite 1 caso contrario 0");
        int input = inputator.nextInt();
        
        while(input != 0 && input != 1) {
            System.out.println("Entrada invalida, tente novamente");
            input = inputator.nextInt();
        }
        boolean researcher = false;
        if(input == 1) {
            researcher = true;
        }
        System.out.println("Selecione a sua ocupacao pelo numero abaixo:");
        System.out.println("    1. Professor");
        System.out.println("    2. Pesquisador");
        System.out.println("    3. Administrador");
        System.out.println("    4. Estudante - Graduacao");
        System.out.println("    5. Estudante - Mestrado");
        System.out.println("    6. Estudante - Doutorado");
        System.out.println("    7. Finalizar programa");
        input = inputator.nextInt();
        while(input <= 0 || input > 7) {
            System.out.println("Entrada invalida, tente novamente: ");
            input = inputator.nextInt();
        }
        String role = null;
        switch(input) {
            case 1:
                role = "Professor";
                break;
            case 2:
                role = "Pesquisador";
                break;
            case 3:
                role = "Administrador";
                break;
            case 4: 
                role = "Graduacao";
                break;
            case 5: 
                role = "Mestrado";
                break;
            case 6:
                role = "Doutorado";
                break;
            case 7:
                System.out.println("Finalizando o programa");
                break;
            default:
                break;
        }
        
        User user1 = new User(name, email, researcher, role);
        users[usersIndex] = user1;
        totalUsers++;
        
        System.out.println("usuario cadastrado: " + user1);
        
    }
    
    private static void sit() {
        
        System.out.println("Total de usuarios no sistema: " + totalUsers);
        System.out.println("Numero de recursos em: \nProcesso de alocacao: " + resoursesInUse[0] + 
                           "\nAlocado: " + resoursesInUse[1] + "\nEm andamento: " + resoursesInUse[2] +
                           "\nConcluido: " + resoursesInUse[3]);
        System.out.println("Numero total de alocacoes: " + totalAloc);
    }
    
    private static void status(){
        System.out.println("Por favor insira seu nome de usuario: ");
        String name = inputator.nextLine();
        boolean exist = false;
        boolean admin = false;
        for(int i = 0;i < totalUsers;i++) {
            if(users[i].getName().equals(name)) {
                exist = true;
                if(users[i].getRole().equals("Administrador")) {
                    admin = true;
                }
                else 
                    System.out.println("Usuario nao e administrador");
                break;
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
    
    public static void main(String[] args) {
        boolean finalizado = false;
        int menu;
        while(finalizado == false) {
            menu = menu();
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
                    System.out.println("Finalizando programa");
                    finalizado = true;
                    break;
                default: 
                    break;
            }
            
        }
        
        
        
        
        inputator.close();
    }
    

}
