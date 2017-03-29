package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import Model.Morador;
import Model.Veiculo;

public class DaoUsuario implements DaoGenerico{


	public boolean inserir(List<Veiculo> listaVeiculos, Morador morador ) {
		
		try {
		
		for (Veiculo veiculo : listaVeiculos) {
			morador.getListaVeiculos().add(veiculo);
		}

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
				
		session.beginTransaction();
		session.save(morador);

		session.getTransaction().commit();
		
//		Morador moradorBanco = (Morador) session.get(Morador.class, 1);
		session.close();
		return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deletar() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Morador> listar() {

		List<Morador> listaMoradores;
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();

		Criteria criteria = session.createCriteria(Morador.class);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		listaMoradores = criteria.list();	
		
		return listaMoradores;
	}

	@Override
	public boolean editar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserir(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

}
