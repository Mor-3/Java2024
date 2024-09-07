import java.util.ArrayList;
import java.util.List;

public class Library {
    private static final int NUM_SHELVES = 3;

    private List<Shelf> shelves;
    private List<Reader> readers;

    public Library() {
        shelves = new ArrayList<>(NUM_SHELVES);
        for (int i = 0; i < NUM_SHELVES; i++) {
            shelves.add(new Shelf());
        }

        readers = new ArrayList<>();
    }

    public boolean isTherePlaceForNewBook() {
        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                return true;
            }
        }
        return false;
    }

    public void addNewBook(Book book) {
        if (!isTherePlaceForNewBook()) {
            System.out.println("No space available to add the new book.");
            return;
        }

        for (Shelf shelf : shelves) {
            if (!shelf.isShelfFull()) {
                shelf.addBook(book);
                System.out.println("Book added: " + book);
                return;
            }
        }
    }

    public void deleteBook(String bookTitle) {
        boolean bookDeleted = false;

        for (Shelf shelf : shelves) {
            List<Book> books = shelf.getBooks();
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getTitle().equals(bookTitle)) {
                    books.remove(i);
                    System.out.println("Book removed: " + bookTitle);
                    if (shelf.getBooks().size() < Shelf.MAX_BOOKS) {
                        shelf.setShelfFull(false);
                    }
                    return;
                }
            }
        }

        if (!bookDeleted) {
            System.out.println("Book not found: " + bookTitle);
        }
    }

    public void registerReader(int id, String name) {
        Reader newReader = new Reader(id, name);
        readers.add(newReader);
        System.out.println("Reader registered: " + newReader);
    }

    public void removeReader(String name) {
        Reader readerToRemove = null;

        for (Reader reader : readers) {
            if (reader.getName().equals(name)) {
                readerToRemove = reader;
                break;
            }
        }

        if (readerToRemove != null) {
            readers.remove(readerToRemove);
            System.out.println("Reader removed: " + name);
        } else {
            System.out.println("Reader not found: " + name);
        }
    }

    public List<String> searchByAuthor(String author) {
        List<String> bookTitles = new ArrayList<>();

        for (Shelf shelf : shelves) {
            for (Book book : shelf.getBooks()) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    bookTitles.add(book.getTitle());
                }
            }
        }

        return bookTitles;
    }

}
