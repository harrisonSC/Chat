package chat.rn;

import java.util.List;

import chat.dao.ListaNegraDAO;
import chat.entities.ListaNegra;
import chat.util.DAOFactory;

public class ListaNegraRN {
	private ListaNegraDAO listaNegraDAO;
	
	public ListaNegraRN() {
		this.listaNegraDAO = DAOFactory.criaListaNegraDAO();
	}	
	
	public void salvar(ListaNegra listaNegra) {
		Integer id = listaNegra.getId();
			this.listaNegraDAO.salvar(listaNegra);
	}

	public List<ListaNegra> listar() {
		return this.listaNegraDAO.listar();
	}

	public void excluir(ListaNegra listaNegra) {
		this.listaNegraDAO.excluir(listaNegra);
	}

}
