import java.util.ArrayList;
import java.util.List;

public class Shelf {
    public static final int MAX_BOOKS = 5;

    private List<Book> books;
    private boolean isShelfFull;

    public Shelf() {
        books = new ArrayList<>(MAX_BOOKS);
        isShelfFull = false;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isShelfFull() {
        return isShelfFull;
    }

    public void setShelfFull(boolean isShelfFull) {
        this.isShelfFull = isShelfFull;
    }

    public void addBook(Book book) {
        if (books.size() < MAX_BOOKS) {
            books.add(book);
            if (books.size() == MAX_BOOKS) {
                setShelfFull(true);
            }
        } else {
            System.out.println("The shelf is full. Cannot add more books.");
        }
    }

}
