package Lab1;

public class ArabicCalcs extends Calculations {

    @Override
    public double division(String number1, String number2) {
        int div = Integer.parseInt(number1) / Integer.parseInt(number2); //???????????? Вроде работает
        return div;
    }

    public void aCalcs(String number1, String number2, String operation) {
        switch (operation) {
            case "+" -> {
                ArabicCalcs ac = new ArabicCalcs();
                System.out.println(ac.addition(number1, number2));
            }
            case "-" -> {
                ArabicCalcs ac = new ArabicCalcs();
                System.out.println(ac.subtraction(number1, number2));
            }
            case "/" -> {
                ArabicCalcs ac = new ArabicCalcs();
                System.out.println(ac.division(number1, number2));
            }
            case "*" -> {
                ArabicCalcs ac = new ArabicCalcs();
                System.out.println(ac.multiplication(number1, number2));
            }
        }
    }
}
