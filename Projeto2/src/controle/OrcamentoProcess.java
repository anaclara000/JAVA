package controle;

import java.util.ArrayList;

import dao.ProdutoDAO;
import modelo.Produto;

public class OrcamentoProcess {

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
		OrcamentoProcess.pd = pd;
	}
}