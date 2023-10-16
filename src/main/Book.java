package src.main;

public class Book {
    private int id;
    @BookInfo(title = "Title X", author = "Author X", yearPublished = 2023)
    private String bookInfo;
    private String isbn;
    public Book(int id, String isbn, String title, String author, int yearPublished) {
        this.id = id;
        this.isbn = isbn;
        this.bookInfo = title + " by " + author + ", " + yearPublished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }
}
