package academy.tae.restaurante;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import academy.tae.main.*;

public class Restaurant extends RunnerMain{

	private Scanner myInput;
	private String nameRestaurant;
	private String nitRestaurant;
	private static ArrayList<MenuRestaurant> listMenuRestaurant = createListMenu();
	private static MenuRestaurant menuRestaurant = new MenuRestaurant();
	protected int index;
	protected RunnerMain mainMenu;

	public Restaurant() {
	}

	public Restaurant(String nameRestaurant, String nitRestaurant) {
		this.nameRestaurant = nameRestaurant;
		this.nitRestaurant = nitRestaurant;
	}

	public void setNameRestaurant(String nameRestaurant) {
		this.nameRestaurant = nameRestaurant;
	}

	public void setNitRestaurant(String nitRestaurant) {
		this.nitRestaurant = nitRestaurant;
	}

	public String getNameRestaurant() {
		return this.nameRestaurant;
	}

	public String getNitRestaurant() {
		return this.nitRestaurant;
	}

	/**
	 * static ArrayList<MenuRestaurant> Return the initial list of menu
	 * 
	 * @return
	 */
	private static ArrayList<MenuRestaurant> createListMenu() {
		listMenuRestaurant = new ArrayList<>();

		listMenuRestaurant.add(new MenuRestaurant(3000, "Arroz"));
		listMenuRestaurant.add(new MenuRestaurant(3000, "Sopa"));
		listMenuRestaurant.add(new MenuRestaurant(8000, "Mini_Paisa"));
		listMenuRestaurant.add(new MenuRestaurant(10000, "Bandeja Paisa"));
		listMenuRestaurant.add(new MenuRestaurant(12000, "Mojarra"));
		return listMenuRestaurant;
	}

	/**
	 * void addNewItemToMenu() Add new Item to menu restaurant
	 */
	public void addNewItemToMenu() {
		System.out.println("\n\n\n\n------------------------------- Agregar item al menú:");
		// Restaurant.listMenuRestaurant = createListMenu();
		myInput = new Scanner(System.in);

		// Add new values to menu
		if (listMenuRestaurant.size() < 5) {
			int auxAmountPlate = 0;
			int newAmountPlate;
			// Validation positive numbers
			do {
				System.out.print("Igrese el valor del plato: $ ");
				newAmountPlate = myInput.nextInt();
				if (newAmountPlate <= 0)
					System.out.println("Igrese vavlores positivos. \n");
				auxAmountPlate = newAmountPlate;
			} while (auxAmountPlate <= 0);
			menuRestaurant.setAmountPlate(newAmountPlate);

			System.out.print("Ingrese el nombre del plato: ");
			String newNamePlate = myInput.next();
			menuRestaurant.setnamePlate(newNamePlate);

			// Add new element to listMenuRestaurant
			listMenuRestaurant.add(menuRestaurant);
			// this.listMenuRestaurant.add(new MenuRestaurant(newAmountPlate,
			// newNamePlate));
			System.out.println("item Agregado exitosamente. \n\n");
			printRestaurant();
		} else {
			System.out.println("Es necesario que elimine un item del menú antes de agregar uno nuevo.");
			System.out.print("Desea consultar 'C' el menú o Eliminar 'E' un Item: C/E:");
			myInput = new Scanner(System.in);
			String confirmacion = myInput.next();
			if (confirmacion.equals("C") || confirmacion.equals("c")) {
				printMenuRestaurant();
			} else {
				deleteItemMenu();
			}
		}
	}

	/**
	 * void deleteItemMenu() Delete an Item of menu restaurant. Using java console
	 * put an Item name of the menu restaurant.
	 */
	public void deleteItemMenu() {
		System.out.println("\n\n\n\n------------------------------- Eliminar item del menú:");
		myInput = new Scanner(System.in);
		System.out.println("Eliminar item del menu ----------------------");
		System.out.print("Ingrese el nombre del producto a eliminar: ");
		String dropItem = myInput.nextLine();

		buscarIndexListMenu(dropItem);

		if (index < 0) {
			System.out.println("El item ingresado no se encuentra en el menú.");
			System.out.println("Intente nuevamente.\n\n");
			printRestaurant();// deleteItemMenu();
		} else {
			listMenuRestaurant.remove(index);
			System.out.println("item eliminado del menú.");
			printRestaurant();
		}

	}

