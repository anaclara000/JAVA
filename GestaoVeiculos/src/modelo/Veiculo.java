package modelo;

public class Veiculo {

	private String placa;
	private int anoModelo;
	private int anoFab;
	private String modelo;
	private String marca;
	private double valor;
	
	
	public Veiculo() {
		
	}
	
	public Veiculo(String placa, int anoModelo, int anoFab, String modelo, String marca, double valor) {
		this.placa = placa;
		this.anoModelo = anoModelo;
		this.anoFab = anoFab;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
	}


	public String toString() {
		return "Veiculo placa=" + placa + ", anoModelo=" + anoModelo + ", anoFab=" + anoFab + ", modelo=" + modelo
				+ ", marca=" + marca + ", valor=" + valor;
	}
	
	
	
	

}
