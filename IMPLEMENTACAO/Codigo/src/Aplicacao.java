package app;

import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		String opcao = null;
		int x = 0;
		User usuarios;
		
		do {
			System.out.println("Menu");
			System.out.println("Insira seu usuário");
			opcao = teclado.next(); 
			if (usuarios.getUsuarios().contains(opcao) == true) {
				System.out.println("Insira sua senha");
				x = teclado.nextInt();

			}
			else {
				System.out.println ("Usuário digitado inválido!");
			}
			
			switch (opcao) {
			
			}
		} while ();
		
		
		
	}
	
	public static void menu() {
		System.out.println("Menu");
		System.out.println("1 - Cadastrar Aluno");
		System.out.println("2 - Cadastrar Professor");
		System.out.println("3 - Cadastrar Curso");
		System.out.println("4 - Remover Aluno");
		System.out.println("5 - Remover Professor");
		System.out.println("Insira uma opção:");
	}
	

	
	


}
