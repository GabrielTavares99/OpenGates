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
	
	JPanel pn_consulta;
	JPanel pn_menu;
	JPanel pn_crud;
	JPanel pn_conteudo;
	
	JFrame tela;
	
	JButton btn_crud, btn_pesquisa;
		
//	VARIAVEIS GLOBAIS DE GERENCIAMENTO
	String TITULO_SISTEMA = "Open Getes - O seu controle de acesso inteligente!";
	static int LARGURA_TELA = 800;
	static int ALTURA_TELA = 600;
	int LARGURA_MENU = 200;
	int ALTURA_MENU = ALTURA_TELA;
	int LARGURA_BOTAO = LARGURA_MENU;
	int ALTURA_BOTAO = 50;
	
	public ViewPrincipal(){
		
		cardLayout = new CardLayout();
		
		setTitle(TITULO_SISTEMA);
		setSize(LARGURA_TELA, ALTURA_TELA);
		setLayout(null);
		setLocationRelativeTo(null);
		
		tela = this;
				
//		PAINEL DO MENU
		pn_menu = new ViewPnMenu();
		pn_menu.setBounds(0, 0, LARGURA_MENU, ALTURA_MENU);
		pn_menu.setLayout(null);
		pn_menu.setOpaque(true);
		pn_menu.setBackground(Color.GREEN);
		add(pn_menu);
		
//		BOTÃO QUE ACESSA O PAINEL DE CADASTRO
		btn_crud = new JButton("Cadastro");
		btn_crud.setBounds(0, 100, LARGURA_BOTAO, ALTURA_BOTAO);
		pn_menu.add(btn_crud);
		
//		BOTÃO QUE ACESSA O PAINEL DE CONSULTA DE PLACA
		btn_pesquisa = new JButton("Consultar PLaca");
		btn_pesquisa.setBounds(0, 0, LARGURA_MENU,ALTURA_BOTAO);
		pn_menu.add(btn_pesquisa);
		
//		PAINEL DE CONTEÚDO
		pn_conteudo = new JPanel();
		pn_conteudo.setLayout(cardLayout);
		pn_conteudo.setOpaque(true);
		pn_conteudo.setBounds(200, 0, LARGURA_TELA-LARGURA_MENU, ALTURA_TELA);
		pn_conteudo.setBackground(Color.pink);
		add(pn_conteudo);
		
//		Primeiro Card
		pn_consulta = new ViewPnConsulta();
		pn_conteudo.add(pn_consulta,"1");
		
//		Segundo Card
		pn_crud = new ViewPnCrud();
		pn_conteudo.add(pn_crud,"2");
		
//		==============================================================

//		=================================================================
				
//		Adicionando Listener ao botão de crud
		btn_crud.addActionListener(this);
		btn_pesquisa.addActionListener(this);

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



