import patterns.iterator.implement.Book;
import patterns.iterator.implement.BookShelf;
import patterns.iterator.implement.BookShelf2;
import patterns.iterator.implement.BookShelfInterface;
import patterns.iterator.implement.Iterator;

public class Main {

    private static void showAllBooks(BookShelfInterface bookShelf) {
        Iterator<Book> it = bookShelf.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        // 0. 세팅
        BookShelfInterface bookShelfWithArr = new BookShelf(4);
        BookShelfInterface bookShelfWithList= new BookShelf2(4);

        bookShelfWithArr.appendBook(new Book("Around the World in 80 Days"));
        bookShelfWithArr.appendBook(new Book("Bible"));
        bookShelfWithArr.appendBook(new Book("Cinderella"));
        bookShelfWithArr.appendBook(new Book("Daddy-Long-Legs"));

        bookShelfWithList.appendBook(new Book("Around the World in 80 Days"));
        bookShelfWithList.appendBook(new Book("Bible"));
        bookShelfWithList.appendBook(new Book("Cinderella"));
        bookShelfWithList.appendBook(new Book("Daddy-Long-Legs"));
        bookShelfWithList.appendBook(new Book("Daddy-Long-Legs2"));
        bookShelfWithList.appendBook(new Book("Daddy-Long-Legs3"));
        bookShelfWithList.appendBook(new Book("Daddy-Long-Legs4"));

        // 1. Iterator pattern 활용
        System.out.println("== BookShelfWithArr ==");
        showAllBooks(bookShelfWithArr);

        System.out.println("== BookShelfWithList ==");
        showAllBooks(bookShelfWithList);

    }
}