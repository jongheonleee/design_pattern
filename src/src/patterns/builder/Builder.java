package patterns.builder;

/**
 * 인스턴스 생성하기 위한 인터페이스
 */
public abstract class Builder {
    abstract void makeTitle(String title);
    abstract void makeString(String str);
    abstract void makeItems(String[] items);
    abstract void close();

}
