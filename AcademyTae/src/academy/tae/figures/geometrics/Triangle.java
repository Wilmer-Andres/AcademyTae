package academy.tae.figures.geometrics;

public class Triangle {
	private double base;
	private double height;
	private double leftSide;
	private double rightSide;
	
	//Constructor
	public Triangle (double base, double height, double leftSide, double rightSide) {
		this.base = base;
		this.height = height;
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	public double getAreaTriangle() {
		return (this.base * this.height) / 2;
	}
	
	public double getPerimeterRectangle() {
		return (this.base + this.leftSide + this.rightSide);
	}
	
	
	//Print method
	public void printMethosTriangle() {
		System.out.print("\nTriangle ------------ \n");
		System.out.print("Area: "+ getAreaTriangle()+ "\n");
		System.out.print("Perimeter: "+ getPerimeterRectangle()+ "\n\n");
	}
}
