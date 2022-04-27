package visao;

import controle.ProcessaDados;


public class Tela {

	public static void main(String[] args) {
	
		ProcessaDados.carregar();
		ProcessaDados.saida();
		System.out.println("Idades calculadas com sucesso");
	}

}
