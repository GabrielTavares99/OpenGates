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
import Model.Pessoa;
import Model.Veiculo;

public class DaoUsuario {


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
	
	public List<Morador> listarPorNome(){
		
		List<Morador> listaMoradores;
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();
		

//		Objeto de consulta
		Criteria criteria = session.createCriteria(Morador.class);
//		eq procura o atributo da classe mais uma descrição
//		ne é restrição, nao deve ter tal parâmetro
//		Dá pra procurar campos vázios com ISnull e um atributo da classe
//		criteria.add(Restrictions.eq("placa","ABC-123"));
//		Listagem de retorno
		ProjectionList listaProjecao = Projections.projectionList();
		listaProjecao.add(Projections.property("id"));
		listaMoradores = criteria.list();
		
		session.close();
			
		return listaMoradores;
		
	}


//	Criando método passando uma pessoa
	public boolean inserir(Pessoa pessoa){
//		Verificando se é um morador
		if (pessoa instanceof Morador) {
			pessoa = (Morador) pessoa;
			((Morador) pessoa).daoMorador.inserir(pessoa);
		}
		
		return false;
	}

}
