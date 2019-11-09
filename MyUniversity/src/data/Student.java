package data;

/**
 * @author wilmer.poveda
 *
 */

import common.Utils;
import test.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {

	University university;
	private Scanner myInput;
	private Utils utils;
	private int age;

	protected static ArrayList<Person> studentList;
	private static String typePerson;

	public Student() {
		university = new University();
		studentList = listByDefaultStudent();
		myInput = new Scanner(System.in);
		this.utils = new Utils();
	}

	public Student(int idPerson, String name, String lastName, int age, String type) {
		super(idPerson, name, lastName, type);
		super.setType("Estudiante");
		typePerson = type;
		this.age = age;
	}

	@Override
	public String addPerson() {
		return (super.getIdPerson() + " " + super.getName() + " " + super.getLastName() + " " + this.age + " "
				+ super.getType());
	}

	public static ArrayList<Person> listByDefaultStudent() {
		// System.out.println("\n\n\n\n------------------------------- Lista actual de
		// estudiantes:");
		studentList = new ArrayList<>();
		studentList.add(new Student(0000001, "Wilmer", "Poveda", 12, "Estudiante"));
		studentList.add(new Student(0000002, "Gloria", "Rodriguez", 27, "Estudiante"));
		studentList.add(new Student(0000003, "Luis", "Larrota", 31, "Estudiante"));
		studentList.add(new Student(0000004, "July", "Masmela", 25, "Estudiante"));
		studentList.add(new Student(0000005, "Camilo", "Ruiz", 29, "Estudiante"));
		studentList.add(new Student(0000006, "John", "Vasquez", 30, "Estudiante"));
//		for (Person personList : studentList) {
//			System.out.println(personList.addPerson());
//		}
		return studentList;
	}

	public void addStudent() {
		System.out.println("\n\n\n\n------------------------------- Agregar un estudiante:");
		System.out.println("Por favor digite los datos solicitados a continuación \npara ingresar un nuevo registro. ");

		System.out.println("Número de documento: ");
		int idStudent = myInput.nextInt();
		myInput.nextLine();
		utils.searchIndexPersonListById(idStudent, studentList);
		int auxLongList = studentList.size() - 1;
		while (auxLongList >= 0 && utils.index != -1) {
			if (studentList.get(auxLongList).getIdPerson() == idStudent) {
				System.out.println("\nEl ID ingresado ya esta registrado");
				System.out.println("Desea ver la lista de estudiantes? S/N");
				String conf = myInput.nextLine();
				if (conf.equalsIgnoreCase("s")) {
					printAllStudentList();
					addStudent();
				} else {
					String[] args = new String[] { "123" };
					Main.main(args);
				}
			}
			auxLongList--;
		}
		
		super.setIdPerson(idStudent);
		
		System.out.print("Nombre del estudiante: ");
		String nameStudent = myInput.nextLine();
		super.setName(nameStudent);

		System.out.print("Apellido del estudiante: ");
		String lastNameStudent = myInput.nextLine();
		super.setLastName(lastNameStudent);

		System.out.print("Edad del estudiante: ");
		this.age = myInput.nextInt();

		studentList.add(new Student(idStudent, nameStudent, lastNameStudent, age, typePerson));
		System.out.println("\n--------------Registro exitoso.");
	}

	public void queryStudentList() {
		System.out.println("\n\n\n\n------------------------------- Buscar un estudiante:");
		System.out.print("Nombre del estudiante: ");
		String nameStudent = myInput.next();

		utils.searchIndexPersonListByName(nameStudent, studentList);
		int auxIndex = utils.index;
		if (auxIndex == -1 || auxIndex < 0) {
			queryStudentList();
		} else {
			System.out.println(studentList.get(auxIndex).addPerson());
		}
	}

	public void printAllStudentList() {
		System.out.println("\n\n\n\n------------------------------- Lista de estudiantes:");
		utils.printList(studentList);
	}

	public void deleteStudent() {
		System.out.println("\n\n\n\n------------------------------- Eliminar un estudiante:");
		System.out.print("Nombre del estudiante: ");
		String nameStudent = myInput.next();
		utils.searchIndexPersonListByName(nameStudent, studentList);
		int auxIndex = utils.index;

		if (auxIndex != -1) {
			studentList.remove(auxIndex).addPerson();
			System.out.println("------ Estudiante eliminado.");
		} else {
			System.out.println("\\n-----El estudiante que ingreso no existe.");
			System.out.println("\\n-----Intente de nuevo por favor, Gracias.\n");
			deleteStudent();
		}

	}

}
