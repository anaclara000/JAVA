package modelo;

import java.text.ParseException;

public class Prato {
		public int codPrato;
		public String tipo;
		public String nome;
		public String descricao;
		public float preco;
		
		public Prato() {
		}
		
		public Prato(int codPrato, String tipo, String nome, String descricao, float preco) throws ParseException {
			this.codPrato = codPrato;
			this.tipo = tipo;
			this.nome = nome;
			this.descricao = descricao;
			this.preco = preco;
		}
		
		public String paraString() {
			return codPrato + "\t" + tipo + "\t" + nome + "\t" + descricao + "\t" + preco;
	} 
		
	
}
