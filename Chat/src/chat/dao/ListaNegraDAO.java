package chat.dao;

import java.util.List;

import chat.entities.ListaNegra;


public interface ListaNegraDAO {

	public void salvar(ListaNegra listaNegra);
	public void excluir(ListaNegra listaNegra);
	public List<ListaNegra> listar();
	public void fecharSessao();
}
