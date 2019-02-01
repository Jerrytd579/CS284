public class Circle extends Shape {
	// Data fields
	private int radius;
	
	// Constructor
	Circle(int radius, String color) {
		super(color);
		this.radius=radius;
	}

	// Methods
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public int area() {
		return (int) Math.PI * radius *radius;
	}
	
}
	
