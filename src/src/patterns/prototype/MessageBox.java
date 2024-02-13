package patterns.prototype;
import patterns.prototype.framework.Product;

public class MessageBox implements Product {

    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    // 문자열에 테두리 박스 그림
    @Override
    public void use(String s) {
        // 전체 길이
        int decoLen = 1+s.length()+1;

        // 상위 그리기
        for (int i=0; i<decoLen; i++) {
            System.out.print(decoChar);
        }
        System.out.println();

        // 문자열 출력
        System.out.println(decoChar + s + decoChar);

        // 하위 그리기
        for (int i=0; i<decoLen; i++) {
            System.out.print(decoChar);
        }
        System.out.println();
    }

    // 해당 인스턴스로부터 새로운 인스턴스 생성
    @Override
    public Product createCopy() {
        Product p = null;
        try {
            p = (Product)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
