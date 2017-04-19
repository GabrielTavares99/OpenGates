package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Anotação que diz que essa vai ser uma tabela no banco de dados
@Entity
//Anotação que alterna o nome da tabela do banco
@Table(name = "tb_Morador")
public class Morador extends Pessoa{

	private Integer numeroApartamento;
	private List<Veiculo> listaVeiculos = new ArrayList<>();
	private Integer id;
	private String bloco;	

//	Anotação que diz que é uma coleção de objetos endereco, cria uma segunda tabela no banco
//	Fetch diz o tamanho de linhas trazias do banco (EAGER traz tudo do banco, todas as informacoes)
	@ElementCollection	(fetch = FetchType.EAGER)
//	Anotação que dá o nome que eu desejo para a tabela a ser criada
	@JoinTable(name="tb_veiculo", joinColumns=@JoinColumn(name = "id_usuario"))
	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	//	Identifica que é uma Primary Key
	@Id
//	Gera o código de PK de moto automatico
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
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
	public Integer getNumeroApartamento() {
		return numeroApartamento;
	}
	public void setNumeroApartamento(Integer numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}


}
