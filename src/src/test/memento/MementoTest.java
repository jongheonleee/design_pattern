package test.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.memento.game.Gamer;
import patterns.memento.game.Memento;

@DisplayName("Memento 시나리오 테스트")
public class MementoTest {
    Gamer gamer;
    Memento memento;

    @BeforeEach
    void setUp() {
        gamer = new Gamer(100);
        memento = gamer.createMemento();
    }

    @Test
    void test() {
        for (int i=0; i<100; i++) {
            System.out.println("===" + i);
            System.out.println("상태 : " + gamer);

            gamer.bet();

            System.out.println("소지금은 " + gamer.getMoney() + "원이 되었습니다.");

            if (gamer.getMoney() > memento.getMoney()) {
                System.out.println("많이 늘었으니 현재 상태를 저장!");
                memento = gamer.createMemento();
            } else if (gamer.getMoney() < memento.getMoney() / 2) {
                System.out.println("많이 줄었으니 이전 상태를 복원!");
                gamer.restoreMemento(memento);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println();
        }
    }
}
