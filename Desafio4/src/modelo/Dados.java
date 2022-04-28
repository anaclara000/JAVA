package modelo;

import java.util.ArrayList;

public class Dados {
	
	private String nome;
	private String senha;
	
	public Dados(String entrada) {
		nome = (entrada.split(";")[0]);
		senha = (entrada.split(";")[1]);
		
	}
	
	public boolean validaEmail(String email, ArrayList<Dados> contas) {
		boolean achou = false;
		for (Dados dados : contas) {
			if (this.nome.equals(dados.nome)) {
				achou = true;
				break;
			}
		}
		
		return achou;
	}
	
	public boolean validaSenha(String email, String senha, ArrayList<Dados> contas) {
		boolean validou = false;
		
		for (Dados dados : contas) {
			if (this.nome.equals(dados.nome) && this.senha.equals(dados.senha)) {
				validou = true;
				break;
			}
		}
		
		return validou;
	}

}

