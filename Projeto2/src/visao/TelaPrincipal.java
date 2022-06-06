package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controle.OrcamentoProcess;

public class TelaPrincipal extends JFrame implements ActionListener {

		private static final long serialVersionUID = 1L;
		private JPanel panel;
		private JMenuBar barraMenu = new JMenuBar();
		private JMenu menuArquivo, menuSistema;
		private JMenuItem itemProdutos, itemVendas, itemLogin, itemSair;
		private ImageIcon fundo = new ImageIcon(".\\assets\\fundo.jpeg");
		private String imgIco = ".\\assets\\icone.png";
		private JLabel lbFundo = new JLabel();

		TelaPrincipal() {
			// COnfigurações do Form principal
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Mercado dois irmãos");
			setIconImage(new ImageIcon(imgIco).getImage());
			setBounds(200, 100, 700, 500);
			panel = new JPanel();
			setJMenuBar(barraMenu);
			setContentPane(panel);
			setLayout(null);

			// Barra de Menús
			menuArquivo = new JMenu("Arquivo");
			menuSistema = new JMenu("Sistema");
			barraMenu.add(menuArquivo);
			barraMenu.add(menuSistema);
			itemLogin = new JMenuItem("Login");
			itemProdutos = new JMenuItem("Produtos");
			itemVendas = new JMenuItem("Vendas");
			itemSair = new JMenuItem("Sair do Sistema");
			menuArquivo.add(itemProdutos);
			menuArquivo.add(itemVendas);
			menuSistema.add(itemSair);
			
			lbFundo.setIcon(fundo);
			lbFundo.setBounds(20,15,650,405);
			panel.add(lbFundo);

			// Ações do Menú
			itemProdutos.addActionListener(this);
			itemVendas.addActionListener(this);
			itemLogin.addActionListener(this);
			itemSair.addActionListener(this);
		}

		//Ações ao clicar nos ítens do menú.
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == itemProdutos) {
				ProdutoForm pf = new ProdutoForm();
				pf.setModal(true);
				pf.setVisible(true);
			} else if (e.getSource() == itemVendas) {
				VendasForm cf = new VendasForm();
				cf.setModal(true);
				cf.setVisible(true);
			} else if (e.getSource() == itemLogin) {
				LoginForm lf = new LoginForm();
				lf.setModal(true);
				lf.setVisible(true);
			}
			else {
				dispose();
			}
		}

		//Método Main que  abre o Form principal e carrega os arquivos
		public static void main(String[] args) {
			TelaPrincipal mf = new TelaPrincipal();
			OrcamentoProcess.abrir();
			mf.setVisible(true);
		}

	}
