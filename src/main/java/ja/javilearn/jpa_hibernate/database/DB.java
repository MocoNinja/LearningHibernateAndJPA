package ja.javilearn.jpa_hibernate.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");
	private static EntityManager manager = null; 

	private static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		if (manager == null) {
			manager = createEntityManager();
		}
		return manager;
	}
	
	public static void close() {
		manager.close();
		manager = null;
	}
}