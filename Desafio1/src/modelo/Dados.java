package modelo;

public class Dados {

	private String nome;
	private int ano;
	
	public Dados(String entrada) {
		nome = (entrada.split(";")[0]);
		ano = Integer.parseInt(entrada.split(";")[1]);
	}
	
	public String toString() {
		return nome + ";" + (2022 - ano);
	}
}
