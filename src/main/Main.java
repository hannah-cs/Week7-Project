package src.main;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "1111111", "Book_1", 10.99, "Author_1", 2020);
        Book book2 = new Book(2, "2222222", "Book_2", 11.99, "Author_2", 2021);
        Book book3 = new Book(3, "3333333", "Book_3", 10.99, "Author_3", 2022);
        Book book4 = new Book(4, "4444444", "Book_4", 10.99, "Author_4", 2023);
        Book book5 = new Book(5, "5555555", "Book_5", 10.99, "Author_1", 1900);
        Book book6 = new Book(6, "6666666", "Book_6", 10.99, "Author_2", 1950);
        Book book7 = new Book(7, "7777777", "Book_7", 10.99, "Author_1", 2000);

        //add book
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);
        library.addBook(book7);

        //add book to favourites
        library.addBookToFavourites(book1);
        library.addBookToFavourites(book2);

        //display list of books
        library.displayBooks();

        //display list of fav books
        library.displayFavourites();

        //find book by id
        int bookIdToFind = 2;
        Book foundBook = library.findBookByID(bookIdToFind);
        if (foundBook != null) {
            System.out.println("\nFound Book by ID " + bookIdToFind + ": " + foundBook);
        } else {
            System.out.println("\nBook with ID " + bookIdToFind + " not found.");
        }

        //remove book from library and favourite list
        library.removeBook(book3);
        library.removeBookFromFavourites(book3);

        //display after removing
        library.displayBooks();
        library.displayFavourites();

        //a. Find the total number of books in the list.
        long totalBooks = library.getBooks().stream().count();
        System.out.println("Total number of books: "+totalBooks);

        //b. Find the average price of the books.
        double avg = library.getBooks().stream()
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("Average price of all books: "+avg);

        //c. Find the most expensive book.
        Book mostExpensive = library.getBooks().stream()
                .reduce((a,b)->a.getPrice()>b.getPrice()?a:b)
                .orElse(null);
        System.out.println("Most expensive book: "+mostExpensive.getTitle());

        //d. Find the books published in the last 5 years (current year - 5).
        List<Book> last5Years = library.getBooks().stream()
                .filter(book -> book.getYearPublished() >= (2023 - 5))
                .collect(Collectors.toList());
        System.out.println("Books published in the last 5 years: " + last5Years);

        //e. Create a map of authors to the list of books they have written.
        Map<String, List<Book>> authorToBooks = library.getBooks().stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
        authorToBooks.forEach((author, books) -> {
            System.out.println("Author: " + author);
            books.forEach(book -> System.out.println("  Book Title: " + book.getTitle()));
        });
    }
}