package modelo;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Manutenção {

	private int id;
	private Date data;
	private String equipamento;
	private double custoHora;
	private double tempoGasto;

	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private DecimalFormat df = new DecimalFormat("#.00");

	public Manutenção(int id, Date data, String equipamento, double custoHora, double tempoGasto) {
		this.id = id;
		this.data = data;
		this.equipamento = equipamento;
		this.custoHora = Double.parseDouble(df.parse(custoHora).toString());
		this.tempoGasto = tempoGasto;
	}

	public Manutenção(int id) {
		this.id = id;
	}

	public Manutenção(String linha) throws ParseException {
		df.setCurrency(Currency.getInstance(BRASIL));

		this.id = Integer.parseInt(linha.split(";")[0]);
		this.data = sdf.parse(linha.split(";")[1]);
		this.equipamento = linha.split(";")[2];
		this.custoHora = Double.parseDouble(linha.split(";")[3]);
		this.tempoGasto = Double.parseDouble(linha.split(";")[4]);

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
		Manutenção other = (Manutenção) obj;
		return Objects.equals(BRASIL, other.BRASIL)
				&& Double.doubleToLongBits(custoHora) == Double.doubleToLongBits(other.custoHora)
				&& Objects.equals(data, other.data) && Objects.equals(df, other.df)
				&& Objects.equals(equipamento, other.equipamento) && id == other.id && Objects.equals(sdf, other.sdf)
				&& Double.doubleToLongBits(tempoGasto) == Double.doubleToLongBits(other.tempoGasto);
	}

	public double getTotal() {
		return custoHora * tempoGasto;
	}

	public String getId(String s) {
		return sdf.format(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData(String s) {
		return sdf.format(data);
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

	public String getCustoHora(String s) {
		return sdf.format(custoHora);
	}

	public void setCustoHora(double custoHora) {
		this.custoHora = custoHora;
	}

	public String getTempoGasto(String s) {
		return sdf.format(tempoGasto);
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
		return id + "\t" + data + "\t" + equipamento + "\t" + custoHora
				+ "\t" + tempoGasto + "\n";
	}

	public String toCSV() {
		return id + ";" + data + ";" + equipamento + ";" + custoHora + ";" + tempoGasto + "\r\n";
	}
}
