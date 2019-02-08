public class Vehicle implements Colorable {
	// Data fields
	private double velocity;
	private Integer color;
	
	public Vehicle(double velocity, Integer color) {
		super();
		this.velocity = velocity;
		this.color = color;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public String getColor() {
		return color.toString();
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	
	
}
