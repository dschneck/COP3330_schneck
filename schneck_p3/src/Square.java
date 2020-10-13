public class Square extends Shape2D {
    private double side;

    public Square(double side) {
        super.name = "square";
        this.side = side;

    }

    public Square(int side) {
        super.name = "square";
        this.side = side;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return this.side * this.side;
    }
}
