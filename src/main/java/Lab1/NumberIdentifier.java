package Lab1;

public class NumberIdentifier {
    //Нет смысла в двух методах, так как они по сути обратны друг другу, и можно использовать просто один метод в прямом и обратном смысле//
    public boolean isArabicNumber(String number) {
        // Сложная проверка, если бы не было ограничения в num <=10//
        /*boolean flag = true;
        String[] Num = number.split("");
        String[] ArabNum = {"-","0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0 ; i < Num.length; i++){
            for (int j = 0 ; j < ArabNum.length; j++){
                boolean g = Num[i].equals(ArabNum[j]);
                if (!g){
                    flag = false;
                    break;
                }
            }
        }
        return flag;*/
        // Проверка необходимая по заданию//
        boolean flag = false;
        String[] ArabNumPlus = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] ArabNumMinus = {"0", "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
        for (int i = 0; i < ArabNumPlus.length; i++) {
            if (number.equals(ArabNumPlus[i]) || number.equals(ArabNumMinus[i])) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean isRomanNumber(String number) {
        // Сложная проверка, если бы не было ограничения в num <=10??? Нужно её усложнять, важен порядок символов???//
        /*boolean flag = true;
        String[] Num = number.split("");
        String[] RomanNum = {"I","V","X","L","C","D","M",};
        for (int i = 0 ; i < Num.length; i++){
            for (int j = 0 ; j < RomanNum.length; j++){
                boolean g = Num[i].equals(RomanNum[j]);
                if (!g){
                    flag = false;
                    break;
                }
            }
        }
        return flag;*/
        // Проверка необходимая по заданию//
        boolean flag = false;
        String[] RomanNum = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        for (int i = 0; i < RomanNum.length; i++) {
            if (number.equals(RomanNum[i])) {
                flag = true;
            }
        }
        return flag;

    }

    public boolean operation(String operation) {
        boolean flag = false;
        String[] Action = {"+", "-", "/", "*"};
        for (int i = 0; i < Action.length; i++) {
            if (operation.equals(Action[i])) {
                flag = true;
            }
        }
        return flag;
    }
}
