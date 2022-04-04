package modelo;

public class Gato extends Animal{

	private int qtVidas = 7;

	public Gato(String especie, String nome, String raca, float peso, int qtVidas) {
	super(especie, nome, raca, peso);
	this.qtVidas = qtVidas;
		if(qtVidas >= 4) {
			System.out.println("Continue assim! " + nome + " possue " + (qtVidas) + "restantes ╰(*°▽°*)╯\n");
		} else  {
			System.out.println("Cuidado! " + nome + " possue apenas " + (qtVidas) + " vidas\n");
		
		}
	}
	

	
	public String toString() {
		return super.toString() + "\nQuantidade de vidas: " + qtVidas + "\n";
	}
	
	
}