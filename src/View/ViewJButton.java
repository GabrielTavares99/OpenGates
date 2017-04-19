package View;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ViewJButton {

	private JPanel pn_painel;
	
	public ViewJButton(JPanel pn_campo){
		pn_painel = pn_campo;
	}
	
	public JButton botaoSimples(JButton btn_inserir,int x, int y, int width, int heigth, String mensagem){
		btn_inserir = new JButton(mensagem);
		btn_inserir.setBounds(x, y, width, heigth);
		return btn_inserir;
	}
	
	
}
