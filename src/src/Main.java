import patterns.factoryMethod.implement.framework.Factory;
import patterns.factoryMethod.implement.framework.Product;
import patterns.factoryMethod.implement.idcard.IDCardFactory;
import patterns.factoryMethod.implement.laptop.LaptopFactory;

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product[] cards = new Product[3];
        Product card1 = factory.create("Lee");
        Product card2 = factory.create("Su");
        Product card3 = factory.create("Hong");

        cards[0] = card1;
        cards[1] = card2;
        cards[2] = card3;

        for (int i=0; i<3; i++) {
            cards[i].use();
        }
    }
}