import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int year;
    private ArrayList<String> genre = new ArrayList<>();
    private String description;

    public Book(String title, String author, int year, ArrayList<String> genre, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle1() {
        return title.toLowerCase();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getAuthor1() {
        return author.toLowerCase();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", year=" + year + ", genre=" + genre + "]";
    }
}
