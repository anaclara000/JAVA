package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controle.ProdutoProcess;
import modelo.Produto;

public class ProdutoForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel codigoProduto, estoque, qtdEstoque, nomeProduto, lucro, precoVenda, precoUnitario, dtFabricacao,
			dtValidade, rotulos, imagem, fornecedor;
	private JTextField tfcodigoProduto, tfestoque, tfqtdEstoque, tfnomeProduto, tflucro, tfprecoVenda, tfprecoUnitario,
			tfdtFabricacao, tfdtValidade, tffornecedor;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton create, read, update, delete;
	private String imgIco = "C:\\Users\\Desenvolvimento\\Desktop\\logic\\FPOO\\wk\\workspace\\Projeto\\assets\\cafe.jpg";
//	private String[] imagens = { "./assets/arroz.webp", "./assets/miau.png", "./assets/coelho.png",
//			"./assets/ornitorrinco.png" };
//	private ImageIcon icon;
	private int autoId = ProdutoProcess.produtos.size() + 1;
	private String texto = "";

	private final Color C1 = Color.orange;
//	, C2 = new Color(255,153,51);

	private final Locale BRASIL = new Locale("pt", "BR");
	private DecimalFormat df = new DecimalFormat("#.00");

	ProdutoForm() {
		setTitle("Mercado Dois Irmãos");
		setBounds(100, 100, 800, 650);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		// cor de fundo
		painel.setBackground(new Color(153, 204, 255));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		codigoProduto = new JLabel("Código do produto:");
		codigoProduto.setBounds(20, 20, 120, 30);
		painel.add(codigoProduto);
		codigoProduto.setForeground(Color.white);

		estoque = new JLabel("Novo Estoque:");
		estoque.setBounds(20, 55, 120, 30);
		painel.add(estoque);
		estoque.setForeground(Color.white);

		qtdEstoque = new JLabel("Qtd. em Estoque:");
		qtdEstoque.setBounds(285, 55, 120, 30);
		painel.add(qtdEstoque);
		qtdEstoque.setForeground(Color.white);

		fornecedor = new JLabel("Fornecedor:");
		fornecedor.setBounds(20, 90, 120, 30);
		painel.add(fornecedor);
		fornecedor.setForeground(Color.white);

		nomeProduto = new JLabel("Nome do Produto:");
		nomeProduto.setBounds(285, 20, 120, 30);
		painel.add(nomeProduto);
		nomeProduto.setForeground(Color.white);

		lucro = new JLabel("Lucro:");
		lucro.setBounds(340, 90, 120, 30);
		painel.add(lucro);
		lucro.setForeground(Color.white);

		precoVenda = new JLabel("Preço de Venda:");
		precoVenda.setBounds(20, 125, 120, 30);
		painel.add(precoVenda);
		precoVenda.setForeground(Color.white);

		precoUnitario = new JLabel("Preço Unitário:");
		precoUnitario.setBounds(285, 125, 120, 30);
		painel.add(precoUnitario);
		precoUnitario.setForeground(Color.white);

		dtFabricacao = new JLabel("Data de Fabricação:");
		dtFabricacao.setBounds(20, 165, 120, 30);
		painel.add(dtFabricacao);
		dtFabricacao.setForeground(Color.white);

		dtValidade = new JLabel("Data de Validade:");
		dtValidade.setBounds(285, 165, 120, 30);
		painel.add(dtValidade);
		dtValidade.setForeground(Color.white);

		rotulos = new JLabel("Cód|Nome|Qtd no Estoque|Fornecedor|Vencimento|Preço|Status:");
		rotulos.setBounds(20, 340, 600, 30);
		painel.add(rotulos);
		rotulos.setForeground(Color.white);

		tfcodigoProduto = new JTextField(String.format("%d", autoId));
		tfcodigoProduto.setEditable(false);
		tfcodigoProduto.setBounds(140, 25, 100, 30);
		painel.add(tfcodigoProduto);
		tfcodigoProduto.setBackground(new Color(215, 215, 215));
		tfcodigoProduto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfestoque = new JTextField();
		tfestoque.setBounds(140, 60, 100, 30);
		painel.add(tfestoque);
		tfestoque.setBackground(new Color(215, 215, 215));
		tfestoque.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfqtdEstoque = new JTextField();
		tfqtdEstoque.setBounds(405, 60, 100, 30);
		painel.add(tfqtdEstoque);
		tfqtdEstoque.setBackground(new Color(215, 215, 215));
		tfqtdEstoque.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tffornecedor = new JTextField();
		tffornecedor.setBounds(140, 95, 150, 30);
		painel.add(tffornecedor);
		tffornecedor.setBackground(new Color(215, 215, 215));
		tffornecedor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfnomeProduto = new JTextField();
		tfnomeProduto.setBounds(405, 25, 100, 30);
		painel.add(tfnomeProduto);
		tfnomeProduto.setBackground(new Color(215, 215, 215));
		tfnomeProduto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tflucro = new JTextField();
		tflucro.setBounds(405, 95, 100, 30);
		painel.add(tflucro);
		tflucro.setBackground(new Color(215, 215, 215));
		tflucro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfprecoVenda = new JTextField();
		tfprecoVenda.setBounds(140, 130, 100, 30);
		painel.add(tfprecoVenda);
		tfprecoVenda.setEnabled(false);
		tfprecoVenda.setBackground(new Color(215, 215, 215));
		tfprecoVenda.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfprecoUnitario = new JTextField();
		tfprecoUnitario.setBounds(405, 130, 100, 30);
		painel.add(tfprecoUnitario);
		tfprecoUnitario.setBackground(new Color(215, 215, 215));
		tfprecoUnitario.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfdtFabricacao = new JTextField();
		tfdtFabricacao.setBounds(140, 165, 100, 30);
		painel.add(tfdtFabricacao);
		tfdtFabricacao.setBackground(new Color(215, 215, 215));
		tfdtFabricacao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		tfdtValidade = new JTextField();
		tfdtValidade.setBounds(405, 165, 100, 30);
		painel.add(tfdtValidade);
		tfdtValidade.setBackground(new Color(215, 215, 215));
		tfdtValidade.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 375, 740, 200);
		painel.add(rolagem);

