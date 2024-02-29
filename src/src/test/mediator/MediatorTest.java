package test.mediator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.mediator.LoginFrame;

@DisplayName("Mediator 패턴 시나리오 테스트")
public class MediatorTest {

    @Test
    void test() {
        new LoginFrame("Mediator Sample");
    }
}
