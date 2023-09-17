package Lab1;

public abstract class Calculations {
    public double addition(String number1, String number2) {
        return Double.parseDouble(number1) + Double.parseDouble(number2);
    }

    public double subtraction(String number1, String number2) {
        return Double.parseDouble(number1) - Double.parseDouble(number2);
    }

    public double multiplication(String number1, String number2) {
        return Double.parseDouble(number1) * Double.parseDouble(number2);
    }

    public double division(String number1, String number2) {
        return Double.parseDouble(number1) / Double.parseDouble(number2);
    }

}
