package data;

/**
 * @author wilmer.poveda
 *
 */

public abstract class Person {

	private int idPerson;
	private String name;
	private String lastName;
	private String type;

	public Person() {
	}

	public Person(int idPerson, String name, String lastName, String type) {
		this.idPerson = idPerson;
		this.name = name;
		this.lastName = lastName;
		this.type = type;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract String addPerson();
}
