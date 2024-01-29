package patterns.iterator.implement;

import java.util.ArrayList;

/**
 * 문제 요구 사항 : 책을 저장하는 자료구조 변경, 배열 -> ArrayList
 * - 0. BookShelf, BookShelf2의 관계 형성, 즉 인터페이스 정의
 * - 1. BookShelf2 내부 구현 변경
 * - 2. BookShelfIterator 생성할 때 인터페이스 받아서 생성
 *
 * => 구현체(BookShelf, BookShelf2)를 쉽게 갈아 끼울 수 있음
 */
public class BookShelf2 implements BookShelfInterface {
    private ArrayList<Book> books;

    public BookShelf2(int size) {
        books = new ArrayList<Book>(size);
    }

    public Book getBookAt(int index) {
        return books.get(index);
    }

    public void appendBook(Book book) {
        books.add(book);
    }

    public int getLength() {
        return books.size();
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
