package Lab1;

public class Exchanger {
    public String exchangerToArabic(String number) {
        switch (number) {
            case "O" -> number = "0";
            case "I" -> number = "1";
            case "II" -> number = "2";
            case "III" -> number = "3";
            case "IV" -> number = "4";
            case "V" -> number = "5";
            case "VI" -> number = "6";
            case "VII" -> number = "7";
            case "VIII" -> number = "8";
            case "IX" -> number = "9";
            case "X" -> number = "10";
            /*case "L" -> number = "50";
            case "C" -> number = "100";
            case "D" -> number = "500";
            case "M" -> number = "1000";*/
        }
        return number;
    }

    public String exchangerToRoman(int number) {
        String result = "";
        switch (number) {
            case 100 -> result += "C";
            case 0 -> result += "N";
        }
        if (number >= 90 & number < 100) {
            number -= 90;
            result += "XC";
        } else if (number >= 50 & number < 90) {
            number -= 50;
            result += "L";
        } else if (number >= 40 & number < 50) {
            number -= 40;
            result += "XL";
        }
        while (number >= 10 & number < 40) {
            number -= 10;
            result += "X";
        }
        switch (number) {
            case 1 -> result += "I";
            case 2 -> result += "II";
            case 3 -> result += "III";
            case 4 -> result += "IV";
            case 5 -> result += "V";
            case 6 -> result += "VI";
            case 7 -> result += "VII";
            case 8 -> result += "VIII";
            case 9 -> result += "IX";
        }
        return result;
    }
}
