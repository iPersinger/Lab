package Lab2;

import jade.core.Agent;

public class FunctionAgent extends Agent {
    @Override
    protected void setup() {
        addBehaviour(new CatchInitiative());
        addBehaviour(new CalcMyFunction());
        System.out.println(getLocalName() + " - I'm here!");
        if (getLocalName().equals("FunctionAgent1")) {
            addBehaviour(new InitiateDistributedCalculation(54, -3.48));
        }
    }
}
