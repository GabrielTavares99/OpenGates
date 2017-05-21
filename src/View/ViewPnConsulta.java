package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import Model.Morador;
import Model.Veiculo;

public class ViewPnConsulta extends JPanel implements KeyListener{

	JFormattedTextField txt_consultaPlca;
	MaskFormatter mk_placaVeiculo; 
	JButton btn_pesquisar;
	
	List<Component> lista_componentes;
	List<Morador> lista_moradores;
	
	Morador morador;
	
	public ViewPnConsulta(){

		setBounds(200, 0, this.getWidth()-200, this.getHeight());
		setLayout(null);
		setOpaque(true);
		setBackground(Color.RED);
		
		lista_componentes = new ArrayList<Component>();
		
		morador = new Morador();
		lista_moradores = morador.daoMorador.listar();
		
//		Caixa de Texto para digitar a placa do veículo
		txt_consultaPlca = new JFormattedTextField();
		txt_consultaPlca.setBounds(0, 0, 100, 60);
		
//		Colocando máscara no campo JFormattedTextField para atender o padrão de placas de carro
		try {
			mk_placaVeiculo = new MaskFormatter( "AAA-####" );
			mk_placaVeiculo.setInvalidCharacters(null);
			mk_placaVeiculo.install(txt_consultaPlca);
//			Adicionando o campo aqui dentro pq tenho que primeiro isntanciar para depois aplicar mascara
			lista_componentes.add(txt_consultaPlca);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
//		Botão para pesquisar a placa digitada
		btn_pesquisar = new JButton("Pesquisa");
		btn_pesquisar.setBounds(150, 0, 100, 60);
		lista_componentes.add(btn_pesquisar);
		
		//ADICIONANDO A LISTA DE COMPONENTES NA TELA
		for (Component component : lista_componentes) {
			add(component);
		}
		
//		-----------------------------------ADICIONANDO LISTENERS-----------------------------------
		txt_consultaPlca.addKeyListener(this);
//		----------------------------------------------------------------------
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void keyTyped(KeyEvent e) {
		
		String mascara_placa = txt_consultaPlca.getText().toString();
		String consulta = mascara_placa;
		
		consulta = consulta.replace(" ", "");
//		consulta = consulta.replace("-", "");

		System.out.println(consulta);
		
		for (Morador morador : lista_moradores) {
			for (Veiculo veiculo : morador.getListaVeiculos()) {
				if (veiculo.getPlaca().toUpperCase().contains(consulta)) {
					System.out.println(veiculo.getPlaca());
				}
			}
		}

		
	}
	
}
