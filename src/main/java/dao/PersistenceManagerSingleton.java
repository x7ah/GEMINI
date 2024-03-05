package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManagerSingleton {
	
	//Lo unico que cambiaremos es la unidad de persistencia, lo demas será igual
	public static final String UNIDAD_PERSISTENCIA="Porra";
	
	private static PersistenceManagerSingleton instance = null;
	
	private EntityManagerFactory emf;
	
	public PersistenceManagerSingleton() {
//		emf.createEntityManager();
		
	}
	
	//si es null creamos una instancia de PersistenceManagerSingleton, y me la devuelve
	public static PersistenceManagerSingleton getInstance() {
		if (instance == null) {
			instance = new PersistenceManagerSingleton();
		}		
//		emf=PersistenceManagerSingleton.getInstance().getEntityManagerFactory();
		return instance;
	}
	
	//se va a encargar de hacer todas las llamadas
	public EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
		}		
		return emf;
	}
	
	public void closeEntityManagerFactory() {
		if(emf != null) {
			emf.close();
			emf=null;
		}
	}
}
