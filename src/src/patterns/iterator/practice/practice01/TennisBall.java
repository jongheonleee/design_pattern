package patterns.iterator.practice.practice01;

public class TennisBall implements Ball {
    public TennisBall() {

    }
    public String toString() {
        return "tennisball";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TennisBall;
    }
}