	/**
	 * void replaceItemMenu() Method that replace any item of menu restaurant.
	 */
	public void replaceItemMenu() {
		System.out.println("\n\n\n\n------------------------------- Reemplazar item del menú:");
		myInput = new Scanner(System.in);
		System.out.print("Ingrese el nombre del producto a reemplazar: ");
		String replaceItem = myInput.next();
		buscarIndexListMenu(replaceItem);

		if (index < 0) {
			System.out.println("El item ingresado no se encuentra en el menú.");
			System.out.println("Intente nuevamente.\n\n");
			printRestaurant();// deleteItemMenu();
		} else {
			System.out.print("Igrese el valor del plato: $ ");
			int newAmountPlate = myInput.nextInt();
			menuRestaurant.setAmountPlate(newAmountPlate);
			System.out.print("Ingrese el nombre del plato: ");
			String newNamePlate = myInput.next();
			menuRestaurant.setnamePlate(newNamePlate);

			listMenuRestaurant.set(index, menuRestaurant);
			System.out.println("item reemplazado exitosamente. \n\n");
			printMenuRestaurant();
			System.out.println("-----------------------------\n\n");
			printRestaurant();
		}

	}

	/**
	 * void buscarIndexListMenu
	 * 
	 * @param namePlate Method that search the Item into menu.
	 */
	public void buscarIndexListMenu(String namePlate) {
		int auxCount = 0;
		int longListMenu = listMenuRestaurant.size() - 1;
		if (longListMenu == -1) {
			System.out.print("No tiene Items para eliminar, por favor ingrese un nuevo Item: ");
			addNewItemToMenu();
		} else {
			while (longListMenu >= 0) {
				if (listMenuRestaurant.get(longListMenu).getNamePlate().equals(namePlate)) {
					auxCount = longListMenu;
					index = auxCount;
					longListMenu = -1;
				} else {
					index = -1;
				}
				longListMenu--;
			}
		}
	}

	/**
	 * void printMenuRestaurant() Print the menu restaurant. Show the current values
	 * in the menu.
	 */
	public void printMenuRestaurant() {
		System.out.println("\n\n\n\n------------------------------- Consultar menú:");
		System.out.println(" PRECIO       PLATO:");
		for (MenuRestaurant menu : listMenuRestaurant) {
			System.out.println(menu.addRecipeMenuRestaurant());
		}
		int sizeMenu = listMenuRestaurant.size();
		System.out.println("\n------------------------");
		System.out.println("Total platos: " + sizeMenu + "\n");

		System.out.println("Desea regresar al menú principal S/N:");
		myInput = new Scanner(System.in);
		String confirmacion = myInput.next();
		if (confirmacion.equals("S") || confirmacion.equals("s")) {
			printRestaurant();
		} else {
			System.out.println("\nGracias por consultar nuestro menú.");
			System.out.println("Buen día. !");
			System.exit(1);
		}
	}

	/**
	 * void optionsMenu() Set main menu options to surf on the program.
	 */

	public void optionsMenu() {
		myInput = new Scanner(System.in);
		int option = myInput.nextInt();
		try {
			switch (option) {
			case 1:
				addNewItemToMenu();
				break;
			case 2:
				deleteItemMenu();
				break;
			case 3:
				printMenuRestaurant();
				break;
			case 4:
				replaceItemMenu();
				break;
			case 5:
				String[] arguments = new String[] {"123"};
			    RunnerMain.main(arguments);
				break;
			case 6:
				System.out.println("\nGracias por consultar nuestro menú.");
				System.out.println("Buen día. !");
				System.exit(1);
				break;
			default:
				System.out.println("\nSeleccione una opción entre 1 and 4. \nPor favor, intente de nuevo: \n	");
				printRestaurant();
			}
		} catch (InputMismatchException e) {
			System.out.println("\nPor favor inresar valores enteros, los precios deben ir sin comas (,) o puntos (.)");
			printRestaurant();
		}
	}

	/**
	 * Method printRestaurant() Shows the options of restaurant
	 */
	public void printRestaurant() {
		System.out.println("\n\n\n\n*******************************************************");
		System.out.println("***************** " + this.nameRestaurant + " ****************");
		System.out.println("******************* nit: " + this.nitRestaurant + " ******************");
		System.out.println("*******************************************************");
		System.out.println("\n \nSeleccione una de las siguientes opciones: \n1- Agregar nuevo item.");
		System.out.println("2- Eliminar item del menú.");
		System.out.println("3- Consultar menú.");
		System.out.println("4- Reemplazar item menú");
		System.out.println("5- Regresar al menú principal");
		System.out.println("6- Salir \n");
		System.out.print("Digite acá la opción: ");
		optionsMenu();
	}
}