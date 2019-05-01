package ja.javilearn.jpa_hibernate.model;

import java.util.List;

import javax.persistence.EntityManager;

import ja.javilearn.jpa_hibernate.database.DB;

public class HelloWorld {

	public static void main(String[] args) {

		EntityManager em = DB.getEntityManager();
		List<Customer> employees = CustomerUtils.generateList(20);
		em.getTransaction().begin();
		employees.forEach(c -> em.persist(c));
		em.getTransaction().commit();
	}
}
