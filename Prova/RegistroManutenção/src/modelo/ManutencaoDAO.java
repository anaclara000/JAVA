package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class ManutencaoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "./dados/entrada.csv";
	
	public ArrayList<Manutencao> ler() throws ParseException {
		ArrayList<Manutencao> linhas = new ArrayList<>();
		Manutencao manu;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				manu = new Manutencao(linha);
				linhas.add(manu);
				linha = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		return linhas;
	}
	
	public void escrever(ArrayList<Manutencao> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Manutencao m : linhas) {
				bw.write(m.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
