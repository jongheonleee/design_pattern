package patterns.iterator.practice.practice01;

import java.util.ArrayList;

public class BaseBallPlayer implements Player {
    ArrayList<BaseBall> baseBalls;

    public BaseBallPlayer() {
        baseBalls = new ArrayList<>();
    }

    @Override
    public void add(Ball ball) {
        if (ball instanceof BaseBall) {
            baseBalls.add((BaseBall) ball);
        }
    }

    @Override
    public Ball getAt(int index) {
        return baseBalls.get(index);
    }

    @Override
    public int size() {
        return baseBalls.size();
    }
}