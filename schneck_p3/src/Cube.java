public class Cube extends Shape3D {
    private double side;

    public Cube(double side) {
        super.name = "cube";
        this.side = side;

    }

    public Cube(int side) {
        super.name = "cube";
        this.side = side;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return (double) this.side * this.side * 6;
    }

    public double getVolume() {
        return (double) this.side * this.side * this.side;
    }
}