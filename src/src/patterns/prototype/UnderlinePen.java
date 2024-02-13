package patterns.prototype;

import javax.sound.sampled.Port;
import patterns.prototype.framework.Product;

public class UnderlinePen implements Product {
    private char ulChar;

    public UnderlinePen(char ulChar) {
        this.ulChar = ulChar;
    }

    // 문자열에 밑줄 긋기
    @Override
    public void use(String s) {
        // 전체 길이
        int uLen = s.length();

        // 문자열 출력
        System.out.println(s);

        // 밑줄 긋기
        for (int i=0; i<uLen; i++) {
            System.out.print(ulChar);
        }
        System.out.println();
    }

    // 해당 인스턴스로부터 새로운 인스턴스 생성
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
