import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        initializeLibrary(library);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("For adding a book - Press 1");
            System.out.println("For deleting a book - Press 2");
            System.out.println("For registering a new reader - Press 3");
            System.out.println("For removing a reader - Press 4");
            System.out.println("For searching books by author - Press 5");
            System.out.println("For exit - Press 6");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter book author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter number of pages:");
                    int numOfPages = scanner.nextInt();
                    scanner.nextLine();

                    Book newBook = new Book(author, title, numOfPages);
                    library.addNewBook(newBook);
                    break;

                case 2:
                    System.out.println("Enter book title to delete:");
                    String bookTitleToDelete = scanner.nextLine();
                    library.deleteBook(bookTitleToDelete);
                    break;

                case 3:
                    System.out.println("Enter new reader ID:");
                    int readerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new reader name:");
                    String readerName = scanner.nextLine();

                    library.registerReader(readerId, readerName);
                    break;

                case 4:
                    System.out.println("Enter reader name to remove:");
                    String readerNameToRemove = scanner.nextLine();
                    library.removeReader(readerNameToRemove);
                    break;

                case 5:
                    System.out.println("Enter author name to search:");
                    String authorName = scanner.nextLine();
                    List<String> booksByAuthor = library.searchByAuthor(authorName);

                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found by this author.");
                    } else {
                        System.out.println("Books by " + authorName + ":");
                        for (String bookTitle : booksByAuthor) {
                            System.out.println(bookTitle);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void initializeLibrary(Library library) {
        Book book1 = new Book("Author1", "Book1", 500);
        Book book2 = new Book("Author2", "Book2", 230);
        Book book3 = new Book("Author3", "Book3", 333);
        Book book4 = new Book("Author4", "Book4", 380);
        Book book5 = new Book("Author5", "Book5", 190);
        Book book6 = new Book("Author6", "Book6", 410);

        for (int i = 0; i < 3; i++) {
            library.addNewBook(book1);
            library.addNewBook(book2);
            library.addNewBook(book3);
            library.addNewBook(book4);
            library.addNewBook(book5);
            library.addNewBook(book6);
        }
    }
}
