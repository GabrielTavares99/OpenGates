package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.MaskFormatter;

import Dao.DaoUsuario;
import Model.ModeloTabela;
import Model.Morador;

public class ViewPrincipal  extends JFrame implements ActionListener, KeyListener{

	CardLayout cardLayout;
	
	static JTable tabela;
	
	JFormattedTextField txt_consultaPlca;
	
	JPanel pn_pesquisa;
	JPanel pn_menu;
	JPanel pn_crud;
	JPanel pn_conteudo;
	
	MaskFormatter mk_placaVeiculo; 
	
	JFrame tela;
	
	JButton btn_pesquisar;
	JButton btn_crud, btn_pesquisa;
	
	DaoUsuario daoUsuario;
	
	
	public ViewPrincipal(){
		
		cardLayout = new CardLayout();
		
		setTitle("Open Gates");
		setSize(800, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		
		tela = this;
		
//		Instanciando um objeto DaoUsuario para o CRUD
		daoUsuario = new DaoUsuario();
		
//		Menu
		pn_menu = new ViewPnMenu();
		pn_menu.setBounds(0, 0, 200, this.getHeight());
		pn_menu.setLayout(null);
		pn_menu.setOpaque(true);
		pn_menu.setBackground(Color.GREEN);
		add(pn_menu);
		
		btn_crud = new JButton("Cadastro");
		btn_crud.setBounds(0, 100, pn_menu.getWidth(), 50);
		pn_menu.add(btn_crud);
		
		btn_pesquisa = new JButton("Consultar PLaca");
		btn_pesquisa.setBounds(0, 0, pn_menu.getWidth(),50);
		pn_menu.add(btn_pesquisa);
		
//		Conteudo - do lado do painel
		pn_conteudo = new JPanel();
		pn_conteudo.setLayout(cardLayout);
		pn_conteudo.setOpaque(true);
		pn_conteudo.setBounds(200, 0, this.getWidth()-200, this.getHeight());
		pn_conteudo.setBackground(Color.pink);
		add(pn_conteudo);
		
//		Primeiro Card
		pn_pesquisa = new JPanel();
		pn_pesquisa.setBounds(200, 0, this.getWidth()-200, this.getHeight());
		pn_pesquisa.setLayout(null);
		pn_pesquisa.setOpaque(true);
		pn_pesquisa.setBackground(Color.RED);
		pn_conteudo.add(pn_pesquisa,"1");
		
//		Segundo Card
		pn_crud = new ViewPnCrud();
		pn_conteudo.add(pn_crud,"2");
		
//		==============================================================
		
		
		
//		=================================================================
				
//		Adicionando Listener ao botão de crud
		btn_crud.addActionListener(this);
		btn_pesquisa.addActionListener(this);
	
//		Caixa de Texto para digitar a placa do veículo
		txt_consultaPlca = new JFormattedTextField();
		txt_consultaPlca.setBounds(0, 0, 100, 60);
		
//		Colocando máscara no campo JFormattedTextField para atender o padrão de placas de carro
		try {
			mk_placaVeiculo = new MaskFormatter( "AAA-####" );
			mk_placaVeiculo.setInvalidCharacters(null);
			mk_placaVeiculo.install(txt_consultaPlca);
//			Adicionando o campo aqui dentro pq tenho que primeiro isntanciar para depois aplicar mascara
			pn_pesquisa.add("",txt_consultaPlca);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		Botão para pesquisar a placa digitada
		btn_pesquisar = new JButton("Pesquisa");
		btn_pesquisar.setBounds(150, 0, 100, 60);
		pn_pesquisa.add(btn_pesquisar);
		
//		Adicionando evento a caixa de pesquisa
		txt_consultaPlca.addKeyListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
//		Usuario usuario
		
//		daoUsuario.inserir(usuario)
		
//		for (Morador morador : daoUsuario.listarPorNome()) {
//			System.out.println(morador.getNome());
//		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(btn_crud)) {
			cardLayout.show(pn_conteudo, "2");
		}else if (e.getSource().equals(btn_pesquisa)) {
			cardLayout.show(pn_conteudo, "1");
			
		}
		
		
	}


	
	
	
}



