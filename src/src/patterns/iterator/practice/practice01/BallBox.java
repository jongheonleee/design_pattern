package patterns.iterator.practice.practice01;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class BallBox<T extends Ball> implements Iterable {
    List<T> balls;

    public BallBox() {
        balls = new ArrayList<>();
    }

    public void addBall(T t) {
        balls.add(t);
    }

    public Ball getAt(int index) {
        return balls.get(index);
    }

    public boolean removeBall(T t) {
        if (balls.contains(t)) {
            balls.remove(t);
            return true;
        }
        return false;
    }

    public int size() {
        return balls.size();
    }

    @Override
    public Iterator iterate() {
        return new BallBoxIterator(this);
    }
}
