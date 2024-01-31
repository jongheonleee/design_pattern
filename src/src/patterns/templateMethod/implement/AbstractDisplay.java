package patterns.templateMethod.implement;

// 템플릿
public abstract class AbstractDisplay {
    // 세부 구현은 하위 클래스에서 결정
    public abstract void open();
    public abstract void print();
    public abstract void close();

    // 전체 작업 흐름 틀 결정
    public final void display() {
        open();
        for (int i=0; i<5; i++) {
            print();
        }
        close();
    }
}
