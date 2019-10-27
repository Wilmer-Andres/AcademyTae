package academy.tae.figures.geometrics;

import academy.tae.main.RunnerMain;

public class RunnerFigures {

//	public static void main(String[] args){
	public void main() {
		/**
		 * Values accepted to classes Rectangle, Square and Triangle Class Rectangle
		 * (width, length) Class Square (side) Class Triangle (base, height, leftSide,
		 * rightSide)
		 */

		Rectangle rectangle = new Rectangle(2, 10);
		Square square = new Square(10);
		Triangle triangle = new Triangle(5, 10, 8, 7);

		// Call & Print methods
		square.printMethosSquare();
		rectangle.printMethosRectangle();
		triangle.printMethosTriangle();
		
		System.out.println("\n\n");
		String[] arguments = new String[] { "123" };
		RunnerMain.main(arguments);

	}
}
