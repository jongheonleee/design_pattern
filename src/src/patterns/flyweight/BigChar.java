package patterns.flyweight;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// '큰 문자'를 나타내는 클래스
public class BigChar {

    // 문자의 이름
    private char charName;

    // 큰 문자를 표현하는 문자열('#' '.' '\n'으로 이루어진 열)
    private String fontData;

    // 생성자
    public BigChar(char charName) {
        this.charName = charName;
        try {
            String fileName = "big" + charName + ".txt";
            StringBuilder sb = new StringBuilder();

            for (String line : Files.readAllLines(Path.of(fileName))) {
                sb.append(line);
                sb.append("\n");
            }

            this.fontData = sb.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    // 큰 문자를 표시함
    public void print() {
        System.out.println(fontData);
    }

}
