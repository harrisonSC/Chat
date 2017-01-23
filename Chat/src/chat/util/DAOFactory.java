package chat.util;

import chat.dao.TemaChatDAO;
import chat.dao.TemaChatDAOHibernate;
import chat.dao.UsuarioDAO;
import chat.dao.UsuarioDAOHibernate;

public class DAOFactory {
	public static UsuarioDAO criaUsuarioDAO() {
		
		UsuarioDAOHibernate UsuarioDAO = new UsuarioDAOHibernate();
		UsuarioDAO.setEntityManager(JPAUtil.getEntityManager());
		return UsuarioDAO;
	}

	public static TemaChatDAO criaTemaChatDAO() {
		
		TemaChatDAOHibernate TemaChatDAO = new TemaChatDAOHibernate();
		TemaChatDAO.setEntityManager(JPAUtil.getEntityManager());
		return TemaChatDAO;
	}	

}
