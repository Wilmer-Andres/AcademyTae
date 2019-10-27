package academy.tae.globant;

import java.util.Scanner;

public class Employee extends Rol implements Globant {

	private String name;
	private String lastName;
	private static Scanner myInput = new Scanner(System.in);
	protected String projectName;

	public Employee() {
	}

//	public Employee(String name, String lastName, String rolName, int rolSalary) {
//		super(rolName, rolSalary);
//		this.setName(name);
//		this.setLastName(lastName);
//	}

	/**
	 * Getters and Setters of this class
	 * 
	 * @return
	 */
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

	/**
	 * Methods of abstract class Rol
	 */
	@Override
	public void rolName() {
		System.out.println("\nSeleccione el rol para el empleado:");
		System.out.println("1- Junior Engeneer.");
		System.out.println("2- Senior Engeneer.");
		System.out.println("3- Technical lead.");
		System.out.print("Digite un número: ");
		int option = myInput.nextInt();
		System.out.println("\nCaracterísticas del rol:");
		switch (option) {
		case 1:
			super.setRolName("Junior Engeneer");
			super.setRolSalary(rolSalary);
			super.listResponsabilityJuniorEngeneer();
			break;
		case 2:
			super.setRolName("Senior Engeneer");
			super.setRolSalary(rolSalary);
			super.listResponsabilitySeniorEngeneer();
			break;
		case 3:
			super.setRolName("Technical Leader");
			super.setRolSalary(rolSalary);
			super.listResponsabilityTechnicalLead();
			break;
		default:
			System.out.println("Ingrese un número.");
		}
	}

	@Override
	public Integer rolSalary() {
		int _rolSalary = 0;
		do {
			System.out.print("\nDigite el salario del empleado(a): ");
			_rolSalary = myInput.nextInt();
			if(_rolSalary <= 0)
				System.out.println("Ingresar valores positivos.\n");
		}while(_rolSalary <= 0);
		super.setRolSalary(_rolSalary);
		return null;
	}

	/**
	 * Methods of implements class
	 */

	@Override
	public void assignedProject() {
		System.out.println("\n-----------------------------------------------------\n");
		System.out.println("El señor(a) " + this.getName() + " " + this.getLastName() + " es un(a) " + Globant.glober);
		System.out.println("Salario: " + super.getRolSalary());
		System.out.println("Asignado al proyecto: " + this.projectName);
		System.out.println("Cargo: " + super.getRolName() + " con las siguientes labores: ");
		if (super.getRolName().equals("Junior Engeneer")) {
			super.listResponsabilityJuniorEngeneer();
		} else if (super.getRolName().equals("Senior Engeneer")) {
			super.listResponsabilitySeniorEngeneer();
		} else {
			super.listResponsabilityTechnicalLead();
		}
	}

	/**
	 * Employee information
	 */
	public void newEmployee() {
		System.out.println("\n\n\n\n*******************************************************");
		System.out.println("********************* Globant *************************");
		System.out.println("*******************************************************");
		System.out.print("Digite el nombre del empleado: ");
		String employeeName = myInput.nextLine();
		this.setName(employeeName);
		System.out.print("Digite el apellido del empleado: ");
		String employeeLastName = myInput.nextLine();
		this.setLastName(employeeLastName);
		System.out.print("Asignar a un proyecto: ");
		projectName = myInput.nextLine();
		rolName();
		rolSalary();
	}

	public void printEmployeeMethods() {
		newEmployee();
	}
}
