package ja.javilearn.jpa_hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

@Entity
@Table(name = "customers", uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "surname" }) })

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_customer")
	@NotNull
	private Long id;

	@Column(name = "name", length = 100)
	@NotNull
	private String name;

	@Column(name = "surname", length = 150)
	@NotNull
	private String surname;

	@Column(name = "birth_date")
	@NotNull
	private Date birthDate;

	public Customer() {

	}

	public Customer(Long id, String name, String surname, Date birthDate) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, surname=%s, birthDate=%s]", id, name, surname, birthDate);
	}

}
