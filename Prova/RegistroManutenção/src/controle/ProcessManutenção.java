package controle;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Manuten��o;
import modelo.Manuten��oDAO;

public class ProcessManuten��o {

	public static ArrayList<Manuten��o> manuten��o = new ArrayList<>();
	private static Manuten��oDAO md = new Manuten��oDAO();
	
	public static void abrir() throws ParseException {
		manuten��o = md.ler();
	}
	
	public static void salvar() {
		md.escrever(manuten��o);
	}
}
