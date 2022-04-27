package modelo;


public class Dados {
	
	private String nome;
	private String senha;
	
	public Dados(String entrada) {
		nome = (entrada.split(";")[0]);
		senha = (entrada.split(";")[1]);
		
	}
	
	public String toString() {
		return nome + ";" + senha;
	}
}

