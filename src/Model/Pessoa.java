package Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Dao.DaoGenerico;
import Dao.DaoPessoa;

public class Pessoa {

	DaoPessoa daoPessoa;
	
//	Identifica que é uma Primary Key
	@Id
//	Gera o código de PK de moto automatico
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String rg;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Pessoa(){
		daoPessoa = new DaoPessoa();
	}
}
