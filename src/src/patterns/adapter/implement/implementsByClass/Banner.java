package patterns.adapter.implement.implementsByClass;

/**
 * adaptee, 제공 받은 거로서 사용할 대상과 결합시켜야하는 것
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + "*");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}


