package chat.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import chat.entities.ListaNegra;
import chat.rn.ListaNegraRN;

@ManagedBean(name = "listaNegraBean")
@RequestScoped
public class ListaNegraBean {

	private ListaNegra listaNegra = new ListaNegra();
	private List<ListaNegra> lista;

	public String salvar() {
		FacesContext contex = FacesContext.getCurrentInstance();
		ListaNegraRN listaNegraRN = new ListaNegraRN();
		listaNegraRN.salvar(this.listaNegra);
		this.listaNegra = new ListaNegra();
		return "/restrito/cadastroListaNegra";
	}


	public String excluir() {
		ListaNegraRN listaNegraRN = new ListaNegraRN();
		listaNegraRN.excluir(this.listaNegra);
		this.lista = null;
		return null;
	}

	public ListaNegra getListaNegra() {
		return listaNegra;
	}

	public void setListaNegra(ListaNegra listaNegra) {
		this.listaNegra = listaNegra;
	}

	public List<ListaNegra> getLista() {
		if (this.lista == null) {
			ListaNegraRN listaNegraRN = new ListaNegraRN();
			this.lista = listaNegraRN.listar();
		}
		return lista;
	}

}
