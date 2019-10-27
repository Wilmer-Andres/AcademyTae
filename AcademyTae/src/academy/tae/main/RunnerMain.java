package academy.tae.main;

import java.util.Scanner;

import academy.tae.bank.account.*;
import academy.tae.figures.geometrics.*;
import academy.tae.globant.*;
import academy.tae.restaurante.*;

public class RunnerMain {
	private static Scanner myInput;
	private static RunnerFigures runnerFigures;
	private static RunnerBank runnerBank;
	private static RunnerRestaurant runnerRestaurant;
	private static RunnerGlobant runnerGlobant;

	public static void chooseHomework() {
		myInput = new Scanner(System.in);
		int option = myInput.nextInt();
		System.out.print("\n\n");
		
		switch (option) {
		case 1:
			runnerFigures.main();
			break;
		case 2:
			runnerBank.main();
			break;
		case 3:
			runnerRestaurant.main();
			break;
		case 4:
			runnerGlobant.main();
			break;
		case 5:
			System.out.println("\nGracias por consultar los ejercicios en clase.");
			System.out.println("Buen día.!");
			System.exit(1);
			break;
		default:
			System.out.println("\nSeleccione una opción entre 1 and 4. \nPor favor, intente de nuevo: \n	");
		}
	}

	public static void main(String[] args){
		runnerFigures = new RunnerFigures();
		runnerBank = new RunnerBank();
		runnerRestaurant = new RunnerRestaurant();
		runnerGlobant = new RunnerGlobant();
		System.out.println("\n\n*******************************************************");
		System.out.println("***************** Ejercicios en clase ****************");
		System.out.println("*******************************************************");
		System.out.println("\n \nSeleccione una de las siguientes actividades: \n1- Figuras geométricas.");
		System.out.println("2- Cuenta de Banco.");
		System.out.println("3- Menú restaurante");
		System.out.println("4- Estructura Globant.");
		System.out.println("5- Salir");
		System.out.print("Digite acá la opción: ");
		chooseHomework();
	}

}
