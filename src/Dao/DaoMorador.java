package Dao;

import java.awt.image.CropImageFilter;
import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import Model.Morador;
import Model.Pessoa;
import Model.Veiculo;

public class DaoMorador extends DaoPessoa{
	
	
	public boolean excluir(Morador morador){
		
		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			
			//EM ALGUMAS VERSÕES SERÁ NECESSÁRIO PASSAR O ID DO OBJETO
			session.delete(morador);
			
			session.getTransaction().commit();
			
			session.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
		
	public boolean inserir(Morador morador) {

		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
								
			session.beginTransaction();
			session.save(morador);
			session.getTransaction().commit();
			
			session.close();
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
		
	}

	public List<Morador> listar() {

//		Cria a lista que irá ser retornada
		List<Morador> listaMoradores;
		
//		Crio a sessão/ conexão
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Abro a sessão
		Session session = factory.openSession();
		session.beginTransaction();
		session.getTransaction().commit();

//		Criteria estrutura de retorno de dados
		Criteria criteria = session.createCriteria(Morador.class);
//		Estou falando pra distinguir objetos iguais
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//		Pego o retorno e coloco dentro da minha lista
		listaMoradores = criteria.list();	
		
		session.close();
		
		return listaMoradores;
		
	}

	//Método que busca um morador pelo seu ID
	public Morador listarPorId(Morador morador){
		
//		Crio a sessão/ conexão
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

//		Abro a sessão
		Session session = factory.openSession();

//		Passo o nome da classe e o ID a ser buscado
		morador = (Morador) session.get(Morador.class, morador.getId());
		
//		Fecho a sessão
		session.close();
		
//		Retorno o objeto encontrado
		return morador;
	}
	
	public void buscarVeiculoPelaPlaca(String consulta) {
		List<Veiculo> listaVeiculos ;

//		Crio a sessão/ conexão
//		SessionFactory factory = new Configuration().configure().buildSessionFactory();
//		Abro a sessão
//		Session session = factory.openSession();		
//		session.beginTransaction();		
//		session.getTransaction().commit();
		
//		listaVeiculos = (List<Veiculo>) session.createCriteria(Veiculo.class).add(Expression.eq("placa","x").ignoreCase()).list();
		
//		String hql = "SELECT x FROM tb_veiculo";
			
//		Criteria criteria = session.createCriteria(Veiculo.class);
//		criteria.add(Restrictions.eq("placa", "x%"));
		
//		listaMoradores = session.createQuery(hql).setParameter("placa", "x").list();
//		listaMoradores = criteria.list();
			
//		for (Morador morador : ve) {
//			for (Veiculo veiculo : listaMoradores) {
//				System.out.println(veiculo.getPlaca());
//			}
//		}
//		System.out.println("saiu");
//		session.close();
		
//		return null;
	}
	
	public boolean editar(Morador morador) {

		try {
//
//			System.out.println(morador.getId());
//			System.out.println(morador.getNome());
//			System.out.println(morador.getRg());
//			System.out.println(morador.getNumeroApartamento());
//			for (Veiculo veiculo : morador.getListaVeiculos()) {
//				System.out.println(veiculo.getPlaca());
//			}
////			morador.setListaVeiculos(null);
//			
//			Crio a sessão/ conexão
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
//			Abro a sessão
			Session session = factory.openSession();
			
			session.beginTransaction();
			session.saveOrUpdate(morador);
			session.getTransaction().commit();
			
			session.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}	
	
}
