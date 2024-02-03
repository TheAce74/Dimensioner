package dimensioner;

public class QuadraticSolver {
    double a;
    double b;
    double c;

    public QuadraticSolver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double solveEquation() {
        double discriminant = this.b * this.b - 4 * this.a * this.c;
        
        if (discriminant == 0) {
            return (-1 * this.b) / (2 * this.a);
        } else if (discriminant > 0) {
            return (-1 * this.b + Math.sqrt(discriminant)) / (2 * this.a);
        } else {
            return 0;
        }
    }
}
