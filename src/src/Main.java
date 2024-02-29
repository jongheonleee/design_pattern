import patterns.abstractFactory.factory.Factory;
import patterns.abstractFactory.factory.Link;
import patterns.abstractFactory.factory.Page;
import patterns.abstractFactory.factory.Tray;
import patterns.mediator.LoginFrame;
import patterns.state.SafeFrame;


public class Main {

    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("State Sample");

        while (true) {
            for (int hour = 0; hour < 24; hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}