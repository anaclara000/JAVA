package modelo;


public class Venda {
	
	private int idCliente;
	private float valor;
	
	public Venda(int idCliente, float valor) {
	super();
	this.idCliente = idCliente;
	this.valor = valor;
	
	}

	
	public String toString() {
		return "Venda [idCliente=" + idCliente + "valor=" + valor + "]";
	}

	
	public float getValor() {
		return (valor * 10) / 100;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	

}
