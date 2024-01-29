package patterns.iterator.implement;

import java.util.NoSuchElementException;


/**
 * 역할 - 구체적인 반복자
 */
public class BookShelfIterator implements Iterator<Book> {
    private BookShelfInterface bookShelf;
    private int index;

    public BookShelfIterator(BookShelfInterface bookShelf) {
        this.bookShelf = bookShelf;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
