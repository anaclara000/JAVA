package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controle.ProcessManutenção;
import modelo.Manutenção;

public class FormManutenção extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, data, equip, custoHora, tempoGasto;
	private JTextField tfid, tfdata, tfcustoHora , tftempoGasto;
	private JComboBox cbequip;
	private DefaultTableModel tableModel;
	private JButton create, read, update, delete;
	private JTable table;
	private JScrollPane rolagem;
	
	private String imgIco = "C:\\Users\\Usuario\\Downloads\\Ana\\JAVA\\Prova\\RegistroManutenção\\assets\\logo.png";
	private int autoId = ProcessManutenção.manutenção.get(ProcessManutenção.manutenção.size() - 1).getId() + 1;
	private DecimalFormat df = new DecimalFormat("#.00");
	private final Locale BRASIL = new Locale("pt", "BR");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	

	FormManutenção(){
		setTitle("Regitro de Manutenção");
		setBounds(100, 100, 800, 650);
		setIconImage(new ImageIcon(imgIco).getImage());
		painel = new JPanel();
		painel.setBackground(new Color(128, 128,128));
		setContentPane(painel);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		id = new JLabel("ID:");
		id.setBounds(20, 25, 120, 30);
		tfid = new JTextField(String.format("%d", autoId));
		tfid.setEditable(false);
		tfid.setEditable(false);
		tfid.setBounds(140, 25, 40, 30);
		tfid.setBackground(new Color(215, 215, 215));
		
		equip = new JLabel("Nome do Produto:");
		equip.setBounds(20, 60, 120, 30);
		cbequip = new JComboBox<String>(new String[] { "Equip1", "Equip2", "Equip3" });
		cbequip.setBounds(140, 60, 300, 30);
		cbequip.setBackground(new Color(215, 215, 215));
		
		data = new JLabel("Data de Hoje:");
		data.setBounds(20, 95, 120, 30);
		tfdata = new JTextField();
		tfdata.setBounds(140, 95, 120, 30);
		painel.add(tfdata);
		tfdata.setBackground(new Color(215, 215, 215));
		
		custoHora = new JLabel("Custo Hora:");
		custoHora.setBounds(20, 130, 120, 30);
		tfcustoHora = new JTextField();
		tfcustoHora.setBounds(140, 130, 100, 30);
		tfcustoHora.setBackground(new Color(215, 215, 215));
		
		tempoGasto = new JLabel("Tempo gasto:");
		tempoGasto.setBounds(20, 195, 120, 30);
		tftempoGasto = new JTextField();
		tftempoGasto.setBounds(140, 195, 100, 30);
		tftempoGasto.setBackground(new Color(215, 215, 215));
		
		
		painel.add(id);
		painel.add(tfid);
		painel.add(data);
		painel.add(tfdata);
		painel.add(equip);
		painel.add(cbequip);
		painel.add(custoHora);
		painel.add(tfcustoHora);
		painel.add(tempoGasto);
		painel.add(tftempoGasto);
		
		table = new JTable();
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Data");
		tableModel.addColumn("Equipamento");
		tableModel.addColumn("Custo Hora");
		tableModel.addColumn("Tempo Gasto");
		tableModel.addColumn("Total");
		
		if (ProcessManutenção.manutenção.size() != 1) {
			preencherTabela();
		}
		table = new JTable(tableModel);
		table.setEnabled(false);
		rolagem = new JScrollPane(table);
		rolagem.setBounds(20, 310, 740, 230);
		painel.add(rolagem);

		
		create = new JButton("Cadastrar");
		create.setBounds(650, 20, 110, 30);
		painel.add(create);

		read = new JButton("Buscar");
		read.setBounds(650, 55, 110, 30);
		painel.add(read);

		update = new JButton("Alterar");
		update.setBounds(650, 90, 110, 30);
		update.setEnabled(false);
		painel.add(update);

		delete = new JButton("Excluir");
		delete.setBounds(650, 125, 110, 30);

		delete.setEnabled(false);
		painel.add(delete);
		
		
		
		create.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		cadastrar();
        	}
        });
		read.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		buscar();
        	}
        });
		update.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		alterar();
        	}
        });
		delete.addActionListener((ActionListener) new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		excluir();
        	}
        });
		
	}
	
	int obterEquipamento(String equipamento) {
		switch (equipamento) {
		case "Equip1":
			return 0;
		case "Equip2":
			return 1;
		case "Equip3":
			return 2;
		default:
			return -1;
		}
	}
	
	private void cadastrar() {
		if(tfid.getText().length() != 0 && tfdata.getText().length() != 0 &&
				tfcustoHora.getText().length() != 0 && tftempoGasto.getText().length() != 0) {
			
			df.setCurrency(Currency.getInstance(BRASIL));
			double custo;
			double hora;
			try {
				hora = Double.parseDouble(df.parse(tftempoGasto.getText()).toString());
				custo = Double.parseDouble(df.parse(tfcustoHora.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				custo = 0;
				hora = 0;
			}

			ProcessManutenção.manutenção.add(new Manutenção(autoId,  tfdata.getText(),
					cbequip.getSelectedItem().toString(), custo, hora));
			autoId = ProcessManutenção.manutenção.get(ProcessManutenção.manutenção.size() - 1).getId() + 1;
			preencherTabela();
			limparCampos();
			ProcessManutenção.salvar();
			
		}else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}
	


	
	private void buscar() {
		String text = JOptionPane.showInputDialog(this, "Digite o id do item");
		try {
			int id = Integer.parseInt(text);
			
			for (Manutenção m : ProcessManutenção.manutenção) {
				if (m.getId() == id) {
					int indice = ProcessManutenção.manutenção.indexOf(m);
			tfid.setText(String.format("%d", ProcessManutenção.manutenção.get(indice).getId()));
			tfdata.setText(sdf.format(ProcessManutenção.manutenção.get(indice).getData()));
			cbequip.setSelectedIndex(obterEquipamento(ProcessManutenção.manutenção.get(indice).getEquipamento()));
			tfcustoHora.setText((String.format("%.2f" , ProcessManutenção.manutenção.get(indice).getCustoHora())));
			tftempoGasto.setText((String.format("%.2f", ProcessManutenção.manutenção.get(indice).getTempoGasto())));
			create.setEnabled(false);
			update.setEnabled(true);
			delete.setEnabled(true);
			ProcessManutenção.salvar();
					}
				}
			} catch (Exception e) {
		JOptionPane.showMessageDialog(this, "Id inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
}
	private void alterar() {
		int id = Integer.parseInt(tfid.getText());
		Manutenção manu = new Manutenção(id);
		int indice = ProcessManutenção.manutenção.indexOf(manu);
		if (tfid.getText().length() != 0 && tfdata.getText().length() != 0 && 
				tfcustoHora.getText().length() != 0 && tftempoGasto.getText().length() != 0)  {
			Manutenção tempManu = new Manutenção(Integer.parseInt(tfid.getText()), tfdata.getText(), cbequip.getSelectedItem().toString(),(Double.parseDouble(tfcustoHora.getText().replace(",", "."))), (Double.parseDouble(tftempoGasto.getText().replace(",", "."))));
			for (Manutenção m : ProcessManutenção.manutenção) {
				if (m.getId() == tempManu.getId()) {
					m.setId(tempManu.getId());
					m.setData(tempManu.getData());
					m.setEquipamento(tempManu.getEquipamento());
					m.setTempoGasto(tempManu.getTempoGasto());
					m.setCustoHora(tempManu.getCustoHora());
					
				}
			}
			df.setCurrency(Currency.getInstance(BRASIL));
			double custo;
			double hora;
			try {
				hora = Double.parseDouble(df.parse(tftempoGasto.getText()).toString());
				custo = Double.parseDouble(df.parse(tfcustoHora.getText()).toString());
			} catch (ParseException e) {
				System.out.println(e);
				custo = 0;
				hora = 0;
			}
				preencherTabela();
				limparCampos();
				ProcessManutenção.salvar();
				
				create.setEnabled(true);
				update.setEnabled(false);
				delete.setEnabled(false);
				tfid.setText(String.format("%d", autoId));
				ProcessManutenção.salvar();
			
		} else {
			JOptionPane.showMessageDialog(this, "Favor Preencher todas as informações");
		}
	}
	
	private void limparCampos() {
		tfid.setText(String.format("%d",autoId));
		tfdata.setText(null);
		cbequip.setSelectedIndex(0);
		tfcustoHora.setText(null);
		tftempoGasto.setText(null);

	}

	private void preencherTabela() {
		int totLinhas = tableModel.getRowCount();
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < totLinhas; i++) {
				tableModel.removeRow(0);
			}
		}
		for (Manutenção m : ProcessManutenção.manutenção) {
			tableModel.addRow(new String[] { String.format("%d", m.getId()), sdf.format(m.getData()), m.getEquipamento(), String.format("%.2f", m.getCustoHora()), String.format("%.2f", m.getTempoGasto()), String.format("%.2f", m.getTotal())});
		}
	}

	
	private void excluir() {
	if (JOptionPane.showConfirmDialog(this, "Tem certeza que deseja EXCLUIR esse Produto?") == 0) {
		Manutenção prodTemp = null;
		for (Manutenção m : ProcessManutenção.manutenção) {
			if (m.getId() == Integer.parseInt(tfid.getText())) {
				prodTemp = m;
			}
		}

		ProcessManutenção.manutenção.remove(ProcessManutenção.manutenção.indexOf(prodTemp));

		preencherTabela();
		limparCampos();
		ProcessManutenção.salvar();

		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
	}
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
	
	
	public static void main(String[] agrs) throws ParseException {
		ProcessManutenção.abrir();
		new FormManutenção().setVisible(true);
	}
}

	


