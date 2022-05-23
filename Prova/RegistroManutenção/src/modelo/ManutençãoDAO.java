package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Manuten��oDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "C:\\Users\\Desenvolvimento\\Desktop\\Prova\\RegistroManuten��o\\dados\\entrada.csv";
	
	public ArrayList<Manuten��o> ler() throws ParseException {
		ArrayList<Manuten��o> linhas = new ArrayList<>();
		Manuten��o manu;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				manu = new Manuten��o(linha);
				linhas.add(manu);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Manuten��o> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Manuten��o m : linhas) {
				bw.write(m.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
