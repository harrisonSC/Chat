package chat.dao;

import java.util.List;

import chat.entities.TemaChat;


public interface TemaChatDAO {

	public void salvar(TemaChat temaChat);
	public void atualizar(TemaChat temaChat);
	public void excluir(TemaChat temaChat);
	public TemaChat carregar(Integer id);
	public List<TemaChat> listar();
}
