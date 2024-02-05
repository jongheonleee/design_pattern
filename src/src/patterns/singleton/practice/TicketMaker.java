package patterns.singleton.practice;

public class TicketMaker {
    private static TicketMaker t = new TicketMaker();
    private int ticket;

    private TicketMaker() {
        ticket = 1000;
    }

    public static TicketMaker getInstance() {
        return t;
    }
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

}
