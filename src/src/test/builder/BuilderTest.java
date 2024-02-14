package test.builder;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.builder.Director;
import patterns.builder.HTMLBuilder;
import patterns.builder.TextBuilder;

@DisplayName("Builder 테스트")
public class BuilderTest {

    TextBuilder textBuilder;
    Director directorForText;
    HTMLBuilder htmlBuilder;
    Director directorForHTML;

    @BeforeEach
    void setUp() {
        textBuilder = new TextBuilder();
        directorForText = new Director(textBuilder);

        htmlBuilder = new HTMLBuilder();
        directorForHTML = new Director(htmlBuilder);
    }

    @DisplayName("1. 텍스트 빌더 테스트")
    @Test
    void test1() {
        // 0. 기대 결과
        String expected =
                "=====================\n"
                        + "[Greeting]\n"
                        + "\n"
                        + "#일반적인 인사\n"
                        + "\n"
                        + "-how are you?\n"
                        + "-hello\n"
                        + "-hi\n"
                        + "\n"
                        + "#시간대별 인사\n"
                        + "\n"
                        + "-good morning\n"
                        + "-good afternoon\n"
                        + "-good evening\n"
                        + "\n"
                        + "=====================\n";
        // 1. 작업 진행
        directorForText.construct();
        String result = textBuilder.getTextResult();

        // 2. 결과 비교
        assertTrue(expected.equals(result));

    }

}
