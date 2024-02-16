package test.bridge;

import org.junit.jupiter.api.Test;
import patterns.bridge.CountDisplay;
import patterns.bridge.Display;
import patterns.bridge.StringDisplayImpl;

public class BridgeTest {

    @Test
    void test() {
        Display d1 = new Display(new StringDisplayImpl("Hello, Korea!!"));
        CountDisplay d2 = new CountDisplay(new StringDisplayImpl("Hello World!!"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe!!"));
        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
    }

}
