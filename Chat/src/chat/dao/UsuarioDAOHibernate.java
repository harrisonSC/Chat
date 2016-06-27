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
		
/*		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {
			Usuario usuarioPermissao = usuario.getCodigo();
			usuario.setPermissao(usuarioPermissao.getPermissao());
			//this.session.evict(usuarioPermissao);
		}	*/	
		
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
		//return this.session.get(Usuario.class, codigo);
		
	}

	@Override
	public List<Usuario> listar() {
		return this.entityManager.createNamedQuery(Usuario.BUSCAR_POR_ORDEM_NOMINAL, Usuario.class).getResultList();

	}
	
	public void  populaPermissao(Usuario usuario){
		
	}

}
