import java.util.ArrayList;
import java.util.List;

public class Reader {
    private int id;
    private String name;
    private List<String> books;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
