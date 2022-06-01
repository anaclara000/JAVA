package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JMenuBar barraMenu = new JMenuBar();
	private JMenu menuCad, menuRelatorio, menuLucro;
	private JMenuItem itemProduto, itemLucro, itemDashBoard, itemRelatorio;
	private String imgIco = "./assets/icone.png";
	private String imgFundo = "./assets/fundo.png";
	private ImageIcon fundo;
	private JLabel lbFundo = new JLabel();

	Menu(){
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Mercado Dois Irmaos");
		setBounds(100, 100, 900, 700);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(255, 233, 213));
		setJMenuBar(barraMenu);
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		
		//background
		fundo = new ImageIcon(new ImageIcon(imgFundo).getImage().getScaledInstance(850, 605, 100));
		lbFundo.setIcon(fundo);
		lbFundo.setBounds(20, 15, 850, 605);
		painel.add(lbFundo);
		
		menuCad = new JMenu("Cadastros");
		menuRelatorio = new JMenu("Relatórios");
		barraMenu.add(menuCad);
		barraMenu.add(menuRelatorio);
		barraMenu.add(menuLucro);
		itemProduto = new JMenuItem("Cadastrar Produto");
		itemRelatorio = new JMenuItem("Relatórios de Produto");
		itemLucro = new JMenuItem("Relatório de Lucro");
		itemDashBoard = new JMenuItem("Analizar Dados - DashBoard");
		menuCad.add(itemProduto);
		menuRelatorio.add(itemRelatorio);
		menuLucro.add(itemRelatorio);
		menuRelatorio.add(itemDashBoard);
		barraMenu.setBackground(new Color(255, 233, 213));

		itemProduto.addActionListener(this);
		itemDashBoard.addActionListener(this);
		itemLucro.addActionListener(this);
		itemRelatorio.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemProduto) {
			ProdutoForm pf = new ProdutoForm();
			pf.setModal(true);
			pf.setVisible(true);
		}
	}
}
