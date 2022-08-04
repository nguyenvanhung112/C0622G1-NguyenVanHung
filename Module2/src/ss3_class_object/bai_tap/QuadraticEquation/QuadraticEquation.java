package ss3_class_object.bai_tap.QuadraticEquation;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }
    public double getRoot1() {
        if (getDiscriminant() > 0) {
            return (-(this.b) + Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        } else if (getDiscriminant() == 0) {
            return -(this.b) / (2 * this.a);
        }
        return 0;
    }

    public double getRoot2() {
        if (getDiscriminant() > 0) {
            return (-(this.b) - Math.pow(getDiscriminant(),0.5)) / (2 * this.a);
        } else if (getDiscriminant() == 0) {
            return -(this.b) / (2 * this.a);
        }
        return 0;
    }
}
