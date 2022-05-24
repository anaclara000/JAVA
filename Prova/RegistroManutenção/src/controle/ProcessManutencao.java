package controle;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Manutencao;
import modelo.ManutencaoDAO;

public class ProcessManutencao {

	public static ArrayList<Manutencao> manutencao = new ArrayList<>();
	private static ManutencaoDAO md = new ManutencaoDAO();
	
	public static void abrir() {
		try {
			manutencao = md.ler();
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void salvar() {
		md.escrever(manutencao);
		abrir();
	}
}
