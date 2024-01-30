package patterns.adapter.practice.practiceByClass.practice01;

public class Client {
    public static void simulate() {
        NewCalendar nc = new AdapterBetweenOldAndNew();
        nc.printDateDot(2024, 1, 30);
        nc.printDateSlash(2024, 1, 30);
        nc.printDateDash(2024, 1, 30);
    }
}
