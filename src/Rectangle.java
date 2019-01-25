public class Rectangle {

    // Data Fields
    private int width;
    private int height;

    // Constructor
    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Methods
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setHeight(int h) {
        height = h;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4,5);
        Rectangle r2 = new Rectangle(7,9);
        r1.setWidth(5);
        r2.setWidth(4);
        System.out.println("Rectangle r1 has width " + r1.getWidth());
        System.out.println("Rectangle r2 was height " + r2.getHeight());
    }
}
