package patterns.factoryMethod.implement.laptop;

import patterns.factoryMethod.implement.framework.Factory;
import patterns.factoryMethod.implement.framework.Product;

public class LaptopFactory extends Factory {

    @Override
    protected Product createProduct(String owner) {
        System.out.println(owner + "님이 맥북을 구입했습니다.");
        return new Laptop();
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println("맥북을 등록했습니다.");
    }
}
