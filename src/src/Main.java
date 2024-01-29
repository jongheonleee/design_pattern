import patterns.iterator.implement.Book;
import patterns.iterator.implement.BookShelf;
import patterns.iterator.implement.BookShelf2;
import patterns.iterator.implement.BookShelfInterface;
//import patterns.iterator.implement.Iterator;
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

public class Main {


    public static void main(String[] args) {
        // 0. 세팅
        BallBox<Ball> box = new BallBox<>();
        BaseBallPlayer baseBallPlayer = new BaseBallPlayer();
        BasketBallPlayer basketBallPlayer = new BasketBallPlayer();
        TennisPlayer tennisPlayer = new TennisPlayer();

        for (int i=0; i<30; i++) {
            if (0 <= i && i < 10) {
                box.addBall(new BaseBall());
            } else if (10 <= i && i < 24) {
                box.addBall(new BasketBall());
            } else {
                box.addBall(new TennisBall());
            }
        }
        Iterator it = box.iterate();
        while (it.hasNext()) {
            Ball ball = it.next();
            System.out.println(ball);
        }

        BallBoxIterator it2 = (BallBoxIterator) box.iterate();
        while (it2.hasBaseBall()) {
            baseBallPlayer.add(it2.nextBaseBall());
        }
        while (it2.hasBasketBall()) {
            basketBallPlayer.add(it2.nextBasketBall());
        }

        System.out.println();
        while (it2.hasTennisBall()) {
            TennisBall tennisBall = it2.nextTennisBall();
            System.out.println(tennisBall);
            tennisPlayer.add(tennisBall);
        }

        System.out.println(baseBallPlayer.size());
        System.out.println(basketBallPlayer.size());
        System.out.println(tennisPlayer.size());
    }
}