package chat.rn;

import java.util.List;

import chat.dao.TemaChatDAO;
import chat.entities.TemaChat;
import chat.util.DAOFactory;

public class TemaChatRN {
	private TemaChatDAO temaChatDAO;
	
	public TemaChatRN() {
		this.temaChatDAO = DAOFactory.criaTemaChatDAO();
	}	
	
	public void salvar(TemaChat temaChat) {
		Integer id = temaChat.getId();
		if (id == null || id == 0) {
			this.temaChatDAO.salvar(temaChat);
		} else {
			this.temaChatDAO.atualizar(temaChat);
		}
	}

	public List<TemaChat> listar() {
		return this.temaChatDAO.listar();
	}

	public void excluir(TemaChat temaChat) {
		this.temaChatDAO.excluir(temaChat);
	}

}
