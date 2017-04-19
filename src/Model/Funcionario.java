package Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Funcionario extends Pessoa{

//	Anotacao de só colocar data
	@Temporal(TemporalType.DATE)
//	Anotação que altera o nome da coluna
	@Column(name="data_nascimento")
	private Date dataAdmissao;
	
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return super.getNome();
	}
	@Override
	public void setNome(String nome) {
		// TODO Auto-generated method stub
		super.setNome(nome);
	}
	@Override
	public String getRg() {
		// TODO Auto-generated method stub
		return super.getRg();
	}
	@Override
	public void setRg(String rg) {
		// TODO Auto-generated method stub
		super.setRg(rg);
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	
}
