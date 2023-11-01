package Lab2;

import Lab2.MathFunc.MathFunc;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.List;
import java.util.Random;

public class InitiateDistributedCalculation extends Behaviour {
    int i = 0;
    private double x, d;
    private String[] agents = {"FunctionAgent1", "FunctionAgent2", "FunctionAgent3"};
    Random random = new Random();
    int randomIndex = random.nextInt(agents.length);
    String randomAgent = agents[randomIndex];
    boolean endInitiate = false;
    MathFunc f = new MathFunc();


    private double p1 = 0, p2 = 0, p3 = 0;

    public InitiateDistributedCalculation(double x, double d) {
        this.x = x;
        this.d = d;
    }

    @Override
    public void onStart() {
        /*System.out.println("Зашли в старт иницианции");*/
        double x1 = x - d;
        double x2 = x;
        double x3 = x + d;
        if (getAgent().getLocalName().equals("FunctionAgent1")) {
            p1 = f.func1(x1);
            p2 = f.func1(x2);
            p3 = f.func1(x3);
        } else if (getAgent().getLocalName().equals("FunctionAgent2")) {
            p1 = f.func2(x1);
            p2 = f.func2(x2);
            p3 = f.func2(x3);
        } else if (getAgent().getLocalName().equals("FunctionAgent3")) {
            p1 = f.func3(x1);
            p2 = f.func3(x2);
            p3 = f.func3(x3);
        }
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setConversationId("counted_y");
        String Content = x + " " + d;
        message.setContent(Content);
        for (String s : agents) {
            if (!getAgent().getLocalName().equals(s)) {
                message.addReceiver(new AID(s, false));
            }
        }
        getAgent().send(message);
    }

    @Override
    public void action() {
        ACLMessage receive = getAgent().receive(MessageTemplate.MatchConversationId("counted_i"));
        /*System.out.println("Зашли в  иницианцию");*/
        if (receive != null) {
            /*System.out.println(" Зашли в InitiateDistributedCalculation");*/
            String[] YYY = receive.getContent().split(" ");
            if (YYY.length == 3) {
                i++;
                try {
                    p1 = p1 + Double.parseDouble(YYY[0]);
                    p2 = p2 + Double.parseDouble(YYY[1]);
                    p3 = p3 + Double.parseDouble(YYY[2]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }

            }
            if (i >= 2) {
                endInitiate = true;
            }

        }

    }

    @Override
    public int onEnd() {

        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        System.out.println(getAgent().getLocalName() + " Получил значения и провожу сравнение x -  " + x + " d - " + d);
        if (Math.abs(d) < 0.00001) {
            System.out.println(" Поздравляю, это победа. Число х - " + x);
            System.out.println(" Число d - " + d);

        } else if (p2 > p1 && p2 > p3) {
            d = d / 2;
            Behaviour initBeh = new InitiateDistributedCalculation(x, d);
            getAgent().addBehaviour(initBeh);
            System.out.println(getAgent().getLocalName() + " Добровольно передаю инициативу сам себе! ");
        } else if (p1 > p2 && p1 > p3) {
            x = x - d;
            System.out.println(getAgent().getLocalName() + " Добровольно передаю инициативу - " + randomAgent);
            String Content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            message.setContent(Content);
            message.setConversationId("counted_x");
            message.addReceiver(new AID(randomAgent, false));
            getAgent().send(message);
        } else if (p3 > p2 && p3 > p1) {
            x = x + d;
            System.out.println(getAgent().getLocalName() + " Добровольно передаю инициативу - " + randomAgent);
            String Content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            message.setContent(Content);
            message.setConversationId("counted_x");
            message.addReceiver(new AID(randomAgent, false));
            getAgent().send(message);
        } else {
            System.out.println("Аномалия");
            String Content = "YOUAREINITNITIATOR" + " " + x + " " + d;
            message.setContent(Content);
            message.setConversationId("counted_x");
            message.addReceiver(new AID(randomAgent, false));
            getAgent().send(message);
        }
        return super.onEnd();
    }


    @Override
    public boolean done() {
        return endInitiate;
    }
}
