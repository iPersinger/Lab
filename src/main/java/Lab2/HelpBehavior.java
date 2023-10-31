package Lab2;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Random;

public class HelpBehavior extends OneShotBehaviour {


    private String[] agents = {"FunctionAgent1", "FunctionAgent2", "FunctionAgent3"};
    Random random = new Random();
    int randomIndex = random.nextInt(agents.length);
    String randomAgent = agents[randomIndex];
    @Override
    public void action() {
        System.out.println(getAgent().getLocalName() + " Отправка пошла ");
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setConversationId("counted_x");
        double x = -2, d = -6;
        String Content = "YOUAREINITNITIATOR" + " " + x + " " + d;
        message.setContent(Content);
        message.addReceiver(new AID(randomAgent, false));
        getAgent().send(message);
        /*message.setConversationId("counted_y");
        message.setContent("-2 -6");
        message.addReceiver(new AID("FunctionAgent1", false));
        getAgent().send(message);*/
    }
}
