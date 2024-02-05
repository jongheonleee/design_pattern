package patterns.singleton.implement;

public class Singleton {

    private static Singleton s = new Singleton();

    private Singleton() {
        System.out.println("인스턴스를 생성했습니다");
    }

    public static Singleton getInstance() {
        return s;
    }

}
