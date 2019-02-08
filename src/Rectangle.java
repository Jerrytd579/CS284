/**
 * Class that models rectangles
 * @author eduardobonelli
 *
 */
public class Rectangle extends Shape {
	// Class variables
	public static int noOfRectangles=0;
	
	// Data fields
	private int width;
	private int height;
	
	// Constructor
	/**
	 * Creates a new rectangle providing "not set" as default color
	 * @param width The width of the rectangle
	 * @param height The height of the rectangle
	 */
	Rectangle(int width, int height) {
		this(width,height,"not set");
	}

	Rectangle(int width, int height, String color) {
		super(color);
		this.width=width;
		this.height=height;
		noOfRectangles++;
	}

	// Methods

	/**
	 * Returns the width
	 * @return The width
	 */
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int area() {
		return width*height;
	}
	
	public String toString() {
		return "Height: "+ height + ", Width: "+width + super.toString();
	}

	public Pair<Integer,Integer>getWidthHeight() {
		return new Pair<Integer,Integer>(width,height);
	}

	public Pair<Integer,String> getWidthColor() {
		return new Pair<Integer,String>(width,getColor());
	}
	// Class methods
	public static int getNoOfRectangles() {
		return noOfRectangles;
	}
	

	

	
	
	
}
