package View;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
	
	MaskFormatter mk_placa ;
	
	public JFormattedTextField mascaraPlaca (JFormattedTextField placa, int x, int y, int width, int height){
		
		placa = new JFormattedTextField();
		placa.setBounds(x, y, width, height);
		
//		Criando a mascara para o campo
		try {
			mk_placa = new MaskFormatter( "AAA-####" );
			mk_placa.setInvalidCharacters(null);
			mk_placa.install(placa);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return placa;
	}
	
	
}
