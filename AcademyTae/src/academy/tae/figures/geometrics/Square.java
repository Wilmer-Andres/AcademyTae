package academy.tae.figures.geometrics;
public class Square {
	private double side;
	
	//Constructor
	public Square (double side) {
		this.side = side;
	}
	
	public double getAreaSquare() {
		return this.side * this.side;
	}
	
	public double getPerimeterSquare () {
		return this.side * 4;
	}
	
	//Print method
	public void printMethosSquare() {
		System.out.print("\nSquare --------------  \n");
		System.out.print("Area: "+ getAreaSquare()+ "\n");
		System.out.print("Perimeter: "+ getPerimeterSquare()+ "\n\n");
	}
}
