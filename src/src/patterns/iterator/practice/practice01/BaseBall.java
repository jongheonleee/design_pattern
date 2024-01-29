package patterns.iterator.practice.practice01;

public class BaseBall implements Ball {
    public BaseBall() {

    }
    public String toString() {
        return "baseball";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof BaseBall;
    }
}