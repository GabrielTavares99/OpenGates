package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

import Model.Morador;
import Model.Pessoa;

public interface DaoGenerico {
	

	public boolean inserir(Object object);
	public boolean excluir(Object object);
//	public List<Object> listar();
	public boolean editar(Object object);
	

	
}
