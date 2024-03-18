package patterns.interpreter;


// 구문 트리의 '노드'가 되는 클래스
public abstract class Node {
    // 구문 해석 처리를 위한 메서드
    public abstract void parse(Context context) throws ParseException;
}
