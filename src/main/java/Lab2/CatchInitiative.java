package Lab2;

import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class CatchInitiative extends Behaviour {
    private double x, d;

    public CatchInitiative(double x, double d) {
        this.x = x;
        this.d = d;
    }

    @Override
    public void action() {
        ACLMessage receive = getAgent().receive();
        if (receive != null) {
            System.out.println("Зашли в CatchInitiative");
            if (receive.getContent().equals("YOUAREINITNITIATOR")) {
                System.out.println(getAgent().getLocalName() + " Зашли в  условие CatchInitiative ");
                Behaviour initBeh = new InitiateDistributedCalculation(x, d);
                // TODO: Проверить строку возможно, нужен getAgent
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
