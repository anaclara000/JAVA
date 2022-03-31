package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Aparelho {
	public String nome;
	public String tipoExercicio;
	public String grupoMuscular;
	public Date dataAq;
	public double valorAq;
	public SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Aparelho() {
	}
	
	public Aparelho (String nome, String tipoExercicio, String grupoMuscular, Date dataAq, double valorAq) throws ParseException {
		this.nome = nome;
		this.tipoExercicio = tipoExercicio;
		this.grupoMuscular = grupoMuscular;
		this.dataAq = dataAq;
		this.valorAq = valorAq;
		
	}
	
	
	public int tempoUso (){
		Date now = new Date();
		return now.getYear () - dataAq.getYear();
	}
	
	
	public double depreciacao() {
		return valorAq / 60;
	}
	
	public double valorDepreciado() {
		double depreciado =  valorAq - (depreciacao() * tempoUso() * 12); 
		if(valorAq < 0) {
			return 0;
		}else {
			return depreciado;
		}
		
	}
	
	public String paraString() {
		return nome + "\t" + tipoExercicio + "\t" + grupoMuscular + "\t" + df.format(dataAq) + "\t" + valorAq;
	}
	
	public double paraString1() {
		return valorDepreciado();
	}

	
}
	

