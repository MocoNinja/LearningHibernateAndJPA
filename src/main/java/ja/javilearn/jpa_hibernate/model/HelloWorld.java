package ja.javilearn.jpa_hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloWorld {

	/**
	 * Requires JEE server
	 * 
	 * @PersistenceContext(unitName = "persistence")
	 */
	private static EntityManager manager;
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory("persistence"); // This works for our setup
		manager = factory.createEntityManager();
		
		List<Employee> employees = EmployeeUtils.generateList(100000);
		System.out.println("Starting to populate the database...");
		manager.getTransaction().begin();
		//Insert employees
		employees.forEach(e -> {
			System.out.println("Insertint employee: " + e);
			manager.persist(e);
		});
		manager.getTransaction().commit();
		System.out.println("Database was populated!");
	}
}
