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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ListaNegra> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
