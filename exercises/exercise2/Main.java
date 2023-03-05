
public class Main {
    public static void main(String[] args) {
        Triangle.name = "Triangle";
        Rectangle.name = "Rectangle";
        Circle.name = "Circle";
        Square.name = "Square";

        Triangle t1 = new Triangle( 4.0, 5.0, 6.0);
        Rectangle r1 = new Rectangle(7.0, 5.0);
        Circle c1 = new Circle(6.0);
        Square s1 = new Square(5.0);

        System.out.println("Shape: " + Triangle.getName());
        System.out.println("Area: " + t1.calculateArea());
        System.out.println("Perimeter: " + t1.calculatePerimeter());
        System.out.println();

        System.out.println("Shape: " + Rectangle.getName());
        System.out.println("Area: " + r1.calculateArea());
        System.out.println("Perimeter: " + r1.calculatePerimeter());
        System.out.println();

        System.out.println("Shape: " + Circle.getName());
        System.out.println("Area: " + c1.calculateArea());
        System.out.println("Perimeter: " + c1.calculatePerimeter());
        System.out.println();

        System.out.println("Shape: " + Square.getName());
        System.out.println("Area: " + s1.calculateArea());
        System.out.println("Perimeter: " + s1.calculatePerimeter());
        System.out.println();
    }
}