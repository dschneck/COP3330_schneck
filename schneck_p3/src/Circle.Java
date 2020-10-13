import static java.lang.Math.PI;

public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        super.name = "circle";
        this.radius = radius;

    }

    public Circle(int radius) {
        super.name = "circle";
        this.radius = radius;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return (double) this.radius * this.radius * PI;
    }
}