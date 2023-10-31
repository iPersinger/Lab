package Lab2.MathFunc;

public class MathFunc {

    public double func1(Double x) {
        double y = (-0.5 * Math.pow(x, 2)) - 4;
        return y;
    }

    public double func2(Double x) {
        double y = Math.pow(2, (-0.1 * x));
        return y;
    }

    public double func3(Double x) {
        double y = Math.cos(x);
        return y;
    }
}