//		imagem = new JLabel();
//		imagem.setBounds(405, 60, 350, 240);
//		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
//		alternarImagens(0);
//		painel.add(imagem);

		create = new JButton("Cadastrar");
		create.setBounds(650, 20, 110, 30);
		painel.add(create);

		read = new JButton("Buscar");
		read.setBounds(650, 55, 110, 30);
		painel.add(read);

		update = new JButton("Atualizar");
		update.setBounds(650, 90, 110, 30);
		update.setEnabled(false);
		painel.add(update);

		delete = new JButton("Excluir");
		delete.setBounds(650, 125, 110, 30);

		delete.setEnabled(false);
		painel.add(delete);

		// Ouvir os eventos dos Botões, ComboBox e outros
		create.setBackground(C1);
		read.setBackground(C1);
		update.setBackground(C1);
		delete.setBackground(C1);

		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);

	}

//	private void alternarImagens(int indice) {
//		icon = new ImageIcon(new ImageIcon(imagens[indice]).getImage().getScaledInstance(350, 240, 100));
//		imagem.setIcon(icon);
//	}

	// CREATE - CRUD
	private void cadastrar() {
		if (tfcodigoProduto.getText().length() != 0 && tfestoque.getText().length() != 0
				&& tfprecoVenda.getText().length() == 0 && tfnomeProduto.getText().length() != 0
				&& tffornecedor.getText().length() != 0 && tflucro.getText().length() != 0
				&& tfprecoUnitario.getText().length() != 0 && tfdtFabricacao.getText().length() != 0
				&& tfdtValidade.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			float pU;
			try {
				pU = Float.parseFloat(df.parse(precoUnitario.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pU = 0;
			}

			ProdutoProcess.produtos.add(new Produto(autoId, nomeProduto.getText(), Integer.parseInt(estoque.getText()),
					Integer.parseInt(qtdEstoque.getText()), fornecedor.getText(), Integer.parseInt(lucro.getText()),
					dtFabricacao.getText(), dtValidade.getText(), pU));
			autoId++;
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		tfcodigoProduto.setText(null);
		tfestoque.setText(null);
		tfqtdEstoque.setText(null);
		tfnomeProduto.setText(null);
		tflucro.setText(null);
		tffornecedor.setText(null);
		tfprecoVenda.setText(null);
		tfprecoUnitario.setText(null);
		tfdtFabricacao.setText(null);
		tfdtValidade.setText(null);
	}

	private void preencherAreaDeTexto() {
		texto = ""; // Limpar a área de texto antes de preenher
		for (Produto p : ProdutoProcess.produtos) {
			texto += p.toString();
		}
		verResultados.setText(texto);
	}

	// READ - CRUD
	private void buscar() {
		String entrada = JOptionPane.showInputDialog(this, "Digite o código do produto:");

		boolean isNumeric = true;
		if (entrada != null) {
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					isNumeric = false;
				}
			}
		} else {
			isNumeric = false;
		}
		if (isNumeric) {
			int id = Integer.parseInt(entrada);
			Produto prod = new Produto(id);
			if (ProdutoProcess.produtos.contains(prod)) {
				int indice = ProdutoProcess.produtos.indexOf(prod);
				tfcodigoProduto.setText(ProdutoProcess.produtos.get(indice).getCodProduto("s"));
				tfestoque.setText(ProdutoProcess.produtos.get(indice).getEstoque("s"));
				tfqtdEstoque.setText(ProdutoProcess.produtos.get(indice).getQtdEstoque("s"));
				tfnomeProduto.setText(ProdutoProcess.produtos.get(indice).getNomeProduto());
				tffornecedor.setText(ProdutoProcess.produtos.get(indice).getFornecedor());
				tflucro.setText(ProdutoProcess.produtos.get(indice).getLucro("s"));
				tfprecoVenda.setText(ProdutoProcess.produtos.get(indice).getPrecoVenda("s"));
				tfprecoUnitario.setText(ProdutoProcess.produtos.get(indice).getPrecoUnitario("s"));
				tfdtFabricacao.setText(ProdutoProcess.produtos.get(indice).getDtFabricacao("s"));
				tfdtValidade.setText(ProdutoProcess.produtos.get(indice).getDtValidade("s"));
				create.setEnabled(false);
				update.setEnabled(true);
				delete.setEnabled(true);
				ProdutoProcess.salvar();
			} else {
				JOptionPane.showMessageDialog(this, "Produto não encontrado");
			}
		}

	}

	// UPDATE - CRUD
	private void alterar() {
		int id = Integer.parseInt(codigoProduto.getText());
		Produto prod = new Produto(id);
		int indice = ProdutoProcess.produtos.indexOf(prod);
		if (tfcodigoProduto.getText().length() != 0 && tfestoque.getText().length() != 0
				&& tfqtdEstoque.getText().length() != 0 && tfnomeProduto.getText().length() != 0
				&& tffornecedor.getText().length() != 0 && tflucro.getText().length() != 0
				&& tfprecoUnitario.getText().length() != 0 && tfdtFabricacao.getText().length() != 0
				&& tfdtValidade.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			float pU;
			try {
				pU = Float.parseFloat(df.parse(precoUnitario.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pU = 0;
			}

			ProdutoProcess.produtos.set(indice,
					new Produto(Integer.parseInt(codigoProduto.getText()), nomeProduto.getText(),
							Integer.parseInt(estoque.getText()), Integer.parseInt(qtdEstoque.getText()),
							fornecedor.getText(), Integer.parseInt(lucro.getText()), dtFabricacao.getText(),
							dtValidade.getText(), pU));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		codigoProduto.setText(String.format("%d", autoId));
		ProdutoProcess.salvar();
	}

	// DELETE - CRUD
	private void excluir() {
		int id = Integer.parseInt(codigoProduto.getText());
		Produto pet = new Produto(id);
		int indice = ProdutoProcess.produtos.indexOf(pet);
		ProdutoProcess.produtos.remove(indice);
		preencherAreaDeTexto();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		codigoProduto.setText(String.format("%d", autoId));
		ProdutoProcess.salvar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == create) {
			cadastrar();
		}
		if (e.getSource() == read) {
			buscar();
		}
		if (e.getSource() == update) {
			alterar();
		}
		if (e.getSource() == delete) {
			excluir();
		}
	}

	public static void main(String[] agrs) {
//		ProdutoProcess.abrir();
		ProdutoProcess.carregarTestes();
		new ProdutoForm().setVisible(true);
	}
}