package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Dados;

public class DAO {
	
	private BufferedWriter bw;
	private BufferedReader br;
	private String entrada = "C:\\Users\\Desenvolvimento\\Desktop\\work1\\Desafio1\\Arquivo\\Entrada.csv";
	private String saida = "C:\\Users\\Desenvolvimento\\Desktop\\work1\\Desafio1\\Arquivo\\Saida.csv";
	
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

	public void calculo(ArrayList<Dados> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(saida));
			for(Dados d : linhas) {
				bw.write(d.toString()+"\r\n");
				
		}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
