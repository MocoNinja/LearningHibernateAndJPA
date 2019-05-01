package ja.javilearn.jpa_hibernate.database;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import ja.javilearn.jpa_hibernate.model.Customer;

public class CustomerDAO {
	public static Customer findById(Long id) {
		EntityManager em = DB.getEntityManager();
		Customer found = em.find(Customer.class, id);
		return found;
	}

	public static List<Customer> findAll() {
		List<Customer> customers = new ArrayList<>();
		EntityManager em = DB.getEntityManager();
		customers = (List<Customer>) em.createQuery("FROM Customer", Customer.class).getResultList();
		return customers;
	}

	public static void insert(Customer c) {
		EntityManager em = DB.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	public static void update(Customer c) {
		EntityManager em = DB.getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	public static void delete(Customer c) {
		EntityManager em = DB.getEntityManager();
		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
	}
}
