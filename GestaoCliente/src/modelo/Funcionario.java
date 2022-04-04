package modelo;

import java.util.Date;

public class Funcionario extends Pessoa{

	private int matricula;
	private double comissao;
	
	public Funcionario() {
		
	}

	public Funcionario(String nome, String telefone, Date nascimento, int matricula, double comissao) {
		super(nome,telefone,nascimento);
		this.matricula = matricula;
		this.comissao = comissao;
	}
	

	public String toString1() {
		return super.toString();
	}
	
	
	public String toString2() {
		return super.toString2() + "\nMatricula: " + matricula + "\n% da comissão: " + comissao + "% \n---------------\n";
	}
	
	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public double getComissao() {
		return comissao;
	}


	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
}
