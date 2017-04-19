package Controller;

import java.awt.Component;
import java.util.List;

import javax.swing.JTextField;

public class FuncoesFormulario {

	
	public FuncoesFormulario(){
		
	}
	
	public void limparCampos(List<Component> componentes){
		
		for (Component componente : componentes) {
			if (componente instanceof JTextField) {
				((JTextField) componente).setText(null);
			}
		}
		
	}
	
}
