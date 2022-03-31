package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.Aparelho;

public class Menu {

	static Aparelho[] aparelhos = new Aparelho [99999];
	private static Scanner scan;
	static int aparelhosCadastrados = 0;
	
	public static void main(String[] args) throws ParseException {
		scan = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 3) {
			System.out.println("👋👩‍🎓Bem vindo! Digite uma opção para começar: \n");
			System.out.println("1-Cadastrar Aparelho\n2-Listar Aparelhos\n3-Sair");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				cadastrarAparelho();
				break;
			case 2:
				listarAparelhos();
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
	
	private static void cadastrarAparelho() throws ParseException {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("---- Cadastro de Aparelhos ----");
		System.out.println("Temos "+ aparelhosCadastrados + " aparelhos cadastrados no nosso sistema.");
		System.out.print("Digite quantos aparelhos serão cadastrados: ");
		int qtdAparelhos = scan.nextInt();
		
		
		for (int i = 0; i < qtdAparelhos; i++) {

			aparelhos[i] = new Aparelho();
			
			
			System.out.println("Digite o " + (i+1) + " ° nome do aparelho: ");
			aparelhos[i].nome = scan.next();
			
			System.out.println("Digite o tipo do exercicio: ");
			aparelhos[i].tipoExercicio = scan.next();
			
			System.out.println("Digite o grupo muscular trabalhado nesse aparelho: ");
			aparelhos[i].grupoMuscular = scan.next();
			
			System.out.println("Digite a data de aquisição: ");
			aparelhos[i].dataAq = DateFor.parse(scan.next());
			
			System.out.println("Digite o valor da aquisição: ");
			aparelhos[i].valorAq = scan.nextDouble();
			
			aparelhosCadastrados++;
			
}
		
		
			
		System.out.println("Nome\tTipo do Ex.\tGrupo Mus.\tData da aq.\tValor da Aq.");
		for (int i = 0; i < qtdAparelhos; i++) { 
			System.out.println(aparelhos[i].paraString() + "\nValor do item para venda: " + aparelhos[i].paraString1());
		}
		System.out.println("Aparelhos cadastrados! Obrigada.\n");
		
}
	
	
	
	private static void listarAparelhos() {
		System.out.println("---- Listas de Aparelhos ----\n");
		System.out.println("Nome\tTipo do Ex.\tGrupo Mus.\tData da aq.\tValor da Aq\tValor do item (hoje)");
		for (int i = 0; i < aparelhos.length; i++) {
			if (aparelhos[i] != null) {
				System.out.println(aparelhos[i].nome + "\t" + aparelhos[i].tipoExercicio + "\t" + aparelhos[i].grupoMuscular + "\t" + aparelhos[i].dataAq + "\t" + aparelhos[i].valorAq + "\t" + aparelhos[i].paraString1() + "\n");
		}
	}
}
		
		
	

	
	
}


