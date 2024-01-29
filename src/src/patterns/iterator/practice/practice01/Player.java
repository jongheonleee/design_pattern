package patterns.iterator.practice.practice01;

import java.util.ArrayList;

public interface Player {
    Ball getAt(int index);
    void add(Ball ball);
    int size();
}


