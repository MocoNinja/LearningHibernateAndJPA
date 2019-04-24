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
		
		List<Employee> employees = EmployeeUtils.generateList(200);
		employees.forEach(e -> System.out.println(e));
	}
}
