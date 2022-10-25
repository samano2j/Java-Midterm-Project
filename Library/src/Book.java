import java.util.Arrays;

public class Book {
    private String title;
    private String author;
    private int year;
    private String[] genre;
    private String description;

    public Book(String title, String author, int year, String[] genre, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
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
    public String[] getGenre() {
        return genre;
    }
    public void setGenre(String[] genre) {
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
        return "Title=" + title + ", Author=" + author + ", Year=" + year + ", Genre=" + Arrays.toString(genre);
    }

}
