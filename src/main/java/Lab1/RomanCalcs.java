package Lab1;

public class RomanCalcs extends Calculations {
    @Override
    public double subtraction(String number1, String number2) {
        return super.subtraction(number1, number2);
    }

    @Override
    public double division(String number1, String number2) {
        int div = Integer.parseInt(number1) / Integer.parseInt(number2);
        return div;
    }

    public void rCalcs(String number1, String number2, String operation) {
        Exchanger exc = new Exchanger();
        number1 = exc.exchangerToArabic(number1);
        number2 = exc.exchangerToArabic(number2);
        switch (operation) {
            case "+" -> {
                RomanCalcs rc = new RomanCalcs();
                int r = (int) rc.addition(number1, number2);
                System.out.println(exc.exchangerToRoman(r));
            }
            case "-" -> {
                RomanCalcs rc = new RomanCalcs();
                int r = (int) rc.subtraction(number1, number2);
                if (r > 0) {
                    System.out.println(exc.exchangerToRoman(r));
                } else {
                    System.out.println("Неположительный результат");
                }

            }
            case "/" -> {
                RomanCalcs rc = new RomanCalcs();
                int r = (int) rc.division(number1, number2);
                System.out.println(exc.exchangerToRoman(r));
            }
            case "*" -> {
                RomanCalcs rc = new RomanCalcs();
                int r = (int) rc.multiplication(number1, number2);
                System.out.println(exc.exchangerToRoman(r));
            }
        }

    }
}
