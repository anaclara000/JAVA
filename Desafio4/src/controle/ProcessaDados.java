package controle;

import java.util.ArrayList;

import modelo.Dados;


public class ProcessaDados {

	private static DAO dao = new DAO();
	public static ArrayList<Dados> linhas = new ArrayList<>();
	
	public static void carregar() {
		linhas = dao.abrir();
		
	}

	public static void saida(String email, String senha) {
		dao.validarConta(email, senha, linhas);
	}
}
