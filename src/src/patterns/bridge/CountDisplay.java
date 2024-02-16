package patterns.bridge;

public class CountDisplay extends Display {
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int items) {
        open();
        for (int i=0; i<items; i++) {
            print();
        }
        close();
    }
}
