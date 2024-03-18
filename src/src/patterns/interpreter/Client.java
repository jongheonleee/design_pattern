package patterns.interpreter;

import java.nio.file.Files;
import java.nio.file.Path;

// 동작 테스트용 클래스
public class Client {

    public static void main(String[] args) {
        try {
            for (String text : Files.readAllLines(Path.of("program.txt"))) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
