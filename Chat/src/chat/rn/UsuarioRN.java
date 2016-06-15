package chat.rn;

import java.util.List;

import chat.dao.UsuarioDAO;
import chat.entities.Usuario;
import chat.util.DAOFactory;

public class UsuarioRN {
	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criaUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}


	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
			if (codigo == null || codigo == 0) {
				//Permissao permissao = new Permissao();
				usuario.getPermissao().add("ROLE_USUARIO");
				//permissao.setTipo("2");
			//usuario.setPermissao(permissao);
			this.usuarioDAO.salvar(usuario);
		} else {
			//Permissao permissao = usuario.getPermissao();
			
			//usuario.setPermissao(permissao);
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}
	
	
}
