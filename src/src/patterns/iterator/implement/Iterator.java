package patterns.iterator.implement;

/**
 * 역할 - 반복자
 * 무언가가 담겨져 있는 박스에서 순서대로 꺼내서 반복해서 처리하는 것, 커서
 */
public interface Iterator<E> {
    boolean hasNext();
    E next();
}
