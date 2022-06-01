package visao;

import controle.ProdutoProcess;
import modelo.Produto;

public class TesteUnitario {

	public static void main(String[] args) {
//		ProdutoProcess.carregarTestes();
		ProdutoProcess.abrir();
		for (Produto p : ProdutoProcess.produtos) {
			System.out.println(p.toString()+"\n");
		}
	}

}
