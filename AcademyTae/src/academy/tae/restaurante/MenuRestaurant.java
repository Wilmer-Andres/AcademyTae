package academy.tae.restaurante;

public class MenuRestaurant {

	private int amoutPlate;
	private String namePlate;

	public MenuRestaurant() {
	}

	public MenuRestaurant(int amountPlate, String namePlate) {
		this.amoutPlate = amountPlate;
		this.namePlate = namePlate;
	}

	public void setAmountPlate(int amountPlate) {
		this.amoutPlate = amountPlate;
	}

	public void setnamePlate(String namePlate) {
		this.namePlate = namePlate;
	}

	public int getAmoutPlate() {
		return this.amoutPlate;
	}

	public String getNamePlate() {
		return this.namePlate;
	}
	
	public String addRecipeMenuRestaurant() {
		return (" $" + getAmoutPlate() + " --- " + getNamePlate());
	}
}
