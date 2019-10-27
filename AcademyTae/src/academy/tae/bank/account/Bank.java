package academy.tae.bank.account;

import java.util.InputMismatchException;
import java.util.Scanner;

import academy.tae.main.RunnerMain;

public class Bank {

	private Scanner myInput;
	private double balance;
	private double amountDeposit;
	private double amountWithDraw;

	public Bank() {
	}

	// Assign value to deposit
	public void setDeposit(double amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	// Assign value to with draw
	public void setAmountWithDraw(double amountWithDraw) {
		this.amountWithDraw = amountWithDraw;
	}

	// Method Deposit
	protected double getDeposit() {
		this.balance = this.balance + this.amountDeposit;
		System.out.println("Your current balance is $" + this.balance + "\n");
		printTransactions();
		return this.balance;
	}

	// Method WithDraw
	protected double getWithDraw() {
		if (this.balance >= this.amountWithDraw) {
			this.balance = this.balance - this.amountWithDraw;
			System.out.println("Your current balance is $" + this.balance);
		} else {
			System.out.println("You can't withdraw more than current balance $" + this.balance);
		}
		printTransactions();
		return this.balance;
	}

	// Choose a transaction type
	public void chooseTransactionType() {
		myInput = new Scanner(System.in);
		int option = myInput.nextInt();
		try {
			switch (option) {
			case 1:
				System.out.println("\n------------------------------- Deposit option:");
				System.out.print("\nPlease insert the amount to deposit: ");
				this.amountDeposit = myInput.nextDouble();
				getDeposit();
				break;
			case 2:
				System.out.println("\n------------------------------- Deposit withdraw:");
				System.out.print("\nPlease insert the amount to withdraw: ");
				this.amountWithDraw = myInput.nextDouble();
				getWithDraw();
				break;
			case 3:
				System.out.println("\n------------------------------- Check balance option:");
				System.out.println("\nYour current balance is: " + this.balance + "\n\n");
				printTransactions();
				break;

			case 4:
				String[] arguments = new String[] {"123"};
			    RunnerMain.main(arguments);
				break;
			case 5:
				System.out.println("\nThanks for use our service.");
				System.out.println("Good bye !");
				System.exit(1);
				break;
			default:
				System.out.println("\nSelect an option between 1 and 5. \nTry again please: \n	");
				printTransactions();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nPlease enter an integer");
			printTransactions();
		}
	}

	public void printTransactions() {
		System.out.println("\n\n*******************************************************");
		System.out.println("***************** Bank Account ****************");
		System.out.println("*******************************************************");
		System.out.println("\n \nChoose an option: \n1- Deposit.");
		System.out.println("2- With Draw.");
		System.out.println("3- Check balance.");
		System.out.println("4- Back to main menu.");
		System.out.println("5- Exit");
		System.out.print("Put your option: ");
		chooseTransactionType();
	}
}
