package main;

import java.util.Scanner;

public class UI {

	Scanner inputer = new Scanner(System.in);
	
	public UI() {
		
	}
	
	public int menu() {
        System.out.println("Selecione a acao que deseja realisar pelo numero:");
        System.out.println("1. Alocacao de recursos");
        System.out.println("2. Cadastro de usuarios");
        System.out.println("3. Relatorio do sistema");
        System.out.println("4. Alterar status de alocacao");
        System.out.println("5. Finalizar programa");
        
        int input = inputer.nextInt();
        while(input <= 0 || input > 5) {
            System.out.println("Entrada invalida, tente novamente");
             input = inputer.nextInt();
        }
        return input;
    }
	
	public int resourceMenu(){
		System.out.println("Recursos");
        System.out.println("    1. Sala de aula");
        System.out.println("    2. Auditorio");
        System.out.println("    3. Projetor");
        System.out.println("    4. Laboratorio");
        System.out.println("    5. Finalizar");
        
        System.out.println("Selecione um recurso utilizando seu numero: ");
        int input = inputer.nextInt();
        
        while(input <= 0 || input > 5){
            System.out.println("Entrada invalida, tente novamente");
            input = inputer.nextInt();
        }
		return input;
	}
	
	public int resourceMenu2(){
		System.out.println("Selecione a sua ocupacao pelo numero abaixo:");
        System.out.println("    1. Professor");
        System.out.println("    2. Pesquisador");
        System.out.println("    3. Administrador");
        System.out.println("    4. Finalizar programa");
        
        int input = inputer.nextInt();
        while(input > 4 && input < 1){
        	System.out.println("Entrada invalida, tente novamente");
        	input = inputer.nextInt();
        }
        return input;
	}
	
	public int resourceMenu3(){
		System.out.println("    Que recurso desejas alterar o status?");
        System.out.println("    1. Sala de aula");
        System.out.println("    2. Auditorio");
        System.out.println("    3. Projetor");
        System.out.println("    4. Laboratorio");
        System.out.println("    5. Finalizar");
        
        System.out.println("Selecione um recurso utilizando seu numero: ");
        int input = inputer.nextInt();
        
        while(input <= 0 || input > 5){
            System.out.println("Entrada invalida, tente novamente");
            input = inputer.nextInt();
        }
		return input;
	}
	
	public int userMenu(){
		System.out.println("Selecione a sua ocupacao pelo numero abaixo:");
        System.out.println("    1. Professor");
        System.out.println("    2. Pesquisador");
        System.out.println("    3. Administrador");
        System.out.println("    4. Estudante - Graduacao");
        System.out.println("    5. Estudante - Mestrado");
        System.out.println("    6. Estudante - Doutorado");
        System.out.println("    7. Finalizar programa");
        int input = inputer.nextInt();
        while(input <= 0 || input > 7) {
            System.out.println("Entrada invalida, tente novamente: ");
            input = inputer.nextInt();
        }
		return input;
	}
	
	
}
