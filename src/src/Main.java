import java.io.IOException;
import patterns.adapter.implement.FileIO;
import patterns.adapter.implement.FileProperties;
import patterns.adapter.practice.practiceByInstance.practice01.Client;
import patterns.templateMethod.implement.AbstractDisplay2;
import patterns.templateMethod.implement.ChairDisplay;
import patterns.templateMethod.implement.StringDisplay;
//import patterns.iterator.implement.Iterator;


public class Main {


    public static void main(String[] args) {
        AbstractDisplay2 ac = new ChairDisplay('#');
        AbstractDisplay2 as = new StringDisplay("Hello");

        ac.display();
        System.out.println();
        as.display();

    }
}