public abstract class Shape implements Colorable {
	// Data fields
	private String color;
	
	// Constructor
	public Shape(String color) {
		super();
		this.color = color;
	}

	// Methods
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract int area();
	
	public String toString() {
		return "Color: "+color;
	}
	
	public int volume(int height) {
		return this.area()*height;
	}
	
}
