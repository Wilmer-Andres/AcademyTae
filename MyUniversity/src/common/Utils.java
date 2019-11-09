package common;

import java.util.ArrayList;
import java.util.List;
import data.Person;
import data.Course;

public class Utils {
	public int index;

	/**
	 * public void searchIndexPersonListByName
	 * Method to find the student/teacher Name.
	 * @param search String type, it should be the name of the person (teacher/student)
	 * @param personList ArrayList/List type
	 */
	public void searchIndexPersonListByName(String search, List<Person> personList) {
		int auxCount = 0;
		int longListMenu = personList.size() - 1;
		while (longListMenu >= 0) {
			if (personList.get(longListMenu).getName().equalsIgnoreCase(search)) {
				// if (personList.get(longListMenu).getIdPerson() == Integer.parseInt(search)) {
				auxCount = longListMenu;
				index = auxCount;
				longListMenu = -1;
			} else {
				index = -1;
			}
			longListMenu--;
		}
		if (longListMenu == -1)
			System.out.println("La persona que busca no existe, por favor intente de nuevo.\n");
	}
	
	/**
	 * public void searchIndexPersonListById
	 * Method to find the student/teacher id.
	 * @param search Integer(int) type, it should be the name of the person (teacher/student)
	 * @param personList ArrayList/List type
	 */
	public void searchIndexPersonListById(int search, List<Person> personList) {
		int auxCount = 0;
		int longListMenu = personList.size() - 1;
		while (longListMenu >= 0) {
			if (personList.get(longListMenu).getIdPerson() == search) {
				// if (personList.get(longListMenu).getIdPerson() == Integer.parseInt(search)) {
				auxCount = longListMenu;
				index = auxCount;
				longListMenu = -1;
			} else {
				index = -1;
			}
			longListMenu--;
		}
		if (longListMenu == -1)
			System.out.println("El dato que ingresó no existe, por favor intente de nuevo.\n");
	}

	/**
	 * public void printList
	 * @param listToPrint ArrayList Person. Could be studentList or teacherList
	 */
	public void printList(ArrayList<Person> listToPrint) {
		for (Person person : listToPrint) {
			System.out.println(person.addPerson());
		}
	}
	
	/**
	 * public void searchIndexCourseList
	 * This method retrieve the index in a list of Course class
	 * @param search String type.
	 * @param courseList List / ArrayList type.
	 */
	public void searchIndexCourseList(String search, List<Course> courseList) {
		int auxCount = 0;
		int longListMenu = courseList.size() - 1;
		while (longListMenu >= 0) {
			if (courseList.get(longListMenu).getNameCourse().equalsIgnoreCase(search)) {
				// if (personList.get(longListMenu).getIdPerson() == Integer.parseInt(search)) {
				auxCount = longListMenu;
				index = auxCount;
				longListMenu = -1;
			} else {
				index = -1;
			}
			longListMenu--;
		}
		if (longListMenu == -1)
			System.out.println("El curso que busca no existe, por favor intent de nuevo.\n");

	}
	
	/**
	 * public void printStringList
	 * Print all list of any ArrayList type Course.
	 * @param listToPrint is an ArrayList
	 */
	public void printStringList(ArrayList<Course> listToPrint) {
		for (Course list : listToPrint) {
			System.out.println(list.addToListCourse());
		}
	}
	
	/**
	 * public void searchIndexStringList
	 * This method retrieve an index of an ArrayList<String>
	 * @param search is a string type
	 * @param stringList is a List/ArrayList type.
	 */
	public void searchIndexStringList(String search, List<String> stringList) {
		int auxCount = 0;
		int longListMenu = stringList.size() - 1;
		while (longListMenu >= 0) {
			if (stringList.get(longListMenu).equalsIgnoreCase(search)) {
				// if (personList.get(longListMenu).getIdPerson() == Integer.parseInt(search)) {
				auxCount = longListMenu;
				index = auxCount;
				longListMenu = -1;
			} else {
				index = -1;
			}
			longListMenu--;
		}
		if (longListMenu == -1)
			System.out.println("El curso que busca no existe, por favor intent de nuevo.\n");
	}
}
