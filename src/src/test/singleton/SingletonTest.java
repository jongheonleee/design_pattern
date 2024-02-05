package test.singleton;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.singleton.implement.Singleton;
import patterns.singleton.practice.SingletonByEnum;
import patterns.singleton.practice.TicketMaker;
import patterns.singleton.practice.Triple;

public class SingletonTest {

    Singleton s;

    @Test
    @DisplayName("인스턴스 하나만 보장하는지 확인")
    void test() {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        assertTrue(s1 == s2);
    }

    @Test
    @DisplayName("이넘으로 싱글톤 패턴 구현 테스트")
    void test2() {
        SingletonByEnum.INSTANCE.work();
    }


    @Test
    @DisplayName("티켓 메이커 테스트")
    void test3() {
        TicketMaker t = TicketMaker.getInstance();

        for (int i=0; i<10; i++) {
            int nextTicketNumber = t.getNextTicketNumber();
            System.out.printf("%d - %d\n", i, nextTicketNumber);
        }
    }

}
