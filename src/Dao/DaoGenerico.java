package Dao;

import java.util.ArrayList;
import java.util.List;

import Model.Morador;

public interface DaoGenerico {
	

	public boolean inserir(Object object);
	public boolean deletar();
	public List<Morador> listar();
	public boolean editar();
	
	
}
