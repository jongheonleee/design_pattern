package patterns.iterator.implement;

/**
 * 역할 - 집합체
 * 집합체, 무언가가 담겨져 있는 박스
 */
public interface Iterable<E> {
    Iterator<E> iterator();
}
