package modelo.dao;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import modelo.Produto;

public class ProdutoDAO {

	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedImage bi;
	private Produto produto;
	private String arquivo = System.getProperty("user.dir")+"\\bd\\produtos.csv";
	private String caminhoImg = System.getProperty("user.dir")+"\\imgs\\";
	private String path = "C:\\Users\\DESENVOLVIMENTO\\Desktop\\logic\\FPOO\\workform\\Projeto2\\dados\\entrada.csv";
	
	public ArrayList<Produto> ler() {
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
				bw.write(p.toCSV());
			}
			bw.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	public boolean saveImg(Produto p, File imagem) {
		boolean resultado = false;
		// String extencaoArquivo =
		// imagem.getPath().substring(imagem.getPath().lastIndexOf(".")+1,imagem.getPath().length());
		String extencaoArquivo = "png";
		String nomeImagem = "produto" + p.getCodProduto() + "." + extencaoArquivo;
		File arquivoDeSaida = new File(caminhoImg + nomeImagem);
		try {
			bi = ImageIO.read(imagem);
			ImageIO.write(bi, extencaoArquivo, arquivoDeSaida);
			resultado = true;
		} catch (IOException e) {
			System.out.println("Erro ao enviar imagem para a pasta de destino: " + e);
		}
		return resultado;
	}
	public String getImgPath(Produto p) {
		String imagem = caminhoImg + "produto" + p.getCodProduto() + ".png";
		try {
			br = new BufferedReader(new FileReader(imagem));
			return ".\\imgs\\produto" + p.getCodProduto() + ".png";
		} catch (FileNotFoundException e) {
			return ".\\assets\\default.png";
		}
	}
}