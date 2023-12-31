package Lab1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите 1ое число (Заданное число должно быть не более 10): ");

        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        System.out.println(name);*/

       /* System.out.println("Введите числа через пробле, затем знак арифметики через пробел  (Заданные числа должно быть не более 10): ");
        String number10 = in.next();
        System.out.println(number10);
        String number11 = in.next();
        System.out.println(number11);
        String operation10 = in.next();
        System.out.println(operation10);*/


        String number1 = in.nextLine();
        System.out.println("Введите желаемую арифмитическую операцию: ");
        String operation = in.nextLine();
        NumberIdentifier value = new NumberIdentifier();
        boolean flag = value.operation(operation);
        if (!flag) {
            System.out.println("Неверно задана математическая операция. Возможные операции - Сложение (+), Вычитание (-), Умножение (*) и Деление (/)");
        } else {
            System.out.println("Введите 2ое число (Заданное число должно быть не более 10): ");
            String number2 = in.nextLine();

            if (value.isArabicNumber(number1) & value.isArabicNumber(number2)) {
                System.out.println("Арабы рулят");
                ArabicCalcs result = new ArabicCalcs();
                result.aCalcs(number1, number2, operation);
            } else {
                if (value.isRomanNumber(number1) & value.isRomanNumber(number2)) {
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