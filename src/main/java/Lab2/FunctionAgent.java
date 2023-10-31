package Lab2;

import jade.core.Agent;

public class FunctionAgent extends Agent {
    private double x, d;

    @Override
    protected void setup() {
        addBehaviour(new CatchInitiative());
        addBehaviour(new CalcMyFunction());


        System.out.println(getLocalName() + " - I'm here!");

    }
}
