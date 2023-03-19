import java.io.Serializable;

abstract class Shape implements Serializable {
    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}

class Triangle extends Shape implements Serializable {
    public static String name;
    private double side1;
    private double side2;
    private double side3;
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public static String getName() {
        return name;
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(4 * (side1 * side1) * (side2 * side2)
                -((side1 * side1)+ (side2 * side2)-(side3 * side3))
                * ((side1 * side1)+ (side2 * side2)-(side3 * side3))
        ) / 4;
    }
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

class Rectangle extends Shape implements Serializable {
    public static String name;
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static String getName() {
        return name;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Circle extends Shape implements Serializable {

    public static String name;
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public static String getName() {
        return name;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square extends Shape implements Serializable {

    public static String name;
    private double sideLength;
    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public static String getName() {
        return name;
    }
    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }
    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }
}