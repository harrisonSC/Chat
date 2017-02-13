package chat.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "lista_negra")
@NamedQueries({
		@NamedQuery(name = "lista_negra.findAll_orderById", query = "SELECT ln FROM lista_negra ln order by ln.id")

		// colocar outras querys

})

public class ListaNegra {

	public static final String BUSCAR_LN_POR_ORDEM_ID = "lista_negra.findAll_orderById";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String msisdn;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar validade;
	@ManyToMany
	@JoinTable(name = "listanegra_tema", joinColumns = @JoinColumn(name = "listanegra_id", referencedColumnName = "id") , inverseJoinColumns = @JoinColumn(name = "tema_id", referencedColumnName = "id") )
	private List<TemaChat> temas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}

	public List<TemaChat> getTemas() {
		return temas;
	}

	public void setTemas(List<TemaChat> temas) {
		this.temas = temas;
	}

}
