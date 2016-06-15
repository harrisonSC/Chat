package chat.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil{
	   private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Chat");
	   
	   public static EntityManager getEntityManager(){
	      return entityManagerFactory.createEntityManager();
	   }
	}
