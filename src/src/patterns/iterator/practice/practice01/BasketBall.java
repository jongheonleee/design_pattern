package patterns.iterator.practice.practice01;

public class BasketBall implements Ball {
    public BasketBall() {

    }
    public String toString() {
        return "basketball";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BasketBall;
    }
}