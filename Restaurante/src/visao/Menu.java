package visao;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import modelo.Prato;

public class Menu {

		static int pratosCadastrados = 0;
		private static Scanner scan;
		static Prato [] pratos = new Prato [100];
		
		
		public static void main(String[] args) throws IOException, ParseException{
			scan = new Scanner(System.in);
			int opcao = 0;
			while (opcao != 3) {
				System.out.println("👋👩‍🎓Bem vindo! Digite uma opção para começar: \n");
				System.out.println("1-Cadastrar Prato\n2-Listar Pratos\n3-Sair");
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
				System.out.println("---- Cadastro de pratos ----");
				System.out.println("Temos "+ pratosCadastrados + " pratos cadastrados no nosso sistema.");
				System.out.print("Digite quantos pratos serão cadastrados: ");
				int qtdPratos = scan.nextInt();
				
				
				for (int i = 0; i < qtdPratos; i++) {
		
					pratos[i] = new Prato();
					
					
					System.out.println("Digite o " + (i+1) + " ° código do prato: ");
					pratos[i].codPrato = scan.nextInt();
					
					System.out.println("Digite o tipo do " + (i+1) + "° prato : ");
					pratos[i].tipo = scan.next();
					
					System.out.println("Digite o nome do " + (i+1) + "° prato : ");
					pratos[i].nome = scan.next();
					
					System.out.println("Digite a descrição do " + (i+1) + "° prato : ");
					pratos[i].descricao = scan.next();
					
					System.out.println("Digite o preço do " + (i+1) + "° prato (Ex:00,00) : ");
					pratos[i].preco = scan.nextFloat();
					
					pratosCadastrados++;
		}
					
				System.out.println("Cód Prato\tTipo\tNome\tDescrição\tPreço");
				for (int i = 0; i < qtdPratos; i++) {
					System.out.println(pratos[i].paraString());
				}
				System.out.println("Pratos cadastrados!\n");
				
		}
			
			private static void listarVeiculos() {
				System.out.println("---- Listas de Pratos ----\n");
				System.out.println("Cód Prato\tTipo\tNome\tDescrição\tPreço");
				for (int i = 0; i < pratos.length; i++) {
					if (pratos[i] != null) {
						System.out.println(pratos[i].codPrato + "\t" + pratos[i].tipo + "\t" + pratos[i].nome + "\t" + pratos[i].descricao + "\t" + pratos[i].preco + "\n");
				}
			}
		}
	}