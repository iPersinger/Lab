package Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 1ое число (Заданное число должно быть не более 10): ");
        String number1 = in.nextLine();
        System.out.println("Введите желаемую арифмитическую операцию: ");
        String operation = in.nextLine();
        NumberIdentifier value = new NumberIdentifier();
        boolean flag = value.operation(operation);
        if (!flag) {
            System.out.println("Неверно задана математическая операция. Возможные операции - Сложение, Вычитание, Умножение и Деление ");
        } else {
            System.out.println("Введите 2ое число (Заданное число должно быть не более 10): ");
            String number2 = in.nextLine();
            boolean flag1 = value.isArabicNumber(number1);
            boolean flag2 = value.isArabicNumber(number2);

            if (flag1 & flag2) {
                System.out.println("Арабы рулят");
                ArabicCalcs result = new ArabicCalcs();
                result.aCalcs(number1, number2, operation);
            } else {
                flag1 = value.isRomanNumber(number1);
                flag2 = value.isRomanNumber(number2);
                if (flag1 & flag2) {
                    System.out.println("Римляне красавчики");
                    RomanCalcs result = new RomanCalcs();
                    result.rCalcs(number1, number2, operation);
                } else {
                    System.out.println("Неверный формат чисел");
                }
            }
        }
    }

}