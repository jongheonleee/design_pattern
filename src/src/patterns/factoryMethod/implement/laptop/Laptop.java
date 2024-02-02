package patterns.factoryMethod.implement.laptop;

import patterns.factoryMethod.implement.framework.Product;

public class Laptop extends Product {

    @Override
    public void use() {
        System.out.println("맥북 : 두둥(켜지는 소리)");
    }
}
