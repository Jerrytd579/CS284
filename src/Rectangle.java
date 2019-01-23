public class Rectangle {
    private int width;
    private int height;

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
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1.setWidth(5);
        r2.setWidth(4);
        System.out.println("Rectangle r1 has width" + r1);
        System.out.println("Rectangle r1 was width" + r2);
    }
}
