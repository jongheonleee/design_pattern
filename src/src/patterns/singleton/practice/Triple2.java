package patterns.singleton.practice;

public enum Triple2 {

    ALPHA, BETA, GAMMA;

    private Triple2() {

    }

    public static Triple2 getInstance(String name) {
        return valueOf(name);
    }
}
