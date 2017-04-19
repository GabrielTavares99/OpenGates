package Model;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel{

	
//	Método para atualzar a tabela 
	public static void atualizar(AbstractTableModel modelo, JTable tabela, List<Morador> listaMoradores, String[] cabecalhos){
		modelo = new ModeloTabela(cabecalhos,listaMoradores);
		tabela.setModel(modelo);
	}
	
//	Variaveis da classe
	private String colunas[];
	private List<Morador> listaMoradores;
	
//	Método contrutor
	public ModeloTabela(String[] cabecalho,List<Morador> listaMoradores) {
		this.listaMoradores = listaMoradores;
		this.colunas = cabecalho;
	}
	
	public ModeloTabela(List<Morador> listaMoradores) {
		this.listaMoradores = listaMoradores;
	}
	
//	Dando nome as colunas
	@Override
	public String getColumnName(int column) {
		if(column > colunas.length || column < 0){
			return null;
		}
		return colunas[column];
		
	}
	
//	Pega a quatidade de colunas da tabela
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
//	Pegar indice do item
	public Morador getMorador(int indice){
		return listaMoradores.get(indice);
	}

//	Pega a quantidade de linhas da tabela
	@Override
	public int getRowCount() {
		return listaMoradores.size();
	}

//	Nega edição da célula
	public boolean isCellEditable(int rowIndex, int columnIndex){
		return false;
	}
	
//	Pega um valor de um campo unico
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Morador morador = listaMoradores.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return morador.getNome();
		case 1:
			return morador.getBloco();
		case 2:
			return morador.getNumeroApartamento();
		case 3:
			return morador.getRg();

		default:
			break;
		}
		
		return null;
	}

}
