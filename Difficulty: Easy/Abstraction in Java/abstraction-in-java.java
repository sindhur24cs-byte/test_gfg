// Abstract Class Shape
abstract class Shape {
    protected String color;

    // Constructor to initialize color
    public Shape(String c) {
        this.color = c;
    }

    // Concrete method returning color
    public String getColor() {
        return this.color;
    }

    // Abstract method to be overridden by subclasses
    public abstract double getArea();
}

// Subclass Square extending Shape
class Square extends Shape {
    private double side;

    // Constructor invoking parent class constructor using super(c)
    public Square(String c, double side) {
        super(c);
        this.side = side;
    }

    // Implementation of the abstract method getArea()
    @Override
    public double getArea() {
        return this.side * this.side;
    }
}