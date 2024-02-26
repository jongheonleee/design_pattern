package test.observer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.observer.DigitObserver;
import patterns.observer.GraphObserver;
import patterns.observer.NumberGenerator;
import patterns.observer.Observer;
import patterns.observer.RandomNumberGenerator;

public class ObserverTest {

    NumberGenerator generator;
    Observer observer1;
    Observer observer2;

    ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        generator = new RandomNumberGenerator();
        observer1 = new DigitObserver();
        observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void clear() {
        System.setOut(System.out);
    }

    @DisplayName("시뮬레이션 돌려보기")
    @Test
    void test() {
    }

}
