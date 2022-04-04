package visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import modelo.Cliente;
import modelo.Funcionario;
import modelo.Venda;


public class Principal {
	
	private static Scanner scan;
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static ArrayList<Venda> vendas = new ArrayList<>();
	static int qtFuncio = 0;
	static int qtClientes = 0;
	

	public static void main(String[] args) throws ParseException {
		
		scan = new Scanner(System.in);
		int opcao = 0;
		while (opcao != 6) {
			System.out.println("👋Bem vindo! Digite uma opção para começar: \n");
			System.out.println("1-Cadastrar Cliente\n2-Cadastrar Funcionário\n3-Listar Cliente\n4-Listar Funcionário\n5-Cadastrar Venda\n6-Sair");
			opcao = scan.nextInt();
			switch (opcao) {
			case 1:
				cadCliente();
				break;
			case 2:
				cadFuncio();
				break;
			case 3:
				listarCliente();
				break;
			case 4:
				listarFuncio();
				break;
			case 5:
				cadVenda();
				break;
			case 6:
				System.out.println("Obrigada por utilizar nosso sistema");
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}

	

	private static void cadVenda() {
		System.out.println("---- Cadastro de Vendas ----");
		System.out.println("Digite a matricula do funcionário: ");
		int matricula = scan.nextInt();
		
		for(Funcionario f: funcionarios) {
			if (f.getMatricula() == matricula) {
				Funcionario funcionario = new Funcionario();
				
				System.out.println(f.toString1());
				System.out.println("Digite as seguintes informações: ");
				System.out.print("Id Cliente\tValor venda.");
				Venda venda = new Venda (scan.nextInt(), scan.nextFloat());
					vendas.add(venda);
						
					for(Venda v: vendas) {
						System.out.println("Sua comissão é: " + v.getValor());
			}
				
		} else {
			System.out.println("Funcionario não encontrado");
			break;
		}
	}
}




	private static void cadCliente() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("---- Cadastro de Cliente ----");
		System.out.println("Temos " + qtClientes + " clientes cadastrados no nosso sistema");
		System.out.print("Nome\tTelefone\tDt nasci.\tID\tCrédito");
		Cliente cliente = new Cliente (scan.next(), scan.next(), df.parse(scan.next()), scan.nextInt(), scan.nextDouble());
			clientes.add(cliente);
		
			qtClientes++;
	}
	
	private static void listarCliente() {
		for(Cliente c: clientes) {
			System.out.println(c.toString());
		}
		
	}
	
	private static void cadFuncio() throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("---- Cadastro de Funcionario ----");
		System.out.println("Temos " + qtFuncio + " funcionários cadastrados no nosso sistema");
		System.out.print("Nome\tTelefone\tDt nasci.\tMatricula\t% comissao");
		Funcionario funcionario = new Funcionario (scan.next(), scan.next(), df.parse(scan.next()), scan.nextInt(), scan.nextDouble());
			funcionarios.add(funcionario);
		
			qtFuncio++;
	}

	private static void listarFuncio() {
		for(Funcionario f: funcionarios) {
			System.out.println(f.toString2());
		}
		
	}


	


	


	
}


