package visao;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Cao;
import modelo.Gato;

public class Principal {

	private static Scanner scan;
	private static ArrayList<Gato> gatos = new ArrayList<>();
	private static ArrayList<Cao> caes = new ArrayList<>();
	int qtCaes = 0;
	int qtGatos = 0;
	
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 5) {
			System.out.println("👋Bem vindo! Digite uma opção para começar: \n");
			System.out.println("1-Cadastrar Cao\n2-Cadastrar Gato\n3-Listar Cao\n4-Listar Gato\n5-Sair");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				cadCao();
				break;
			case 2:
				cadGato();
				break;
			case 3:
				listarCao();
				break;
			case 4:
				listarGato();
				break;
			case 5:
				System.out.println("Obrigada por utilizar nosso sistema");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
	
	private static void cadCao() {
		
		System.out.println("---- Cadastro de Caes ----");
		System.out.print("Especie\tNome\tRaça\tPeso\tMotoqueiros");
		Cao cao = new Cao (scan.next(), scan.next(), scan.next(), scan.nextFloat(), scan.nextInt());
			caes.add(cao);
		
	}

	private static void cadGato() {
		System.out.println("---- Cadastro de Gatos ----");
		System.out.print("Especie\tNome\tRaça\tPeso\tQtd Vidas");
		Gato gato = new Gato (scan.next(), scan.next(), scan.next(), scan.nextFloat(), scan.nextInt());
			gatos.add(gato);
	}

	private static void listarCao() {
		for(Cao c: caes) {
			System.out.println(c.toString());
		}
		
	}
	
	
	private static void listarGato() {
		for(Gato g: gatos) {
			System.out.println(g.toString());
		}
		
	}

	
	
}