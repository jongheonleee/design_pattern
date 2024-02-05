package patterns.singleton.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class Triple {

    private static Map<String, Triple> map = new HashMap<>();

    private static String[] names = {"ALPHA", "BETA", "GAMMA"};

    static {
        for (String name : names) {
            map.put(name, new Triple(name));
        }
    }

    private String name;

    private Triple(String name) {
        this.name = name;
    }


    public Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
