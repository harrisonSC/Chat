package chat.util;

import chat.dao.UsuarioDAO;
import chat.dao.UsuarioDAOHibernate;

public class DAOFactory {
	public static UsuarioDAO criaUsuarioDAO() {
		
		UsuarioDAOHibernate UsuarioDAO = new UsuarioDAOHibernate();
		UsuarioDAO.setEntityManager(JPAUtil.getEntityManager());
		return UsuarioDAO;
	}


}
