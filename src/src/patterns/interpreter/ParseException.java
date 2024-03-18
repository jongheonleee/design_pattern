package patterns.interpreter;

// 구문 해석 중의 예외 클래스
public class ParseException extends Exception{
    public ParseException(String msg) {
        super(msg);
    }
}
