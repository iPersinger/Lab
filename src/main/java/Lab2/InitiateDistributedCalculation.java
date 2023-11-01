package Lab2;


import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;


public class InitiateDistributedCalculation extends Behaviour {
    int i = 0;
    private double x, d;

    public InitiateDistributedCalculation(double x, double d) {
        this.x = x;
        this.d = d;
    }
    boolean endInitiate = false;
    private double p1 = 0, p2 = 0, p3 = 0;
    @Override
    public void onStart() {
        /*System.out.println("Зашли в старт иницианции");*/
        String content = x + " " + d;
        for (String s : Helper.agents()) {
            if (!getAgent().getLocalName().equals(s)) {
                Helper.message("Calc", s, content, getAgent());
            }
        }
    }
    @Override
    public void action() {
        ACLMessage receive = getAgent().receive(MessageTemplate.MatchConversationId("Take"));
        /*System.out.println("Зашли в  иницианцию");*/
        if (receive != null) {
            /*System.out.println(" Зашли в InitiateDistributedCalculation");*/
            String[] YYY = receive.getContent().split(" ");
            if (YYY.length == 3) {
                i++;
                try {
                    p1 = p1 + Double.parseDouble(YYY[0]);
                    p2 = p2 + Double.parseDouble(YYY[1]);
                    p3 = p3 + Double.parseDouble(YYY[2]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }
            }
            if (i >= 2) {
                String[] MyYYY = Helper.ContentYYY(x, d, getAgent()).split(" ");
                try {
                    p1 = p1 + Double.parseDouble(MyYYY[0]);
                    p2 = p2 + Double.parseDouble(MyYYY[1]);
                    p3 = p3 + Double.parseDouble(MyYYY[2]);
                } catch (NullPointerException | NumberFormatException e) {
                    e.printStackTrace();
                    System.err.println("Айяйяй!");
                }
                endInitiate = true;
            }
        }
    }
    @Override
    public int onEnd() {
        Helper.InitiateOnEnd(x, d, p1, p2, p3, getAgent());
        return super.onEnd();
    }
    @Override
    public boolean done() {
        return endInitiate;
    }
}
