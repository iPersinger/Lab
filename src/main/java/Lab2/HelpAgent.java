package Lab2;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class HelpAgent extends Agent {
    double x = -4, d = 1;

    @Override
    protected void setup() {
        System.out.println(getLocalName() + " - I'm ready!");
        Behaviour initBeh = new InitiateDistributedCalculation(x, d);
        addBehaviour(initBeh);
        /*addBehaviour(new HelpBehavior());*/


    }
}
