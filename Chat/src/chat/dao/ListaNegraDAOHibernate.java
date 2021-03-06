package chat.dao;

import java.util.List;

import javax.persistence.EntityManager;

import chat.entities.ListaNegra;

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
		 List<ListaNegra> resultList = this.entityManager.createNamedQuery(ListaNegra.BUSCAR_LN_POR_ORDEM_ID, ListaNegra.class).getResultList();
		 
		return	resultList;
		
	}
	
	public void fecharSessao(){
		this.entityManager.close();
	}

}
