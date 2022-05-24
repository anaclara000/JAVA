package controle;

import java.text.ParseException;
import java.util.ArrayList;

import modelo.Manuten��o;
import modelo.Manuten��oDAO;

public class ProcessManuten��o {

	public static ArrayList<Manuten��o> manuten��o = new ArrayList<>();
	private static Manuten��oDAO md = new Manuten��oDAO();
	
	public static void abrir() {
		try {
			manuten��o = md.ler();
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
	}
	
	public static void salvar() {
		md.escrever(manuten��o);
		abrir();
	}
}
