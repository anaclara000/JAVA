package modelo;


public class Cao extends Animal {
	
	private int qtMotoqueirosAtacado;

	public Cao(String especie, String nome, String raca, float peso, int qtMotoqueirosAtacado ) {
	super(especie, nome, raca, peso);
	this.qtMotoqueirosAtacado = qtMotoqueirosAtacado;
		if(qtMotoqueirosAtacado > 3) {
			System.out.println("Parabéns! " + nome + " mordeu muitos motoqueiros! ╰(*°▽°*)╯\n");
		} else {
			System.out.println(nome + " precisa morder mais motoqueiros! (┬┬﹏┬┬)\n");
			
		}
	}

	public String toString() {
		return super.toString() + "\nMotoqueiros Atacados: " + qtMotoqueirosAtacado + "\n";
	}
	
	
}