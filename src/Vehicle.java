public class Vehicle implements Colorable {
    // Data fields
    private double velocity;
    private int color;

    public Vehicle(double velocity, int color) {
        this.velocity = velocity;
        this.color = color;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
