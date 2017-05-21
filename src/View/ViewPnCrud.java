package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.MaskFormatter;

import Controller.FuncoesFormulario;
import Model.ModeloTabela;
import Model.Morador;
import Model.Veiculo;

public class ViewPnCrud extends JPanel implements ActionListener, MouseListener{
	
//	Componentes tabela
	JTable tabela;
	ModeloTabela modeloTabela;
	
//	Components formulario morador
	JTextField txt_nome, txt_bloco,txt_numApartamento,txt_rg;
	JLabel lbl_nome,lbl_bloco,lbl_numApartamento,lbl_rg;
	JButton btn_inserir, btn_salvar, btn_excluir;

//	Componentes formulario veiculo
	JTextField txt_numeroChassi;
	JFormattedTextField txt_placa;
	JList<Veiculo> jlist_veiculos;
	JScrollPane scroolVeiculos;
	DefaultListModel<Veiculo> modeloListaVeiculo;
	JButton btn_inserirVeiculo;
	JButton btn_removerVeiculo;
	List<Veiculo> list_veiculos;
	MaskFormatter mk_placaVeiculo;
	JLabel lbl_placa;
	JLabel lbl_chassi;

//	Componentes outros
	List<Component> list_componentes;
	String[] colunasNomes;
	JPanel pn_crud;
	JLabel lbl_titulo;

	List<Morador> listaMoradores;
	Veiculo veiculo;
	Morador morador;
	FuncoesFormulario funcoesFormularios = new FuncoesFormulario();
	
	int LARGURA_JTEXTFIELD = 200;
	int ALTURA_JTEXTFIELD = 30;
	
	int LARGURA_JLABEL = 100;
	int ALTURA_JLABEL = 30;
	
	int X_JTEXTFIELD = 100;
	int X_JLABEL = 0;

	int LARGURA_TABELA = 500;
	int ALTURA_TABELA = 150;
	
	int LARGURA_JTEXTFIEL_VEICULO = 80;
	int ALTURA_JTEXTFIEL_VEICULO = 30;
	
	int LARGURA_JLABEL_VEICULO = 80;
	int ALTURA_JLABEL_VEICULO = 30;
	
