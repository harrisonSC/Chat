package chat.dao;

import java.util.List;

import javax.persistence.EntityManager;

import chat.entities.ListaNegra;
import chat.entities.TemaChat;

public class ListaNegraDAOHibernate implements ListaNegraDAO{

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}
	
	@Override
	public void salvar(ListaNegra listaNegra) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(listaNegra);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	@Override
	public void excluir(ListaNegra listaNegra) {
		this.entityManager.getTransaction().begin();
		Object c = this.entityManager.merge(listaNegra);
		this.entityManager.remove(c);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
		
	}

	@Override
	public List<ListaNegra> listar() {
		return	this.entityManager.createNamedQuery(ListaNegra.BUSCAR_LN_POR_ORDEM_ID, ListaNegra.class).getResultList();
	}

}
