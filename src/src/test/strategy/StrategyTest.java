package test.strategy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import patterns.strategy.Hand;
import patterns.strategy.Player;
import patterns.strategy.ProbStrategy;
import patterns.strategy.WinningStrategy;

@DisplayName("Strategy 테스트")
public class StrategyTest {


    @DisplayName("시뮬레이션 돌리기")
    @ParameterizedTest(name = "{index}. 입력된 시드값은 \"{0}\"입니다.")
    @ValueSource(ints = {3, 5, 6, 9})
    void test(int seed) {
        Player p1 = new Player("KIM", new WinningStrategy(seed));
        Player p2 = new Player("LEE", new ProbStrategy(seed*2));

        for (int i=0; i<10000; i++) {
            Hand nextHand1 = p1.nextHand();
            Hand nextHand2 = p2.nextHand();

            if (nextHand1.isStrongerThen(nextHand2)) {
                System.out.println("Winner : " + p1);
                p1.win();
                p2.lose();
            } else if (nextHand2.isStrongerThen(nextHand1)) {
                System.out.println("Winner : " + p2);
                p1.lose();
                p2.win();
            } else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
        }

        System.out.println("Total Result : " + p1 + p2);
    }
}
