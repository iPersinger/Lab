package Lab2;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class CatchInitiative extends Behaviour {
    private double x, d;


    @Override
    public void action() {
        ACLMessage receive = getAgent().blockingReceive(MessageTemplate.MatchConversationId("counted_x"));
        String[] CallANDXD = receive.getContent().split(" ");
        if (receive != null) {
            System.out.println("Зашли в CatchInitiative");
            if (CallANDXD[0].equals("YOUAREINITNITIATOR")) {
                System.out.println(getAgent().getLocalName() + " Зашли в  условие CatchInitiative ");
                try {
                    x = Double.parseDouble(CallANDXD[1]);
                    d = Double.parseDouble(CallANDXD[2]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }
                Behaviour initBeh = new InitiateDistributedCalculation(x, d);
                getAgent().addBehaviour(initBeh);
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
