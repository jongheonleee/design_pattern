package test.iterator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.iterator.practice.practice01.Ball;
import patterns.iterator.practice.practice01.BallBox;
import patterns.iterator.practice.practice01.BallBoxIterator;
import patterns.iterator.practice.practice01.BaseBall;
import patterns.iterator.practice.practice01.BaseBallPlayer;
import patterns.iterator.practice.practice01.BasketBall;
import patterns.iterator.practice.practice01.BasketBallPlayer;
import patterns.iterator.practice.practice01.Iterator;
import patterns.iterator.practice.practice01.TennisBall;
import patterns.iterator.practice.practice01.TennisPlayer;

class Expect {
    int baseBall, basketBall, tennisBall;

    Expect(int baseBall, int basketBall, int tennisBall) {
        this.baseBall = baseBall;
        this.basketBall = basketBall;
        this.tennisBall = tennisBall;
    }
}

public class IteratorTest {

    BallBox<Ball> ballBox;
    BaseBallPlayer baseBallPlayer;
    BasketBallPlayer basketBallPlayer;
    TennisPlayer tennisPlayer;
    Expect expect;


    @BeforeEach
    void setUp() {
        ballBox = new BallBox<>();

        baseBallPlayer = new BaseBallPlayer();
        basketBallPlayer = new BasketBallPlayer();
        tennisPlayer = new TennisPlayer();

        int baseBall = 0;
        int basketBall = 0;
        int tennisBall = 0;

        for (int i=0; i<30; i++) {
            if (0 <= i && i < 10) {
                ballBox.addBall(new BaseBall());
                baseBall++;
            } else if (10 <= i && i < 20) {
                ballBox.addBall(new BasketBall());
                basketBall++;
            } else {
                ballBox.addBall(new TennisBall());
                tennisBall++;
            }
        }

        expect = new Expect(baseBall, basketBall, tennisBall);
    }

    @Test
    @DisplayName("Iterator 패턴 확인")
    void test0() {
        int index = 0;
        Iterator it = ballBox.iterate();
        while (it.hasNext()) {
            Ball next = it.next();
            assertTrue(ballBox.getAt(index).equals(next));
            index++;
        }
    }

    @Test
    @DisplayName("각 선수마다 원하는 공을 수집했는지 확인")
    void test1() {
        BallBoxIterator it2 = (BallBoxIterator) ballBox.iterate();
        while (it2.hasBaseBall()) {
            baseBallPlayer.add(it2.nextBaseBall());
        }
        while (it2.hasBasketBall()) {
            basketBallPlayer.add(it2.nextBasketBall());
        }
        while (it2.hasTennisBall()) {
            tennisPlayer.add(it2.nextTennisBall());
        }

        assertTrue(expect.baseBall == baseBallPlayer.size());
        assertTrue(expect.basketBall == basketBallPlayer.size());
        assertTrue(expect.tennisBall == tennisPlayer.size());
    }
}
