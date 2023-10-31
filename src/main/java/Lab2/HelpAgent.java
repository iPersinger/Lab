package Lab2;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Random;

public class HelpAgent extends Agent {


    @Override
    protected void setup() {
        System.out.println(getLocalName() + " - I'm ready!");
        addBehaviour(new HelpBehavior());


    }
}
