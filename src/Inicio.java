import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import Dao.DaoUsuario;
import Model.Morador;
import Model.Veiculo;
import View.ViewPrincipal;


public class Inicio {
	public static void main(String[] args) {
		
		ViewPrincipal v = new ViewPrincipal();
		
//		Veiculo veiculo = new Veiculo();
//		veiculo.setNumeroChassi(010101);
//		veiculo.setPlaca("ABC-123");
//		
//		Veiculo veiculo2 = new Veiculo();
//		veiculo2.setNumeroChassi(010101);
//		veiculo2.setPlaca("ccC-999");
//		
//		Morador morador = new Morador();
//		morador.setNome("Mário");
//		morador.setNumeroApartamento(20);
//		morador.setRg(123456789);
//		morador.setBloco("G");
//		
//		morador.getListaVeiculos().add(veiculo);
//		morador.getListaVeiculos().add(veiculo2);
//		
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Session session = factory.openSession();
//				
//		session.beginTransaction();
//		session.save(morador);
//
//		session.getTransaction().commit();
//		
////		Morador moradorBanco = (Morador) session.get(Morador.class, 1);
//		session.close();
//
//				
//		DaoUsuario d = new DaoUsuario();
//		
//		for (Morador morador1 : d.listar()) {
//			System.out.println(morador1.getNome());
//		}
//		
		
//		System.out.println(moradorBanco.getNome()+" - "+moradorBanco.getId()+" - Numero: "+moradorBanco.getNumeroApartamento()+" bloco"+moradorBanco.getBloco());
//		System.out.println(moradorBanco.getListaVeiculos().get(0).getPlaca());
//		System.out.println(moradorBanco.getListaVeiculos().get(1).getPlaca());
	
		

		
	}
}
