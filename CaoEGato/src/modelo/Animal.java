package modelo;

public class Animal {

	private String especie;
	private String nome;
	private String raca;
	private float peso;

	public Animal(String especie, String nome, String raca, float peso) {
		this.especie = especie;
		this.nome = nome;
		this.raca = raca;
		this.peso = peso;
	}

	public String toString() {
		return "Nome do animal: " + nome + "\n----------" + "\nEspecie: "+ especie +  "\nRaça: " + raca + "\nPeso: " + peso + "KG";
	}

		
}
