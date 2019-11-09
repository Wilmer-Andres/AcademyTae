package data;

/**
 * @author wilmer.poveda
 *
 */

import java.util.ArrayList;
import java.util.Scanner;
import common.Utils;
import test.Main;

public class Professor extends Person {
	private Scanner myInput;
	private Utils utils;
	private String typeWorker;
	private int basicSalary;
	private int experienceYears;
	private double activeHours;
	private int indexTypeWorked;
	private static String typePerson;
	private double finalSalary;
	protected static ArrayList<Person> teacherList;

	/**
	 * Default constructor
	 */
	public Professor() {
		this.myInput = new Scanner(System.in);
		this.utils = new Utils();
		new Main();
		teacherList = listByDefaultTeacher();
		this.basicSalary = 800000;
	}

	/**
	 * This is a main constructor of Professor.java This constructor helps to build
	 * the teacherList by default.
	 * 
	 * @param idPersona
	 * @param name
	 * @param lastName
	 * @param type
	 * @param typeWorker
	 * @param salary
	 */
	public Professor(int idPersona, String name, String lastName, String type, String typeWorker, double salary) {
		super(idPersona, name, lastName, type);
		super.setType("Profesor");
		typePerson = super.getType();
		this.typeWorker = typeWorker;
		this.finalSalary = salary;
	}

	/**
	 * public String getTypeWorker
	 * 
	 * @return typeWorker
	 */
	public String getTypeWorker() {
		return typeWorker;
	}

	/**
	 * public void setTypeWorker
	 * 
	 * @param typeWorker. String type.
	 */
	public void setTypeWorker(String typeWorker) {
		this.typeWorker = typeWorker;
	}

	/**
	 * private double getFinalSalary Double type
	 * 
	 * @return finalSalary
	 */
	private double getFinalSalary() {
		return finalSalary;
	}

	/**
	 * private void setFinalSalary
	 * 
	 * @param finalSalary
	 */
	private void setFinalSalary(double finalSalary) {
		this.finalSalary = finalSalary;
	}

	/**
	 * public String addPerson() is an Abstract method from Person.java. Return a
	 * string with all values to add to teacherList.
	 */
	@Override
	public String addPerson() {
		return (super.getIdPerson() + " " + super.getName() + " " + super.getLastName() + " " + super.getType() + " "
				+ " " + this.typeWorker + " " + this.finalSalary);
	}

	/**
	 * public static ArrayList<Person> listByDefaultTeacher() Add initial values to
	 * teacherList, it's using a constructor to create a new register.
	 * 
	 * @return teacherList this is an initial list of professors.
	 */
	public static ArrayList<Person> listByDefaultTeacher() {
		teacherList = new ArrayList<>();
		teacherList.add(new Professor(12, "Felipe", "Jimenez", "Profesor(a)", "Tiempo completo", 4400000));
		teacherList.add(new Professor(21, "Carol", "Bohorquez", "Profesor(a)", "Tiempo completo", 5500000));
		teacherList.add(new Professor(10, "Luisa", "Hernandez", "Profesor(a)", "Tiempo parcial", 3800000));
		teacherList.add(new Professor(20, "David", "Castañeda", "Profesor(a)", "Tiempo parcial", 4700000));
		return teacherList;
	}

