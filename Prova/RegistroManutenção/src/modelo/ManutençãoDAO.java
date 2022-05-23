package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ManutençãoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "C:\\Users\\Desenvolvimento\\Desktop\\Prova\\RegistroManutenção\\dados\\entrada.csv";
	
	public ArrayList<Manutenção> ler() throws ParseException {
		ArrayList<Manutenção> linhas = new ArrayList<>();
		Manutenção manu;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				manu = new Manutenção(linha);
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
	
	public void escrever(ArrayList<Manutenção> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Manutenção m : linhas) {
				bw.write(m.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
