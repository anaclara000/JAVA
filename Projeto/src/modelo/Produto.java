package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Produto {

	private int codProduto;
	private String nomeProduto;
	private int estoque;
	private int qtdEstoque;
	private int lucro;
	private String fornecedor;
	private double precoVenda;
	private double precoUnitario;
	private Date dtFabricacao;
	private Date dtValidade;

	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");

	// Contrutor só com Id
	public Produto(int id) {
		this.codProduto = id;
	}

	// Construtor completo
	public Produto(int codProduto, String nomeProduto, int estoque, int qtdEstoque, String fornecedor, int lucro,
			String dtFabricacao, String dtValidade, double precoUnitario) {
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.estoque = estoque;
		this.qtdEstoque = qtdEstoque;
		this.fornecedor = fornecedor;
		this.lucro = lucro;
		try {
			this.dtFabricacao = sdf.parse(dtFabricacao);
		} catch (ParseException e) {
			System.out.println(e);
		}
		try {
			this.dtValidade = sdf.parse(dtValidade);
		} catch (ParseException e) {
			System.out.println(e);
		}
		this.precoUnitario = precoUnitario;
	}

	// Construtor para receber dados do arquivo
	public Produto(String linha) throws NumberFormatException, ParseException {
		df.setCurrency(Currency.getInstance(BRASIL));

		this.codProduto = Integer.parseInt(linha.split(";")[0]);
		this.estoque = Integer.parseInt(linha.split(";")[1]);
		this.qtdEstoque = Integer.parseInt(linha.split(";")[2]);
		this.nomeProduto = linha.split(";")[3];
		this.fornecedor = linha.split(";")[4];
		this.lucro = Integer.parseInt(linha.split(";")[5]);
		try {
			
			this.precoVenda = Float.parseFloat(df.parse(linha.split(";")[6]).toString());
			this.precoUnitario = Float.parseFloat(df.parse(linha.split(";")[7]).toString());
			this.dtFabricacao = sdf.parse(linha.split(";")[8]);
			this.dtValidade = sdf.parse(linha.split(";")[9]);
		} catch (ParseException e) {
			System.out.println(e);
		}

	}

	// Getters && Setters

	

	

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(int lucro) {
		this.lucro = lucro;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(float precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Date getDtFabricacao() {
		return dtFabricacao;
	}

	public void setDtFabricacao(Date dtFabricacao) {
		this.dtFabricacao = dtFabricacao;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public String getCodProduto(String s) {
		return String.format("%d", codProduto);
	}

	public String getEstoque(String s) {
		return String.format("%d", estoque);
	}

	public String getQtdEstoque(String s) {
		return String.format("%d", qtdEstoque);
	}

	public String getLucro(String s) {
		return String.format("%d %%",lucro);
	}

	public String getPrecoVenda(String s) {
		return valorTotal();
	}

	public String getPrecoUnitario(String s) {
		return df.format(precoUnitario);
	}

	public String getDtFabricacao(String s) {
		return sdf.format(dtFabricacao);
	}

	public String getDtValidade(String s) {
		return sdf.format(dtValidade);
	}

	// Define o "id" como campo Chave
	@Override
	public int hashCode() {
		return Objects.hash(codProduto);
	}

	public int estoqueTotal() {
		int Estoque = estoque + qtdEstoque;
		return Estoque;
	}

	public String valorTotal() {
		double valor = (precoUnitario * (lucro / 100)) + precoUnitario;
		return String.format("%.2f", valor);
	}

	public String status() {
		Date hoje = new Date();
		if (hoje.getTime() > dtValidade.getTime()) {
			return "Inadequado";
		} else {
			return "Adequado";
		}
	}

	@Override
	public String toString() {
		return codProduto + "       " + nomeProduto + "\t" + estoqueTotal() + "\t" + fornecedor + "\t" + "\t"
				+ sdf.format(dtValidade) + "\t" + valorTotal() + "\t" + status() + "\n";
	}

	public String toCSV() {
		return codProduto + ";" + nomeProduto + ";" + estoque + ";" + qtdEstoque + ";" + fornecedor + ";" + lucro + "%"
				+ ";" + sdf.format(dtFabricacao) + ";" + sdf.format(dtValidade) + ";"
				+ String.format("%.2f", precoVenda) + ";" + String.format("%.2f", precoUnitario);
	}

	// Define o "id" como campo Chave
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codProduto == other.codProduto;
	}

}