package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

public class Manutencao {

	private int id;
	private Date data;
	private String equipamento;
	private double custoHora;
	private double tempoGasto;

	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Manutencao(int id, String data, String equipamento, double custoHora, double tempoGasto) {
		this.id = id;
		try {
			this.data = sdf.parse(data);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		this.equipamento = equipamento;
		this.custoHora = custoHora;
		this.tempoGasto = tempoGasto;
	}

	public Manutencao(int id) {
		this.id = id;
	}

	public Manutencao(String linha) {
		df.setCurrency(Currency.getInstance(BRASIL));
		
		String[] temp = linha.split(";");		
			
		this.id = Integer.parseInt(temp[0]);
		try {
			this.data = sdf.parse(temp[1]);
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
		this.equipamento = temp[2];
		this.custoHora = Double.parseDouble(temp[3].replace(",", "."));
		this.tempoGasto = Double.parseDouble(temp[4]);


	}

	@Override
	public int hashCode() {
		return Objects.hash(BRASIL, custoHora, data, df, equipamento, id, sdf, tempoGasto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manutencao other = (Manutencao) obj;
		return Objects.equals(BRASIL, other.BRASIL)
				&& Double.doubleToLongBits(custoHora) == Double.doubleToLongBits(other.custoHora)
				&& Objects.equals(data, other.data) && Objects.equals(df, other.df)
				&& Objects.equals(equipamento, other.equipamento) && id == other.id && Objects.equals(sdf, other.sdf)
				&& Double.doubleToLongBits(tempoGasto) == Double.doubleToLongBits(other.tempoGasto);
	}

	public double getTotal() {
		return this.custoHora * this.tempoGasto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public double getCustoHora() {
		return custoHora;
	}

	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}

	public double getTempoGasto() {
		return tempoGasto;
	}

	public void setTempoGasto(double tempoGasto) {
		this.tempoGasto = tempoGasto;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public DecimalFormat getDf() {
		return df;
	}

	public void setDf(DecimalFormat df) {
		this.df = df;
	}

	public Locale getBRASIL() {
		return BRASIL;
	}

	public String toString() {
		return id + "\t" + sdf.format(data) + "\t" + equipamento + "\t" + custoHora
				+ "\t" + tempoGasto + "\n";
	}

	public String toCSV() {
		return id + ";" + sdf.format(data) + ";" + equipamento + ";" + custoHora + ";" + tempoGasto + "\r\n";
	}
}
