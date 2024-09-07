public class Book {
    private String author;
    private String title;
    private int numOfPages;

    public Book(String author, String title, int numOfPages) {
        this.author = author;
        this.title = title;
        this.numOfPages = numOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
