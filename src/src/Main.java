import java.io.IOException;
import patterns.adapter.implement.FileIO;
import patterns.adapter.implement.FileProperties;
//import patterns.iterator.implement.Iterator;


public class Main {


    public static void main(String[] args) {
        FileIO f = new FileProperties();

        try {
            f.readFromFile("/Users/qwefghnm1212/Desktop/study/java/design_pattern/src/src/patterns/adapter/implement/file.txt");
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile("/Users/qwefghnm1212/Desktop/study/java/design_pattern/src/src/patterns/adapter/implement/nweFile.txt");
            System.out.println("newFile.txt is created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}