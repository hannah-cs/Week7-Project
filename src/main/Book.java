package src.main;

public class Book {
    private int id;

    private String author;

    private double price;

    private String title;
    @BookInfo(title = "Title X", author = "Author X", yearPublished = 2023)
    private String bookInfo;
    @ISBN
    private String isbn;
    public Book(int id, String isbn, String title, double price, String author, int yearPublished) {
        this.id = id;
        this.price = price;
        if (isValidISBN(isbn)) {
            this.isbn = isbn;
        } else {
            //IllegalArgumentException is a built-in Java exception class that is used
            // to indicate that a method has been called with an illegal or inappropriate argument
            throw new IllegalArgumentException("Invalid ISBN: " + isbn);
        }
        this.bookInfo = title + " by " + author + ", " + yearPublished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isValidISBN(isbn)) {
            this.isbn = isbn;
        } else {
            //IllegalArgumentException is a built-in Java exception class that is used
            // to indicate that a method has been called with an illegal or inappropriate argument
            throw new IllegalArgumentException("Invalid ISBN: " + isbn);
        }
    }

    public String getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(String bookInfo) {
        this.bookInfo = bookInfo;
    }

    //ISBN validation method
    private boolean isValidISBN(String isbn) {
        //need to implement the logic
        return isbn != null && !isbn.isEmpty();
    }
}