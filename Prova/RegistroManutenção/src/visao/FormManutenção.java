package visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import controle.ProcessManutenção;
import modelo.Manutenção;

public class FormManutenção extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JLabel id, data, equip, custoHora, tempoGasto;
	private JTextField tfid, tfdata, tfequip, tfcustoHora , tftempoGasto;
	private DefaultTableModel tableModel;
	private JButton create, read, update, delete;
	private String imgIco = "C:\\Users\\Desenvolvimento\\Desktop\\WORKPROJETO\\RegistroManutenção\\assets";
	private int autoId = ProcessManutenção.manutenção.size() + 1;

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
		
		data = new JLabel("Data de Fabricação:");
		data.setBounds(20, 200, 120, 30);
		
		tfdata = new JTextField();
		tfdata.setBounds(140, 200, 120, 30);
		painel.add(tfdata);
		tfdata.setBackground(new Color(215, 215, 215));
		
		equip = new JLabel("Nome do Produto:");
		equip.setBounds(20, 60, 120, 30);
		tfequip = new JTextField();
		tfequip.setBounds(140, 60, 300, 30);
		tfequip.setBackground(new Color(215, 215, 215));
		
		custoHora = new JLabel("Lucro:");
		custoHora.setBounds(20, 165, 120, 30);
		tfcustoHora = new JTextField();
		tfcustoHora.setBounds(140, 165, 100, 30);
		tfcustoHora.setBackground(new Color(215, 215, 215));
		
		tempoGasto = new JLabel("Lucro:");
		tempoGasto.setBounds(20, 165, 120, 30);
		tftempoGasto = new JTextField();
		tftempoGasto.setBounds(140, 165, 100, 30);
		tftempoGasto.setBackground(new Color(215, 215, 215));
		
		
		painel.add(id);
		painel.add(tfid);
		painel.add(data);
		painel.add(tfdata);
		painel.add(equip);
		painel.add(tfequip);
		painel.add(custoHora);
		painel.add(tfcustoHora);
		painel.add(tempoGasto);
		painel.add(tftempoGasto);
		
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
		

	}
	
	private void cadastrar() {
		if(tfid.getText().length() != 0 && tfdata.getText().length() != 0 && tfequip.getText().length() != 0 &&
				tfcustoHora.getText().length() != 0 && tftempoGasto.getText().length() != 0) {
			
		}else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
	}

	
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
		Manutenção manu = new Manutenção(id);
		if (ProcessManutenção.manutenção.contains(manu)) {
			int indice = ProcessManutenção.manutenção.indexOf(manu);
			tfid.setText(ProcessManutenção.manutenção.get(indice).getId("s"));
			tfdata.setText(ProcessManutenção.manutenção.get(indice).getData("s"));
			tfequip.setText(ProcessManutenção.manutenção.get(indice).getEquipamento());
			tfcustoHora.setText(ProcessManutenção.manutenção.get(indice).getCustoHora("s"));
			tftempoGasto.setText(ProcessManutenção.manutenção.get(indice).getTempoGasto("s"));
			create.setEnabled(false);
			update.setEnabled(true);
			delete.setEnabled(true);
			ProcessManutenção.salvar();
		} else {
			JOptionPane.showMessageDialog(this, "Produto não encontrado");
		}
		}
	}
	
	private void alterar() {
		int id = Integer.parseInt(tfid.getText());
		Manutenção manu = new Manutenção(id);
		int indice = ProcessManutenção.manutenção.indexOf(manu);
		if(tfid.getText().length() != 0 && tfdata.getText().length() != 0 && tfequip.getText().length() != 0 &&
				tfcustoHora.getText().length() != 0 && tftempoGasto.getText().length() != 0) {
		} else {
			JOptionPane.showMessageDialog(this, "Favor preencher todos os campos.");
		}
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfid.setText(String.format("%d", autoId));
		ProcessManutenção.salvar();
	}
	
	private void limparCampos() {
		tfid.setText(String.format("%d",autoId));
		tfdata.setText(null);
		tfequip.setText(null);
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
			tableModel.addRow(new String[] { m.getId("s"), m.getData("s"), m.getEquipamento(), m.getCustoHora("s"), m.getTempoGasto("s"), });
		}
	}

	
	private void excluir() {
		int id = Integer.parseInt(tfid.getText());
		Manutenção manu = new Manutenção(id);
		int indice = ProcessManutenção.manutenção.indexOf(manu);
		ProcessManutenção.manutenção.remove(indice);
		preencherTabela();
		limparCampos();
		create.setEnabled(true);
		update.setEnabled(false);
		delete.setEnabled(false);
		tfid.setText(String.format("%d", autoId));
		ProcessManutenção.salvar();
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

	


