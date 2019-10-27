package academy.tae.bank.account;

public class RunnerBank {
	
//	public static void main(String[] args){
	public void main() {
		Bank bank = new Bank ();
		Person person = new Person();
		
		person.setOwnerName("Wilmer", "Poveda");
		person.printPerson();
		bank.printTransactions();

	}
}
