package View;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewLabel {

	private JPanel pn_painel;
	
	public ViewLabel(JPanel pn_panel){
		this.pn_painel = pn_panel;
	}
	
	public JLabel labelSimples(JLabel lbl_campo, int x, int y, int width, int height,String mensagem){
		
		lbl_campo = new JLabel(mensagem);
		lbl_campo.setBounds(x, y, width, height);
		
		return lbl_campo;
	}
	
}
