package ja.javilearn.jpa_hibernate.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence");

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}