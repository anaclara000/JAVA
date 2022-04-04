package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

	
	private String nome;
	private String telefone;
	private Date nascimento;
	
	private SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public Pessoa() {
		
	}
	
	
	public Pessoa(String nome, String telefone, Date nascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.nascimento = nascimento;
	}


	public String toString() {
		return "Dados pessoais\n---------------\nNome do funcionário: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento:" + nascimento + "\n---------------\n";
	}

	public String toString2() {
		return "Dados pessoais\n---------------\nNome do funcionário: " + nome + "\nTelefone: " + telefone + "\nData de Nascimento:" + nascimento;
	}
	
}
