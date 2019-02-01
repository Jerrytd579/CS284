public class PlayingWithShapes {

	public static void printArea(Shape s) {
		System.out.println("The area is "+s.area());
	}


	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4,5);
		Rectangle r2 = new Rectangle(7,9,"blue");
//		r1.setWidth(5);
//		r2.setWidth(4);
//		System.out.println("Rectangle r1 has width " + r1.getWidth());
//		System.out.println("Rectangle r2 has height " + r2.getHeight());
//		System.out.println("Rectangle r1 has color " + r1.getColor());
//		System.out.println("Rectangle r2 has color " + r2.getColor());
//
		Triangle t1 = new Triangle(4,5,"orange");
		Triangle t2 = new Triangle(7,9);

//		System.out.println("No of rectangles is "+ Rectangle.getNoOfRectangles());
		
//		System.out.println("Triangle t1 has base " + t1.getBase());
//		System.out.println("Triangle t1 has color " + t1.getColor());

//		Rectangle[] rs = new Rectangle[3];
//		
//		rs[0]=r1;
//		rs[1]=r2;
//		rs[2]=new Rectangle(3,4,"green");
//		
//		for (Rectangle r:rs) {
//			printArea(r);
//		}
//		
//		Triangle[] ts = new Triangle[3];
//		
//		ts[0]=t1;
//		ts[1]=t2;
//		ts[2]=new Triangle(3,4,"yellow");
//
//		for (Triangle t:ts) {
//			printArea(t);
//		}
		
		
		Shape[] ss = new Shape[6];
		
		ss[0]=r1;
		ss[1]=r2;
		ss[2]=new Rectangle(3,4,"green");
		ss[3]=t1;
		ss[4]=t2;
		ss[5]=new Triangle(3,4,"yellow");

		for (Shape s:ss) {
			printArea(s);
		}


	}
}
