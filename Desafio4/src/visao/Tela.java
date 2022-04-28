package visao;

import java.util.Scanner;

import controle.ProcessaDados;

public class Tela {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		ProcessaDados.carregar();
		
		System.out.println("Digite seu login: ");
		String email = scan.nextLine();
		
		System.out.println("Digite sua senha: ");
		String senha = scan.nextLine();
		
		ProcessaDados.saida(email, senha);
	}
}
