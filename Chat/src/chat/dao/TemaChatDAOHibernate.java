package chat.dao;

import java.util.List;

import javax.persistence.EntityManager;

import chat.entities.TemaChat;


public class TemaChatDAOHibernate implements TemaChatDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}
	@Override
	public void salvar(TemaChat temaChat) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(temaChat);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}

	@Override
	public void atualizar(TemaChat temaChat) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(temaChat);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}

	@Override
	public void excluir(TemaChat temaChat) {
		this.entityManager.getTransaction().begin();
		Object c = this.entityManager.merge(temaChat);
		this.entityManager.remove(c);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}
	@Override
	public TemaChat carregar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TemaChat> listar() {
		return	this.entityManager.createNamedQuery(TemaChat.BUSCAR_TEMA_POR_ORDEM_NOMINAL, TemaChat.class).getResultList();

		
		 
	}



}
