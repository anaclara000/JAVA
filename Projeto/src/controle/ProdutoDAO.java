package controle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import modelo.Produto;

public class ProdutoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private String path = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\wk\\workspace\\Projeto\\dados\\projeto.csv";
	
	public ArrayList<Produto> ler() throws NumberFormatException, ParseException {
		ArrayList<Produto> linhas = new ArrayList<>();
		Produto prod;
		try {
			br = new BufferedReader(new FileReader(path));
			String linha = br.readLine();
			while(linha != null) {
				prod = new Produto(linha);
				linhas.add(prod);
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
	
	public void escrever(ArrayList<Produto> linhas) {
		try {
			bw = new BufferedWriter(new FileWriter(path));
			for (Produto p : linhas) {
				bw.write(p.toCSV()+"\n");
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}