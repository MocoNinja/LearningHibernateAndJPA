package ja.javilearn.jpa_hibernate.model;

import ja.javilearn.jpa_hibernate.database.CustomerDAO;
import ja.javilearn.jpa_hibernate.database.DB;

public class HelloWorld {

	public static void main(String[] args) {
		CustomerUtils.populateDatabase(10);
		Customer number2 = CustomerDAO.findById(2L);
		System.out.println(number2.toString());
		number2.setName("Esto ha cambiado!");
		System.out.println(number2.toString());
		CustomerDAO.update(number2);
		System.out.println(number2.toString());
		CustomerDAO.findAll().forEach(c -> System.out.println(c));
		CustomerDAO.delete(CustomerDAO.findById(2L));
		CustomerDAO.findAll().forEach(c -> System.out.println(c));
		DB.close();
		CustomerDAO.insert(number2);
		DB.close();
		CustomerDAO.findAll().forEach(c -> System.out.println(c));
	}
}
