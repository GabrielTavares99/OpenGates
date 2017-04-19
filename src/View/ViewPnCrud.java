package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;

import Controller.FuncoesFormulario;
import Model.ModeloTabela;
import Model.Morador;
import Model.Veiculo;

public class ViewPnCrud extends JPanel implements ActionListener{

//	Componentes tabela
	JTable tabela;
	ModeloTabela modeloTabela;
	
//	Components formulario morador
	JTextField txt_nome, txt_bloco,txt_numApartamento,txt_rg;
	JLabel lbl_nome,lbl_bloco,lbl_numApartamento,lbl_rg;
	JButton btn_inserir;

//	Componentes formulario veiculo
	JTextField txt_numeroChassi, txt_placa;
	JList<Veiculo> jlist_veiculos;
	JScrollPane scroolVeiculos;
	DefaultListModel<Veiculo> modeloListaVeiculo;
	JButton btn_inserirVeiculo;
	List<Veiculo> list_veiculos;

//	Componentes outros
	List<Component> list_componentes;
	String[] colunasNomes;
	Morador morador;
	List<Morador> listamoradores;
	FuncoesFormulario funcoesFormularios = new FuncoesFormulario();
	
	public ViewPnCrud(){
		setBounds(0, 0, this.getHeight()-200, this.getHeight());
		setLayout(null);
		setOpaque(true);
		setBackground(Color.ORANGE);
		
		morador = new Morador();
		
		list_componentes = new ArrayList<Component>();

//		-------------------------- Adicionando tabela --------------------------
		
		listamoradores = new ArrayList<Morador>();
		Morador m = new Morador();
		m.setNome("Gabriel");
		m.setBloco("G");
		m.setNumeroApartamento(7);
		m.setRg("818");
		listamoradores.add(m);
		m = new Morador();
		m.setNome("José");
		m.setBloco("H");
		m.setNumeroApartamento(98);
		m.setRg("8855");
		listamoradores.add(m);
		
//		Instancio a tabela
		tabela = new JTable();
		
//		Crio o vetor com o cabeçalho da tabela
		colunasNomes = new String[]{"Nome","Bloco","Nº Apartamento", "RG"};
		
//		Crio um modelo para a tabela e passo pra ele o cabeçalho e a lista de ibjetos a serem adicionados
		modeloTabela = new ModeloTabela(colunasNomes, morador.daoMorador.listar());
		
//		Seto o modelo de tabela na minha tabela
		tabela.setModel(modeloTabela);
		
//		Seto um scroll na minha tabela pra ela poder criar uma barra de rolagem - o tamanho do scrool determinada o tamanho da tabela
		JScrollPane scroolPane = new JScrollPane(tabela);
		
//		Seto o tamanho di scroll
		scroolPane.setBounds(100,250,400,70);
				
//		Adiciono a tabela + o scrool no painel
		this.add(scroolPane);
		
//		-----------------------------------------------------------------

//		-----------------------------------Colocando a List-----------------------------------

		modeloListaVeiculo = new DefaultListModel();
				
		jlist_veiculos = new JList<Veiculo>(modeloListaVeiculo);
		scroolVeiculos = new JScrollPane();
		scroolVeiculos.setViewportView(jlist_veiculos);
		scroolVeiculos.setBounds(200, 400, 100, 100);
				
		list_veiculos = new ArrayList<Veiculo>();
		
		list_componentes.add(scroolVeiculos);
		
//		-----------------------------------------------------------------

		
//		-----------------------------------Colocando Campos de Texto-----------------------------------
		
//		Objeto que já configura os JTextFields
		ViewJTextField viewJTextField = new ViewJTextField(this);
		txt_nome = viewJTextField.campoSimples(txt_nome, 50, 0, 100, 50);
		txt_numApartamento = viewJTextField.campoSimples(txt_nome, 50, 50, 100, 50);
		txt_bloco = viewJTextField.campoSimples(txt_nome, 50, 100, 200, 50);
		txt_rg = viewJTextField.campoSimples(txt_nome, 50, 150, 250, 50);
		
		txt_numeroChassi = viewJTextField.campoSimples(txt_numeroChassi, 0, 400, 100, 50);
		txt_placa = viewJTextField.campoSimples(txt_placa, 0, 450, 100, 50);
		
		list_componentes.add(txt_numeroChassi);
		list_componentes.add(txt_placa);
		
		list_componentes.add(txt_nome);
		list_componentes.add(txt_bloco);
		list_componentes.add(txt_rg);
		list_componentes.add(txt_numApartamento);
//		---------------------------------------------------------------------------------------------------------
		
//		-----------------------------------Colocando os Rótulos-----------------------------------
//		Objeto que configura pra mim as JLabels
		ViewLabel viewLabel = new ViewLabel(this);
		lbl_nome = viewLabel.labelSimples(lbl_nome,0,0,50,50,"Nome");
		lbl_numApartamento = viewLabel.labelSimples(lbl_numApartamento,0,50,50,50,"apartamento");
		lbl_bloco = viewLabel.labelSimples(lbl_bloco,0,100,50,50,"Bloco");
		lbl_rg = viewLabel.labelSimples(lbl_rg,0,150,50,50,"Rg");
		
		list_componentes.add(lbl_nome);
		list_componentes.add(lbl_bloco);
		list_componentes.add(lbl_rg);
		list_componentes.add(lbl_numApartamento);
//		---------------------------------------------------------------------------------------------------------

//		-----------------------------------Colocando os botoes-----------------------------------
//		Objeto que configura os buttons
		ViewJButton viewJButton = new ViewJButton(this);
		btn_inserir = viewJButton.botaoSimples(btn_inserir, 0, 200, 100, 50, "Inserir");
		list_componentes.add(btn_inserir);
		
		btn_inserirVeiculo = viewJButton.botaoSimples(btn_inserir, 300, 450, 100, 50, "+");
		list_componentes.add(btn_inserirVeiculo);
//		---------------------------------------------------------------------------------------------------------

//		Adicionando os componentes na tela
		for (Component component : list_componentes) {
			add(component);
		}
		
//		Adicionando o actionListener ao botao
		btn_inserir.addActionListener(this);
		btn_inserirVeiculo.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
						
//		Vericicando se o botão é o de Inserir um novo registro
		if (e.getSource().equals(btn_inserir)) {
//			Instânciando o objeto morador
			morador = new Morador();
			morador.setNome(txt_nome.getText());
			morador.setNumeroApartamento(Integer.valueOf(txt_numApartamento.getText()));
			morador.setRg(txt_rg.getText());
			morador.setBloco(txt_bloco.getText());
						
//			Método que chama o método de cadastrar no banco, parametros: morador e sua lista de veiculos
			morador.daoMorador.inserir(morador, list_veiculos);
			
//			Limpo a lista
			listamoradores.clear();
//			Pego o retorno dos moradores cadastrados no banco e coloco na lista
			listamoradores = morador.daoMorador.listar();
			
//			Atualizo minha tabela
			modeloTabela.atualizar(modeloTabela, tabela, listamoradores, colunasNomes);
			
			funcoesFormularios.limparCampos(list_componentes);
			
		}else if (e.getSource().equals(btn_inserirVeiculo)) {
			
			Integer numeroChassi = Integer.valueOf(txt_numeroChassi.getText());
			String placa = txt_placa.getText();
			
			Veiculo veiculo = new Veiculo();
			veiculo.setNumeroChassi(numeroChassi);
			veiculo.setPlaca(placa);
			
			list_veiculos.add(veiculo);
			modeloListaVeiculo.addElement(veiculo);
			
		}
		
		
	}
	
	
	
}
