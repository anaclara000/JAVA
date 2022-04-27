package modelo;

import java.text.DecimalFormat;

public class Dados {

	private String nome;
	private double nota1;
	private double nota2;
	private double nota3;
	
	public Dados(String entrada) {
		nome = (entrada.split(";")[0]);
		nota1 = Double.parseDouble(entrada.split(";")[1]);
		nota2 = Double.parseDouble(entrada.split(";")[2]);
		nota3 = Double.parseDouble(entrada.split(";")[3]);
		
	}
	
	public String toString() {
		
		double md = (nota1 + nota2 + nota3) / 3;
		return nome + ";" + (new DecimalFormat("0.00").format(md));
	}
}