	/**
	 * public void addTeacher() This method is available to add a new teacher, using
	 * this method is possible to add name, lastName and idTeacher.
	 */
	public void addTeacher() {
		System.out.println("\n\n\n\n------------------------------- Agregar un profesor:");
		System.out.println("Por favor digite los datos solicitados a continuación \npara ingresar un nuevo registro. ");

		System.out.print("Número de identificación: ");
		int idTeacher = myInput.nextInt();
		myInput.nextLine();
		utils.searchIndexPersonListById(idTeacher, teacherList);
		int auxLongList = teacherList.size() - 1;

		while (auxLongList >= 0 && utils.index != -1) {
			if (teacherList.get(auxLongList).getIdPerson() == idTeacher) {
				System.out.println("\nEl ID ingresado ya esta registrado");
				System.out.println("Desea ver la lista de profesores? S/N");
				String conf = myInput.nextLine();
				if (conf.equalsIgnoreCase("s")) {
					printAllTeacherList();
					addTeacher();
				} else {
					String[] args = new String[] { "123" };
					Main.main(args);
				}
			}
			auxLongList--;
		}
		super.setIdPerson(idTeacher);

		System.out.print("Nombre del profesor: ");
		String nameTeacher = myInput.nextLine();
		super.setName(nameTeacher);

		System.out.print("Apellido del profesor: ");
		String lastNameTeacher = myInput.nextLine();
		super.setLastName(lastNameTeacher);

		super.setType("Profesor");

		System.out.println("Digite el tipo de contrato del profesor(a) : ");
		System.out.println("1- Tiempo completo.");
		System.out.println("2- Tiempo parcial.");
		System.out.print("Digite 1 o 2: ");
		indexTypeWorked = myInput.nextInt();

		calculateSalasry(indexTypeWorked);

		teacherList.add(
				new Professor(idTeacher, nameTeacher, lastNameTeacher, typePerson, this.typeWorker, getFinalSalary()));

		System.out.println("\n-------------- Registro exitoso.");
	}

	/**
	 * public void queryTeacher() Search a teacher using
	 * utils.searchIndexPersonList(nameTeacher, teacherList) method. Print the value
	 * of teacherList using the retrieve index
	 */
	public void searchTeacher() {
		System.out.println("\n\n\n\n------------------------------- Buscar un profesor:");
		System.out.print("Nombre del docente: ");
		String nameTeacher = myInput.next();

		utils.searchIndexPersonListByName(nameTeacher, teacherList);
		int auxIndex = utils.index;
		if (auxIndex != -1) {
			System.out.println(teacherList.get(auxIndex).addPerson());
		} else {
			System.out.println("\\n-------------- Intente de nuevo por favor.");
			searchTeacher();
		}
	}

	/**
	 * public void deleteTeacher() Delete a teacher using
	 * utils.searchIndexPersonList method and teacher's name as parameter
	 */
	public void deleteTeacher() {
		System.out.println("\n\n\n\n------------------------------- Eliminar un profesor:");
		System.out.print("Nombre del(a) profesor(a): ");
		String nameTeacher = myInput.next();
		utils.searchIndexPersonListByName(nameTeacher, teacherList);
		int auxIndex = utils.index;

		if (auxIndex != -1) {
			teacherList.remove(auxIndex).addPerson();
			System.out.println("------ Profesor(a) eliminado.");
		} else {
			System.out.println("\\n-----El profesor que ingreso no existe.");
			System.out.println("\\n-----Intente de nuevo por favor, Gracias.\n");
			deleteTeacher();
		}

	}

	/**
	 * public void printAllTeacherList() Print all list values within teacherList.
	 */
	public void printAllTeacherList() {
		System.out.println("\n\n\n\n------------------------------- Lista de Profesores:");
		utils.printList(teacherList);
	}

	/**
	 * Double calculateSalasry Return final salary value using getFinalSalary Use
	 * the following values to index variable (1) Tiempo completo (2) Tiempo parcial
	 * 
	 * @param index
	 * @return getFinalSalary() Assign to finalSalary variable a value to add a new
	 *         professor
	 */
	public Double calculateSalasry(int index) {
		Double auxSalary;
		while (index > 2 && index < 1) {
			System.out.print("Ingrese un número: (1 o 2): ");
			index = myInput.nextInt();
		}
		if (index == 1) {
			System.out.print("Digite los años de experiencia: ");
			experienceYears = myInput.nextInt();
			auxSalary = (experienceYears * 1.1);
			setFinalSalary(this.basicSalary + auxSalary.intValue());
			this.typeWorker = "Tiempo completo.";
			return getFinalSalary();
		} else {
			System.out.print("Digite horas de trabajo por semana (Ejemplo: 10,5): ");
			activeHours = myInput.nextDouble();
			setFinalSalary(this.basicSalary + ((this.basicSalary * activeHours) / 100));
			this.typeWorker = "Tiempo parcial.";
			return getFinalSalary();
		}
	}
}
