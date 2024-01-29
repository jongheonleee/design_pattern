package patterns.iterator.implement;

public interface BookShelfInterface extends Iterable<Book> {
    Book getBookAt(int index);
    void appendBook(Book book);
    int getLength();

}
