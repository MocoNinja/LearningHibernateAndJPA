package ja.javilearn.jpa_hibernate.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import ja.javilearn.jpa_hibernate.database.CustomerDAO;

public class CustomerUtils {
	private static final String[] names = { "Pepe", "Juan", "Gonzalo", "David", "Jorge", "Víctor", "Antonio", "Carlos",
			"Alejandro", "Alex", "Daniel", "Javier", "Mario", "Paula", "Sara", "Verónica", "Victoria", "Beatriz" };
	private static final String[] surnames = { "González", "Tello", "Gómez", "Fernández", "Pérez", "Sánchez", "García",
			"Moreno", "Jiménez", "Fustero", "Sanz", "Rodríguez", "De la fuente", "Fuertes", "Forcano" };

	public static void populateDatabase(int amount) {
		List<Customer> employees = CustomerUtils.generateList(20);
		employees.forEach(c -> CustomerDAO.insert(c));
	}

	public static List<Customer> generateList(int amount) {
		List<Customer> customers = new ArrayList<Customer>();

		for (long i = 1; i <= amount; i++) {
			Customer creating = new Customer(i, getRandomName(), getRandomSurname(2), getRandomDate(18, 50));
			customers.add(creating);
		}

		return customers;
	}

	private static Date getRandomDate(int minAge, int maxAge) {
		Random random = new Random();
		int currentYear = LocalDate.now().getYear();
		int minYear = currentYear - maxAge;
		int maxYear = currentYear - minAge;
		int minDay = (int) LocalDate.of(minYear, 1, 1).toEpochDay();
		int maxDay = (int) LocalDate.of(maxYear, 1, 1).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);

		return java.sql.Date.valueOf(LocalDate.ofEpochDay(randomDay));

	}

	private static String getRandomName() {
		Random rand = new Random();
		int index = rand.nextInt(names.length);
		return names[index];
	}

	private static String getRandomSurname(int amount) {
		Random rand = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < amount; i++) {
			int index = rand.nextInt(surnames.length);
			sb.append(surnames[index]);
			if (i < amount - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
