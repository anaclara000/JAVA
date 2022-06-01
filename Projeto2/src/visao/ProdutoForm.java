package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import controle.ProdutoProcess;
import modelo.Produto;

public class ProdutoForm extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final File path = null;
	private JPanel painel;
	private JLabel text, codigoProduto, estoque, nomeProduto, lucro, precoVenda, precoUnitario, dtFabricacao, dtValidade,
			rotulos, fornecedor, imagem;
	private JTextField tftext, tfcodigoProduto, tfestoque, tfnomeProduto, tflucro, tfprecoVenda, tfprecoUnitario,
			tfdtFabricacao, tfdtValidade, tffornecedor;
	private JScrollPane rolagem;
	private JTextArea verResultados;
	private JButton create, read, update, delete, carregar, btSalvar;
	private String imgIco = ".\\assets\\2.png";
	private int autoId = ProdutoProcess.produtos.size() + 1;
	private ImageIcon img;
	private Image image;
	private Image newImg;
	private String texto = "";

	private final Color C1 = Color.orange;
	private final Color C2 = new Color(238, 238, 238);

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
		
		text = new JLabel("Cadastro e Consulta");
		text.setBounds(310, 5, 250, 30);
		text.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
		text.setForeground(new Color(180,112,54));
		painel.add(text);

		codigoProduto = new JLabel("Código do produto:");
		codigoProduto.setBounds(20, 45, 120, 30);
		painel.add(codigoProduto);
		tfcodigoProduto = new JTextField(String.format("%d", autoId));
		tfcodigoProduto.setEditable(false);
		tfcodigoProduto.setBounds(140, 45, 300, 30);
		painel.add(tfcodigoProduto);
		tfcodigoProduto.setBackground(C2);

		nomeProduto = new JLabel("Nome do Produto:");
		nomeProduto.setBounds(20, 80, 120, 30);
		painel.add(nomeProduto);
		tfnomeProduto = new JTextField();
		tfnomeProduto.setBounds(140, 80, 300, 30);
		painel.add(tfnomeProduto);
		tfnomeProduto.setBackground(C2);
		tfnomeProduto.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		estoque = new JLabel("Estoque:");
		estoque.setBounds(20, 115, 120, 30);
		painel.add(estoque);
		tfestoque = new JTextField();
		tfestoque.setBounds(140, 115, 100, 30);
		painel.add(tfestoque);
		tfestoque.setBackground(C2);
		tfestoque.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		fornecedor = new JLabel("Fornecedor:");
		fornecedor.setBounds(20, 150, 120, 30);
		painel.add(fornecedor);
		tffornecedor = new JTextField();
		tffornecedor.setBounds(140, 150, 300, 30);
		painel.add(tffornecedor);
		tffornecedor.setBackground(C2);
		tffornecedor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		lucro = new JLabel("Margem de lucro:");
		lucro.setBounds(20, 185, 120, 30);
		painel.add(lucro);
		tflucro = new JTextField();
		tflucro.setBounds(140, 185, 100, 30);
		painel.add(tflucro);
		tflucro.setBackground(C2);
		tflucro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		precoUnitario = new JLabel("Preço Unitário:");
		precoUnitario.setBounds(20, 220, 120, 30);
		painel.add(precoUnitario);
		tfprecoUnitario = new JTextField();
		tfprecoUnitario.setBounds(140, 220, 100, 30);
		painel.add(tfprecoUnitario);
		tfprecoUnitario.setBackground(C2);
		tfprecoUnitario.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


		dtFabricacao = new JLabel("Data de Fabricação:");
		dtFabricacao.setBounds(20, 255, 120, 30);
		painel.add(dtFabricacao);
		tfdtFabricacao = new JTextField();
		tfdtFabricacao.setBounds(140, 255, 120, 30);
		painel.add(tfdtFabricacao);
		tfdtFabricacao.setBackground(C2);
		tfdtFabricacao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		dtValidade = new JLabel("Data de Validade:");
		dtValidade.setBounds(20, 295, 120, 30);
		painel.add(dtValidade);
		tfdtValidade = new JTextField();
		tfdtValidade.setBounds(140, 295, 120, 30);
		painel.add(tfdtValidade);
		tfdtValidade.setBackground(C2);
		tfdtValidade.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		precoVenda = new JLabel("Preço de Venda:");
		precoVenda.setBounds(20, 330, 120, 30);
		painel.add(precoVenda);
		tfprecoVenda = new JTextField();
		tfprecoVenda.setBounds(140, 330, 120, 30);
		painel.add(tfprecoVenda);
		tfprecoVenda.setEditable(false);
		tfprecoVenda.setBackground(new Color(119, 221, 119));
		tfprecoVenda.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		rotulos = new JLabel(
				"Cód           |          Nome         |     Estoque     |       Fornecedor       |   Vencimento  |        Preço       |         Status:");
		rotulos.setBounds(20, 400, 900, 30);
		painel.add(rotulos);
		rotulos.setForeground(Color.black);

		verResultados = new JTextArea();
		verResultados.setEditable(false);
		verResultados.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		preencherAreaDeTexto();
		rolagem = new JScrollPane(verResultados);
		rolagem.setBounds(20, 410, 740, 200);
		painel.add(rolagem);

		imagem = new JLabel();
		imagem.setBounds(500, 130, 260, 200);
		painel.add(imagem);
		imagem.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

		create = new JButton("Cadastrar");
		create.setBounds(20, 370, 110, 30);
		painel.add(create);

		read = new JButton("Buscar");
		read.setBounds(140, 370, 110, 30);
		painel.add(read);

		update = new JButton("Atualizar");
		update.setBounds(260, 370, 110, 30);
		update.setEnabled(false);
		painel.add(update);

		delete = new JButton("Excluir");
		delete.setBounds(380, 370, 110, 30);

		delete.setEnabled(false);
		painel.add(delete);

		carregar = new JButton("Carregar imagem");
		carregar.setBounds(500, 90, 260, 30);
		painel.add(carregar);

		// Ouvir os eventos dos Botões, ComboBox e outros
