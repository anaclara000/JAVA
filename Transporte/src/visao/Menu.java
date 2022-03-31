package visao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import modelo.Prato;


public class Menu {
	
	static int veiculosCadastrados = 0;
	private static Scanner scan;
	static Prato [] veiculos = new Prato [100];
	
	
	public static void main(String[] args) throws IOException, ParseException{
		scan = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("👋👩‍🎓Bem vindo! Digite uma opção para começar: \n");
			System.out.println("1-Cadastrar Veiculo\n2-Listar Veiculos\n3-Sair");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				cadVeiculo();
				break;
			case 2:
				listarVeiculos();
				break;
			case 3:
				System.out.println("Obrigada por utilizar nosso sistema");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
		
		private static void cadVeiculo() {
			System.out.println("---- Cadastro de veiculos ----");
			System.out.print("Digite quantos veiculos serão cadastrados: ");
			int qtdVeiculos = scan.nextInt();
			
			
			for (int i = 0; i < qtdVeiculos; i++) {
	
				veiculos[i] = new Prato();
				
				
				System.out.println("Digite a " + (i+1) + " ª placa: ");
				veiculos[i].placa = scan.next();
				
				System.out.println("Digite a marca do " + (i+1) + "° veiculo : ");
				veiculos[i].marca = scan.next();
				
				System.out.println("Digite o modelo do " + (i+1) + "° veiculo : ");
				veiculos[i].modelo = scan.next();
				
				System.out.println("Digite o ano do modelo do " + (i+1) + "° veiculo : ");
				veiculos[i].anoModelo = scan.nextInt();
				
				System.out.println("Digite o ano de fabricação do " + (i+1) + "° veiculo : ");
				veiculos[i].anoFab = scan.nextInt();
				
				System.out.println("Digite a cor do " + (i+1) + "° veiculo : ");
				veiculos[i].cor = scan.next();
				
				veiculosCadastrados++;
	}
				
			System.out.println("Placa\tMarca\tModelo\tAno de modelo\tAno de fabricação\tCor");
			for (int i = 0; i < qtdVeiculos; i++) {
				System.out.println(veiculos[i].paraString());
			}
			System.out.println("Veiculos cadastrados!\n");
			
	}
		
		private static void listarVeiculos() {
			System.out.println("---- Listas de Veiculos ----\n");
			System.out.println("Placa\tMarca\tModelo\tAno de modelo\tAno de fabricação\tCor");
			for (int i = 0; i < veiculos.length; i++) {
				if (veiculos[i] != null) {
					System.out.println(veiculos[i].placa + "\t" + veiculos[i].marca + "\t" + veiculos[i].modelo + "\t" + veiculos[i].anoModelo + "\t" + veiculos[i].anoFab + "\t" + "\t" + "\t" +veiculos[i].cor + "\n");
			}
		}
	}
}


