package academy.tae.bank.account;

public class Person {
	
	private int idPerson;
	private String firstName;
	private String lastName;
	
	public Person () {}
	
	
	//Insert new Values
	public void setOwnerName (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Retrieve and show the values
		public String getFullName() {
			return firstName +" "+ lastName;
		}
	
	//Random idPerson
	public int generateIdPerson() {
		this.idPerson = (int) (Math.random() * 100.0 + 1);
		return this.idPerson;
	}
	
	//Print values methods
	public void printPerson() {
		System.out.println("Welcome " + getFullName() + " your ID is: " + generateIdPerson() + "\n");
	}
}
