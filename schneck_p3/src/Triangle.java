public class Triangle extends Shape2D {
    private double sideA;
    private double sideB;

    public Triangle(double sideA, double sideB) {
        super.name = "triangle";
        this.sideA = sideA;
        this.sideB = sideB;

    }

    public Triangle(int side) {
        super.name = "triangle";
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return (double) this.sideA * this.sideB * .5;
    }
}