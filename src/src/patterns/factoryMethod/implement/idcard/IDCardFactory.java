package patterns.factoryMethod.implement.idcard;

import patterns.factoryMethod.implement.framework.Factory;
import patterns.factoryMethod.implement.framework.Product;

public class IDCardFactory extends Factory {

    private int serial = 100;
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard card = (IDCard) product;
        System.out.printf("%s님의 카드를 등록했습니다.(카드 일련번호 : %d)\n", card.getOwner(), card.getSerial());
    }
}
