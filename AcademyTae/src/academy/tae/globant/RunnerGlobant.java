package academy.tae.globant;

import java.util.Scanner;
import academy.tae.main.*;

public class RunnerGlobant{

	protected static Scanner myInput;
	protected RunnerMain mainMenu;

	public void main() {
		Employee employee = new Employee();
		employee.printEmployeeMethods();
		assignedPoject(employee);
	}
//	
//	public static void assignedPoject(Globant g) {
//		System.out.print("Digite el salario del empleado: ");
//		String projectName = myInput.nextLine();
//		g.assignedProject(projectName);
//	}

	private static void assignedPoject(Employee e) {
		e.assignedProject();
		System.out.print("\nDese ingresar al men� principal? S/N: ");
		myInput = new Scanner(System.in);
		String confirmation = myInput.next();
		if (confirmation.equals("S")) {
			String[] arguments = new String[] { "123" };
			RunnerMain.main(arguments);
		} else {
			System.out.println("\nGracias por consultar el ejercicio de herencia, abstracci�n e implementaci�n.");
			System.out.println("Buen d�a.!");
			System.exit(1);
		}
	}
}
