package patterns.iterator.practice.practice01;

import java.util.ArrayList;

public class BasketBallPlayer implements Player {
    ArrayList<BasketBall> basketBalls;

    public BasketBallPlayer() {
        basketBalls = new ArrayList<>();
    }

    @Override
    public void add(Ball ball) {
        if (ball instanceof BasketBall) {
            basketBalls.add((BasketBall) ball);
        }
    }

    @Override
    public Ball getAt(int index) {
        return basketBalls.get(index);
    }

    @Override
    public int size() {
        return basketBalls.size();
    }
}
