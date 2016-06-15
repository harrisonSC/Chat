package chat.dao;

import java.util.List;
import javax.persistence.EntityManager;
import chat.entities.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO {
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public void salvar(Usuario usuario) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(usuario);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();

	}

	@Override
	public void atualizar(Usuario usuario) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuario);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	@Override
	public void excluir(Usuario usuario) {

		this.entityManager.getTransaction().begin();
		Object c = this.entityManager.merge(usuario);
		this.entityManager.remove(c);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return null;
	}

	@Override
	public List<Usuario> listar() {
		return this.entityManager.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();

	}

}
