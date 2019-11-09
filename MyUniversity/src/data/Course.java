package data;

/**
 * @author wilmer.poveda
 *
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import common.Utils;
import data.Professor;
import data.Student;
import test.Main;

public class Course {

	private String nameCourse;
	private String classRoom;
	private static int indexTeacher;
	private static int indexStudent;
	private static int indexCourse;

	private static Scanner myInput;
	private static Utils utils;
	private static ArrayList < Course > courseList = listByDefaultCourse();
	private static ArrayList < String > courseListWithStudentTeacher;

	public Course() {
		myInput = new Scanner(System.in);
		Course.utils = new Utils();
		courseListWithStudentTeacher = new ArrayList <  > ();
		listTeacherStudentToClassbyDefault();
	}

	/**
	 * public Course(String classRoom, String name) constructor
	 * Constructor
	 * @param classRoom
	 * @param name
	 */
	public Course(String classRoom, String name) {
		this.classRoom = classRoom;
		this.nameCourse = name;
	}

	/**
	 * public String getNameCourse()
	 * @return nameCouse of Course.java
	 */
	public String getNameCourse() {
		return nameCourse;
	}

	/**
	 * public void setNameCourse
	 * @param nameCourse
	 */
	public void setNameCourse(String nameCourse) {
		this.nameCourse = nameCourse;
	}

	/**
	 * getClassRoom()
	 * @return classRoom of Course.java
	 */
	public String getClassRoom() {
		return classRoom;
	}

	/**
	 * public void setClassRoom
	 * @param classRoom
	 */
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	/**
	 * public static ArrayList<Course> listByDefaultCourse() This method save a
	 * default courseList
	 * @return courseList classRoom, nameCourse
	 */
	public static ArrayList < Course > listByDefaultCourse() {
		courseList = new ArrayList <  > ();
		courseList.add(new Course("Training room", "Java Basic"));
		courseList.add(new Course("Feria room", "Jenkins"));
		courseList.add(new Course("Forest room", "Git"));
		courseList.add(new Course("Space room", "Maven"));
		return courseList;
	}

	/**
	 * public String addToListCourse() This method only return a String value and
	 * it's use to print the courseList values.
	 *
	 * @return classRoom and nameCourse Previous values have send by public void
	 *         addCourse() method.
	 */
	public String addToListCourse() {
		return (this.getClassRoom() + " " + this.getNameCourse());
	}

	/**
	 * public void addCourse() Add a new Course, this method use classRoom and
	 * nameCourse setter to send the values.
	 */
	public void addCourse() {
		System.out.println("\n\n\n\n------------------------------- Agregar un curso:");
		System.out.println("Por favor digite los datos solicitados a continuación \npara ingresar un nuevo registro. ");

		System.out.print("Nombre del salón: ");
		this.classRoom = myInput.nextLine();
		this.setClassRoom(classRoom);

		System.out.print("Nombre de la clase: ");
		this.nameCourse = myInput.nextLine();
		utils.searchIndexCourseList(this.nameCourse, courseList);
		int auxLongList = courseList.size() - 1;
		while (auxLongList >= 0 && utils.index != -1) {
			if (courseList.get(auxLongList).getNameCourse().equalsIgnoreCase(this.nameCourse)) {
				System.out.println("\nEl curso ingresado ya esta registrado");
				System.out.println("Desea ver la lista de cursos? S/N");
				String conf = myInput.nextLine();
				if (conf.equalsIgnoreCase("s")) {
					printAllCourseList();
					addCourse();
				} else {
					String[] args = new String[] { "123" };
					Main.main(args);
				}
			}
			auxLongList--;
		}
		this.setNameCourse(nameCourse);

		courseList.add(new Course(this.classRoom, this.nameCourse));
		System.out.println("\n--------------Registro exitoso.");
	}

	
	/**
	 * public static String addListAsignedByCourse(String courseName, String
	 * teacherName, String studentName)
	 *
	 * @param courseName  Name of course within courseList of Course.java
	 * @param teacherName Teacher name within teacherList of Professor.java
	 * @param studentName Student name within studentList of Student.java Search the
	 *                    list index of Course, Professor and Student classes.
	 *                    Return the main characteristics of each class to show it
	 *                    using printCourseTeacherStudent method.
	 * @return ("-------- Información curso: " +
	 *         Course.courseList.get(indexCourse).getNameCourse() + " " + "\n----" +
	 *         Course.courseList.get(indexCourse).getClassRoom() + " " + "\n----" +
	 *         Professor.teacherList.get(indexTeacher).getName() + " " +
	 *         Professor.teacherList.get(indexTeacher).getLastName() + " " +
	 *         Professor.teacherList.get(indexTeacher).getType() + " " + "\n----" +
	 *         Student.studentList.get(indexStudent).getName() + " " +
	 *         Student.studentList.get(indexStudent).getLastName() + " " +
	 *         Student.studentList.get(indexStudent).getType())
	 */
	public static String addListAsignedByCourse(String courseName, String teacherName, String studentName) {
		utils.searchIndexCourseList(courseName, courseList);
		indexCourse = utils.index;
		utils.searchIndexPersonListByName(teacherName, Professor.teacherList);
		indexTeacher = utils.index;
		utils.searchIndexPersonListByName(studentName, Student.studentList);
		indexStudent = utils.index;

		if (indexCourse == -1 || indexTeacher == -1 || indexStudent == -1) {
			addTeacherAndStudetToCourse();
		}

		return ("-------- Información curso: " + Course.courseList.get(indexCourse).getNameCourse() + " " + "\n----"
			 + Course.courseList.get(indexCourse).getClassRoom() + " " + "\n----"
			 + Professor.teacherList.get(indexTeacher).getName() + " "
			 + Professor.teacherList.get(indexTeacher).getLastName() + " "
			 + Professor.teacherList.get(indexTeacher).getType() + " " + "\n----"
			 + Student.studentList.get(indexStudent).getName() + " "
			 + Student.studentList.get(indexStudent).getLastName() + " "
			 + Student.studentList.get(indexStudent).getType()) + "\n\n";
	}

	/**
	 * public static ArrayList<String> listTeacherStudentToClassbyDefault() Initial
	 * relation Course, Teacher and Student. return a list by default
	 * couserListWithStudentTeacher.add(addListAsignedByCourse(courseName,
	 * professorName, studentName));
	 *
	 * @return couserListWithStudentTeacher
	 */
	public static ArrayList < String > listTeacherStudentToClassbyDefault() {
		courseListWithStudentTeacher.add(addListAsignedByCourse("Java Basic", "Felipe", "Wilmer"));
		courseListWithStudentTeacher.add(addListAsignedByCourse("Java Basic", "Felipe", "Gloria"));
		courseListWithStudentTeacher.add(addListAsignedByCourse("Jenkins", "David", "Luis"));
		courseListWithStudentTeacher.add(addListAsignedByCourse("Jenkins", "David", "July"));
		courseListWithStudentTeacher.add(addListAsignedByCourse("Jenkins", "David", "Gloria"));
		return courseListWithStudentTeacher;
	}

	/**
	 * public static ArrayList<String> addTeacherAndStudetToCourse() Send a
	 * courseName, a teacherName and StudentName using addListAsignedByCourse()
	 * method in Course.class
	 *
	 * @return courseListWithStudentTeacher
	 */
	public static ArrayList < String > addTeacherAndStudetToCourse() {
		System.out.print("Ingrese el nombre del curso:");
		String courseName = myInput.nextLine();
		System.out.print("Ingrese el nombre del docente:");
		String teacherName = myInput.nextLine();
		System.out.print("Ingrese el nombre del estudiante:");
		String studentName = myInput.nextLine();

		courseListWithStudentTeacher.add(addListAsignedByCourse(courseName, teacherName, studentName));
		System.out.println("-----Profesor y estudiante vinculado exitosamente. \n");

		return courseListWithStudentTeacher;
	}

	/**
	 * public void printAllCourseList() This method call the Utils.class to use
	 * printStringList(list<> parameter) method and print all elements within of
	 * courseList.
	 */
	public void printAllCourseList() {
		System.out.println("\n\n\n\n------------------------------- Lista de cursos:");
		utils.printStringList(courseList);
	}

	/**
	 * public void printCourseTeacherStudent() This method use an Iterator<string>
	 * to print all couserListWithStudentTeacher list.
	 */
	public void printCourseTeacherStudent() {
		System.out.println("\n\n\n\n------------------------------- Asistentes por curso:");
		Iterator<String> itr = courseListWithStudentTeacher.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}	
	}

	/**
	 * public void retrieveStudentCourseInfo() Retrieve student information using
	 * idStudent
	 */
	public void retrieveStudentCourseInfo() {
		System.out.print("Ingrese el documento del estudiante:");

		int studentId = 0;

		try {
			studentId = Integer.parseInt(myInput.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("-- El dato ingresado no es un número.");
			System.out.println("-- Por favor, intente de nuevo: \n");
			retrieveStudentCourseInfo();
		}

		utils.searchIndexPersonListById(studentId, Student.studentList);
		indexStudent = utils.index;

		if (indexStudent != -1) {
			String fullName = (Student.studentList.get(indexStudent).getName() + " "
				 + Student.studentList.get(indexStudent).getLastName());

			int longListStudentTeacher = courseListWithStudentTeacher.size() - 1;
			while (longListStudentTeacher >= 0) {
				if (courseListWithStudentTeacher.get(longListStudentTeacher).contains(fullName)) {
					System.out.println(courseListWithStudentTeacher.get(longListStudentTeacher));
				}
				longListStudentTeacher--;
			}
		} else {
			retrieveStudentCourseInfo();
		}
	}
}
