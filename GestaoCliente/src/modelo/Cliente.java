package modelo;

import java.util.Date;

public class Cliente extends Pessoa{

	private int id;
	private double creditoLimite;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String telefone, Date nascimento,int id, double creditoLimite) {
		super(nome,telefone,nascimento);
		this.id = id;
		this.creditoLimite = creditoLimite;
	}


	public String toString() {
		return "Cliente [id=" + id + ", creditoLimite=" + creditoLimite + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getCreditoLimite() {
		return creditoLimite;
	}


	public void setCreditoLimite(double creditoLimite) {
		this.creditoLimite = creditoLimite;
	}
	
	
}
