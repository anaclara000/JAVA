package modelo;

import java.text.ParseException;
import java.util.Date;

public class Prato {
	public String placa;
	public String marca;
	public String modelo;
	public int anoModelo;
	public int anoFab;
	public String cor;
	
	
	public Prato() {
	}
	
	public Prato(String placa, String marca, String modelo, int anoModelo, int anoFab, String cor) throws ParseException {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.anoModelo = anoModelo;
		this.anoFab = anoFab;
		this.cor = cor;
	}
	
	public String paraString() {
		return placa + "\t" + marca + "\t" + modelo + "\t" + anoModelo + "\t" + anoFab + "\t" + "\t" + "\t" + cor;
} 
}
