package chat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 * The persistent class for the TemaChat database table.
 * 
 */
@Entity(name = "tema_chat")
@NamedQueries({ @NamedQuery(name = "tema_chat.findAll_orderByName", query = "SELECT t FROM tema_chat t order by t.descricaoSala")

// colocar outras querys	
})

public class TemaChat {

	public static final String BUSCAR_TEMA_POR_ORDEM_NOMINAL = "tema_chat.findAll_orderByName";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name ="descricao_sala")
	private String descricaoSala;
	@Column(name ="tamanho_sala")
	private int tamanhoSala;
	@Column(name ="qtd_sala")	
	private int qtdSala;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricaoSala() {
		return descricaoSala;
	}
	public void setDescricaoSala(String descricaoSala) {
		this.descricaoSala = descricaoSala;
	}
	public int getTamanhoSala() {
		return tamanhoSala;
	}
	public void setTamanhoSala(int tamanhoSala) {
		this.tamanhoSala = tamanhoSala;
	}
	public int getQtdSala() {
		return qtdSala;
	}
	public void setQtdSala(int qtdSala) {
		this.qtdSala = qtdSala;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricaoSala == null) ? 0 : descricaoSala.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + qtdSala;
		result = prime * result + tamanhoSala;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemaChat other = (TemaChat) obj;
		if (descricaoSala == null) {
			if (other.descricaoSala != null)
				return false;
		} else if (!descricaoSala.equals(other.descricaoSala))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (qtdSala != other.qtdSala)
			return false;
		if (tamanhoSala != other.tamanhoSala)
			return false;
		return true;
	}
	
}
