package controle;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Manutenção;
import modelo.ManutençãoDAO;

public class ProcessManutenção {

	public static ArrayList<Manutenção> manutenção = new ArrayList<>();
	private static ManutençãoDAO md = new ManutençãoDAO();
	
	public static void abrir() throws ParseException {
		manutenção = md.ler();
	}
	
	public static void salvar() {
		md.escrever(manutenção);
	}
}
