package Model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotaão que diz que essa classe vai compor a classe Usuario
@Embeddable
public class Veiculo {
	
//	private Integer id;
	private String placa;
	private Integer numeroChassi;
	
	public Veiculo(){

	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getNumeroChassi() {
		return numeroChassi;
	}

	public void setNumeroChassi(Integer numeroChassi) {
		this.numeroChassi = numeroChassi;
	}
	

//	Identifica que é uma Primary Key
//	@Id
//	Gera o código de PK de moto automatico
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
	
	@Override
		public String toString() {
			return "Placa "+this.getPlaca()+" Chassi "+ this.getNumeroChassi().toString();
		}

	
}
