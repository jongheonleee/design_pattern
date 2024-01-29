package patterns.iterator.implement;

/**
 * 역할 - 구체적인 집합체
 */
public class BookShelf implements BookShelfInterface{
    private Book[] books;
    private int last = 0;

    public BookShelf(int maxSize) {
        books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        if (last == books.length) {
            throw new IllegalStateException("공간이 없습니다");
        }
        books[last++] = book;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }
}
