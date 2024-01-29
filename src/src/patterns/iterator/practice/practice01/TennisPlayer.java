package patterns.iterator.practice.practice01;

import java.util.ArrayList;

public class TennisPlayer implements Player {
    ArrayList<TennisBall> tennisBalls;

    public TennisPlayer() {
        tennisBalls = new ArrayList<>();
    }

    @Override
    public void add(Ball ball) {
        if (ball instanceof TennisBall) {
            tennisBalls.add((TennisBall) ball);
        }
    }

    @Override
    public Ball getAt(int index) {
        return tennisBalls.get(index);
    }

    @Override
    public int size() {
        return tennisBalls.size();
    }
}