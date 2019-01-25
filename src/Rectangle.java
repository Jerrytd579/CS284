/**
 * Class that models rectangles
 * @author jcheng15
 *
 */

public class Rectangle extends Shape {
    // Class Variables
    public static int noOfRectangles = 0;


    // Data Fields
    private int width;
    private int height;

    // Constructor
    /**
     * Creates a new rectangle providing "not set" as default color
     * @param width The width of the rectangle
     * @param height The height of the rectangle
     */
    Rectangle(int width, int height) {
        this(width, height, "not set");
    }


    Rectangle(int width, int height, String color) {
        super(color);
        this.width = width;
        this.height = height;
        noOfRectangles++;
    }

    // Methods

    /**
     * Returns the width
     * @return The width
     */
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

    public static int getNoOfRectangles() {
        return noOfRectangles;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4,5);
        Rectangle r2 = new Rectangle(7,9, "blue");
//        r1.setWidth(5);
//        r2.setWidth(4);
        System.out.println("Rectangle r1 has width " + r1.getWidth());
//        System.out.println("Rectangle r1 has width " + r1.width);
        System.out.println("Rectangle r2 was height " + r2.getHeight());
        System.out.println("Rectangle r2 has color " + r2.getColor());

        System.out.println("Number of rectangles is " + Rectangle.noOfRectangles);
        System.out.println("Number of rectangles is " + Rectangle.getNoOfRectangles());
    }
}
