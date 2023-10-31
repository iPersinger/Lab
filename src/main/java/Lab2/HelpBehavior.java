package Lab2;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class HelpBehavior extends OneShotBehaviour {
    @Override
    public void action() {
        System.out.println(getAgent().getLocalName() + " Отправка пошла ");
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        message.setContent("-2 -6 3");
        message.addReceiver(new AID("FunctionAgent1", false));
        getAgent().send(message);
    }
}
