package controle;

import java.util.ArrayList;

import modelo.Produto;
import modelo.dao.ProdutoDAO;

public class ProdutoProcess {

	public static ArrayList<Produto> produtos = new ArrayList<>();
	private static ProdutoDAO pd = new ProdutoDAO();

	public static void abrir() {
		produtos = pd.ler();
	}

	public static void salvar() {
		pd.escrever(produtos);
	}

	public static ProdutoDAO getPd() {
		return pd;
	}
	public static void setPd(ProdutoDAO pd) {
		ProdutoProcess.pd = pd;
	}

	
//	public static void carregarTestes() {
//		ProdutoProcess.produtos.add(new Produto(1,"Arroz",24,"L & M",5,"01/01/2022","08/05/2022",6.30));
//		ProdutoProcess.produtos.add(new Produto(2,"Azeite",21,"ATTACADÃO",5,"02/01/2022","02/07/2022",73.50));
//		ProdutoProcess.produtos.add(new Produto(3,"Café",11,"TENDA",5,"03/01/2022","03/05/2022",11.55));
//		ProdutoProcess.produtos.add(new Produto(4,"Chá",55,"ANTONELLI",5,"04/01/2022","04/05/2022",103.95));		
//	}
}