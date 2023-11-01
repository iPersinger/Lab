package Lab2;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class Helper {

    public static String[] agents() {
        return new String[]{"FunctionAgent1", "FunctionAgent2", "FunctionAgent3"};
    }

    public static String randomAgent() {
        Random random = new Random();
        int randomIndex = random.nextInt(Helper.agents().length);
        return Helper.agents()[randomIndex];
    }

    public static void message(String id, String receiver, String content, Agent e) {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setConversationId(id);
        message.addReceiver(new AID(receiver, false));
        message.setContent(content);
        e.send(message);

    }

    public static double func1(Double x) {
        return (-0.5 * Math.pow(x, 2)) - 4;
    }

    public static double func2(Double x) {
        return Math.pow(2, (-0.1 * x));
    }

    public static double func3(Double x) {
        return Math.cos(x);
    }

    public static String ContentYYY(double x, double d, Agent e) {
        double x1 = x - d;
        double x2 = x;
        double x3 = x + d;
        double p1 = 0, p2 = 0, p3 = 0;
        switch (e.getLocalName()) {
            case "FunctionAgent1" -> {
                p1 = Helper.func1(x1);
                p2 = Helper.func1(x2);
                p3 = Helper.func1(x3);
            }
            case "FunctionAgent2" -> {
                p1 = Helper.func2(x1);
                p2 = Helper.func2(x2);
                p3 = Helper.func2(x3);
            }
            case "FunctionAgent3" -> {
                p1 = Helper.func3(x1);
                p2 = Helper.func3(x2);
                p3 = Helper.func3(x3);
            }
        }
        return p1 + " " + p2 + " " + p3;
    }

    public static void InitiateOnEnd(double x, double d, double p1, double p2, double p3, Agent e) {
        System.out.println(e.getLocalName() + " Получил значения и провожу сравнение x -  " + x + " d - " + d);
        if (Math.abs(d) < 0.00001) {
            System.out.println(" Поздравляю, это победа. Число х - " + x);
            System.out.println(" Число d - " + d);

        } else if (p2 > p1 && p2 > p3) {
            d = d / 2;
            Behaviour initBeh = new InitiateDistributedCalculation(x, d);
            e.addBehaviour(initBeh);
            /*System.out.println(e.getLocalName() + " Добровольно передаю инициативу сам себе! ");*/
        } else if (p1 > p2 && p1 > p3) {
            x = x - d;
            /*System.out.println(e.getLocalName() + " Добровольно передаю инициативу - " + Helper.randomAgent());*/
            String content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            Helper.message("Initiative", Helper.randomAgent(), content, e);
        } else if (p3 > p2 && p3 > p1) {
            x = x + d;
            /*System.out.println(e.getLocalName() + " Добровольно передаю инициативу - " + Helper.randomAgent());*/
            String content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            Helper.message("Initiative", Helper.randomAgent(), content, e);
        } else {
            d = d * 1.5;
            System.out.println("Аномалия");
            /*System.out.println(e.getLocalName() + " Добровольно передаю инициативу - " + Helper.randomAgent());*/
            String content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            Helper.message("Initiative", Helper.randomAgent(), content, e);
        }
    }
}
