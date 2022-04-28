package controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Dados;


public class DAO {
		
	private BufferedReader br;
	private String entrada ="C:\\Users\\Desenvolvimento\\Desktop\\work1\\Desafio4\\Arquivo\\usuarios.csv";
	
	public ArrayList<Dados> abrir(){
		ArrayList<Dados> linhas = new ArrayList<>();
		Dados d;
		
		try {
			br = new BufferedReader(new FileReader(entrada));
			String l = br.readLine();
			
			while(l != null) {
				d = new Dados (l);
				linhas.add(d);
				l = br.readLine();
			}
			br.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return linhas;
	}
	
	public boolean validarConta(String email, String senha, ArrayList<Dados> linhas) {
		Dados d = new Dados(email + ";" + senha);
		
		if(d.validaEmail(email, linhas)) {
			if (d.validaSenha(email, senha, linhas)) {
				System.out.println("Acesso permitido");
				return true;
			} else {
				System.out.println("Acesso negado");
				return false;
			}
		} else {
			System.out.println("usuário não encontrado");
			return false;
		}
	}

}


