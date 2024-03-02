package patterns.flyweight;

// BigChar 를 모아서 만든 '큰 문자열'을 나타내는 클래스
public class BigString {

    // '큰 문자'의 배열
    private BigChar[] bigChars;

    // 생성자
    public BigString(String string) {
        BigCharFactory factory = BigCharFactory.getInstance();
        bigChars = new BigChar[string.length()];

        for (int i=0; i< bigChars.length; i++) {
            bigChars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    // 표시
    public void print() {
        for (BigChar bc : bigChars) {
            bc.print();
        }
    }
}
