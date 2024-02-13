package patterns.prototype.framework;

import java.util.HashMap;
import java.util.Map;

// Product의 특정 구현체를 생성
// 내부적으로는 복제함(인스턴스로부터 인스턴스 생성)
public class Manager {
    private Map<String, Product> showcase = new HashMap<>();

    public void register(String name, Product prototype) {
        showcase.put(name, prototype);
    }

    public Product create(String prototypeName) {
        Product p = showcase.get(prototypeName);
        return p.createCopy();
    }
}
