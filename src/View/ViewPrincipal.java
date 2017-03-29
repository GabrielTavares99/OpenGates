package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.MaskFormatter;

public class ViewPrincipal  extends JFrame implements KeyListener{

	CardLayout cardLayout;
	
	JFormattedTextField txt_consultaPlca;
	
	JPanel pn_pesquisa;
	JPanel pn_menu;
	
	MaskFormatter mk_placaVeiculo; 
	
	JFrame tela;
	
	JButton btn_pesquisar;
	
	public ViewPrincipal(){
		
		 cardLayout = new CardLayout();
		
		setTitle("Open Gates");
		setSize(800, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		
		tela = this;
		
//		Primeiro Card
		pn_pesquisa = new JPanel();
		pn_pesquisa.setBounds(200, 0, this.getWidth()-200, this.getHeight());
		pn_pesquisa.setLayout(null);
		pn_pesquisa.setOpaque(true);
		pn_pesquisa.setBackground(Color.RED);
		add(pn_pesquisa);
		
//		Menu
		pn_menu = new JPanel();
		pn_menu.setBounds(0, 0, 200, this.getHeight());
		pn_menu.setLayout(cardLayout);
		pn_menu.setOpaque(true);
		pn_menu.setBackground(Color.GREEN);
		add(pn_menu);
		
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
		
		btn_pesquisar = new JButton("Pesquisa");
		btn_pesquisar.setBounds(150, 0, 100, 60);
		pn_pesquisa.add(btn_pesquisar);
			
//		txt_consultaPlca.addKeyListener(new KeyListener() {
//			
//			@Override
//			public void keyTyped(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyReleased(KeyEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void keyPressed(KeyEvent e) {
//				
//				char[] vet = txt_consultaPlca.getText().toCharArray();
//				
//				for (int i = 0; i < vet.length; i++) {
//					if (" ".equals(String.valueOf(vet[i]))) {
//						System.out.print(vet[i]+"+");
//					}
//				}
				
//				if (txt_consultaPlca.getText().toString().length() == 8) {
//					System.out.println(txt_consultaPlca.getText().toString());
//				}

//			}
//		});
		
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
		// TODO Auto-generated method stub
		
	}


	
	
	
}



