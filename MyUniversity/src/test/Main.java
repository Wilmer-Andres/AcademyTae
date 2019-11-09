package test;
/**
 * @author wilmer.poveda
 *
 */
//import java.util.List;

import data.University;

public class Main {

	private static University university;

	public Main() {
	}

	public static void main(String[] args) {
		university = new University("Academy TAE");
		university.menuUniversity();
	}
}