	public ViewPnCrud(){
		
		setBounds(0, 0, ViewPrincipal.LARGURA_TELA-200, ViewPrincipal.ALTURA_TELA);
		setLayout(null);
		setOpaque(true);
		setBackground(Color.ORANGE);
		
		pn_crud = this;
		
		morador = new Morador();
				
		list_componentes = new ArrayList<Component>();

//		-------------------------- Adicionando tabela --------------------------
		
		listaMoradores = new ArrayList<Morador>();
		
//		Instancio a tabela
		tabela = new JTable();
		
//		Crio o vetor com o cabeçalho da tabela
		colunasNomes = new String[]{"Nome","Bloco","Nº Apartamento", "RG"};
		
//		Crio um modelo para a tabela e passo pra ele o cabeçalho e a lista de ibjetos a serem adicionados
		modeloTabela = new ModeloTabela(colunasNomes, morador.daoMorador.listar());
		
//		Preenchendo uma lista de moradores  para controle de diversas funcoes
		listaMoradores = morador.daoMorador.listar();
		
//		Seto o modelo de tabela na minha tabela
		tabela.setModel(modeloTabela);
		
//		Seto um scroll na minha tabela pra ela poder criar uma barra de rolagem - o tamanho do scrool determinada o tamanho da tabela
		JScrollPane scroolPane = new JScrollPane(tabela);
		
//		Seto o tamanho DO SCROOL DA TABELA
		scroolPane.setBounds(0,50,pn_crud.getWidth()-16,ALTURA_TABELA);
				
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
		txt_nome = viewJTextField.campoSimples(txt_nome, X_JTEXTFIELD, 250, LARGURA_JTEXTFIELD,  ALTURA_JTEXTFIELD);
		txt_numApartamento = viewJTextField.campoSimples(txt_nome, X_JTEXTFIELD, 280, LARGURA_JTEXTFIELD,  ALTURA_JTEXTFIELD);
		txt_bloco = viewJTextField.campoSimples(txt_nome, X_JTEXTFIELD, 310, LARGURA_JTEXTFIELD,  ALTURA_JTEXTFIELD);
		txt_rg = viewJTextField.campoSimples(txt_nome,X_JTEXTFIELD, 340, LARGURA_JTEXTFIELD,  ALTURA_JTEXTFIELD);
		
		txt_numeroChassi = viewJTextField.campoSimples(txt_numeroChassi, 100, 450,  LARGURA_JTEXTFIEL_VEICULO,  ALTURA_JTEXTFIEL_VEICULO);
		txt_placa = viewJTextField.mascaraPlaca(txt_placa, 100, 480, LARGURA_JTEXTFIEL_VEICULO,  ALTURA_JTEXTFIEL_VEICULO);
		
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
		lbl_titulo = viewLabel.labelSimples(lbl_titulo, 0, 10, 400, 50, "Cadastros de Moradores");
		lbl_nome = viewLabel.labelSimples(lbl_nome,0,250,LARGURA_JLABEL,ALTURA_JLABEL,"Nome");
		lbl_numApartamento = viewLabel.labelSimples(lbl_numApartamento,0,280,LARGURA_JLABEL,ALTURA_JLABEL,"apartamento");
		lbl_bloco = viewLabel.labelSimples(lbl_bloco,0,310,LARGURA_JLABEL,ALTURA_JLABEL,"Bloco");
		lbl_rg = viewLabel.labelSimples(lbl_rg,0,340,LARGURA_JLABEL,ALTURA_JLABEL,"Rg");
		lbl_chassi = viewLabel.labelSimples(lbl_chassi, 0, 450, LARGURA_JLABEL_VEICULO, ALTURA_JLABEL_VEICULO, "Chassi");
		lbl_placa = viewLabel.labelSimples(lbl_placa, 0, 480, LARGURA_JLABEL_VEICULO, ALTURA_JLABEL_VEICULO, "Placa");
		
		list_componentes.add(lbl_placa);
		list_componentes.add(lbl_chassi);
		list_componentes.add(lbl_titulo);
		list_componentes.add(lbl_nome);
		list_componentes.add(lbl_bloco);
		list_componentes.add(lbl_rg);
		list_componentes.add(lbl_numApartamento);
//		---------------------------------------------------------------------------------------------------------

//		-----------------------------------Colocando os botoes-----------------------------------
//		Objeto que configura os buttons
		ViewJButton viewJButton = new ViewJButton(this);
		
//		Botão de inserir um novo cadastro
		btn_inserir = viewJButton.botaoSimples(btn_inserir, 0, 200, 100, 50, "Inserir");
		list_componentes.add(btn_inserir);
		
//		Botão de editar um cadastro
		btn_salvar = viewJButton.botaoSimples(btn_salvar, 200, 200, 100, 50, "Salvar");
		list_componentes.add(btn_salvar);
		
//		BOTÃO DE EXCLUSÃO DE CLIENTE
		btn_excluir = viewJButton.botaoSimples(btn_excluir, 100, 200, 100, 50, "EXCLUIR");
		list_componentes.add(btn_excluir);
		
//		BOTÃO DE REMOÇÃO DE VEICULO
		btn_removerVeiculo = viewJButton.botaoSimples(btn_removerVeiculo, 300, 400, 100, 50, "-");
		list_componentes.add(btn_removerVeiculo);
		
//		BOTÃO DE ADIÇÃO DE VEICULO
		btn_inserirVeiculo = viewJButton.botaoSimples(btn_inserirVeiculo, 300, 450, 100, 50, "+");
		list_componentes.add(btn_inserirVeiculo);
//		---------------------------------------------------------------------------------------------------------

//		Adicionando os componentes na tela
		for (Component component : list_componentes) {
			add(component);
		}
		
//		------------------------------------------- Adicionando o actionListener ao botao -----------------------------------------------
		btn_inserir.addActionListener(this);
		btn_inserirVeiculo.addActionListener(this);
		btn_removerVeiculo.addActionListener(this);
		btn_salvar.addActionListener(this);
		btn_excluir.addActionListener(this);
		
//		Adicionando função à tabela - relacioando a interação de mouse
		tabela.addMouseListener(this);
//		---------------------------------------------------------------------------------------------------------------------------------
		
//		------------------------------------------- Adicionando o actionListener ao botao -----------------------------------------------
//		O BOTÃO SALVAR FICA DESABILITADO PORQUE NAO FOI SELECIONADO NENHUM MORADOR PARA EDIÇÃO
		btn_salvar.setEnabled(false);
//		O BOTÃO EXCLUIR FICA DESABILITADO PORQUE NÃO FOI SELECIONADO NENHUM MORADOR PARA EXCLUSÃO
		btn_excluir.setEnabled(false);
//		---------------------------------------------------------------------------------------------------------------------------------
	}

