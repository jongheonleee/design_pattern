package patterns.factoryMethod.implement.idcard;

import patterns.factoryMethod.implement.framework.Product;

public class IDCard extends Product {
    private String owner;
    private int serial;

    IDCard(String owner, int serial) {
        System.out.printf("%s 님의 카드를 만듦(일련번호 : %d)\n", owner, serial);
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(this + " 를 사용합니다.");
    }

    @Override
    public String toString() {
        return "[ IDCard : " + owner + " ]";
    }

    public String getOwner() {

        return owner;
    }

    public int getSerial() {
        return serial;
    }
}
