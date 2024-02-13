package test.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import patterns.prototype.MessageBox;
import patterns.prototype.UnderlinePen;
import patterns.prototype.framework.Manager;
import patterns.prototype.framework.Product;

@DisplayName("Prototype 테스트")
public class PrototypeTest {
    Manager manager;
    ByteArrayOutputStream outputStream;


    @BeforeEach
    void setUp() {
        manager = new Manager();
        outputStream = new ByteArrayOutputStream(); // 출력값 비교 객체
        System.setOut(new PrintStream(outputStream));

        // 준비
        UnderlinePen underlinePen = new UnderlinePen('-');
        MessageBox messageBoxForStar = new MessageBox('*');
        MessageBox messageBoxForSlash = new MessageBox('/');

        // 등록
        manager.register("strong message", underlinePen);
        manager.register("warning box", messageBoxForStar);
        manager.register("slash box", messageBoxForSlash);
    }

    @AfterEach
    void clear() {
        System.setOut(System.out);
    }

    @DisplayName("1. Manager로부터 underlinePen의 인스턴스 생성받아서 사용하기")
    @ParameterizedTest(name = "{index}. 입력된 문자열은 \"{0}\"입니다.")
    @ValueSource(strings = {"hello world", "goodbye world", "happy world"})
    void test1(String message) {
        // 0. 기대 결과
        String expected = "";
        expected += message;
        expected += "\n";

        for (int i=0; i<message.length(); i++) {
            expected += '-';
        }
        expected += "\n";


        // 1. 작업 실행
        Product product = manager.create("strong message");
        product.use(message);

        // 2. 결과 비교
        assertEquals(expected, outputStream.toString());
        assertEquals(UnderlinePen.class, product.getClass());

    }

    @DisplayName("2. Manager로부터 MessageBox(*)의 인스턴스 생성받아서 사용하기")
    @ParameterizedTest(name = "{index}. 입력된 문자열은 \"{0}\"입니다.")
    @ValueSource(strings = {"안녕 친구", "요르레이호", "호날두"})
    void test2(String message) {
        // 0. 기대 결과
        String expected = "";
        int len = message.length()+2;

        String s = "";
        for (int i=0; i<len; i++) {
            s += '*';
        }
        expected += s + "\n*" + message + "*\n" + s + "\n";

        // 1. 작업 실행
        Product product = manager.create("warning box");
        product.use(message);

        // 2. 결과 비교
        assertEquals(expected, outputStream.toString());
        assertEquals(MessageBox.class, product.getClass());
    }

    @DisplayName("3. Manager로부터 MessageBox(/)의 인스턴스 생성받아서 사용하기")
    @ParameterizedTest(name = "{index}. 입력된 문자열은 \"{0}\"입니다.")
    @ValueSource(strings = {"안녕 친구", "요르레이호", "호날두"})
    void test3(String message) {
        // 0. 기대 결과
        String expected = "";
        int len = message.length()+2;

        String s = "";
        for (int i=0; i<len; i++) {
            s += '/';
        }
        expected += s + "\n/" + message + "/\n" + s + "\n";

        // 1. 작업 실행
        Product product = manager.create("slash box");
        product.use(message);

        // 2. 결과 비교
        assertEquals(expected, outputStream.toString());
        assertEquals(MessageBox.class, product.getClass());
    }
}
