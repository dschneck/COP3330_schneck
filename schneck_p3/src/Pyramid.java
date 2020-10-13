import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Pyramid extends Shape3D {
    private double sideA;
    private double sideB;
    private double sideC;

    public Pyramid(double sideA, double sideB, double sideC) {
        super.name = "pyramid";
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

    }

    public Pyramid(int sideA, int sideB, int sideC) {
        super.name = "pyramid";
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public String getName() {
        return super.name;
    }

    public double getArea() {
        return (double) this.sideA*this.sideB + this.sideA * Math.sqrt(Math.pow((this.sideB/2), 2) + Math.pow(this.sideC,2)) + this.sideB * Math.sqrt(Math.pow((this.sideA/2), 2) + Math.pow(this.sideC,2));
    }

    public double getVolume() {
        return (double) (this.sideA * this.sideB * this.sideC) / 3.0;
    }
}