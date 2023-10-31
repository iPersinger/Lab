package Lab2;

import Lab2.MathFunc.MathFunc;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.util.List;

public class CalcMyFunction extends Behaviour {

    @Override
    public void action() {
        ACLMessage receive = getAgent().receive();
        if (receive != null) {
            /*System.out.println("Зашли в CalcMyFunction");*/
            String[] XAndD = receive.getContent().split(" ");
            if (XAndD.length == 2) {
                /*System.out.println(getAgent().getLocalName() + " Зашли в условие CalcMyFunction");*/


                double x = 0, d = 0, y1 = 0, y2 = 0, y3 = 0;
                try {
                    x = Double.parseDouble(XAndD[0]);
                    d = Double.parseDouble(XAndD[1]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }

                /*System.out.println(x);
                System.out.println(d);*/
                double x1 = x - d;
                double x2 = x;
                double x3 = x + d;
                MathFunc f = new MathFunc();
                if (getAgent().getLocalName().equals("FunctionAgent1")) {
                    y1 = f.func1(x1);
                    y2 = f.func1(x2);
                    y3 = f.func1(x3);
                } else if (getAgent().getLocalName().equals("FunctionAgent2")) {
                    y1 = f.func2(x1);
                    y2 = f.func2(x2);
                    y3 = f.func2(x3);
                } else if (getAgent().getLocalName().equals("FunctionAgent3")) {
                    y1 = f.func3(x1);
                    y2 = f.func3(x2);
                    y3 = f.func3(x3);
                }
                String Content = y1 + " " + y2 + " " + y3;
                /*System.out.println(Content);*/
                ACLMessage message = new ACLMessage(ACLMessage.INFORM);
                message.setContent(Content);
                message.addReceiver(new AID(receive.getSender().getLocalName(), false));
                getAgent().send(message);
            }
        } else {
            block();
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
