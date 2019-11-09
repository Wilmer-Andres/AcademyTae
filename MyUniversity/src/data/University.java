package data;

/**
 * @author wilmer.poveda
 *
 */

import java.util.Scanner;


public class University {

	private Scanner myInput;
	private String name;
	private Professor teacher;
	private Student student;
	private Course course;

	public University(String name) {
		this.setName(name);
		this.teacher = new Professor();
		this.student = new Student();
		this.course = new Course();
		this.myInput = new Scanner(System.in);
	}

	public University() {
	}

	public void universityMenuOptions() {
		int option = 0;
		try {
			option = Integer.parseInt(myInput.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("El dato ingresado no es un número.");
			System.out.println("\nSeleccione una opción entre 1 and 4. \nPor favor, intente de nuevo: \n");
			universityMenuOptions();
		}

		if (option != 4 && option != 3 && option != 2 && option != 1) {
			System.out.println("\nSeleccione una opción entre 1 y 4. \nPor favor, intente de nuevo: \n");
			menuUniversity();
		} else {
			switch (option) {
			case 1:
				int optTeacher = 0;
				do {
					System.out.println("\n\n\n\n\n///////////////////////////////////////////////////////");
					System.out.println("------------------------------- Menú Profesor");
					System.out.println("///////////////////////////////////////////////////////");
					System.out.println("1 - Consultar lista profesores.");
					System.out.println("2 - Consultar un profesor.");
					System.out.println("3 - Agregar un(a) profesor(a).");
					System.out.println("4 - Retirar de la lista un profesor.");
					System.out.println("5 - Regresar al menú principal.");
					System.out.print("Digite una opción (1 a 5): ");

					try {
						optTeacher = Integer.parseInt(myInput.nextLine());
					} catch (NumberFormatException ex) {
						System.out.println("El dato ingresado no es un número.");
						System.out.println("\nSeleccione una opción entre 1 y 5. \nPor favor, intente de nuevo: \n");
					}

					switch (optTeacher) {
					case 1:
						teacher.printAllTeacherList();
						break;
					case 2:
						teacher.searchTeacher();
						break;
					case 3:
						teacher.addTeacher();
						break;
					case 4:
						teacher.deleteTeacher();
						break;
					case 5:
						System.out.println("\nMenú de profesores cerrado. Regresando al menú principal...");
						menuUniversity();
						break;
					default:
						System.out
								.println("\nSeleccione una opción entre 1 and 5. \nPor favor, intente de nuevo: \n	");
					}
				} while (optTeacher > 0 & optTeacher < 6);

				break;
			case 2:
				int optStudent = 0;
				do {
					System.out.println("\n\n\n\n\n///////////////////////////////////////////////////////");
					System.out.println("------------------------------- Menú Estudinte");
					System.out.println("///////////////////////////////////////////////////////");
					System.out.println("1 - Consultar lista estudiantes.");
					System.out.println("2 - Consultar un estudiante.");
					System.out.println("3 - Agregar un(a) estudiante(a).");
					System.out.println("4 - Retirar de la lista un estudiante.");
					System.out.println("5 - Regresar al menú principal.");
					System.out.print("Digite una opción (1 a 5): ");
					
					try {
						optStudent = Integer.parseInt(myInput.nextLine());
					} catch (NumberFormatException ex) {
						System.out.println("El dato ingresado no es un número.");
						System.out.println("\nSeleccione una opción entre 1 y 5. \nPor favor, intente de nuevo: \n");
					}

					switch (optStudent) {
					case 1:
						student.printAllStudentList();
						break;
					case 2:
						student.queryStudentList();
						break;
					case 3:
						student.addStudent();
						break;
					case 4:
						student.deleteStudent();
						break;
					case 5:
						System.out.println("\nMenú de profesores cerrado. Regresando al menú principal...");
						menuUniversity();
						break;
					default:
						System.out
								.println("\nSeleccione una opción entre 1 and 5. \nPor favor, intente de nuevo: \n	");
					}
				} while (optStudent > 0 & optStudent < 6);
				break;
			case 3:
				int optCourse = 0;
				do {
					System.out.println("\n\n\n\n\n///////////////////////////////////////////////////////");
					System.out.println("------------------------------- Menú Clases/Cursos");
					System.out.println("///////////////////////////////////////////////////////");
					System.out.println("1 - Consultar lista de cursos.");
					System.out.println("2 - Consultar cursos con asignación (profesor/estudiante).");
					System.out.println("3 - Consultar un estudiante.");
					System.out.println("4 - Agregar un(a) clase/curso.");
					System.out.println("5 - Agregar un profesor/estudiante a un curso.");
					System.out.println("6 - Regresar al menú principal.");
					System.out.print("Digite una opción (1 a 6): ");

					try {
						optCourse = Integer.parseInt(myInput.nextLine());
					} catch (NumberFormatException ex) {
						System.out.println("El dato ingresado no es un número.");
						System.out.println("\nSeleccione una opción entre 1 y 6. \nPor favor, intente de nuevo: \n");
					}

					switch (optCourse) {
					case 1:
						course.printAllCourseList();
						break;
					case 2:
						System.out.println(
								"\n\n\n\n------------------------------- Lista relación Clase-Profesor-estudiante:");
						course.printCourseTeacherStudent();
						break;
					case 3:
						course.retrieveStudentCourseInfo();
						break;
					case 4:
						course.addCourse();
						break;
					case 5:
						Course.addTeacherAndStudetToCourse();
						break;
					case 6:
						System.out.println("\nMenú de clases/cursos cerrado. Regresando al menú principal...");
						menuUniversity();
						break;
					default:
						System.out
								.println("\nSeleccione una opción entre 1 and 5. \nPor favor, intente de nuevo: \n	");
					}
				} while (optCourse > 0 & optCourse < 8);
				break;
			case 4:
				System.out.println("\nGracias por consultar nuestro menú.");
				System.out.println("Buen día. !");
				System.exit(1);
				break;
			default:
				System.out.println("\nSeleccione una opción entre 1 and 4. \nPor favor, intente de nuevo: \n");
			}
		}
	}

	public void menuUniversity() {
		System.out.println("\n\n\n\n*******************************************************");
		System.out.println("******************************** " + this.getName());
		System.out.println("********************************     Menú");
		System.out.println("*******************************************************");
		System.out.println("\n Seleccione una opción del menú: ");
		System.out.println("1 - Menú Profesores.");
		System.out.println("2 - Menú Estudiantes.");
		System.out.println("3 - Menú Clases/Cursos.");
		System.out.println("4 - Salir.");
		System.out.print("Digite una opción (1 a 4): ");
		universityMenuOptions();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