//		create.setBackground(C1);
//		read.setBackground(C1);
//		update.setBackground(C1);
//		delete.setBackground(C1);

		create.addActionListener(this);
		read.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		carregar.addActionListener(this);
	}

	private Border BorderFactory(Color color) {
		// TODO Auto-generated method stub
		return null;
	}

	// CREATE - CRUD
	private void cadastrar() {
		if (tfcodigoProduto.getText().length() != 0 && tfestoque.getText().length() != 0
				&& tfnomeProduto.getText().length() != 0 && tffornecedor.getText().length() != 0
				&& tflucro.getText().length() != 0 && tfprecoUnitario.getText().length() != 0
				&& tfdtFabricacao.getText().length() != 0 && tfdtValidade.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			float pU;
			try {
				pU = Float.parseFloat(df.parse(tfprecoUnitario.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pU = 0;
			}

			ProdutoProcess.produtos.add(new Produto(autoId, tfnomeProduto.getText(),
					Integer.parseInt(tfestoque.getText()), tffornecedor.getText(), Integer.parseInt(tflucro.getText()),
					tfdtFabricacao.getText(), tfdtValidade.getText(), pU));
			autoId++;
			ProdutoProcess.salvar();
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	private void limparCampos() {
		tfcodigoProduto.setText(null);
		tfestoque.setText(null);
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
				tfnomeProduto.setText(ProdutoProcess.produtos.get(indice).getNomeProduto());
				tffornecedor.setText(ProdutoProcess.produtos.get(indice).getFornecedor());
				tflucro.setText(ProdutoProcess.produtos.get(indice).getLucro("s"));
				tfprecoUnitario.setText(ProdutoProcess.produtos.get(indice).getPrecoUnitario("s"));
				tfdtFabricacao.setText(ProdutoProcess.produtos.get(indice).getDtFabricacao("s"));
				tfdtValidade.setText(ProdutoProcess.produtos.get(indice).getDtValidade("s"));
				tfprecoVenda.setText(ProdutoProcess.produtos.get(indice).valorTotal());
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
		int id = Integer.parseInt(tfcodigoProduto.getText());
		Produto prod = new Produto(id);
		int indice = ProdutoProcess.produtos.indexOf(prod);
		if (tfcodigoProduto.getText().length() != 0 && tfestoque.getText().length() != 0
				&& tfnomeProduto.getText().length() != 0 && tffornecedor.getText().length() != 0
				&& tflucro.getText().length() != 0 && tfprecoUnitario.getText().length() != 0
				&& tfdtFabricacao.getText().length() != 0 && tfdtValidade.getText().length() != 0) {

			// Converter o peso no formato Brasileiro usando virgula como decimal
			df.setCurrency(Currency.getInstance(BRASIL));
			float pU;
			try {
				pU = Float.parseFloat(df.parse(tfprecoUnitario.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				pU = 0;
			}

			ProdutoProcess.produtos.set(indice,
					new Produto(Integer.parseInt(tfcodigoProduto.getText()), tfnomeProduto.getText(),
							Integer.parseInt(tfestoque.getText()), tffornecedor.getText(),
							Integer.parseInt(tflucro.getText()), tfdtFabricacao.getText(), tfdtValidade.getText(), pU));
			preencherAreaDeTexto();
			limparCampos();
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfcodigoProduto.setText(String.format("%d", autoId));
		ProdutoProcess.salvar();
	}

	// DELETE - CRUD
	private void excluir() {
		int id = Integer.parseInt(tfcodigoProduto.getText());
		Produto prod = new Produto(id);
		int indice = ProdutoProcess.produtos.indexOf(prod);
		ProdutoProcess.produtos.remove(indice);
		preencherAreaDeTexto();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfcodigoProduto.setText(String.format("%d", autoId));
		ProdutoProcess.salvar();
	}

	private void carregarImagem() {
		File path = null;
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens tipo: png, jpg ou jpeg",
				new String[] { "png", "jpg", "jpeg" });
		fc.setFileFilter(filter);
		if (fc.showOpenDialog(this) != 1) {
			path = fc.getSelectedFile();
			img = new ImageIcon(path.getAbsolutePath());
			imagem.setIcon(new ImageIcon(img.getImage().getScaledInstance(300, 250, java.awt.Image.SCALE_SMOOTH)));
		}
		int id = Integer.parseInt(tfcodigoProduto.getText());
		Produto prod = new Produto(id);
		if (path != null) {
			if (ProdutoProcess.getPd().saveImg(prod, path)) {
				JOptionPane.showMessageDialog(this, "Alterada com sucesso.");
			}
		} else {
			dispose();
		}
	}

	public void setModal(boolean b) {

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
		if (e.getSource() == carregar) {
			carregarImagem();
		}
		if (btSalvar == e.getSource()) {
			int id = Integer.parseInt(tfcodigoProduto.getText());
			Produto prod = new Produto(id);
			int indice = ProdutoProcess.produtos.indexOf(prod);
			if (path != null) {
				if (ProdutoProcess.getPd().saveImg(prod, path)) {
					JOptionPane.showMessageDialog(this, "Alterada com sucesso.");
					this.dispose();
				}
			} else {
				dispose();
			}
		} else {
			this.dispose();
		}
	}

	public static void main(String[] agrs) {
		ProdutoProcess.abrir();
		new ProdutoForm().setVisible(true);
	}
}