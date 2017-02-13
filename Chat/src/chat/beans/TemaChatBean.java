package chat.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.model.DualListModel;

import chat.entities.TemaChat;
import chat.rn.TemaChatRN;

@ManagedBean(name = "temaChatBean")
@RequestScoped
public class TemaChatBean {

	private TemaChat temaChat = new TemaChat();
	private List<TemaChat> lista;
	private List<SelectItem> listarItens;
 //   private DualListModel<String> temas;

	public String salvar() {
		FacesContext contex = FacesContext.getCurrentInstance();
		TemaChatRN TemaChatRN = new TemaChatRN();
		TemaChatRN.salvar(this.temaChat);
		this.temaChat = new TemaChat();
		return "/restrito/cadastroTemas";
	}

	public String editar() {
		return "/restrito/cadastroTemas";
	}

	public String excluir() {
		TemaChatRN TemaChatRN = new TemaChatRN();
		TemaChatRN.excluir(this.temaChat);
		this.lista = null;
		return null;
	}

	public TemaChat getTemaChat() {
		return temaChat;
	}

	public void setTemaChat(TemaChat temaChat) {
		this.temaChat = temaChat;
	}

	public List<TemaChat> getLista() {
		if (this.lista == null) {
			TemaChatRN TemaChatRN = new TemaChatRN();
			this.lista = TemaChatRN.listar();
		}

		return lista;
	}

	public List<SelectItem> getListarItens() {

		TemaChatRN TemaChatRN = new TemaChatRN();
		ArrayList<SelectItem> temaChatAux = new ArrayList<SelectItem>();
		//List<String> temasTarget = new ArrayList<String>();
		//List<String> listarItensAux = new ArrayList<String>();
		for (TemaChat temaChat : TemaChatRN.listar()) {
			temaChatAux.add(new SelectItem(temaChat.getId(), temaChat.getDescricaoSala()));
			this.listarItens = temaChatAux;
		}
		return listarItens;
		
	}

}
