package Lab2;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class CalcMyFunction extends Behaviour {
    private double x, d;
    @Override
    public void action() {
        ACLMessage receive = getAgent().receive(MessageTemplate.MatchConversationId("Calc"));
        if (receive != null) {
            /*System.out.println(getAgent().getLocalName() + " Зашёл в CalcMyFunction от  " + receive.getSender().getLocalName());*/
            String[] XAndD = receive.getContent().split(" ");
            if (XAndD.length == 2) {
                /*System.out.println(getAgent().getLocalName() + " Зашёл в  условие CalcMyFunction ");*/
                try {
                    x = Double.parseDouble(XAndD[0]);
                    d = Double.parseDouble(XAndD[1]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }
                Helper.message("Take", receive.getSender().getLocalName(), Helper.ContentYYY(x, d, getAgent()), getAgent());
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
