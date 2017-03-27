package View;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class ViewPrincipal extends JFrame{

	CardLayout cardLayout;
	
	public void ViewPrincipal(){
		
		 cardLayout = new CardLayout();
		
		setTitle("Open Gates");
		setSize(800, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}
	
}
