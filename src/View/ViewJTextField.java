package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ViewJTextField extends JTextField{

	private JPanel pn_painel;
	
	public ViewJTextField(JPanel pn_painel){
		this.pn_painel = pn_painel;
	}
	
	public JTextField campoSimples(JTextField txt_campo, int x, int y, int width, int height){
		
		txt_campo = new JTextField();
		txt_campo.setBounds(x, y, width, height);
		
		return txt_campo;
	}
	

	
}
