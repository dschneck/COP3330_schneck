import static java.lang.Math.PI;

public class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        super.name = "sphere";
        this.radius = radius;
    }

    public Sphere(int radius) {
        super.name = "sphere";
        this.radius = radius;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return (double) 4.0 * PI * this.radius * this.radius;
    }

    public double getVolume() {
        return (double) (4.0/3.0) * PI * (this.radius * this.radius * this.radius);
    }
}