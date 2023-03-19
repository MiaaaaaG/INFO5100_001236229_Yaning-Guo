import java.io.*;

public class Main {
    public static void main(String[] args) {
        Triangle.name = "Triangle";
        Rectangle.name = "Rectangle";
        Circle.name = "Circle";
        Square.name = "Square";

        Triangle t1 = new Triangle(4.0, 5.0, 6.0);
        Rectangle r1 = new Rectangle(7.0, 5.0);
        Circle c1 = new Circle(6.0);
        Square s1 = new Square(5.0);

        // Serialize objects
        try {
            FileOutputStream fileOut = new FileOutputStream("shapes.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(t1);
            out.writeObject(r1);
            out.writeObject(c1);
            out.writeObject(s1);
            out.close();
            fileOut.close();
            System.out.println("Objects serialized to shapes.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize objects
        try {
            FileInputStream fileIn = new FileInputStream("shapes.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Triangle t2 = (Triangle) in.readObject();
            Rectangle r2 = (Rectangle) in.readObject();
            Circle c2 = (Circle) in.readObject();
            Square s2 = (Square) in.readObject();
            in.close();
            fileIn.close();

            // Print deserialized objects
            System.out.println("Deserialized objects:");
            System.out.println("Shape: " + Triangle.getName());
            System.out.println("Area: " + t2.calculateArea());
            System.out.println("Perimeter: " + t2.calculatePerimeter());
            System.out.println();

            System.out.println("Shape: " + Rectangle.getName());
            System.out.println("Area: " + r2.calculateArea());
            System.out.println("Perimeter: " + r2.calculatePerimeter());
            System.out.println();

            System.out.println("Shape: " + Circle.getName());
            System.out.println("Area: " + c2.calculateArea());
            System.out.println("Perimeter: " + c2.calculatePerimeter());
            System.out.println();

            System.out.println("Shape: " + Square.getName());
            System.out.println("Area: " + s2.calculateArea());
            System.out.println("Perimeter: " + s2.calculatePerimeter());
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}