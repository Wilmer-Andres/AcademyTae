package academy.tae.figures.geometrics;

public class Rectangle {
	private double width;
	private double lenght;
	
	//Constructor
	public Rectangle(double width, double lenght) {
		this.width = width;
		this.lenght = lenght;
	}

	
	public double getAreaRectangle() {
		return this.width * this.lenght;
	}
	
	public double getPerimeterRectangle() {
		return (this.width + this.lenght) * 2;
	}
	
	
	//Print method
	public void printMethosRectangle() {
		System.out.print("\nRectangle ----------- \n");
		System.out.print("Area: "+ getAreaRectangle()+ "\n");
		System.out.print("Perimeter: "+ getPerimeterRectangle()+ "\n\n");
	}
}