	@Override
	public void actionPerformed(ActionEvent e) {
								
//		Vericicando se o botão é o de Inserir um novo registro
		if (e.getSource().equals(btn_inserir)) {
						
//			Pega os valores dos campos e atribui ao objeto morador
			morador = montarMorador(morador);
						
//			Método que chama o método de cadastrar no banco, parametro: morador
			morador.daoMorador.inserir(morador);
			
//			Função de limpar os campos e a lista de veiculos
			limparCampos(list_componentes);
			
//			Função que atualiza a tabela e a lista de moradores
			atualizarFormulario();
			
//			"Limpo" o objeto morador para evitar troca de atributos entre objetos
			morador = null;
			morador = new Morador();
			
		}else if (e.getSource().equals(btn_inserirVeiculo)) {
			
//			RECUPERO VALORES DA CAIXA DE TEXTO
			Integer numeroChassi = Integer.valueOf(txt_numeroChassi.getText());
			String placa = txt_placa.getText();
			
//			INSTANCIO O OBJETO VEICULO
			veiculo = new Veiculo();
			veiculo.setNumeroChassi(numeroChassi);
			veiculo.setPlaca(placa);
			
//			ADICIONO NA LISTA DE VEICULOS DO MORADOR
			morador.getListaVeiculos().add(veiculo);
//			ADICIONO NO MODELO DA LISTA VISUAL
			modeloListaVeiculo.addElement(veiculo);
			
//			LIMPO OS CAMPOS DE CADASTRO DO VEICULO
			limparCamposVeiculo();
						
		}else if (e.getSource().equals(btn_removerVeiculo)) {
						
//			Remove o veiculo que está na lista do morador;
			morador.getListaVeiculos().remove(jlist_veiculos.getSelectedIndex());					
			
//			Remove o veiculo da lista visual
			modeloListaVeiculo.removeElement(jlist_veiculos.getSelectedValue());
			
		}else if (e.getSource().equals(btn_salvar)) {
			
			
			
//			Pego as alterações de campos
			morador = montarMorador(morador);

//			Chamo o método de edição
			morador.daoMorador.editar(morador);

//			Limpas os campos e a lista
			limparCampos(list_componentes);
			
//			ATUALIZO O FORMULARIO
			atualizarFormulario();

//			LIMPO A INSTANCIA DO OBJETO PARA EVITAR TROCA DE ATRIBUTOS ENTRE METODOS
			morador = null;
			
//			O BOTÃO INSERIR FICA HABILITADO, POIS O MORADOR JÁ FOI EDITADO E O SISTEMA SE PREPARA PARA UM NOVO CADASTRO
			btn_inserir.setEnabled(true);
//			O BOTÃO SALVAR FICA DESABILITADO PORQUE NENHUM MORADOR FOI SELECIONADO PRA SUA EDIÇÃO
			btn_salvar.setEnabled(false);
//			O BOTÃO EXCLUIR FICAR DESABILITADO PORQUE NÃO FOI SELECIONADO NENHUM MORADOR PARA A EXCLUSÃO
			btn_excluir.setEnabled(false);
			
		}else if (e.getSource().equals(btn_excluir)) {
			
			preencherCampos();
			
			morador.daoMorador.excluir(morador);
			
			limparCampos(list_componentes);
			
			atualizarFormulario();
			
		}
		
		
	}
	
private void limparCampos(List<Component> list_componentes2) {
	
//		Limpa os campos de texto
		for (Component component : list_componentes2) {
			if (component instanceof JTextField) {
				((JTextField) component).setText("");
			}
		}
		
//		Limpa minha lista visual
		modeloListaVeiculo.clear();
		
	}

	private void atualizarFormulario() {
	
//		Pego o retorno dos moradores cadastrados no banco e coloco na lista
		listaMoradores = morador.daoMorador.listar();
		
//		Atualizo minha tabela
		modeloTabela.atualizar(modeloTabela, tabela, listaMoradores, colunasNomes);
				
	}

	//	Limpa os campos de placa e chassi
	public void limparCamposVeiculo(){
		txt_placa.setText("");
		txt_numeroChassi.setText("");
	}
	
//	Preenche o objeto morador
	public Morador montarMorador(Morador morador){
		
		morador.setNome(txt_nome.getText());
		morador.setNumeroApartamento(Integer.valueOf(txt_numApartamento.getText()));
		morador.setRg(txt_rg.getText());
		morador.setBloco(txt_bloco.getText());
						
		return morador;
	}
	
//	Preencher campos de acordo com a seleção da tabela
	public void preencherCampos(){

//		INSTANCIO UM NOVO OBJETO
		morador = new Morador();
		
//		ATUALIZO MINHA LISTA
		listaMoradores = morador.daoMorador.listar();
		
//		Pegando o morador selecionado
		morador = listaMoradores.get(tabela.getSelectedRow());
		
//		SETO NOS CAMPOS DE TEXTO OS CAMPOS DO MORADOR SELECIONADO
		txt_nome.setText(morador.getNome());
		txt_bloco.setText(morador.getBloco());
		txt_numApartamento.setText(String.valueOf(morador.getNumeroApartamento()));
		txt_rg.setText(morador.getRg());
				
//		Limpo a minha list view
		modeloListaVeiculo.removeAllElements();
		
//		Setando um veiculo em cada posição
		for (Veiculo veiculo : morador.getListaVeiculos()) {
			modeloListaVeiculo.addElement(veiculo);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(tabela)) {
			
//			Método que preenche os campos, pega o item clicado na tabela e preenche os campos
			preencherCampos();
			
//			AO CLICAR NO MORADOR O BOTÃO SALVAR FICAR HABILIDADE PARA PODER SALVAR O MORADOR EDITADO
			btn_salvar.setEnabled(true);
//			O BOTÃO INSERIR FICAR DESABILITADO PORQUE FOI SELECIONADO UM MORADOR PARA EDIÇÃO
			btn_inserir.setEnabled(false);
//			O BOTÃO EXCLUIR FICA HABILITADO PORQUE FOI SELECIONADO UM MORADOR
			btn_excluir.setEnabled(true);
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
