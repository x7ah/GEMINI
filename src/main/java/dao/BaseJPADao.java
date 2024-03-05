package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

public class BaseJPADao {
	
	public BaseJPADao() {
		
	}
	
	//llama al PersistenceManagerSingleton, que maneja todas las entidades
	public static EntityManager getEntityManager() {//El EntityManager abre la conexión con la base de datos
		EntityManagerFactory emf = PersistenceManagerSingleton.getInstance().getEntityManagerFactory();
		return emf.createEntityManager();
	}

}
